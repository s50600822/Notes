package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Runtime.getRuntime;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static Logger log = LogManager.getLogger(App.class);
    private static final String NEWS_URL = "https://news.google.com/news/rss";
    private static final Map<String, String> RES_HEADERS = Map.of(
            "Content-Type", "application/json",
            "X-Custom-Header", "application/json"
    );
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public APIGatewayProxyResponseEvent handleRequest(
            final APIGatewayProxyRequestEvent input,
            final Context context
    ) {
        final APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(RES_HEADERS);
        try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("cpu", String.valueOf(getRuntime().availableProcessors()))
        ) {
            final Map<String, String> responseHeader = new HashMap<>();
            if (input != null) {
                final APIGatewayProxyRequestEvent.ProxyRequestContext reqCtx = input.getRequestContext();
                ctc.put("resources", input.getResource())
                        .put("path", input.getPath());

                input.getHeaders().forEach((k, v) -> ctc.put(k, v.toString()));
                input.getMultiValueHeaders().forEach((k, v) -> ctc.put(k, v.toString()));
                ctc.put("requestId", reqCtx.getRequestId());
                ctc.put("apiId", reqCtx.getApiId());
                ctc.put("path", reqCtx.getPath());
                ctc.put("stage", reqCtx.getStage());
                ctc.put("resourceId", reqCtx.getResourceId());
                ctc.put("resourcePath", reqCtx.getResourcePath());

                responseHeader.put("requestId", reqCtx.getRequestId());
                responseHeader.put("apiId", reqCtx.getApiId());
                responseHeader.put("resourceId", reqCtx.getResourceId());
            }

            final String responseData = getNewsFromGoogle();
            log.info(responseData);
            return response
                    .withStatusCode(200)
                    .withBody(responseData)
                    .withHeaders(responseHeader);
        } catch (final IOException | InterruptedException | XMLStreamException e) {
            return response.withBody("{\"err\":\"" + e.getMessage() + "\"}").withStatusCode(500);
        }
    }

    private String getNewsFromGoogle() throws IOException, InterruptedException, XMLStreamException {

        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(NEWS_URL))
                .setHeader("User-Agent", "Daily News Lambda")
                .build();

        final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return rssToNewsItems(response.body()).toString();
    }

    private List<NewsItem> rssToNewsItems(final String rssFeed)
            throws XMLStreamException {

        final List<NewsItem> newsItems = new ArrayList<>();
        final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        final InputStream inputStream = new ByteArrayInputStream(rssFeed.getBytes());
        final XMLEventReader reader = inputFactory.createXMLEventReader(inputStream);
        NewsItem newsItem = null;
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                final StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "item":
                        newsItem = new NewsItem();
                        break;
                    case "title":
                        nextEvent = reader.nextEvent();
                        setTitle(nextEvent, newsItem);
                        break;
                    case "pubDate":
                        nextEvent = reader.nextEvent();
                        setPubDate(nextEvent, newsItem);
                        break;
                    default:
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                final EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("item")) {
                    newsItems.add(newsItem);
                }
            }
        }
        return newsItems;
    }

    private void setTitle(final XMLEvent xmlEvent, final NewsItem newsItem) {

        if (null != newsItem) {
            newsItem.setTitle(xmlEvent.asCharacters().getData());
        }
    }

    private void setPubDate(final XMLEvent xmlEvent, final NewsItem newsItem) {

        if (null != newsItem) {
            newsItem.setPubDate(xmlEvent.asCharacters().getData());
        }
    }
}
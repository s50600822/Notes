# Getting Started

### Single Thread
localhost:8080/bs

{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[6239d28] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"1fc6c3b284fd681c"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[11f2cc7] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"df1ef4732a586242"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[5424c537] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"2a46846eec226aa6"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[349dc538] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"1402396a51e706b4"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2407e878] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"98ddc7c24ba33c54"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[56f88cb2] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"7395230223d1bc67","spanId":"80e2a334f3d531b4"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[5424c537] [e6ef7dad-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"2a46846eec226aa6"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[349dc538] [aa28a504-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"1402396a51e706b4"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[6239d28] [3385e62b-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"1fc6c3b284fd681c"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[11f2cc7] [358ef626-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"df1ef4732a586242"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2407e878] [898fd2b8-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"98ddc7c24ba33c54"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[56f88cb2] [7c5e6111-1] Response 200 OK, headers={masked}","traceId":"7395230223d1bc67","spanId":"80e2a334f3d531b4"}





### Parallel
localhost:8080/bsp


{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2bacb7b1] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"15c4e7d5c0b31b22"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[44937173] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"b30e81a2e2433292"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[318de69d] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"a76b43ef2fb5409d"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[3693641c] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"0fae7f3f16f2f094"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2563cfab] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"9a25318b39b0bd89"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[7b846c94] HTTP GET https://data.nsw.gov.au/data/api/3/action/datastore_search, headers={masked}","traceId":"dc681e011a66416a","spanId":"f67e2872bd8a88ce"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[44937173] [59d6017a-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"b30e81a2e2433292"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2bacb7b1] [56727302-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"15c4e7d5c0b31b22"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[7b846c94] [4394a55c-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"f67e2872bd8a88ce"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[318de69d] [2a05fdb0-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"a76b43ef2fb5409d"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[3693641c] [9542d060-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"0fae7f3f16f2f094"}
{"logger":"org.springframework.web.reactive.function.client.ExchangeFunctions","level":"TRACE","thread":"reactor-http-nio-4","message":"[2563cfab] [d60f26e0-1] Response 200 OK, headers={masked}","traceId":"dc681e011a66416a","spanId":"9a25318b39b0bd89"}

why same thread???? It wasnt like this when I started
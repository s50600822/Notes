package tut.springbootk8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value("${a.b.c:DEFAULT_ABC}")
    private String test1;

    @Value("${x.y.z:DEFAULT_XYZ}")
    private String test2;

    @Bean
    public SomeComponent someComponent(){
        return new SomeComponent(test1, test2);
    }
}

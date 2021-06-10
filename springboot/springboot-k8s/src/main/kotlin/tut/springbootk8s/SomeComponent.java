package tut.springbootk8s;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeComponent {
    private static final Logger log = LoggerFactory.getLogger(SomeComponent.class);
    public SomeComponent(String test1, String test2){
        log.warn("\n{} >>> {}\n{} >>>> {}", "a.b.c", test1, "x.y.z", test2);
    }
}

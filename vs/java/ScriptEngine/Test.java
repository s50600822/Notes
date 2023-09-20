import javax.script.ScriptEngineManager;
import javax.script.ScriptEngineFactory;

public class Test{
    public static void main(String[] args){
        // ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");
        // System.out.println(engine);
        java.util.List<ScriptEngineFactory> eF = new ScriptEngineManager().getEngineFactories();
        System.out.println(eF.size());
        eF.forEach(f -> System.out.println(String.format("[%s] [%s]", f.getEngineName(), f.getClass())));
    }
}
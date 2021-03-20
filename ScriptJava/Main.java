import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String script1 = "print('Hello world!');";
        String script2 = "function add(a, b) {\n" +
                "    c = a + b;\n" +
                "    return c;\n" +
                "}\n" +
                "\n" +
                "result = add (10, 5);\n" +
                "print ('Result = ' + result);";
        try {
            engine.eval(script1);
            engine.eval(script2);

            engine.eval("var x = 10;");
            engine.eval("var y = 20;");
            int x = (int) engine.eval("x");
            int y = (int) engine.eval("y");
            int z = x + y;
            System.out.println("Sum: "+z);
        } catch (ScriptException e) {
            System.err.println(e.getMessage());
        }


    }
}

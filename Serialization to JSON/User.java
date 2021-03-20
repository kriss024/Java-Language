import java.util.List;

public class User {

    public String name;
    public int age;
    private List<String> messages;

    public String toString(){
        return name+' '+age;
    }
}
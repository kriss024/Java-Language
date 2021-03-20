import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class JavaStream {
    public static void main(String [] args)
    {
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9};

        IntStream intStream = Arrays.stream(numbers);
        intStream = intStream.limit(3);
        System.out.println(intStream.sum());

        IntStream
                .range(0, 10)
                .average()
                .ifPresent(System.out::println);


        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);


        memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));


        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);

    }

}

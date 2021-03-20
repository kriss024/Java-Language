import com.google.common.collect.*;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.util.List;
import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();

        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        Ordering ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering );
        System.out.println("Sorted List: ");
        System.out.println(numbers);

        System.out.println("======================");
        System.out.println("List is sorted: " + ordering.isOrdered(numbers));
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        Collections.sort(numbers,ordering.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        List<String> names = new ArrayList<String>();

        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);

        Collections.sort(names,ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);

        System.out.println("======================");

        Multimap<String, Integer> scores = HashMultimap.create();
        scores.put("Bob", 20);
        scores.put("Bob", 10);
        scores.put("Bob", 15);
        System.out.println(Collections.max(scores.get("Bob")));

        System.out.println("======================");
        Table<String, String, String> employeeTable = HashBasedTable.create();

        //initialize the table with employee details
        employeeTable.put("IBM", "101","Mahesh");
        employeeTable.put("IBM", "102","Ramesh");
        employeeTable.put("IBM", "103","Suresh");

        employeeTable.put("Microsoft", "111","Sohan");
        employeeTable.put("Microsoft", "112","Mohan");
        employeeTable.put("Microsoft", "113","Rohan");

        employeeTable.put("TCS", "121","Ram");
        employeeTable.put("TCS", "122","Shyam");
        employeeTable.put("TCS", "123","Sunil");

        //get Map corresponding to IBM
        Map<String,String> ibmEmployees =  employeeTable.row("IBM");

        System.out.println("List of IBM Employees");

        for(Map.Entry<String, String> entry : ibmEmployees.entrySet()) {
            System.out.println("Emp Id: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        //get all the unique keys of the table
        Set<String> employers = employeeTable.rowKeySet();
        System.out.print("Employers: ");

        for(String employer: employers) {
            System.out.print(employer + " ");
        }

        System.out.println();

        //get a Map corresponding to 102
        Map<String,String> EmployerMap =  employeeTable.column("102");

        for(Map.Entry<String, String> entry : EmployerMap.entrySet()) {
            System.out.println("Employer: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        System.out.println("======================");

        String fileName = "balzac.txt";

        List<String> lines = null;

        try {
            lines = Files.readLines(new File(fileName), Charsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        for (String line: lines) {
            System.out.println(line);
        }

    }
}
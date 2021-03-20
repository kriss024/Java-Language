import java.io.*;


public class Person implements Serializable {
    private String surname, firstname;

    public Person(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public String toString()
    {
        return getFirstname()+" "+getSurname();
    }

    public static void main(String [] args)
    {
        Person a = new Person("Jan","Kowalski");
        System.out.println(a.toString());

        try {
            FileOutputStream fos = new FileOutputStream("test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(a);
            out.close();
            fos.close();
        } catch(Exception ex) {
            System.err.println(ex.toString());
        }
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        Person b = null;

        try {
            FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            b = (Person) in.readObject();
            in.close();
            fis.close();
        } catch(Exception ex) {
            System.err.println(ex.toString());
        }

        System.out.println(b.toString());
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

}
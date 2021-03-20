package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

    public class Person {
        private static int count = 0;
        private SimpleIntegerProperty id;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty email;

        public Person(String fName, String lName, String email) {
            count++;
            this.id = new SimpleIntegerProperty(count);
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public Integer getId() {
            return id.get();
        }
        public void setId(Integer id) {
            this.id.set(id);
        }

        public String getFirstName() {
            return firstName.get();
        }
        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }
        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }
        public void setEmail(String fName) {
            email.set(fName);
        }

    }

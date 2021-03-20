package zad12;

abstract class Pacjent {

    private String name;

    public Pacjent() {
    }

    public Pacjent(String name) {
        this.name= name;
    }

    public String nazwisko(){
        return this.name;
    }

    abstract String choroba();
    abstract String leczenie();

}

public class Employee extends Person {

    public Employee(Person person) {
        this(person.getName(), person.getYear());
    }
    public Employee(String name, int birthYear) {
        super(name, birthYear);
    }
}

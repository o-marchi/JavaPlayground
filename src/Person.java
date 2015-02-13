import java.util.Calendar;

public class Person {

    private String name;
    private int birthYear;
    private int age;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = this.ResolveAge(this.birthYear);
    }

    public String getName() { return this.name; }
    public int getYear() { return this.birthYear; }

    public int ResolveAge(int year) {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return currentYear - year;
    }

    public String SayHi() { return SayHi("There"); }
    public String SayHi(Person person) { return SayHi(person.getName()); }
    public String SayHi(String otherPerson) {
        return "Hello " + otherPerson + ", my name is " + this.name + ".";
    }

    public String Profile() {
        String profile = "My name is " + this.name +
                ", I was born is " + this.birthYear +
                ", so I am " + this.age + " years old.";

        return  profile;
    }
}

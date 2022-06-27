import model.Dog;
import model.Person;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Person hendrik = new Person("Hendrik", "Rummens", LocalDate.of(2000, 6, 10));
        Person lucas = new Person("Lucas", "Rummens", LocalDate.of(2002, 5, 11));

        hendrik.setBrother(lucas);

        Dog dog = new Dog("Leo", LocalDate.of(2005, 1, 2));

        hendrik.setPet(dog);
        System.out.println(hendrik.getBrother().toString());
        System.out.println(hendrik.getPet().toString());
    }
}

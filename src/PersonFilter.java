import java.util.List;

// Improved version of the Functional Interface designed for customizable filtering.
@FunctionalInterface
public interface PersonFilter {
    List<Person> filterPersons(List<Person> persons, int age, String occupation, Gender gender);

}

/*

// Previous version of the Functional Interface supporting multiple instances with no specific criteria.
@FunctionalInterface
public interface PersonFilter {
    List<Person> filterPersons(List<Person> persons);
}

*/
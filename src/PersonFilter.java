import java.util.List;

@FunctionalInterface
public interface PersonFilter {
    List<Person> filterPersons(List<Person> persons, int age, String occupation, Gender gender);

}

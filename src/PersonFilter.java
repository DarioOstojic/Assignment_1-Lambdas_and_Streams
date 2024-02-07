import java.util.List;

// Improved version of the Functional Interface designed for customizable filtering.
@FunctionalInterface
public interface PersonFilter {
    List<Person> filterPersons(List<Person> persons, int age, String occupation, Gender gender);

    static boolean isMaleArchitect(Person person) {
        return person.getOccupation().equals("Architect") && person.getGender() == Gender.MALE;
    }

    default boolean isAdultFemaleProgrammers(Person person) {
        return person.getAge() >= 18 && person.getOccupation().equals("Programmer") && person.getGender() == Gender.FEMALE;
    }
}


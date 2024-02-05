import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        PersonGenerator personGenerator = new PersonGenerator(100);
        List<Person> persons = personGenerator.getPersons();

        PersonFilter specifiedAgeFilter = (people, age, occupation, gender) -> people.stream()
                .filter(person -> person.getAge() < age)
                .filter(person -> person.getOccupation().equals(occupation))
                .filter(person -> person.getGender().equals(gender))
                .collect(Collectors.toList());

        List<Person> filteredPersons = specifiedAgeFilter.filterPersons(persons, 30, "Teacher", Gender.FEMALE);

        // Display the generated persons
        for (Person person : filteredPersons) {
            System.out.println(person);
        }
    }
}
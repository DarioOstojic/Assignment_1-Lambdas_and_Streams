import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        PersonGenerator personGenerator = new PersonGenerator(100);
        List<Person> persons = personGenerator.getPersons();

        PersonFilter specifiedAgeFilter = personList -> personList.stream()
                .filter(person -> person.getAge() < 30)
                .collect(Collectors.toList());

        List<Person> filteredPersons = specifiedAgeFilter.filterPersons(persons);

        // Display the generated persons
        for (Person person : filteredPersons) {
            System.out.println(person);
        }
    }
}
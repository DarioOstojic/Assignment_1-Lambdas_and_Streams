import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Generating a list of 100 persons using the PersonGenerator.
        PersonGenerator personGenerator = new PersonGenerator(1000);
        List<Person> persons = personGenerator.getPersons();
        System.out.println("Length of person list: " + persons.size());

        // Creating a PersonFilter instance using a lambda expression to filter persons based on age, occupation, and gender.
        PersonFilter personFilter = (people, age, occupation, gender) -> people.stream()
                .filter(person -> person.getAge() < age)
                .filter(person -> person.getOccupation().equals(occupation))
                .filter(person -> person.getGender().equals(gender))
                .collect(Collectors.toList());

        // Record the start time
        long startTime = System.nanoTime();

        // Applying the created filter to the generated list of persons.
        List<Person> filteredPersons = personFilter.filterPersons(persons, 60, "Teacher", Gender.FEMALE);

        // Record the end time
        long endTime = System.nanoTime();
        long timeMicro = (endTime - startTime) / 1000;
        System.out.println("Filtered in: " + timeMicro + " microseconds");

        /*
        // Additional filters with specific criteria.
        // Filter for persons older than 21.
        PersonFilter onlyOlderThan21 = people -> people.stream()
                .filter(person -> person.getAge() < 21)
                .collect(Collectors.toList());

        // Filter for persons with the occupation "Teacher".
        PersonFilter onlyTeachers = people -> people.stream()
                .filter(person -> person.getOccupation().equals("Teacher"))
                .collect(Collectors.toList());

        // Filter for persons with the gender "Female".
        PersonFilter onlyFemales = people -> people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        // Applying each specific filter to the list of persons.
        List<Person> personsOlderThan21 = onlyOlderThan21.filterPersons(persons);
        List<Person> personsTeachers = onlyTeachers.filterPersons(persons);
        List<Person> personsFemales = onlyFemales.filterPersons(persons);
        */


        // Display the generated persons
        for (Person person : filteredPersons) {
            System.out.println(person);
        }
    }
}
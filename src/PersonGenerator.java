import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

    List<Person> persons;

    public PersonGenerator (int numberOfPeople) {
        this.persons = generatePersonList(numberOfPeople);
    }

    public List<Person> getPersons() {
        return persons;
    }

    // Method to generate a list of Person objects with random attributes
    public static List<Person> generatePersonList(int count) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(50) + 20; // Random age between 20 and 69
            String name = generateRandomName();
            String occupation = generateRandomOccupation();
            Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;

            Person person = new Person(age, name, occupation, gender);
            persons.add(person);
        }

        return persons;
    }

    // Helper method to generate a random name
    private static String generateRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    // Helper method to generate a random occupation
    private static String generateRandomOccupation() {
        String[] occupations = {"Engineer", "Teacher", "Doctor", "Artist", "Programmer", "Writer"};
        Random random = new Random();
        return occupations[random.nextInt(occupations.length)];
    }
}
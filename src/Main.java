import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Generating a list of persons through using the PersonGenerator.
        PersonGenerator personGenerator = new PersonGenerator(20000);
        List<Person> randomPersons = personGenerator.getPersons();
        System.out.println("Length of person list: " + randomPersons.size());
        Person randomPerson = personGenerator.generatePerson();

        // Lambda expression with no parameters
        DatePrinter currentWorkingDate = (() -> System.out.println("Current working date is " + new Date()));
        currentWorkingDate.printCurrentDate();

        // Lambda expression with one parameter
        Occupation jobOccupation = person -> person.getOccupation();
        String personJobOccupation = jobOccupation.getJobOccupation(randomPerson);
        System.out.println(personJobOccupation);

        // Lambda expression with several parameters
        PersonFilter filterByAgeOccupationGender = (people, age, occupation, gender) -> people.stream()
                .filter(person -> person.getAge() < age)
                .filter(person -> person.getOccupation().equals(occupation))
                .filter(person -> person.getGender().equals(gender))
                .collect(Collectors.toList());

        // Applying the filterByAgeOccupationGender to the generated list of persons.
        List<Person> filteredPersons = filterByAgeOccupationGender.filterPersons(randomPersons, 60, "Teacher", Gender.FEMALE);

        // Display the generated persons by age, occupation and gender
        for (Person person : filteredPersons) {
            System.out.println(person);
        }

        // Predicate example
        Predicate<Person> femaleProgrammersAbove18 =
                person -> person.getAge() >= 18
                        && person.getOccupation().equals("Programmer")
                        && person.getGender() == Gender.FEMALE;
        boolean result = femaleProgrammersAbove18.test(randomPerson);

        // Record the start time
        long startTime = System.nanoTime();

        // Record the end time
        long endTime = System.nanoTime();
        long timeMicro = (endTime - startTime) / 1000;
        System.out.println("Filtered in: " + timeMicro + " microseconds");
    }

    // Custom filter using loops
    private static List<Person> filterPersons(List<Person> persons, int age, String occupation, Gender gender) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : persons) {
            if ( person.getAge()<age && person.getOccupation().equals(occupation) && person.getGender().equals(gender)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }
}
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Short person list for testing
        List<Person> personListTest = Arrays.asList(
                new Person(24, "Alice", "Teacher", Gender.FEMALE),
                new Person(30, "Bob", "Engineer", Gender.MALE),
                new Person(25, "Charlie", "Teacher", Gender.MALE),
                new Person(28, "David", "Artist", Gender.MALE)
        );

        // Creating an instance of PersonGenerator.
        PersonGenerator personGenerator = new PersonGenerator();

        // Generating a list of random persons through using the PersonGenerator.
        List<Person> randomPersons = personGenerator.generatePersonList(100);
        System.out.println("A list of " + randomPersons.size() + "was generated.");

        // Generating a single random person through using the PersonGenerator.
        Person randomPerson = personGenerator.generatePerson();

        // Example of lambda expression with no parameters
        DatePrinter currentWorkingDate = (() -> System.out.println("Current working date is " + new Date()));
        currentWorkingDate.printCurrentDate();

        //  Lambda expression with one parameter
        Occupation jobOccupation = person -> person.getOccupation();
        String personJobOccupation = jobOccupation.getJobOccupation(randomPerson);
        System.out.println(personJobOccupation);

        //  Custom filter using loops (Internal iteration)
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
        Predicate<Person> isFemaleProgrammerAbove18 =
                person -> person.getAge() >= 18
                        && person.getOccupation().equals("Programmer")
                        && person.getGender() == Gender.FEMALE;
        boolean result = isFemaleProgrammerAbove18.test(randomPerson);


        // Measuring performance of imperative vs declarative approach
        List<Person> listOf10Persons = personGenerator.generatePersonList(10);
        List<Person> listOf100Persons = personGenerator.generatePersonList(100);
        List<Person> listOf1000Persons = personGenerator.generatePersonList(1000);
        List<Person> listOf10000Persons = personGenerator.generatePersonList(10000);
        List<Person> listOf100000Persons = personGenerator.generatePersonList(100000);


        System.out.printf("%nMeasuring performance of imperative vs declarative approach%n");
        // Displaying header
        System.out.printf("%n%-20s%-25s%-20s%n", "Elements in list", "Declarative approach", "Imperative approach");

        for (List<Person> list : Arrays.asList(listOf10Persons, listOf100Persons, listOf1000Persons, listOf10000Persons, listOf100000Persons)) {
            System.out.printf("%-20d", list.size()); // Displaying the number of elements in the list

            // Declarative approach
            long startTime = System.nanoTime(); // Record the start time
            List<Person> filteredList = filterByAgeOccupationGender.filterPersons(list, 60, "Teacher", Gender.FEMALE);
            long endTime = System.nanoTime(); // Record the end time
            long timeMicro = (endTime - startTime) / 1000; // Calculate the difference
            System.out.printf("%-25d", timeMicro);

            // Imperative approach
            startTime = System.nanoTime(); // Record the start time
            filteredList = filterPersons(list, 60, "Teacher", Gender.FEMALE);
            endTime = System.nanoTime(); // Record the end time
            timeMicro = (endTime - startTime) / 1000; // Calculate the difference
            System.out.printf("%-20d%n", timeMicro);
        }
    }

    // Custom filter using loops (External iteration)
    private static List<Person> filterPersons(List<Person> personList, int age, String occupation, Gender gender) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() < age &&
                    person.getOccupation().equals(occupation) &&
                    person.getGender().equals(gender)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }
}
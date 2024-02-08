import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.printf("\nEXAMINATION 1: Functional Programing\n");
        System.out.printf("Code by: Dario Ostojic, Simon Edman Persson and Elina Rosato\n");


        // Short person list for testing
        List<Person> personListTest = Arrays.asList(
                new Person(24, "Alice", "Teacher", Gender.FEMALE),
                new Person(30, "Bob", "Engineer", Gender.MALE),
                new Person(25, "Charlie", "Teacher", Gender.MALE),
                new Person(28, "David", "Artist", Gender.MALE)
        );

        // Creating an instance of PersonGenerator.
        PersonGenerator personGenerator = new PersonGenerator();

        // Generating a list of 500 random persons through using the PersonGenerator.
        List<Person> randomPersons = personGenerator.generatePersonList(300);

        // Generating a random person through using the PersonGenerator.
        Person randomPerson = personGenerator.generatePerson();

        // This code shows how to use lambda expressions with no parameters to print the current date.
        System.out.printf("%nThis is today's date obtained using lambda expressions with no parameter: ");
        DatePrinter currentDate = (() -> System.out.println( new Date() ));
        currentDate.printCurrentDate();

        //  This code shows how to use lambda expressions with one parameter to obtain the occupation of a random person.
        System.out.printf("%nThis is a random person's occupation obtained using lambda expressions with one parameter: ");
        Occupation job = person -> person.getOccupation();
        String personJob = job.getOccupation(randomPerson);
        System.out.println(personJob);

        // This code shows how to use lambda expression with several parameters to define a custom filter (Internal iteration)
        PersonFilter filterByAgeOccupationGender = (people, age, occupation, gender) -> people.stream()
                .filter(person -> person.getAge() < age)
                .filter(person -> person.getOccupation().equals(occupation))
                .filter(person -> person.getGender().equals(gender))
                .collect(Collectors.toList());

        // Applying the filterByAgeOccupationGender to the randomly generated list of 300 persons.
        List<Person> filteredPersons = filterByAgeOccupationGender.filterPersons(randomPersons, 45, "Teacher", Gender.FEMALE);

        // Display the generated persons by age, occupation and gender
        System.out.printf("%nThis are the persons obtained by filtering a list of 300 random persons using lambda expressions with multiple parameters:%n");
        System.out.printf("%-10s%-20s%-20s%-15s%n", "Age", "Name", "Occupation", "Gender");
        System.out.println("---------------------------------------------------------");
        if (filteredPersons.isEmpty()) {
            System.out.println("No persons match the criteria");
        } else {
            for (Person person : filteredPersons) {
                System.out.println(person);
            }
        }

        // This code shows how use filter intermediate operation
        List<Person> filterOperation = randomPersons.stream()
                .filter(person -> person.getAge() < 20)
                .toList();
        // Display the generated persons by age, occupation and gender
        System.out.printf("%nThis are the persons obtained by filtering a list of 300 random persons by age (<20):%n");
        System.out.printf("%-10s%-20s%-20s%-15s%n", "Age", "Name", "Occupation", "Gender");
        System.out.println("---------------------------------------------------------");
        if (filteredPersons.isEmpty()) {
            System.out.println("No persons match the criteria");
        } else {
            for (Person person : filterOperation) {
                System.out.println(person);
            }
        }

        // This code shows how use map intermediate operation
        List<String> mapOperation = randomPersons.stream()
                .map(person -> person.getName())
                .toList();
        // Display the names of teh generated list
        System.out.printf("%n%nThis are the names obtained by mapping a list of 300 random persons to their names:%n");
        for (String name : mapOperation) {
                System.out.printf("%s - ", name);
            }

        // This code shows how use reduce intermediate operation
        System.out.printf("%n%nThis is the result of accumulating all persons ages using the reduce terminal operation:%n");
        int reduceOperation = randomPersons.stream()
                .map(person -> person.getAge())
                .reduce(0, (age1, age2) -> Integer.sum(age1, age2));
        System.out.println(reduceOperation);



        // This code shows how to use the Predicate Functional Interface
        System.out.printf("%nThis is the result of testing if a random person's gender is FEMALE obtained using the pre-built Predicate Functional Interface:%n");
        Predicate<Person> isFemaleProgrammerAbove18 =
                person -> person.getAge() >= 18
                        && person.getOccupation().equals("Programmer")
                        && person.getGender() == Gender.FEMALE;
        boolean result = isFemaleProgrammerAbove18.test(randomPerson);
        System.out.println(result);

        // Measuring performance of imperative vs declarative approach
        System.out.printf("%nMeasuring performance of imperative vs declarative approach:%n");

        // Generating lists
        List<Person> listOf10Persons = personGenerator.generatePersonList(10);
        List<Person> listOf100Persons = personGenerator.generatePersonList(100);
        List<Person> listOf1000Persons = personGenerator.generatePersonList(1000);
        List<Person> listOf10000Persons = personGenerator.generatePersonList(10000);
        List<Person> listOf20000Persons = personGenerator.generatePersonList(20000);
        List<Person> listOf50000Persons = personGenerator.generatePersonList(50000);
        List<Person> listOf100000Persons = personGenerator.generatePersonList(100000);

        // Displaying header
        System.out.printf("%-20s%-25s%-20s%n", "Elements in list", "Declarative approach", "Imperative approach");
        System.out.println("------------------------------------------------------------------");

        // Displaying table content
        for (List<Person> list : Arrays.asList(listOf10Persons, listOf100Persons, listOf1000Persons, listOf10000Persons, listOf20000Persons, listOf50000Persons, listOf100000Persons)) {
            System.out.printf("%-20d", list.size()); // Displaying the number of elements in the list

            // Declarative approach
            long startTime = System.nanoTime(); // Record the start time
            List<Person> filteredList = filterByAgeOccupationGender.filterPersons(list, 30, "Teacher", Gender.FEMALE);
            long endTime = System.nanoTime(); // Record the end time
            long timeMicro = (endTime - startTime) / 1000; // Calculate the difference
            System.out.printf("%-25s", timeMicro + " μs");

            // Imperative approach
            startTime = System.nanoTime(); // Record the start time
            filteredList = filterPersons(list, 30, "Teacher", Gender.FEMALE);
            endTime = System.nanoTime(); // Record the end time
            timeMicro = (endTime - startTime) / 1000; // Calculate the difference
            System.out.printf("%-20s%n", timeMicro + " μs");
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
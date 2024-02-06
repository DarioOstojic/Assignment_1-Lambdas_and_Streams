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
            int age = random.nextInt(18, 65); // Random age between 18 and 65
            String[] nameWithGender = generateRandomNameWithGender();
            String name = nameWithGender[0];
            Gender gender = Gender.valueOf(nameWithGender[1]);
            String occupation = generateRandomOccupation();

            Person person = new Person(age, name, occupation, gender);
            persons.add(person);
        }

        return persons;
    }

    // Helper method to generate a random name
    private static String[] generateRandomNameWithGender() {
        String[][] namesWithGender = {
                {"Alice", "FEMALE"}, {"Bob", "MALE"}, {"Charlie", "MALE"}, {"David", "MALE"},
                {"Emma", "FEMALE"}, {"Frank", "MALE"}, {"Grace", "FEMALE"}, {"Henry", "MALE"},
                {"Louise", "FEMALE"}, {"Jessica", "FEMALE"}, {"Michael", "MALE"}, {"Sarah", "FEMALE"},
                {"Miranda", "FEMALE"}, {"Harvey", "MALE"}, {"Lucas", "MALE"}, {"Robert", "MALE"},
                {"Kate", "FEMALE"}, {"John", "MALE"}, {"Peter", "MALE"}, {"Ethan", "MALE"},
                {"Olivia", "FEMALE"}, {"Liam", "MALE"}, {"Noah", "MALE"}, {"Ava", "FEMALE"},
                {"Sophia", "FEMALE"}, {"Jackson", "MALE"}, {"Isabella", "FEMALE"}, {"Aiden", "MALE"},
                {"Mia", "FEMALE"}, {"Caden", "MALE"}, {"Amelia", "FEMALE"}, {"Grayson", "MALE"},
                {"Harper", "FEMALE"}, {"Mason", "MALE"}, {"Evelyn", "FEMALE"}, {"Elijah", "MALE"},
                {"Abigail", "FEMALE"}, {"Logan", "MALE"}, {"Ella", "FEMALE"}, {"Carter", "MALE"},
                {"Scarlett", "FEMALE"}, {"Caleb", "MALE"}, {"Lily", "FEMALE"}, {"Aria", "FEMALE"},
                {"Oliver", "MALE"}, {"Chloe", "FEMALE"}, {"Sebastian", "MALE"}, {"Penelope", "FEMALE"},
                {"Henry", "MALE"}, {"Layla", "FEMALE"}, {"Owen", "MALE"}, {"Zoey", "FEMALE"},
                {"Wyatt", "MALE"}, {"Aurora", "FEMALE"}, {"Samuel", "MALE"}, {"Addison", "FEMALE"},
                {"Leo", "MALE"}, {"Brooklyn", "FEMALE"}, {"Gabriel", "MALE"}, {"Hannah", "FEMALE"},
                {"Julian", "MALE"}, {"Lillian", "FEMALE"}, {"Levi", "MALE"}, {"Victoria", "FEMALE"},
                {"Dylan", "MALE"}, {"Natalie", "FEMALE"}, {"Zachary", "MALE"}, {"Samantha", "FEMALE"},
                {"Anthony", "MALE"}, {"Stella", "FEMALE"}, {"Joseph", "MALE"}, {"Aurora", "FEMALE"},
                {"Isaac", "MALE"}, {"Claire", "FEMALE"}, {"Lincoln", "MALE"}, {"Lucy", "FEMALE"},
                {"Joshua", "MALE"}, {"Anna", "FEMALE"}, {"Savannah", "FEMALE"}, {"Nathan", "MALE"},
                {"Zoe", "FEMALE"}, {"Hunter", "MALE"}, {"Nora", "FEMALE"}, {"Aaron", "MALE"},
                {"Eleanor", "FEMALE"}, {"Hazel", "FEMALE"}, {"Daniel", "MALE"}, {"Violet", "FEMALE"},
                {"Matthew", "MALE"}, {"Audrey", "FEMALE"}, {"Elijah", "MALE"}, {"Skylar", "FEMALE"},
                {"James", "MALE"}, {"Paisley", "FEMALE"}, {"Benjamin", "MALE"}, {"Christopher", "MALE"},
                {"Jonathan", "MALE"}, {"Caroline", "FEMALE"}, {"Samuel", "MALE"}, {"Kennedy", "FEMALE"},
                {"Julian", "MALE"}, {"Naomi", "FEMALE"}, {"Jack", "MALE"}, {"Genesis", "FEMALE"},
                {"Wyatt", "MALE"}, {"Sadie", "FEMALE"}, {"Jayden", "MALE"}, {"Piper", "FEMALE"}
        };

        Random random = new Random();
        return namesWithGender[random.nextInt(namesWithGender.length)];
    }

    // Helper method to generate a random occupation
    private static String generateRandomOccupation() {
        String[] occupations = {"Engineer", "Teacher", "Doctor", "Painter", "Programmer", "Writer", "Singer", "Astronaut",
                                "Chef", "Scientist", "Pilot", "Librarian", "Athlete", "Psychologist", "Photographer",
                                "Architect", "Firefighter", "Lawyer", "Dancer", "Electrician", "Journalist", "Veterinarian"};
        Random random = new Random();
        return occupations[random.nextInt(occupations.length)];
    }
}
public class Person {
    private int age;
    private String name;
    private String occupation;
    private Gender gender;

    public Person(int age, String name, String occupation, Gender gender) {
        this.age = age;
        this.name = name;
        this.occupation = occupation;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10d%-20s%-20s%-15s",
                age,
                name,
                occupation,
                gender
        );
    }

}

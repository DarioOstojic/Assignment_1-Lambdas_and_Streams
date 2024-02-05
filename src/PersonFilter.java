import java.util.List;

@FunctionalInterface
public interface PersonFilter {
    List<Person> filterPersons(List<Person> persons);

}

import java.util.Random;

public class Student implements QueryItem {

    protected static Random random = new Random();
    private static final String[] courses =
            {"C++", "Ruby", "C#", "Rust", "Java", "Python", "JavaScript"};
    private static final String[] firstNames =
            {"Jaanika", "Mihkel", "Hilja", "Ivari", "Johannes", "Grete", "Anneli", "Toomas", "Pilvi"};

    private final String name;
    private final String course;
    private final int yearStarted;
    private final int id;

    public Student(final int id) {
        this.id = id;
        int lastNameIndex = random.nextInt(65,91);
        this.name = firstNames[random.nextInt(firstNames.length)] + " " + (char) lastNameIndex;
        this.course = courses[random.nextInt(courses.length)];
        this.yearStarted = random.nextInt(2020,2024);
    }

    @Override
    public String toString() {
        return "%15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }
}

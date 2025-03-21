import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int studentCount = 25;

        List<ScoredStudent> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            students.add(new ScoredStudent(i));
        }

        List<ScoredStudent> filteredStudent = new ArrayList<>();
        for (ScoredStudent student : students) {
            if (student.getPercentComplete() <=50) {
                filteredStudent.add(student);
            }
        }
        System.out.println("\n UnSorted by ID ");
        printMoreStudents(filteredStudent);
        System.out.println("\n Sorted by ID (Natural order)");
        filteredStudent.sort(Comparator.naturalOrder());
        printMoreStudents(filteredStudent);
        System.out.println("\n Year started sorted");
        Comparator<ScoredStudent> yearStarted = Comparator.comparingInt(Student::getYearStarted);
        filteredStudent.sort(yearStarted);
        printMoreStudents(filteredStudent);

        /*filteredStudent.sort(Comparator.naturalOrder());
        printMoreStudents(filteredStudent);*/



       /* printStudentsOld(students);

        printStudents(students);
        printMoreStudents(students);

        List<ScoredStudent> scoredStudents = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            scoredStudents.add(new ScoredStudent());
        }

        printStudents(scoredStudents);
        printMoreStudents(scoredStudents);

        testList(new ArrayList<>(List.of("Apples", "Bananas", "Oranges")));
        testList(new ArrayList<>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(scoredStudents);

        var matches = queryList.getMatches("Course", "Python");
        printMoreStudents(matches);

        var students2021 = QueryList.getMatches(scoredStudents, "Python", "2021");
        printMoreStudents(students2021);*/

    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    public static void printMoreStudents(List<? extends Student> students) {
        for (Student student : students) {
            System.out.println("ID : "+student.getId() + " ,Year started " +  student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static <T extends Student> void printStudents(List<T> students) {
        for (T student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void printStudentsOld(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Johnson", LocalDate.of(2015, 6, 10)));
        employees.add(new Employee("Bob", "Smith", LocalDate.of(2018, 3, 25)));
        employees.add(new Employee("Charlie", "Brown", LocalDate.of(2020, 11, 5)));
        employees.add(new Employee("Diana", "Williams", LocalDate.of(2012, 7, 19)));


        printEmployeeDetails(employees);
    }

    public static void printEmployeeDetails(List<Employee> employees) {
        class EmployeeInfo {
            private final Employee employee;

            EmployeeInfo(Employee employee) {
                this.employee = employee;
            }

            void printInfo() {
                System.out.println("Full Name: " + employee.getFullName());
                System.out.println("Years Worked: " + employee.getYearWorked() + " years");
            }
        }

        System.out.println("Employee Details:");

        for (Employee e : employees) {
            EmployeeInfo info = new EmployeeInfo(e);
            info.printInfo();

            Runnable messagePrinter = () -> System.out.println("Thanks for your service, "
                    + e.getFullName()
                    + "!\n----------------------------");

            messagePrinter.run();
        }

        employees.sort(Comparator.comparing(Employee::getFullName));

        System.out.println("Sorted by Full Name:");
        for (Employee e : employees) {
            System.out.println(e);
        }


        employees.sort((e1, e2) -> {
            return Integer.compare(e2.getYearWorked(), e1.getYearWorked()); // Descending order
        });

        System.out.println("\nSorted by Years Worked:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }


}
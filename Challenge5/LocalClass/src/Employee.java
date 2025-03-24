import java.time.LocalDate;
import java.time.Period;

public record Employee(String firstName, String lastName, LocalDate hireDate) {
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getYearWorked() {
        return Period.between(hireDate,LocalDate.now()).getYears();
    }
}

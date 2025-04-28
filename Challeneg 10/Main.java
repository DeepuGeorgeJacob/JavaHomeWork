import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Broadway", 5, 12);

        // Reserve a single seat
        theatre.reserveSeat("A002");
        // Reserve a block of 10 contiguous seats from row B to C
        List<String> reservedSeats = theatre.reserveSeats(10, 'B', 'C');
        System.out.println("Reserved seats: " + reservedSeats);

        // Print the seating map
        theatre.printSeatMap();
    }
}
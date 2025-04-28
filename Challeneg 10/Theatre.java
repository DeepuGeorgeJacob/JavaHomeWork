import java.util.*;

public class Theatre {
    private String theatreName;
    private int seatsPerRow;
    private TreeSet<Seat> seats;

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        if (numRows > 26) {
            throw new IllegalArgumentException("Number of rows cannot exceed 26 (A-Z).");
        }
        this.theatreName = theatreName;
        this.seatsPerRow = seatsPerRow;
        this.seats = new TreeSet<>();

        for (char row = 'A'; row < (char) ('A' + numRows); row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                seats.add(new Seat(row, seatNum));
            }
        }
    }

    public boolean reserveSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                return seat.reserve();
            }
        }
        return false;
    }

    public List<String> reserveSeats(int numberOfSeats, char startRow, char endRow) {
        List<String> reservedSeats = new ArrayList<>();

        for (char row = startRow; row <= endRow; row++) {
            List<Seat> availableSeatsInRow = new ArrayList<>();

            for (Seat seat : seats) {
                if (seat.getSeatId().charAt(0) == row && !seat.isReserved()) {
                    availableSeatsInRow.add(seat);
                }
            }

            for (int i = 0; i <= availableSeatsInRow.size() - numberOfSeats; i++) {
                boolean contiguous = true;
                for (int j = 1; j < numberOfSeats; j++) {
                    int previous = Integer.parseInt(availableSeatsInRow.get(i + j - 1).getSeatId().substring(1));
                    int current = Integer.parseInt(availableSeatsInRow.get(i + j).getSeatId().substring(1));
                    if (current != previous + 1) {
                        contiguous = false;
                        break;
                    }
                }
                if (contiguous) {
                    for (int j = 0; j < numberOfSeats; j++) {
                        Seat seat = availableSeatsInRow.get(i + j);
                        seat.reserve();
                        reservedSeats.add(seat.getSeatId());
                    }
                    return reservedSeats;
                }
            }
        }

        return reservedSeats;
    }

    public void printSeatMap() {
        char currentRow = ' ';
        for (Seat seat : seats) {
            char rowLetter = seat.getSeatId().charAt(0);
            if (rowLetter != currentRow) {
                if (currentRow != ' ') {
                    System.out.println();
                }
                currentRow = rowLetter;
                System.out.print(rowLetter + ": ");
            }

            if (seat.isReserved()) {
                System.out.print("[XX]");
            } else {
                System.out.print("[" + seat.getSeatId().substring(1) + "]");
            }
        }
        System.out.println();
    }

    public class Seat implements Comparable<Seat> {
        private final String seatId;
        private boolean reserved;

        public Seat(char row, int seatNumber) {
            this.seatId = String.format("%c%03d", row, seatNumber);
            this.reserved = false;
        }

        public String getSeatId() {
            return seatId;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean reserve() {
            if (!reserved) {
                reserved = true;
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat other) {
            return this.seatId.compareTo(other.seatId);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Seat seat = (Seat) obj;
            return seatId.equals(seat.seatId);
        }

        @Override
        public int hashCode() {
            return seatId.hashCode();
        }
    }
}

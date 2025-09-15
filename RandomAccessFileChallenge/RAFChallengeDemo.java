import java.io.*;
import java.util.*;


public class RAFChallengeDemo {
    public static void main(String[] args) {
        String fileName = "employees.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            int count = raf.readInt();
            Map<Integer, Long> index = new TreeMap<>();

            for (int i = 0; i < count; i++) {
                int empId = raf.readInt();
                long position = raf.readLong();
                index.put(empId, position);
            }

            System.out.println("Employee IDs in file: " + index.keySet());

            int targetId = index.keySet().iterator().next();
            System.out.println("\nRetrieving employee with ID " + targetId);

            Employee emp = readEmployee(raf, index.get(targetId));
            System.out.println("Before update: " + emp);


            double newSalary = emp.salary + 5000;
            updateSalary(raf, index.get(targetId), newSalary);

            Employee updated = readEmployee(raf, index.get(targetId));
            System.out.println("After update: " + updated);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee readEmployee(RandomAccessFile raf, long position) throws IOException {
        raf.seek(position);
        int id = raf.readInt();
        double salary = raf.readDouble();
        String first = raf.readUTF();
        String last = raf.readUTF();
        return new Employee(id, salary, first, last);
    }

    private static void updateSalary(RandomAccessFile raf, long position, double newSalary) throws IOException {
        raf.seek(position + Integer.BYTES);
        raf.writeDouble(newSalary);
    }
}

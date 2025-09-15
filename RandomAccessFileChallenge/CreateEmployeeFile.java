import java.io.*;
import java.util.*;

public class CreateEmployeeFile {
    public static void main(String[] args) {
        String fileName = "employees.dat";

        List<Employee> employees = Arrays.asList(
                new Employee(101, 50000, "Alice", "Smith"),
                new Employee(102, 60000, "Bob", "Johnson"),
                new Employee(103, 70000, "Charlie", "Brown"),
                new Employee(104, 61000, "Alex", "Nik"),
                new Employee(105, 32100, "Private", "Ryder")
        );

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.setLength(0);

            raf.writeInt(employees.size());

            long indexStart = raf.getFilePointer();
            for (int i = 0; i < employees.size(); i++) {
                raf.writeInt(0);
                raf.writeLong(0L);
            }

            Map<Integer, Long> indexMap = new LinkedHashMap<>();
            for (Employee emp : employees) {
                long position = raf.getFilePointer();
                indexMap.put(emp.id, position);

                raf.writeInt(emp.id);
                raf.writeDouble(emp.salary);
                raf.writeUTF(emp.firstName);
                raf.writeUTF(emp.lastName);
            }

            raf.seek(indexStart);
            for (Map.Entry<Integer, Long> entry : indexMap.entrySet()) {
                raf.writeInt(entry.getKey());
                raf.writeLong(entry.getValue());
            }

            System.out.println("Employee file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

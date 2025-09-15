class Employee {
    int id;
    double salary;
    String firstName;
    String lastName;

    Employee(int id, double salary, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, salary=%.2f, first='%s', last='%s'}",
                id, salary, firstName, lastName);
    }
}
package model;
import java.time.LocalDate;
import java.util.Objects;


public class EmployeePayrollData {
    public int id;
    public String name;
    public String gender;
    public double salary;
    public LocalDate start;

    public EmployeePayrollData(int id, String name, String gender, double salary, LocalDate start) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.start = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name);
    }
}

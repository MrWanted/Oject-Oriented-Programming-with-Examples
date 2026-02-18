package oop.basics.solid;

// Class responsible ONLY for holding employee data
class Employee {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

// Class responsible ONLY for salary calculations
class SalaryCalculator {

    public double calculateAnnualSalary(Employee employee) {
        return employee.getSalary() * 12;
    }
}

// Demo class
public class SingleResponsibility {

    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 20000);
        SalaryCalculator calculator = new SalaryCalculator();

        System.out.println(
                employee.getName() + "'s annual salary: " +
                        calculator.calculateAnnualSalary(employee)
        );
    }
}

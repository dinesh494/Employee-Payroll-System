package EmployeePayrollSystem;

import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name , int id){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calaculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calaculateSalary()+"]";
    }

}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calaculateSalary() {
        return 0;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calaculateSalary() {
        return hoursWorked*hourlyRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employeeArrayList;
    public PayRollSystem(){
        employeeArrayList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeArrayList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove= null;
        for(Employee employee : employeeArrayList){
            if (employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove!=null)
            employeeArrayList.remove(employeeToRemove);
    }
    public void displayEmployees(){
        for (Employee employee: employeeArrayList)
            System.out.println(employee);
    }
}


public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem  = new PayRollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Dinesh Kumar",1001,500000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Sunil Patro",1002,50,16.0);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);

        System.out.println("Intial Employee Details: ");
        payRollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payRollSystem.removeEmployee(1001);

        System.out.println("\nRemaining Employee Details..");
        payRollSystem.displayEmployees();

    }
}

import Employee.EmployeeBook;
public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(3);
        employeeBook.addEmployee();
        employeeBook.addEmployee();
        employeeBook.printAllSalary();
        employeeBook.findAverageSalary();
    }
}

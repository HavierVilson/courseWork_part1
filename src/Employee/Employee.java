package Employee;

import java.util.Objects;

public class Employee {
    private String lastName; // Фамилия
    private String firstName; // Имя
    private String middleName; // Отчество
    private int department; // Отдел
    private double salary; // Зарплата
    private int id; // ID
    private static int counter = 1; //  Счетчик

    protected Employee(String lastName, String firstName, String middleName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public void setDepartment(int department) {  // Метод изменения отдела
        try {
            if (department < 1 || department > 5) {
                throw new Exception("\nВ отдел можно написать число от 1 до 5!\nВ изменеиии отказано!");
            }
            this.department = department;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setSalary(double newSalary) { // Метод изсения зарплаты
        try {
            if (newSalary < 1) {
                throw new Exception("\nОшибка заработная плата не может быть меньше или равна 0!\nВ изменеиии отказано!");
            }
            this.salary = newSalary;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lastName + firstName + middleName + department + salary + id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee e = (Employee) obj;
        return Objects.equals(lastName, e.lastName) && Objects.equals(firstName, e.firstName) && Objects.equals(middleName, e.middleName) && Objects.equals(salary, e.salary) &&
                Objects.equals(department, e.department);
    }

    @Override
    public String toString() {
        return "ФИО: " + lastName + " " + firstName + " " + middleName + ". Отдел: " + department + ". Заработканя плата: " + salary + " рублей.";
    }
}
class ExceptionDepartment extends Exception { //Я еще не докуонца понимаю обработчик ошибок, но надеюсь иду в правильном пути
    public ExceptionDepartment(String message) {
        super(message);
    }
}

class ExceptionBadSalary extends Exception {
    public ExceptionBadSalary(String message) {
        super(message);
    }
}

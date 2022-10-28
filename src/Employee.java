public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private int department;
    private int salary;
    private int id;
    private static int counter = 1;

    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        try {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.salary = salary;
            this.id = counter;
            counter++;
            if (department < 1 || department > 5) {
                throw new Exception("Ошибка! В отдел можно написать число от 1 до 5...");
            }
            this.department = department;
            System.out.println("Карточка сотрудника создана!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Карточка сотрудника создана, но отдел был выставлен принудительно!");
            this.department = 1;
        }
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

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public void setDepartment(int department) {
        try {
            if (department < 1 || department > 5) {
                throw new Exception("В отдел можно написать число от 1 до 5!\nВ изменеиии отказано!");
            }
            this.department = department;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ФИО: " + lastName + " " + firstName + " " + middleName + ". Отдел: " + department + ". Заработканя плата: " + salary + " рублей.";
    }
}

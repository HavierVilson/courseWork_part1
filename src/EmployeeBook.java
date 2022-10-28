import java.util.Scanner;

public class EmployeeBook {
    private static Employee[] employeesBook = new Employee[10];

    public static void readEmployeeBook() {
        int counter = 1;
        System.out.println("\nСписок сотрудников:");
        for (Employee e : employeesBook) {
            System.out.println(counter + ". "+ e);
            counter++;
        }
    }

    public static void addEmployee() {
        int freeCell = 0;
        for (Employee e : employeesBook) {
            if (e == null) {
                break;
            } else {
                if (freeCell == 9){
                    System.out.println("Все ячейки заняты!");
                } else {
                    freeCell++;
                }
            }
        }
        Scanner in = new Scanner(System.in); //Создал сканер
        System.out.print("Введите ФИО сотрудника: "); //Вводить ФИО через пробел!
        String fullName = in.nextLine(); //Временная переменная для ФИО
        System.out.print("В каком отделе будет работь сотрудник? (Для ввода доступно 1 -5) - ");
        int department = in.nextInt(); //Переменная для отдела
        System.out.print("Введите заработную плату: ");
        int salary = in.nextInt(); //Переменная для заработной платы
        String[] arrayName = new String[3]; //Массив для разделения ФИО
        arrayName = fullName.split(" "); //Разделяю ФИО
        employeesBook[freeCell] = new Employee(arrayName[0],arrayName[1],arrayName[2],department,salary);
    }
    public static void deleteEmployee() {
        Scanner in = new Scanner(System.in); //Создал сканер
        System.out.print("Введите номер сотрудника для удаления: ");
        int a = in.nextInt();
        employeesBook[a-1] = null; //Номер сотрудника начинается с 1, не с 0 как в массиве
        System.out.println("Ячейка сотрудника была удалена");
    }
}

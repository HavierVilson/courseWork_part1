package Employee;

import java.util.Scanner;

public class EmployeeBook {
    private Employee[] array;

    public EmployeeBook(int length) {
        this.array = new Employee[length];
    }

    public void addEmployee() {
        try {
            int freeCell = 0; // Счетчик
            for (Employee e : array) {
                if (e == null) { // Проверка на пустую ячейку
                    break; // Если ячейка пустая - то цил прерывается и начинается создание класса
                } else {
                    if (freeCell == array.length - 1) { // Если в масиве нет места - то выпадает ошибка
                        throw new Exception("\nВсе ячейки заняты!");
                    } else {
                        freeCell++;
                    }
                }
            }
            try {
                Scanner in = new Scanner(System.in); //Создал сканер
                System.out.print("Введите ФИО сотрудника: "); //Вводить ФИО через пробел!
                String fullName = in.nextLine(); //Временная переменная для ФИО
                System.out.print("В каком отделе будет работь сотрудник? (Для ввода доступно от 1 до 5) - ");
                int department = in.nextInt(); //Переменная для отдела
                if (department < 1 || department > 5) {
                    throw new ExceptionDepartment("\nОшибка! Для ввода доступно от 1 до 5. Создание сотрудника прервано...");
                }
                System.out.print("Введите заработную плату: ");
                double salary = in.nextDouble(); //Переменная для заработной платы
                if (salary <= 0) {
                    throw new ExceptionBadSalary("\nОшибка заработная плата не может быть меньше или равна 0! Создание сотрудника прервано...");
                }
                String[] arrayName = new String[3]; //Массив для разделения ФИО
                arrayName = fullName.split(" "); //Разделяю ФИО
                Employee e = new Employee(arrayName[0], arrayName[1], arrayName[2], department, salary); //Если я правильно понял - то так я не нарушаю принципов SOLID
                array[freeCell] = e;
            } catch (ExceptionDepartment ex) {
                System.out.println(ex.getMessage());
            } catch (ExceptionBadSalary ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printEmployeeBook() { // Метод для чтения книги сотрудников
        int counter = 1;
        System.out.println("\nСписок сотрудников:");
        for (Employee e : array) {
            if (e != null) {
                System.out.println(counter + ". " + e);
            }
            counter++;
        }
    }

    public void deleteEmployee() { // Метод удаления сотрудника
        Scanner in = new Scanner(System.in); //Создал сканер
        System.out.print("\nВведите номер сотрудника для удаления: ");
        int a = in.nextInt();
        array[a - 1] = null; //Номер сотрудника начинается с 1, не с 0 как в массиве
        System.out.println("Ячейка сотрудника была удалена");
    }

    public void findAllSalary() { //Поиск суммы всех зарплат
        double sum = 0;
        for (Employee e : array) {
            if (e != null) {
                sum += e.getSalary();
            }
        }
        System.out.println("\nСумма всех зарплат: " + sum + " рублей.");
    }

    public void findMinSalary() { //Поиск минимальной зарплаты
        double min = array[0].getSalary();
        for (Employee e : array) {
            if (e.getSalary() < min && e != null) {
                min = e.getSalary();
            }
        }
        System.out.println("\nМинимальная зарплата: " + min + " рубей.");
    }

    public void findMaxSalary() {  // Поиск максимальной зарплаты
        double max = array[0].getSalary();
        for (Employee e : array) {
            if (e.getSalary() > max && e != null) ;
            {
                max = e.getSalary();
            }
        }
        System.out.println("\nМаксимальная зарплата: " + max + " рубей.");
    }

    public void findAverageSalary() { // Поиск середней суммы заработной платы
        int sum = 0;
        for (Employee e : array) {
            if (e != null) {
                sum += e.getSalary();
            }
        }
        int result = sum / array.length;
        System.out.println("\nСредняя зарплата равна: " + result + " рублей.");
    }

    public void printOnlyFullName() { // Метод для вывода ФИО
        for (Employee e : array) {
            if (e != null) {
                System.out.println("\nФИО сотрудника: " + e.getLastName() + " " + e.getFirstName() + " " + e.getMiddleName() + ".");
            }
        }
    }

    public void indexSalarys(double percent) { // Индексация на аргумент
        for (Employee e : array) {
            if (e != null) {
                e.setSalary(e.getSalary() + e.getSalary() * (percent / 100));
            }
        }
    }

    public void findMinSalaryInDepartment(int department) { // Поиск минимальной зарплаты по отделу
        double min = 999_999_999;
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                if (e.getSalary() < min) {
                    min = e.getSalary();
                }
            }
        }
        System.out.println("\nМинимальная зарплата в " + department + " отделе. Равна: " + min + " рублей.");
    }

    public void findMaxSalaryInDepartment(int department) { // Поиск максимальной зарплаты по отделу
        double max = -1;
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                if (e.getSalary() > max) {
                    max = e.getSalary();
                }
            }
        }
        System.out.println("\nМаксимальная зарплата в " + department + " отделе. Равна: " + max + " рублей.");
    }

    public void findAllSalaryInDepartment(int department) { // Поиск суммы зарплат по отделу
        double sum = 0;
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                sum += e.getSalary();
            }
        }
        System.out.println("\nСумма зарплат в отделе " + department + " равна: " + sum + " рублей.");
    }

    public void findAverageSalaryInDepartment(int department) { // Поиск средней зарплаты по отделу
        int counter = 0, sum = 0;
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                counter++;
                sum += e.getSalary();
            }
        }
        int result = sum / counter;
        System.out.println("\nСредняя зарплата в отделе " + department + " равна: " + result + " рублей.");
    }

    public void printEmployeeInDepartment(int department) { // Выводит список сотрудников отдела
        System.out.println("\nСотрудники отдела " + department + ":");
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                System.out.print("\nФИО сотрудника: " + e.getLastName() + " " + e.getFirstName() + " " + e.getMiddleName() + "." + "  Зарплата: " + e.getSalary() + " рублей.");
            }
        }
    }

    public void indexSalaryInDepartment(int department, double percent) { // Индексация зарплат в депертаменте
        for (Employee e : array) {
            if (e.getDepartment() == department) {
                e.setSalary(e.getSalary() + e.getSalary() * (percent / 100));
            }
        }
    }

    public void printEmployeeByDepartment() { // Печатает сотрудников по департаменту
        for (int i = 1; i <= 5; i++) {
            int stop = 0;
            for (Employee e : array) {
                if (e.getDepartment() == i) {
                    if (stop < i) {
                        System.out.println("\nВ департаменте " + i + " работают:");
                    }
                    System.out.println("ФИО сотрудника: " + e.getLastName() + " " + e.getFirstName() + " " + e.getMiddleName() + "." + "  Зарплата: " + e.getSalary() + " рублей.");
                }
            }
        }
    }

    public void changeEmployee() {  // Метод измениения сотрудника
        Scanner in = new Scanner(System.in);
        System.out.print("\nКакого сотрудника вы хотите изменить? - ");
        int id = in.nextInt();
        System.out.print("\nКакая зарабатная блата должны быть у сотрудника? - ");
        double newSalary = in.nextDouble();
        array[id-1].setSalary(newSalary);
        System.out.print("\n В каком отделе должен работать сотрудник? - ");
        int department = in.nextInt();
        array[id-1].setDepartment(department);
        System.out.print("\nИзменение сотрудника завершено!");
    }
}

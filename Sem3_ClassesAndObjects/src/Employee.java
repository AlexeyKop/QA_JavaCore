// Класс "Сотрудник" с базовыми полями
public class Employee {
    private String fullName;
    private String position;
    private String phone;
    private double salary;
    private int age;

    // Конструктор для инициализации объекта
    public Employee(String fullName, String position, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // Метод для вывода всей информации о сотруднике
    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    // Геттеры для полей
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    // Статический метод для повышения зарплаты сотрудникам старше 45 лет
    public static void increaseSalaryForOlderEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getAge() > 45) {
                employee.setSalary(employee.getSalary() + 5000);
            }
        }
    }

    // Метод для вычисления среднего возраста сотрудников
    public static double calculateAverageAge(Employee[] employees) {
        int totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        return (double) totalAge / employees.length;
    }

    // Метод для вычисления средней зарплаты сотрудников
    public static double calculateAverageSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.length;
    }

    // Метод-компаратор для сравнения двух дат без условного оператора
    public static int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        return Integer.compare(year1 * 10000 + month1 * 100 + day1, year2 * 10000 + month2 * 100 + day2);
    }
}
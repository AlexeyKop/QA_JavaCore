// Класс "Руководитель", наследник класса "Сотрудник"
class Manager extends Employee {
    public Manager(String fullName, String position, String phone, double salary, int age) {
        super(fullName, position, phone, salary, age);
    }

    // Перенесенный метод повышения зарплаты
    public static void increaseSalaryForEmployeesExceptManagers(Employee[] employees) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager) && employee.getAge() > 45) {
                employee.setSalary(employee.getSalary() + 5000);
            }
        }
    }
}
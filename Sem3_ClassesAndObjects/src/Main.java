public class Main {
    public static void main(String[] args) {
        //Массив сотрудников
        Employee[] employees = {
                new Employee("Иван Иванов", "Инженер", "8 999 123-45-67", 50000, 30),
                new Employee("Петр Петров", "Программист", "8 999 789-89-00", 60000, 46),
                new Employee("Анна Смирнова", "Дизайнер", "8 999 345-67-89", 55000, 50),
                new Employee("Ольга Сидорова", "Менеджер", "8 999 901-23-45", 52000, 28),
                new Manager("Сергей Волков", "Руководитель", "8 999 567-89-00", 80000, 48)
        };

        // Выводим информацию о всех сотрудниках
        System.out.println("Информация о сотрудниках:");
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        // Повышаем зарплату всем сотрудникам старше 45 лет
        Manager.increaseSalaryForEmployeesExceptManagers(employees);

        // Снова выводим информацию о всех сотрудниках
        System.out.println("Информация после повышения зарплаты:");
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        // Вычисляем и выводим средний возраст и зарплату
        System.out.println("Средний возраст сотрудников: " + Employee.calculateAverageAge(employees));
        System.out.println("Средняя зарплата сотрудников: " + Employee.calculateAverageSalary(employees));
    }
}

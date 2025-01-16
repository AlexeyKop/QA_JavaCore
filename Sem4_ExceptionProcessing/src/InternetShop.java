import java.time.LocalDate;

public class InternetShop {

    // Создание массивов
    private static final Customer[] people = {
            new Customer("Ivan", 20, "+7-999-333-44-55", Gender.MALE),
            new Customer("Anna", 30, "+7-999-444-55-66", Gender.FEMALE),
            new Customer("Petr", 25, "+7-999-222-11-00", Gender.MALE),
    };

    private static final Item[] items = {
            new Item("Ball", 100),
            new Item("Sandwich", 1000),
            new Item("Table", 10000),
            new Item("Car", 100000),
            new Item("Rocket", 10000000)
    };

    private static final Order[] orders = new Order[5];

    // Основной метод покупки
    public static Order buy(Customer who, Item what, int howMuch) {
        if (!isInArray(people, who)) {
            throw new CustomerException("Unknown customer: " + who);
        }
        if (!isInArray(items, what)) {
            throw new ProductException("Unknown item: " + what);
        }
        if (howMuch < 0 || howMuch > 100) {
            throw new AmountException("Incorrect amount: " + howMuch);
        }

        return new Order(who, what, howMuch);
    }

    // Метод проверки наличия объекта в массиве
    private static boolean isInArray(Object[] arr, Object o) {
        for (Object element : arr) {
            if (element.equals(o)) return true;
        }
        return false;
    }

    // Метод для поздравления сотрудников
    private static void congratulateEmployees(Customer[] customers, Holiday holiday) {
        switch (holiday) {
            case NEW_YEAR:
                System.out.println("C Новым Годом!");
                break;
            case MARCH_8:
                for (Customer customer : customers) {
                    if (customer.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 марта, " + customer.getName() + "!");
                    }
                }
                break;
            case FEBRUARY_23:
                for (Customer customer : customers) {
                    if (customer.getGender() == Gender.MALE) {
                        System.out.println("С 23 февраля, " + customer.getName() + "!");
                    }
                }
                break;
            default:
                System.out.println("Сегодня нет праздников.");
        }
    }

    // Тестовая среда
    public static void main(String[] args) {
        Object[][] info = {
                {people[0], items[0], 1}, // good
                {people[1], items[1], -1}, // bad amount -1
                {people[2], items[2], 150}, // bad amount > 100
                {people[1], new Item("Flower", 10), 1}, // no item
                {new Customer("Fedor", 40, "+7-999-555-66-77", Gender.MALE), items[3], 1} // no customer
        };

        int capacity = 0;
        int i = 0;

        while (capacity != orders.length && i < info.length) {
            try {
                orders[capacity] = buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                System.out.println("Ошибка товара: " + e.getMessage());
            } catch (AmountException e) {
                System.out.println("Ошибка количества: " + e.getMessage());
                orders[capacity++] = buy((Customer) info[i][0], (Item) info[i][1], 1);
            } catch (CustomerException e) {
                System.out.println("Критическая ошибка: " + e.getMessage());
                break;
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            i++;
        }

        // Итоговый вывод
        System.out.println("Итоговые заказы:");
        for (Order order : orders) {
            if (order != null) {
                System.out.println(order);
            }
        }

        //поздравление сотрудников
        LocalDate today = LocalDate.now();
        Holiday holiday = switch (today.getDayOfMonth()) {
            case 1 -> Holiday.NEW_YEAR;
            case 8 -> Holiday.MARCH_8;
            case 23 -> Holiday.FEBRUARY_23;
            default -> Holiday.NO_HOLIDAY;
        };
        congratulateEmployees(people, holiday);
    }
}

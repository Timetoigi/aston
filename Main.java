/**
// Создаем класс Сотрудник
class Employee {
    private String fullName; // ФИО
    private String position;  // Должность
    private String email;     // Email
    private String phone;     // Телефон
    private double salary;    // Зарплата
    private int age;         // Возраст

    // Конструктор класса
    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // Метод для вывода информации об объекте
    public void displayInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println("-----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Объявляем массив объектов
        Employee[] empArray = new Employee[5];

        // Заполняем массив объектами класса Employee
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivanov@mailbox.com", "892312312", 30000, 30);
        empArray[1] = new Employee("Petrov Petr", "Manager", "petrov@mailbox.com", "892312313", 40000, 35);
        empArray[2] = new Employee("Sidorov Sidr", "Analyst", "sidorov@mailbox.com", "892312314", 35000, 28);
        empArray[3] = new Employee("Kuznetsov Kuzya", "Designer", "kuznetsov@mailbox.com", "892312315", 32000, 32);
        empArray[4] = new Employee("Smirnov Semyon", "Developer", "smirnov@mailbox.com", "892312316", 45000, 29);

        // Выводим информацию о каждом сотруднике
        for (Employee emp : empArray) {
            emp.displayInfo();
        }
    }
}
*/


/**


// Класс Park, представляющий парк аттракционов
class Park {
    private String name; // Название парка
    private String location; // Местоположение парка
    private Attraction[] attractions; // Массив аттракционов
    private int attractionCount; // Количество аттракционов

    // Конструктор класса Park
    public Park(String name, String location, int maxAttractions) {
        this.name = name;
        this.location = location;
        this.attractions = new Attraction[maxAttractions];
        this.attractionCount = 0;
    }

    // Метод для добавления аттракциона
    public void addAttraction(String name, String openingHours, double price) {
        if (attractionCount < attractions.length) {
            attractions[attractionCount++] = new Attraction(name, openingHours, price);
        } else {
            System.out.println("Превышено максимальное количество аттракционов.");
        }
    }

    // Метод для вывода информации о парке и аттракционах
    public void displayInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Местоположение: " + location);
        System.out.println("Аттракционы:");
        for (int i = 0; i < attractionCount; i++) {
            attractions[i].displayInfo();
        }
    }

    // Внутренний класс Attraction
    private class Attraction {
        private String name; // Название аттракциона
        private String openingHours; // Время работы
        private double price; // Стоимость

        // Конструктор класса Attraction
        public Attraction(String name, String openingHours, double price) {
            this.name = name;
            this.openingHours = openingHours;
            this.price = price;
        }

        // Метод для вывода информации об аттракционе
        public void displayInfo() {
            System.out.println("  Аттракцион: " + name);
            System.out.println("  Время работы: " + openingHours);
            System.out.println("  Стоимость: " + price + " руб.");
        }
    }
}

// Главный класс для тестирования
public class Main {
    public static void main(String[] args) {
        Park park = new Park("Сказочный парк", "Москва", 5);

        // Добавляем аттракционы
        park.addAttraction("Колесо обозрения", "09:00 - 22:00", 500);
        park.addAttraction("Американские горки", "10:00 - 20:00", 700);
        park.addAttraction("Поездка на лодке", "11:00 - 19:00", 300);

        // Выводим информацию о парке и аттракционах
        park.displayInfo();
    }
}
 */
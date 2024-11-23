import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phoneNumber) {
        contacts.putIfAbsent(surname, new ArrayList<>());
        contacts.get(surname).add(phoneNumber);
    }

    // Метод для получения номера по фамилии
    public List<String> get(String surname) {
        return contacts.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Иванов", "123456");
        phoneBook.add("Петров", "654321");
        phoneBook.add("Иванов", "789012");
        phoneBook.add("Сидоров", "345678");
        phoneBook.add("Петров", "987654");

        // Получаем номера по фамилии
        System.out.println("Записи для фамилии Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Записи для фамилии Петров: " + phoneBook.get("Петров"));
        System.out.println("Записи для фамилии Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Записи для фамилии Смирнов: " + phoneBook.get("Смирнов"));  // Нет записей
    }
}

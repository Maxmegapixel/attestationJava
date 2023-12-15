import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class program {
    public static void main(String[] args) {
        // Создаем телефонную книгу с использованием HashMap
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "987-654-321");
        addContact(phoneBook, "Иванов", "111-222-333");
        addContact(phoneBook, "Сидоров", "555-555-555");
        addContact(phoneBook, "Петров", "444-444-444");

        // Выводим отсортированный список контактов
        printSortedPhoneBook(phoneBook);
    }
    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт с таким именем уже существует, добавляем телефон к существующему списку
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Иначе создаем новую запись в телефонной книге
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода отсортированной телефонной книги
    private static void printSortedPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей телефонной книги для сортировки
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        // Выводим отсортированный список
        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}    
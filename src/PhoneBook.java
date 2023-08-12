import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        // добавление записей в телефонную книгу
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Для остановки ввода данных введите 0");

        while (true) {
            System.out.print("Введите имя: ");
            String name = in.nextLine();

            if (name.equals("0")) {
                break;
            }

            System.out.print("Введите номер телефона: ");
            String phone = in.nextLine();

            addRecord(phoneBook, name, phone);
        }

        in.close();

        // // вывод записей в телефонной книге
        // System.out.println("Телефонная книга:");
        // for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
        //     String name = entry.getKey();
        //     ArrayList<String> phones = entry.getValue();
        //     System.out.println(name + ": " + phones);
        // }

        // сортировка записей по убыванию числа телефонов
        List<Map.Entry<String, ArrayList<String>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        // вывод отсортированных записей
        System.out.println("Ваша телефонная книга:");
        for (Map.Entry<String, ArrayList<String>> entry : list) {
            String name = entry.getKey();
            ArrayList<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    // метод для добавления записи в телефонную книгу
    public static void addRecord(HashMap<String, ArrayList<String>> phoneBook, String name, String phone) {
        if (phoneBook.containsKey(name)) {
            ArrayList<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> telbook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        boolean Exit = false;


        while (!Exit) {
            PrintMenu();
            System.out.println();
            switch (in.nextLine()) {
                case "1":
                    AddTelephoneWithName(telbook);
                    break;
                case "2":
                    PrintTelephoneBook(telbook);
                    break;
                case "3":
                    Exit = true;
                    break;
                default:

                    break;
            }
        }
    }
    public static void PrintMenu(){
        System.out.println("1: Добавить запись");
        System.out.println("2: Вывести книгу на экран");
        System.out.println("3: Выход");
    }
    public static void AddTelephoneWithName(HashMap<String, HashSet<String>> book){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите номер телефона: ");
        String number = in.nextLine();
        if (book.containsKey(name)){
            var numbers = book.get(name);
            numbers.add(number);
        }
        else{
            HashSet<String> numbers = new HashSet<>();
            numbers.add(number);
            book.put(name, numbers);
        }
    }

    public static void PrintTelephoneBook(HashMap<String, HashSet<String>>book){
        HashSet<String> keys = new HashSet<>(book.keySet());
        for (String item: keys){
            System.out.println("Имя: "+item);
            System.out.println("Номер: " + book.get(item));
        }

    }
}
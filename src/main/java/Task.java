// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//        Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.

import java.util.*;
public class Task {
    public static void main(String[] args){
        //System.out.println("Hello world!");
        dataBase();
        getEmployees();
        getPopularName(0);
    }
    static HashMap<Integer, ArrayList<String>> employees = new HashMap<>();
    static Integer keyEmployee = 0;
    private static void dataBase(){
        HashMap<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addEmployees("Иван", "Иванов", createPhoneNumber());
        addEmployees("Светлана", "Петрова", createPhoneNumber());
        addEmployees("Кристина", "Белова", createPhoneNumber());
        addEmployees("Анна", "Мусина", createPhoneNumber());
        addEmployees("Анна", "Крутова", createPhoneNumber());
        addEmployees("Иван", "Юрин", createPhoneNumber());
        addEmployees("Петр", "Лыков", createPhoneNumber());
        addEmployees("Павел", "Чернов", createPhoneNumber());
        addEmployees("Петр", "Чернышов", createPhoneNumber());
        addEmployees("Мария", "Федорова", createPhoneNumber());
        addEmployees("Марина", "Светлова", createPhoneNumber());
        addEmployees("Мария", "Савина", createPhoneNumber());
        addEmployees("Мария", "Рыкова", createPhoneNumber());
        addEmployees("Марина", "Лугова", createPhoneNumber());
        addEmployees("Анна", "Владимирова", createPhoneNumber());
        addEmployees("Иван", "Мечников", createPhoneNumber());
        addEmployees("Петр", "Петин", createPhoneNumber());
        addEmployees("Иван", "Ежов", createPhoneNumber());
    }
    private static void addEmployees(String firstName, String lastName, String phone){
        keyEmployee +=1;
        ArrayList<String> empl = new ArrayList<>();
        empl.add(firstName);
        empl.add(lastName);
        empl.add(phone);
        employees.put(keyEmployee, empl);
    }
    private static String createPhoneNumber(){
        String number = "+7-9";
        Random random = new Random();
        int num = random.nextInt(99999999 - 11000000) + 11000000;
        String phoneNumber = Integer.toString(num);
        number += phoneNumber;
        return number;
    }
    private static void getEmployees(){
        for (Integer key: employees.keySet()) {
            System.out.println(key + " = " + employees.get(key));
        }
        System.out.println();
    }
    private static void getPopularName(Integer id){
        TreeMap<String, Integer> tmpTree = new TreeMap<>();
        employees.forEach((k, v) -> tmpTree.put(v.get(0), 0));
        int[] tmpCnt = new int[]{0, 0};
        String[] strings = new String[]{""};
        for (String nbame: tmpTree.keySet()) {
            tmpCnt[0] = tmpTree.get(nbame);
            employees.forEach((k, v) -> {
                if (v.get(0).equals(nbame)) tmpCnt[0]++;
                if(tmpCnt[0] > tmpCnt[1]){
                    tmpCnt[1] = tmpCnt[0];
                    strings[0] = nbame;
                }
            });
            tmpTree.put(nbame, tmpCnt[0]);
        }
        System.out.print(tmpTree);
    }
}

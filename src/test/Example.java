package test;

public class Example {
    public static void main(String args[]) {
        System.out.println("Пример 1:");
        String str = "разделить-строку-по-разделителю";
        String[] subStr;
        String delimeter = "-"; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        // Вывод результата на экран
        for(int i = 0; i < subStr.length; i++) {
            System.out.println(subStr[i]);
        }

        // Ещё один пример разделения
        System.out.println("\nПример 2:");
        str = "1    !   mike   !  qwerty    !";
        System.out.println(str);
        delimeter = "\\!"; // Разделитель
        subStr = str.split(delimeter);
        // Вывод результата на экран
        for(int i = 0; i < subStr.length; i++) {
            System.out.println(subStr[i]);
            if (i==2){System.out.println(subStr[i].equals("qwerty"));}
        }

        // Ещё один пример разделения с использованием порога
        System.out.println("\nПример 3:");
        str = "ID!name!password!";
        delimeter = "!"; // Разделитель
        subStr = str.split(delimeter, 3); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        for(int i = 0; i < subStr.length; i++) {
            System.out.println(subStr[i]);
        }
    }
}
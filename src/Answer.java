import java.util.Scanner;

public class Answer {
    Scanner scan = new Scanner(System.in);

    public String checkCommands() {
        boolean commandRight = false;
        String out = "";
        String command = scan.nextLine();
        do {
            switch (command) {
                case "да":
                case "y":
                case "yes":
                case "ДА":
                case "YES":
                case "д":
                case "Д":
                    commandRight = true;
                    out = "yes";
                    break;
                case "нет":
                case "n":
                case "no":
                case "NO":
                case "НЕТ":
                case "Н":
                case "н":
                    commandRight = true;
                    out = "no";
                    break;
                case "exit":
                case "EXIT":
                case "выход":
                case "ВЫХОД":
                case "В":
                case "в":
                case "e":
                    commandRight = true;
                    out = "exit";
                    break;
                default:
                    System.out.println("Введите ДА(Д,д), НЕТ(Н,н) или Выход(В,в) Input YES(Y,y), NO(N,n)!!! or EXIT(E,e)!!!");
                    command = scan.nextLine();
            }
        } while (!commandRight);
        return out;
    }
}
//25.06.23
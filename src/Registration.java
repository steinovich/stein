import java.util.Scanner;

public class Registration {
    private final Scanner scan = new Scanner(System.in);

    public void regAcc(Base base) {
        //===============================
        //input  name
        //===============================
        System.out.println("Введите имя пользователя:");
        String name;
        name = scan.nextLine();

        //===============================
        //check Existing Name in Base
        //===============================
        boolean exist;
        do {
            exist = base.checkExistName(name);
            if (exist) {
                System.out.println("Аккаунт с таким именем уже существует ");
                System.out.println("Введите другое имя пользователя:");
                name = scan.nextLine();
            }
        } while (exist);
        //===============================
        //input  password
        //===============================
        System.out.println("Введите пароль:");
        int pass = scan.nextLine().hashCode();
        //===============================
        //Add account in Base
        //===============================
        base.addAccount(name, pass);
        System.out.println("Регистрации прошла успешно");
    }
}



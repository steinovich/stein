import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private final Scanner scan = new Scanner(System.in);

    public void regAcc(Base base) throws IOException {
        //===============================
        //input  name
        //===============================
        System.out.println("Введите имя пользователя:");
        String name;
        name = scan.nextLine();

        //===============================
        //check Existing Name in Base
        //===============================
        boolean exist = true;
        if (base.emptyBase()) {
            exist = false;
        }
        while (exist) {
            exist = base.checkExistName(name);
            if (exist) {
                System.out.println("Аккаунт с таким именем уже существует ");
                System.out.println("Введите другое имя пользователя:");
                name = scan.nextLine();
            }
        }
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

//25.06.23

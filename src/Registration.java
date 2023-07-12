import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private final Scanner scan = new Scanner(System.in);

    public void regAcc(Base base) throws IOException {
        //===============================
        //input  name
        //===============================
        System.out.println(Language.inputName);
        String name;
        name = scan.nextLine();

        //===============================
        //check Existing Name in Base
        //===============================
        boolean exist = !base.emptyBase();
        while (exist) {
            exist = base.checkExistName(name);
            if (exist) {
                System.out.println(Language.NameAlreadyExist);
                System.out.println(Language.inputOtherName);
                name = scan.nextLine();
            }
        }
        //===============================
        //input  password
        //===============================
        System.out.println(Language.inputPassword);
        int pass = scan.nextLine().hashCode();
        //===============================
        //Add account in Base
        //===============================
        base.addAccount(name, pass);
        System.out.println(Language.registrationCompleted);
    }
}

//25.06.23

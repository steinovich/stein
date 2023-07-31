import java.io.IOException;
import java.util.Scanner;

public class Registration {
    Language language;
    private final Scanner scan = new Scanner(System.in);
    public Registration(Language lng){
       Language language=lng;

    }

    public void regAcc(Base base) throws IOException {
        //===============================
        //input  name
        //===============================
        System.out.println(language.inputName);
        String name;
        name = scan.nextLine();

        //===============================
        //check Existing Name in Base
        //===============================
        boolean exist = !base.emptyBase();
        while (exist) {
            exist = base.checkExistName(name);
            if (exist) {
                System.out.println(language.NameAlreadyExist);
                System.out.println(language.inputOtherName);
                name = scan.nextLine();
            }
        }
        //===============================
        //input  password
        //===============================
        System.out.println(language.inputPassword);
        int pass = scan.nextLine().hashCode();
        //===============================
        //Add account in Base
        //===============================
        base.addAccount(name, pass);
        System.out.println(language.registrationCompleted);
    }
}

//25.06.23

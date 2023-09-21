import java.io.IOException;
import java.util.Scanner;

public class Registration {
    Language language;
    private final Scanner scan = new Scanner(System.in);
    BaseInterface base;

    public Registration(Language lng) {
        Language language = lng;

    }

    /**
     * зеленый  комментарий
     */
    public void regAcc(BaseInterface base, Language language) throws IOException, ClassNotFoundException {
        this.language=language;
        this.base = base;
        String name = inputName();
        checkExistName(name);
        base.addAccount(name, inputPassword());
        System.out.println(language.registrationCompleted);
    }

    String inputName() {
        System.out.println(language.inputName);
        return scan.nextLine();
    }

    void checkExistName(String name) throws IOException, ClassNotFoundException {
        boolean exist = !base.emptyBaseFile();
        while (exist) {
            exist = base.checkExistName(name);
            if (exist) {
                System.out.println(language.NameAlreadyExist);
                System.out.println(language.inputOtherName);
                name = scan.nextLine();
            }
        }
    }

    int inputPassword() {
        System.out.println(language.inputPassword);
        return scan.nextLine().hashCode();

    }
}

//20.09.23

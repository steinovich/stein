import java.io.IOException;
import java.util.Scanner;

class Authentication {

    private int try_count = 3;

    private final Scanner scan = new Scanner(System.in);

    //===============================
    //main  Authentication Function
    //===============================
    void authFunc(Base base) throws IOException {
        // try_count = 3;
        boolean auth;

        Answer input = new Answer();
        if (try_count > 0) {
            do {
//            ifEmptyBaseWrite(base);

                System.out.println(Language.autentification);
                System.out.println(Language.inputName);
                String name = scan.nextLine();

                //==============checkOutProgram==================================
                if (name.equals("exit") || name.equals("e") || name.equals("отмена")) {
                    System.out.println(Language.cancel);
                    break;
                }
                //==============check NameExistInBase============================
                boolean exist = base.checkExistName(name);

                //==============start Authentication===============================
                if (exist) {
                    auth = authenticationFunction(base, name);

                } else {
                    System.out.println(Language.NameNotExist);
                    System.out.println(Language.doYouWantReg);
                    //=====================check input=======================

                    if (input.checkCommands().equals("yes")) {

                        Registration reg = new Registration();
                        reg.regAcc(base);
                        break;
                    }
                    break;
                }
            } while (try_count > 0 && !auth);
        } else {
            System.out.println(Language.autentificationLocked);
        }


    }



    //===============================
    //additional Authentication Function
    //===============================
    boolean authenticationFunction(Base base, String name) throws IOException {
        // Answer answer = new Answer();
        boolean auth = false;
        int basePass = base.getPass(name);


//===============Input password==========================================
        System.out.println(Language.inputPassword);
        int passIn = scan.nextLine().hashCode();
        //==============checkOutProgram==================================
        if (passIn == "exit".hashCode() || passIn == "выход".hashCode()) {
            System.out.println(Language.cancel);


            //==================check  password for Authentication=========================

        } else if (passIn == basePass) {
            auth = true;
            System.out.println(Language.authentificationCompleted);

        } else {
            System.out.println(Language.nameOrPasswordWrong);
            try_count--;
            System.out.println(Language.numberTry + try_count);

            //==============checkOutProgram==================================


            //=====================check input=======================



        }



        return auth;
    }

    //===============================
    //check Empty Base
    //===============================
}
//25.06.23
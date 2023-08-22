import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Authentication {
    Language lang;
    //    String autentification=;
//    String inputName;
//    String NameNotExist;
//    String doYouWantReg;
//
//    String cancel;
//    String doYouWantReg;
//    String doYouWantReg;
//    String doYouWantReg;
//    String doYouWantReg;
//    String doYouWantReg;
    private int try_count = 5;

    private final Scanner scan = new Scanner(System.in);

    public Authentication(Language language) {
        lang = language;

    }

    //===============================
    //main  Authentication Function
    //===============================
    void authFunc(Base base) throws IOException {
        // try_count = 3;
        boolean auth;
        TryCount tryCountObjecct;
        tryCountObjecct = new TryCount(try_count, "name");

        ArrayList<String> names = new ArrayList<>();
        Answer input = new Answer(lang);
        if (try_count > 0) {
            do {
//            ifEmptyBaseWrite(base);

                System.out.println(lang.authentification);
                System.out.println(lang.inputName);
                String name = scan.nextLine();
                if (!names.contains(name)) {
                    tryCountObjecct = new TryCount(try_count, name);
                    names.add(name);
                }

                //==============checkOutProgram==================================
                if (name.equals("exit") || name.equals("e") || name.equals("отмена")) {
                    System.out.println(lang.cancel);
                    break;
                }
                //==============check NameExistInBase============================
                boolean exist = base.checkExistName(name);

                //==============start Authentication===============================
                if (exist) {
                    auth = authenticationFunction(base, name, tryCountObjecct);

                } else {
                    System.out.println(lang.NameNotExist);
                    System.out.println(lang.doYouWantReg);
                    //=====================check input=======================

                    if (input.checkCommands().equals("yes")) {

                        Registration reg = new Registration(lang);
                        reg.regAcc(base, lang);
                        break;
                    }
                    break;
                }
            } while (tryCountObjecct.getTryCount() > 0 && !auth);
        } else {
            System.out.println(lang.authentificationLocked);
        }


    }


    //===============================
    //additional Authentication Function
    //===============================
    boolean authenticationFunction(Base base, String name, TryCount tryCount) throws IOException {
        // Answer answer = new Answer();

        boolean auth = false;
        int basePass = base.getPass(name);


//===============Input password==========================================
        System.out.println(lang.inputPassword);
        int passIn = scan.nextLine().hashCode();
        //==============checkOutProgram==================================
        if (passIn == "exit".hashCode() || passIn == "выход".hashCode()) {
            System.out.println(lang.cancel);


            //==================check  password for Authentication=========================

        } else if (passIn == basePass) {
            auth = true;
            System.out.println(lang.authentificationCompleted);

        } else {
            System.out.println(lang.nameOrPasswordWrong);
            tryCount.setTryCount(tryCount.getTryCount() - 1);
            System.out.println(lang.numberTry + tryCount.getTryCount());

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
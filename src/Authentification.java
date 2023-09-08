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
    int try_count = 5;
    Scanner scan;
    Registration reg;
    ArrayList<String> names;
    Answer input;
    ArrayList<String> checkedNames;

    TryCount tryCountObjects;
    ArrayList<TryCount> tryCountObjecctArray;

    public Authentication(Language language) {
        try_count=5;
        lang = language;
        Registration reg = new Registration(lang);
        scan = new Scanner(System.in);
        names = new ArrayList<>();
        input = new Answer(lang);
        names = new ArrayList<>();
        tryCountObjecctArray=new ArrayList<>();
//        tryCountObjecct = new TryCount(try_count, null);


        ArrayList<String> checkedNames = new ArrayList<>();
    }
    //===============================
    //main  Authentication Function
    //===============================

    void authFunc(BaseInterface base) throws IOException, ClassNotFoundException {
        // try_count = 3;
        boolean auth;
//        TryCount tryCountObjecct;
//        tryCountObjecct = new TryCount(try_count, null);

//        ArrayList<String> checkedNames = new ArrayList<>();
//        Answer input = new Answer(lang);
        if (try_count > 0) {
            do {
//            ifEmptyBaseWrite(baseText);

                System.out.println(lang.authentification);
                System.out.println(lang.inputName);
                String name = scan.nextLine();
                if (!checkedNames.contains(name)) {
                    tryCountObjects = new TryCount(try_count, name);
                    tryCountObjecctArray.add(tryCountObjects);
                    checkedNames.add(name);
                }

                //==============checkOutProgram==================================
                if (name.equals("exit") || name.equals("e") || name.equals("отмена")) {
                    System.out.println(lang.cancel);
                    break;
                }

                //==============start Authentication===============================
                if (base.checkExistName(name)) {
                    auth = authenticationFunction(base, name,tryCountObjecctArray );

                } else {
                    System.out.println(lang.NameNotExist);
                    System.out.println(lang.doYouWantReg);
                    //=====================check input=======================

                    if (input.checkCommands().equals("yes")) {

                        Registration reg = new Registration(lang);
                        reg.regAcc(base, lang);
//                        break;
                    }
                    break;
                }
                TryCount tryCountObjects;
            } while (tryCountObjects.getTryCount() > 0 && !auth);
        } else {
            System.out.println(lang.authentificationLocked);
        }
    }


    //===============================
    //additional Authentication Function
    //===============================
    boolean authenticationFunction(BaseInterface base, String name, ArrayList tryCountObjecctArray) throws IOException, ClassNotFoundException {
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
            System.out.println(lang.doYouWantReg);
            if (input.checkCommands().equals("yes")) {

                reg.regAcc(base, lang);
            } else {
                tryCount;
                System.out.println(lang.numberTry + tryCount.getTryCount());
            }

            //==============checkOutProgram==================================


            //=====================check input=======================


        }


        return auth;
    }

    //===============================
    //check Empty BaseText
    //===============================
}


//25.06.23
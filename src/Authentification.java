import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Authentication {
    Language lang;
    //    String authentication=;
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
    int Count;
    Scanner scan;
    Registration reg;
    ArrayList<String> names;
    Answer input;
    ArrayList<String> checkedNames;

    TryCount tryCount;
    ArrayList<TryCount> tryCountsArray;

    public Authentication(Language language) {
        Count =5;
        lang = language;
        reg = new Registration(lang);
        scan = new Scanner(System.in);
        names = new ArrayList<>();
        input = new Answer(lang);
        names = new ArrayList<>();
        tryCountsArray =new ArrayList<>();
        checkedNames=new ArrayList<>();
//        tryCountObject = new TryCount(try_count, null);


//        ArrayList<String> checkedNames = new ArrayList<>();
    }
    //===============================
    //main  Authentication Function
    //===============================

    void authFunc(BaseInterface base) throws IOException, ClassNotFoundException {
        // try_count = 3;
        boolean auth;
//        TryCount tryCountObject;
//        tryCountObject = new TryCount(try_count, null);

//        ArrayList<String> checkedNames = new ArrayList<>();
//        Answer input = new Answer(lang);
        if (Count > 0) {
            do {
//            ifEmptyBaseWrite(baseText);

                System.out.println(lang.authentification);
                System.out.println(lang.inputName);
                String name = scan.nextLine();
                if (!checkedNames.contains(name)) {
                    tryCount = new TryCount(Count, name);
                    tryCountsArray.add(tryCount);
                    checkedNames.add(name);
                }

                //==============checkOutProgram==================================
//                if (name.equals("exit") || name.equals("e") || name.equals("отмена")) {
//                    System.out.println(lang.cancel);
//                    break;
//                }

                //==============start Authentication===============================
                if (base.checkExistName(name)) {
                    TryCount tryCount=null;
                    for( TryCount tryCountTemp : tryCountsArray){
                        if((tryCountTemp.getName().equals(name))){
                            tryCount = tryCountTemp;
                            break;
                        }
                    }
                    auth = authenticationFunction(base, name,tryCount );

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
//                TryCount tryCountObjects;
            } while (tryCount.getTryCount() > 0 && !auth);
        } else {
            System.out.println(lang.authentificationLocked);
        }
    }


    //===============================
    //additional Authentication Function
    //===============================
    boolean authenticationFunction(BaseInterface base, String name, TryCount tryCount) throws IOException, ClassNotFoundException {
        // Answer answer = new Answer();

        boolean auth = false;
        int basePass = base.getPass(name);


//===============Input password==========================================
        System.out.println(lang.inputPassword);
        int passIn = scan.nextLine().hashCode();
        //==============checkOutProgram==================================
        if (passIn == "exit".hashCode() || passIn == "выход".hashCode()) {
            System.out.println(lang.cancel);
            return false;
        }

            //==================check  password for Authentication=========================

         if (passIn == basePass) {
            auth = true;
            System.out.println(lang.authentificationCompleted);

        } else {
            System.out.println(lang.nameOrPasswordWrong);
             tryCount.decrease();
             System.out.println(lang.numberTry+" " + tryCount.getTryCount());
             System.out.println(lang.doYouWantReg);
             if (input.checkCommands().equals("yes")) {

                reg.regAcc(base, lang);
            }else {
                 System.out.println(lang.doYouHaveAcc);

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
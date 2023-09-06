/***03.08.23*/


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       // String choseLanguage;
Language language=new Language();
//language.setInputLanguage();
      //  System.out.println(language.createdBase);


        BaseInterface  base = new BaseObject(language);
        boolean out;
        Answer answer = new Answer(language);
        Authentication auth = new Authentication(language);


        do {
            if (base.emptyBaseFile()) {
                System.out.println(language.emptyBase);
                System.out.println(language.regAtLestOne);
                System.out.println(language.doYouWantReg);

                switch (answer.checkCommands()) {
                    case "yes":

                        Registration reg = new Registration(language);
                        reg.regAcc(base,language);
                        break;
                    case "no":
                        break;
                }
            } else {
                System.out.println(language.doYouHaveAcc);
//=====================General menu========================================
//=====================checking input commands========================================

                switch (answer.checkCommands()) {
                    case "exit":
                        break;
                    case "no":
                        System.out.println(language.doYouWantReg);
                        switch (answer.checkCommands()){
                            case "no":
                            case "exit":
                                break;
                            case "yes":


                        System.out.println(language.regNewAccount);
                        Registration reg = new Registration(language);
                        reg.regAcc(base,language);
                        break;}
                        break;

                    case "yes":
                        auth.authFunc(base);
                        break;
                }


                //==============exit request============================
            }
            System.out.println(language.doYouWantExit);
            out = "yes".equals(answer.checkCommands());
        } while (!out);
    }
    //================================================================

    //=========additional function====================================

    //================================================================



}



//25.06.23


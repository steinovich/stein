import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        String choseLanguage;
Language language=new Language();
        System.out.println(Language.createdBase);


        Base base = new Base();
        boolean out;
        Answer answer = new Answer();
        Authentication auth = new Authentication();


        do {
            if (base.emptyBase()) {
                System.out.println(Language.emptyBase);
                System.out.println(Language.regAtLestOne);
                System.out.println(Language.doYouWantReg);

                switch (answer.checkCommands()) {
                    case "yes":

                        Registration reg = new Registration();
                        reg.regAcc(base);
                        break;
                    case "no":
                        break;
                }
            } else {
                System.out.println(Language.doYouHaveAcc);
//=====================General menu========================================
//=====================checking input commands========================================

                switch (answer.checkCommands()) {
                    case "exit":
                        break;
                    case "no":
                        System.out.println(Language.regNewAccount);
                        Registration reg = new Registration();
                        reg.regAcc(base);
                        break;
                    case "yes":
                        auth.authFunc(base);
                        break;
                }


                //==============exit request============================
            }
            System.out.println(Language.doYouWantExit);
            out = "yes".equals(answer.checkCommands());
        } while (!out);
    }
    //================================================================

    //=========additional function====================================

    //================================================================



}



//25.06.23


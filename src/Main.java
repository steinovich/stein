import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        File jarDir = new File(ClassLoader.getSystemClassLoader().getResource("Main.class").getPath());
        String dirJar=jarDir.getAbsolutePath();
        System.out.println("dirJar="+dirJar);

        int indexDotClass=dirJar.indexOf(".class");
        String dirDotClass=dirJar.substring(0, indexDotClass);



        int indexClassName=dirDotClass.lastIndexOf("\\");
        System.out.println("indexClassName="+indexClassName);

        String dirClassName=dirJar.substring(0, indexClassName);
        System.out.println("work directory="+dirClassName+"      indexDotClass="+indexDotClass);

        System.out.println("Создание Базы данных");


        Base base = new Base();
        boolean out;
        Answer answer = new Answer();
        Authentication auth = new Authentication();


        do {
            if (base.emptyBase()) {
                System.out.println("База данных пуста");
                System.out.println("Зарегистрируйте хотя бы одного пользователя ");
                System.out.println("Зарегистрировать? Д/Н");

                switch (answer.checkCommands()) {
                    case "yes":

                        Registration reg = new Registration();
                        reg.regAcc(base);
                        break;
                    case "no":
                        break;
                }
            } else {
                System.out.println("У Вас уже есть аккаунт?:да,yes/нет,no/выход,exit");
//=====================General menu========================================
//=====================checking input commands========================================

                switch (answer.checkCommands()) {
                    case "exit":
                        break;
                    case "no":
                        System.out.println("Регистрация нового пользователя");
                        Registration reg = new Registration();
                        reg.regAcc(base);
                        break;
                    case "yes":
                        auth.authFunc(base);
                        break;
                }


                //==============exit request============================
            }
            System.out.println("Выйти из программы?:да,yes/нет,no");
            out = "yes".equals(answer.checkCommands());
        } while (!out);
    }


}



//25.06.23


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

                System.out.println("Аутентификация:");
                System.out.println("Введите ваше имя пользователя:");
                String name = scan.nextLine();

                //==============checkOutProgram==================================
                if (name.equals("exit") || name.equals("e") || name.equals("отмена")) {
                    System.out.println("Отмена");
                    break;
                }
                //==============check NameExistInBase============================
                boolean exist = base.checkExistName(name);

                //==============start Authentication===============================
                if (exist) {
                    auth = authenticationFunction(base, name);

                } else {
                    System.out.println("Такого имени в базе не существует");
                    System.out.println("Зарегистрироваться? да,yes/нет,no");
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
            System.out.println("Заблокировано");
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
        System.out.println("Введите пароль:");
        int passIn = scan.nextLine().hashCode();
        //==============checkOutProgram==================================
        if (passIn == "exit".hashCode() || passIn == "выход".hashCode()) {
            System.out.println("Отмена");


            //==================check  password for Authentication=========================

        } else if (passIn == basePass) {
            auth = true;
            System.out.println("Вы успешно прошли аутентификацию!");

        } else {
            System.out.println("имя или пароль неверные");
            try_count--;
            System.out.println("Осталось попыток " + try_count);

            //==============checkOutProgram==================================


            //=====================check input=======================

//                if (answer.checkCommands().equals("yes")) {
//
//                    Registration reg = new Registration();
//                    reg.regAcc(base);
//                }


        }

//        if (try_count == 0) {
//            System.out.println("Заблокировано");
//            try_count = 3;
        //           auth = false;


        return auth;
    }

    //===============================
    //check Empty Base
    //===============================
//    void ifEmptyBaseWrite(Base base) throws IOException {
//        Answer answer = new Answer();
//        if (base.emptyBase()) {
//            System.out.println("База данных пуста");
//            System.out.println("Зарегистрируйте хотя бы одного пользователя ");
//            System.out.println("Зарегистрировать? ");
//
//            if (answer.checkCommands().equals("yes")) {
//                Registration reg = new Registration();
//                reg.regAcc(base);
//            }
//        }
    // }
}
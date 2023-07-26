import java.io.File;
import java.util.Scanner;

public class Language {

    static String language;


    static String createdBase;
    static String emptyBase;
    static String errorCreateBase;
    //    "База данных пуста"
    //  "Ошибка при создании базы даннных"
//            "Зарегистрируйте хотя бы одного пользователя "
//            "Зарегистрировать? Д/Н"
//            "У Вас уже есть аккаунт?:да,yes/нет,no/выход,exit"
//            "Регистрация нового пользователя"
//            "Выйти из программы?:да,yes/нет,no"
//            "Аутентификация:"
//            "Введите ваше имя пользователя:"
//            "Отмена"
//            "Такого имени в базе не существует"
//            "Зарегистрироваться? да,yes/нет,no"
//    "Аккаунт с таким именем уже существует "
//            "Введите другое имя пользователя:"
//    "Аутентификация заблокированa"
//    "Введите пароль:"
//            "Регистрации прошла успешно"
//    "Вы успешно прошли аутентификацию!"
//            "имя или пароль неверные"
//            "Осталось попыток "
    static String authentificationCompleted;
    static String nameOrPasswordWrong;
    static String numberTry;
    static String regAtLestOne;
    static String doYouWantReg;
    static String doYouHaveAcc;

    static String regNewAccount;
    static String doYouWantExit;
    static String autentification;
    static String autentificationLocked;
    static String inputName;
    static String cancel;
    static String NameNotExist;
    static String NameAlreadyExist;
    static String inputOtherName;
    static String inputPassword;
    static String registrationCompleted;
    static String inputLanguage;

public Language
    public void setup(){
        private Scanner scan = new Scanner(System.in);
        System.out.println(inputLanguage);
        language=scan.nextLine();
    }
    public String dirJar(){

        System.out.println("chose language:"+);
        File jarDir = new File(ClassLoader.getSystemClassLoader().getResource("Main.class").getPath());
        String dirJar=jarDir.getAbsolutePath();
        System.out.println("dirJar="+dirJar);

        int indexDotClass=dirJar.indexOf(".class");
        String dirDotClass=dirJar.substring(0, indexDotClass);

        int indexClassName=dirDotClass.lastIndexOf("\\");
        System.out.println("indexClassName="+indexClassName);

        String dirClassName=dirJar.substring(0, indexClassName);
        System.out.println("work directory="+dirClassName+"      indexDotClass="+indexDotClass);
        return dirClassName;
    }

//    "База данных пуста"
//            "Зарегистрируйте хотя бы одного пользователя "
//            "Зарегистрировать? Д/Н"
//            "У Вас уже есть аккаунт?:да,yes/нет,no/выход,exit"
//            "Регистрация нового пользователя"
//            "Выйти из программы?:да,yes/нет,no"
//            "Аутентификация:"
//            "Введите ваше имя пользователя:"
//            "Отмена"
//            "Такого имени в базе не существует"
//            "Зарегистрироваться? да,yes/нет,no"
search

//12.07.23
}

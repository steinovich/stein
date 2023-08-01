import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Language {
    FileReader fileReader;
    BufferedReader bufferReader;
    String inputLanguage=setInputLanguage();
    String fileLanguage = "Language.conf";
    public String createdBase=searchWord("createdBase");
    public String emptyBase=searchWord("emptyBase");
    public String errorCreateBase=searchWord("errorCreateBase");
    public String authentificationCompleted=searchWord("authentificationCompleted");
    public String nameOrPasswordWrong=searchWord("nameOrPasswordWrong");
    public String numberTry=searchWord("numberTry");
    public String regAtLestOne=searchWord("regAtLestOne");
    public String doYouWantReg=searchWord("doYouWantReg");
    public String doYouHaveAcc=searchWord("doYouHaveAcc");

    public String regNewAccount=searchWord("regNewAccount");
    public String doYouWantExit=searchWord("doYouWantExit");
    public String authentication =searchWord("authentication");
    public String authenticationLocked =searchWord("authenticationLocked");
    public String inputName=searchWord("inputName");
    public String cancel=searchWord("cancel");
    public String NameNotExist=searchWord("NameNotExist");
    public String NameAlreadyExist=searchWord("NameAlreadyExist");
    public String inputOtherName=searchWord("inputOtherName");
    public String inputPassword=searchWord("inputPassword");
    public String registrationCompleted=searchWord("registrationCompleted");
    public String languageIsIncorrect=searchWord("languageIsIncorrect");
    public String  notFound=searchWord("notFound");

    public Language() throws IOException {
    }

    public String setInputLanguage() throws IOException {

        //  ==================Creat Buffer Read========================

        Scanner scan = new Scanner(System.in);
        fileReader = new FileReader("Language.conf");
        bufferReader = new BufferedReader(fileReader);
        //  ==================Search all language========================
        String lineSplit;
        String generalLanguage="1";
        ArrayList<String> allLanguages=new ArrayList<>();
        String line="";
        while (line != null) {
            if (line.contains("=")) {
                lineSplit=line.split("=",0)[1];
                allLanguages.add( line.split("=",0)[1]+" ");

            }
            line = bufferReader.readLine();
        }                System.out.println(allLanguages);
        //  ==================input language========================

        while (!allLanguages.contains(generalLanguage)) {
            System.out.println("input correct language:" + allLanguages);
            generalLanguage = scan.nextLine();
        }
        return generalLanguage;
    }

    //   static String language;



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
   // "language.conf is incorrect, "
  //  " not found"

    public String searchWord(String word) throws IOException {
       // String[] findWordSplit = new String[2];
        String[] findWordSplit=new String[2];
        fileReader = new FileReader(fileLanguage);
        bufferReader = new BufferedReader(fileReader);
        String line="";
        while (line != null&&!line.equals(inputLanguage)){
            line = bufferReader.readLine();
        }
        while ((line != null &&!line.equals("}")&&line.contains(word))){
            line = bufferReader.readLine();

        }
        if (line.contains(word)&&line != null) {
            findWordSplit=line.split(":   ",2);
            return findWordSplit[1];
        }else {System.out.println(languageIsIncorrect+word+notFound);
        return null;
        }
       // return findWordSplit[1];

    }


//    public String dirJar(){
//
//        System.out.println("chose language:"+);
//        File jarDir = new File(ClassLoader.getSystemClassLoader().getResource("Main.class").getPath());
//        String dirJar=jarDir.getAbsolutePath();
//        System.out.println("dirJar="+dirJar);
//
//        int indexDotClass=dirJar.indexOf(".class");
//        String dirDotClass=dirJar.substring(0, indexDotClass);
//
//        int indexClassName=dirDotClass.lastIndexOf("\\");
//        System.out.println("indexClassName="+indexClassName);
//
//        String dirClassName=dirJar.substring(0, indexClassName);
//        System.out.println("work directory="+dirClassName+"      indexDotClass="+indexDotClass);
//        return dirClassName;
//    }

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


//12.07.23
}

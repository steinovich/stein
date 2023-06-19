
import java.io.*;
//import java.util.ArrayList;

public class Base {
    String dir = "e:/JavaBase/";
    String file = dir + "base.txt";
    FileWriter fileWriter;

    public Base() {
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {

        }


        //dir = "e:/JavaBase/";
        //file = dir + "base.txt";
        System.out.println("Создание Базы данных");
        File directory = new File(dir);
        boolean created = directory.mkdir();
        File base = new File(file);
        try {
            created = base.createNewFile() & created;
            if (created) {
                System.out.println("База данных успешно создана");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании базы даннных");
            throw new RuntimeException(e);
        }

        //       int n = 0;

        System.out.println("Base:" + file);

        //      void writeBase (dir, file);
    }
//    String lineSeparator = System.getProperty("line.separator");
    //   private final ArrayList<Account_old> accArray = new ArrayList<>();

    public boolean emptyBase() {
        //       System.out.println("lrngth"+file.length());
        File fileBase = new File(file);
        System.out.println("fileBase.length()=" + fileBase.length());
        return fileBase.length() < 30;
    }

    //       return accArray.size() == 0;
    public void addAccount(String name, int pass) throws IOException {
        String lineSeparator = System.lineSeparator();
        //       Account newAcc = new Account();
        // String str;
        //String delimiter;
        //String[] subStr;
        String headLine = "!\tID\t!\tname\t!\tpassword\t!" + lineSeparator;

        // newAcc.setAccountID(nextID);

//        delimiter = "!"; // Разделитель
//        subStr = str.split(delimiter, 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
//        // Вывод результата на экран
//        System.out.println(subStr[2]);
        int ID = getLastID();

        ID++;

        if (emptyBase()) {
            fileWriter.write(headLine);
        }
        String newAccount = "!\t" + ID + "\t!\t" + name + "\t!\t" + pass + "\t!" + lineSeparator;
        fileWriter.write(newAccount);
        fileWriter.close();
        //        newAcc.setAccountName(name);
//        newAcc.setAccountPassword(pass);
//        accArray.add(newAcc);

    }

    int getLastID() throws IOException {
//        int Password = 0;//begin number for default
//        int positionInStr = 0;
        int ID;
        String IDStr;
        File fileBase = new File(file);

        if (fileBase.length() < 4) {
            IDStr = "0";
        } else {

            IDStr = getAccount("ID", "");
        }
//        String lastAccount;
//        String account = "";
//        String IDStr;
//        String delimiter = "   !  "; // Разделитель
//        String[] subStr;
//        String[] secondSubStr;

        ID = Integer.parseInt(IDStr);
        return ID;// = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);

//        do {
//            try {
//                lastAccount=account;
//                account = bufferReader.readLine();
//            } catch (IOException e) {
//                System.out.println("Не удалось прочитать файл базы данных");
//                throw new RuntimeException(e);
//            }
//            //str = "ID!name!password!";
//            //delimiter = "   !  "; // Разделитель
//            subStr = lastAccount.split(delimiter, 3);
//            // ===========password search by name================
//        } while (account != null);
//        secondSubStr = subStr[0].split("    !   ", 2);// "ID" with "!  ";
//        IDStr = secondSubStr[1];//separate "ID" and  "!    "
//        ID=Integer.parseInt(IDStr)
//            return  ID;
    }


    public int getPass(String name) throws IOException {
//        int Password = 0;//begin number for default
//        int positionInStr = 0;
//        String account = "";
//        String password;
//        String delimiter = "   !  "; // Разделитель
//        String[] subStr;
//        String[] secondSubStr;// = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
//        // Вывод результата на экран
//        //   subStr = subStr[2].split("  !", 2);
//        //  System.out.println(subStr[1]);
//
//        do {
//            try {
//                account = bufferReader.readLine();
//            } catch (IOException e) {
//                System.out.println("Не удалось прочитать файл базы данных");
//                throw new RuntimeException(e);
//            }
//            //str = "ID!name!password!";
//            //delimiter = "   !  "; // Разделитель
//            subStr = account.split(delimiter, 3);
//            // ===========password search by name================
//        } while (account != null || !subStr[1].equals(name));
//        secondSubStr = subStr[2].split("  !", 2);// Password with  !;
//        password = secondSubStr[0];//separate "Password" and  "    !"
        String password = getAccount("password", name);
        return password.hashCode();// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
    }

    boolean checkExistName(String name) throws IOException {
//        switch (mode){
//        case "":
//            case "":
//                String accName;
        boolean exist;//= false;
//        ArrayList accArray;
//        for (Account accounts : accArray) {
//            accName = accounts.getName();
//            if (accName.equals(name)) {
        File fileBase = new File(file);

        if (fileBase.length() < 30) {
            exist = false;
        } else {
            exist = getAccount("name", name).equals(name);
        }
        return (exist);
    }


    private String getAccount(String part, String name) throws IOException {
//        if (emptyBase()) {
//            return "0";
//        }
//        int Password = 0;//begin number for default
//        int positionInStr = 0;

        FileReader fileReader; //= null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String account = null;
        String delimiter; // Разделитель
        String[] subStr;
        subStr = new String[5];
        subStr[1] = "";
        String[] secondSubStr;
        int firstIndex;
        int secondIndex;
        String partAcc;
        //   boolean firstStep=true;
        // = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);
        switch (part) {
            case "name":
                System.out.println("part name");
                delimiter = "";
                firstIndex = 1;
                secondIndex = 1;
                break;
            case "password":
                System.out.println("part password");
                delimiter = "\t!";
                firstIndex = 3;
                secondIndex = 1;
                break;
            case "ID":
                System.out.println("part ID");
                delimiter = "!\t";
                firstIndex = 0;
                secondIndex = 2;
                break;
            default:
                delimiter = "";
                firstIndex = 0;
                secondIndex = 0;
        }
        account = bufferReader.readLine();
        account = bufferReader.readLine();

        while (account != null && !subStr[1].equals(name)) {
            System.out.println("acc" + account);
            subStr = account.split("\t!\t", 3);
            account = bufferReader.readLine();
            //            accountLast=account;
            // firstStep=false;
            // ===========password search by name================
        } //while (!subStr[1].equals(name));
        //while (account != null && !subStr[1].equals(name));
        if (part.equals("name")) {
            partAcc = subStr[firstIndex];
        } else {
            secondSubStr = subStr[firstIndex].split(delimiter, 2);
            // Password with  !;
            partAcc = secondSubStr[secondIndex];
        }//separate "Password"
        // and  "    !"
        return partAcc;// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
    }


//    static void writeBase() throws IOException {
//        System.out.println("Write base:");
//        int n = 0;
//        File directory = new File(dir);
//        boolean created = directory.mkdir();
//        File base = new File(file);
//        System.out.println("file:" + file);
//
//        created = base.createNewFile();
//        if (created)
//            System.out.println("Base has been created");
//        else {
//            System.out.println("Base already exist");
//        }
//
//        String lineSeparator = System.lineSeparator();
//        String result = "";
//        FileWriter fileWriter = new FileWriter(file, true);
//        while (n < 5) {
//
//            String text = String.format("%s result!", n);
//            n++;
//            result += text + lineSeparator;
//        }
//
//        fileWriter.write(result);
//        System.out.println(result);
//        fileWriter.flush();
//        fileWriter.close();
//    }

//    private String getAccPart(String part,String name) {
//        int Password = 0;//begin number for default
//        int positionInStr = 0;
//        String account;
//        String password;
//        String delimiter ; // Разделитель
//        String[] subStr;
//        String[] secondSubStr;
//        int firstIndex;
//        int secondIndex;
//        String partAcc;
//        // = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
//        // Вывод результата на экран
//        //   subStr = subStr[2].split("  !", 2);
//        //  System.out.println(subStr[1]);
//switch (part) {
//    case "name":
//        delimeter=" !    ";
//    firstIndex=2;
//   // secondIndex=2;
//        case "password":
//            delimeter="     !";
//            firstIndex=3;
//            secondIndex=1;
//    case "ID":
//        delimeter="!    ";
//        firstIndex=0;
//        secondIndex=2;
//
//}
//        do {
//            try {
//                account = bufferReader.readLine();
//            } catch (IOException e) {
//                System.out.println("Не удалось прочитать файл базы данных");
//                throw new RuntimeException(e);
//            }
//            subStr = account.split("    !   ", 3);
//            // ===========password search by name================
//        } while (account != null || !subStr[1].equals(name));
//        secondSubStr = subStr[firstIndex].split(delimeter, 2);// Password with  !;
//        partAcc = secondSubStr[secondIndex];//separate "Password" and  "    !"
//        return partAcc;// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
//    }
//////    void testConnection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
//////        String url = "jdbc:mysql://localhost/store";
//////        String username = "root";
//////        String password = "root";
//////        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//////        try (Connection conn = DriverManager.getConnection(url, username, password)) {
//////
//////            System.out.println("Connection to Store DB successful!");
////
////        }
//    }
}
//15.06.23 17:15


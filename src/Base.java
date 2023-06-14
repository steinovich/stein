
import javax.sound.sampled.Line;
import java.io.*;

public class Base {
    String dir = "e:/JavaBase/";
    String file = dir + "base.txt";
    BufferedReader bufferReader;
    FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Base() {


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
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        bufferReader = new BufferedReader(fileReader);
        //       int n = 0;

        System.out.println("Base:" + file);

        //      void writeBase (dir, file);
    }
//    String lineSeparator = System.getProperty("line.separator");
    //   private final ArrayList<Account_old> accArray = new ArrayList<>();

    public boolean emptyBase() {
        return file.length() == 0;
    }

    //       return accArray.size() == 0;
    public void addAccount(String name, int pass) {
        //       Account newAcc = new Account();
        String str;
        String delimeter;
        String[] subStr;
        String headLine = "!    ID   !   name    !  password !";

        // newAcc.setAccountID(nextID);

//        delimeter = "!"; // Разделитель
//        subStr = str.split(delimeter, 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
//        // Вывод результата на экран
//        System.out.println(subStr[2]);
        if (file.length() == 0) {
            fileWriter.write(headLine);
        }
        String ID = getLastID();
        ID++;
        fileWriter.write("!    " + ID + "   !   " + name + "    !   " + pass + "    !");

//        newAcc.setAccountName(name);
//        newAcc.setAccountPassword(pass);
//        accArray.add(newAcc);

    }

    int getLastID() {
        int Password = 0;//begin number for default
        int positionInStr = 0;
        int ID;
        String lastAccount;
        String account = "";
        String IDStr;
        String delimeter = "   !  "; // Разделитель
        String[] subStr;
        String[] secondSubStr;// = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);

        do {
            try {
                lastAccount=account;
                account = bufferReader.readLine();
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл базы данных");
                throw new RuntimeException(e);
            }
            //str = "ID!name!password!";
            //delimeter = "   !  "; // Разделитель
            subStr = lastAccount.split(delimeter, 3);
            // ===========password search by name================
        } while (account != null);
        secondSubStr = subStr[0].split("    !   ", 2);// "ID" whith "!  ";
        IDStr = secondSubStr[1];//separate "ID" and  "!    "
        ID=Integer.parseInt(IDStr)
            return  ID;
        }


    public int getPass(String name) {
        int Password = 0;//begin number for default
        int positionInStr = 0;
        String account = "";
        String password;
        String delimeter = "   !  "; // Разделитель
        String[] subStr;
        String[] secondSubStr;// = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);

        do {
            try {
                account = bufferReader.readLine();
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл базы данных");
                throw new RuntimeException(e);
            }
            //str = "ID!name!password!";
            //delimeter = "   !  "; // Разделитель
            subStr = account.split(delimeter, 3);
            // ===========password search by name================
        } while (account != null || !subStr[1].equals(name));
        secondSubStr = subStr[2].split("  !", 2);// Password whith  !;
        password = secondSubStr[0];//separate "Password" and  "    !"
        return password.hashCode();// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
    }

    private String getAccPart(String part,String name) {
//        int Password = 0;//begin number for default
//        int positionInStr = 0;
        String account;
        String password;
        String delimeter ; // Разделитель
        String[] subStr;
        String[] secondSubStr;
        int firstIndex;
        int secondIndex;
        String partAcc;
        // = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);
        switch (part) {
            case "name":
                delimeter=" !    ";
                firstIndex=2;
                // secondIndex=2;
            case "password":
                delimeter="     !";
                firstIndex=3;
                secondIndex=1;
            case "ID":
                delimeter="!    ";
                firstIndex=0;
                secondIndex=2;

        }
        do {
            try {
                account = bufferReader.readLine();
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл базы данных");
                throw new RuntimeException(e);
            }
            subStr = account.split("    !   ", 3);
            // ===========password search by name================
        } while (account != null || !subStr[1].equals(name));
        secondSubStr = subStr[firstIndex].split(delimeter, 2);// Password whith  !;
        partAcc = secondSubStr[secondIndex];//separate "Password" and  "    !"
        return partAcc;// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
    }

    boolean checkExistName(String name) {
        String accName;
        boolean exist = false;
        for (Account accounts : accArray) {
            accName = accounts.getName();
            if (accName.equals(name)) {
                exist = true;
            }
        }
        return (exist);
    }

    static void writeBase() throws IOException {
        System.out.println("Write base:");
        int n = 0;
        File dirertory = new File(dir);
        boolean created = dirertory.mkdir();
        File base = new File(file);
        System.out.println("file:" + file);

        created = base.createNewFile();
        if (created)
            System.out.println("Base has been created");
        else {
            System.out.println("Base already exist");
        }

        String lineSeparator = System.lineSeparator();
        String result = "";
        FileWriter fileWriter = new FileWriter(file, true);
        while (n < 5) {

            String text = String.format("%s result!", n);
            n++;
            result += text + lineSeparator;
        }

        fileWriter.write(result);
        System.out.println(result);
        fileWriter.flush();
        fileWriter.close();
    }
}
    private String getAccPart(String part,String name) {
//        int Password = 0;//begin number for default
//        int positionInStr = 0;
        String account;
        String password;
        String delimeter ; // Разделитель
        String[] subStr;
        String[] secondSubStr;
        int firstIndex;
        int secondIndex;
        String partAcc;
        // = account.split("   !  ", 4); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        // Вывод результата на экран
        //   subStr = subStr[2].split("  !", 2);
        //  System.out.println(subStr[1]);
switch (part) {
    case "name":
        delimeter=" !    ";
    firstIndex=2;
   // secondIndex=2;
        case "password":
            delimeter="     !";
            firstIndex=3;
            secondIndex=1;
    case "ID":
        delimeter="!    ";
        firstIndex=0;
        secondIndex=2;

}
        do {
            try {
                account = bufferReader.readLine();
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл базы данных");
                throw new RuntimeException(e);
            }
            subStr = account.split("    !   ", 3);
            // ===========password search by name================
        } while (account != null || !subStr[1].equals(name));
        secondSubStr = subStr[firstIndex].split(delimeter, 2);// Password whith  !;
        partAcc = secondSubStr[secondIndex];//separate "Password" and  "    !"
        return partAcc;// выдача пароля в скрытом хеше

//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
    }
//////    void testConnection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
//////        String url = "jdbc:mysql://localhost/store";
//////        String username = "root";
//////        String password = "root";
//////        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//////        try (Connection conn = DriverManager.getConnection(url, username, password)) {
//////
//////            System.out.println("Connection to Store DB succesfull!");
////
////        }
//    }
    }
    //14.06.23


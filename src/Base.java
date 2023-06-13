
import java.io.*;

public class Base {
    String dir = "e:/JavaBase/";
    String file = dir + "base.txt";
    BufferedReader bufferReader;
    FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter(file,true);
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
        // newAcc.setAccountID(nextID);
        int ID=getLastID();
        ID++;
        fileWriter.write(ID+"   !   "+name+"    !   "+pass+"    !");

//        newAcc.setAccountName(name);
//        newAcc.setAccountPassword(pass);
//        accArray.add(newAcc);

    }

    int getLastID()  {
        String str="";
        int ID=;
        String strOut="";
        String delimeter;
        String[] subStr;
        while(str!=null){
            strOut=str;
            str=bufferReader.readLine();
            str = "ID!name!password!";
            delimeter = "!"; // Разделитель
            subStr = str.split(delimeter, 3); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
            // Вывод результата на экран
            for(int i = 0; i < subStr.length; i++) {
                System.out.println(subStr[i]);
        }return ID;
    }

    public int getPass(String namePass) {
        int Password = 0;//begin number for default
        int positionInStr =0;

//===========password search by name================
//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
            }
        }
        return 0;// Password;
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


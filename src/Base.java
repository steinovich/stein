
import java.io.*;

public class Base {
    String dir = "e:/JavaBase/";
    String file = dir + "base.txt";
    FileWriter fileWriter;

    public Base() {


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

    }

    public boolean emptyBase() {
        File fileBase = new File(file);
        return fileBase.length() < 30;
    }

    public void addAccount(String name, int pass) throws IOException {
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println(e);
        }
        String lineSeparator = System.lineSeparator();
        String headLine = "!\tID\t!\tname\t!\tpass\t!" + lineSeparator;


        int ID = getLastID();

        ID++;

        if (emptyBase()) {
            fileWriter.write(headLine);
        }
        String newAccount = "!\t" + ID + "\t!\t" + name + "\t!\t" + pass + "\t!" + lineSeparator;
        fileWriter.write(newAccount);
        fileWriter.close();

    }

    int getLastID() throws IOException {
        int ID;
        String IDStr;
        File fileBase = new File(file);

        if (fileBase.length() < 4) {
            IDStr = "0";
        } else {

            IDStr = getAccount("ID", null);
        }

        ID = Integer.parseInt(IDStr);
        return ID;
    }


    protected int getPass(String name) throws IOException {

        String password = getAccount("password", name);
        return Integer.parseInt(password);// выдача пароля в скрытом хеше
    }

    boolean checkExistName(String name) throws IOException {
        boolean exist;
        File fileBase = new File(file);

        if (fileBase.length() < 30) {
            exist = false;
        } else {
            exist = getAccount("name", name).equals(name);
        }
        return (exist);
    }


    private String getAccount(String part, String name) throws IOException {


        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String account;
        String delimiter; // Разделитель
        String[] subStr;
        subStr = new String[5];
        subStr[1] = "";
        String[] secondSubStr;
        int firstIndex;
        int secondIndex;
        String partAcc;
        // Вывод результата на экран
        switch (part) {
            case "name":
                delimiter = "";
                firstIndex = 1;
                secondIndex = 1;
                break;
            case "password":
                delimiter = "\t!";
                firstIndex = 2;
                secondIndex = 0;
                break;
            case "ID":
                delimiter = "!\t";
                firstIndex = 0;
                secondIndex = 1;
                break;
            default:
                delimiter = "";
                firstIndex = 0;
                secondIndex = 0;
        }
        account = bufferReader.readLine();
        account = bufferReader.readLine();

        while (account != null && !subStr[1].equals(name)) {
            //        System.out.println("acc" + account);
            subStr = account.split("\t!\t", 3);        // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.

            account = bufferReader.readLine();
            //            accountLast=account;
            // firstStep=false;
            // ===========password search by name================
        }
        if (part.equals("name")) {
            partAcc = subStr[firstIndex];
        } else {
            secondSubStr = subStr[firstIndex].split(delimiter, 2);
            // Password with  !;
            partAcc = secondSubStr[secondIndex];
        }//separate "Password"
        // and  "    !"
        return partAcc;// выдача пароля в скрытом хеше

    }

}
//09.07.23


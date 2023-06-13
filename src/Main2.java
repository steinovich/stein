import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) throws IOException {

        String dir = "e:/JavaBase/";
        String file = dir + "base.txt";
        writeBase(dir, file);
        System.out.println(readBase(file));


    }

    static String readBase(String file) throws IOException {
        System.out.println("read base:");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String lineSeparator = System.getProperty("line.separator");
        String result="";
        String str="";
        while (str!=null){
            str=bufferReader.readLine();
            result+=str+lineSeparator;
        }
        return result;
    }

    static void writeBase(String dir, String file) throws IOException {
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
        FileWriter fileWriter=new FileWriter(file,true);
        while (n < 5) {

            String text = String.format("%s result!", n);
            n++;
            result += text + lineSeparator;
        }
        fileWriter.write(result);
        System.out.println(result);
        fileWriter.flush();
        fileWriter.close();
        //======================Write=======================


    }
}


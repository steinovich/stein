import java.io.*;

public class IOClass {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        IOClass io = new IOClass();
        String name= "e:JavaBase//base.txt";
        //Читать из файла
        //Писать в файл
        io.processingFiles();
    }

    private void processingFiles() throws FileNotFoundException, IOException {
        String name= "e:JavaBase//base.txt";
        FileReader fr = new FileReader(name);
        BufferedReader br = new BufferedReader(fr);
        String lineSeparator;
        String str = br.readLine()+"123";
        lineSeparator = System.getProperty("line.separator");

              String result="";
      //  FileWriter fw = new FileWriter(name);
        int n=0;
        System.out.println(" begin str= "+str);
        while (n<10) {//while (str != null&&n<10) {
            System.out.println(" n= "+n);
 //           System.out.println("wrie in file n ");
            //fw.write(n);
            System.out.println("wrie in file result= "+result);

          //  fw.write(result);
n++;
 //           System.out.println(" str= "+str);
            str = br.readLine();
            System.out.println(str);
            result += str;
            System.out.println("result ="+result);
        }
        FileWriter fw = new FileWriter(name);
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
    }

}
package test;

import java.io.*;
import java.util.ArrayList;

public class WriteObject2 {

    //  Language language;


    public static void main(String args[]) throws IOException, ClassNotFoundException {
        String file = "account2.bin";
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        ArrayList<Account> accounts = new ArrayList<>();
        Account account=new Account();
        accounts.add(account);
        oos.writeObject(accounts);

  //      accounts = (ArrayList<Account>) ois.readObject();
         account = accounts.get(0);
        System.out.println(account.getName());

        // System.out.println(language.AccountAdded);
    }
}

import java.io.*;
import java.util.ArrayList;

/**
 * ll
 */

public class BaseObject implements BaseInterface {
    String file = "account.bin";
    Language language;
//    private FileOutputStream fout = new FileOutputStream(file);
//    private ObjectOutputStream oos = new ObjectOutputStream(fout);
//    private FileInputStream fin = null;
//    private ObjectInputStream ois = null;
//    ArrayList<Account> accounts;

    public BaseObject(Language language) throws IOException {
        this.language = language;
        ArrayList<Account> accounts = new ArrayList<Account>();
//        FileOutputStream fout = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fout);
////        FileInputStream fin = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fin);

        accounts = new ArrayList<Account>();
//        if (emptyBaseFile()) {
            initBase();
//            accounts = new ArrayList<Account>();
//            Account accountNull = new Account(0, "", -1);
//            accounts.add(accountNull);
//            oos.writeObject(accounts);
//            fout.close();
//            oos.close();

//        }
        //  accounts.add(new Account(0, "", 0));
//        System.out.println(accounts);
//        oos.writeObject(accounts);


    }

    public boolean initBase() throws IOException {
        boolean created;
        File fileBase = new File(file);
          if (!fileBase.exists()) {
              created = fileBase.createNewFile();
              //       oos.writeObject(new ArrayList<Account>());
        System.out.println(language.createdBase); }
        created = true;
        //created = false;
        return created;
    }

    @Override
    public boolean emptyBaseFile() {
        boolean lowLengthFile = true;
                  File fileBase = new File(file);
        int length = (int) fileBase.length();
        boolean exist = fileBase.exists();
        if (exist) {
            lowLengthFile = fileBase.length()<5;
        }
        return length < 5;
    }

//    @Override
//    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
//        int ID;
//        ArrayList<Account> accounts = new ArrayList<Account>();
//        FileInputStream fin = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fin);
//        //accounts = (ArrayList<Account>) ois.readObject();
//        FileOutputStream fout = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fout);
////        ArrayList<Account> accounts = new ArrayList<Account>();
////        FileInputStream fileInput = new FileInputStream(file);
////        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
//        try {
//            accounts = (ArrayList<Account>) ois.readObject();//getAccountsArray();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
////        Account account ;//= new Account(0, "", 0);
//        // ArrayList<Account> accounts = new ArrayList<Account>();/**!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
//        // accounts.add(account);
//        ID = accounts.size();
//        Account account = new Account(ID, name, pass);
//        accounts.add(account);
//        oos.writeObject(accounts);
//        fin.close();
//        ois.close();
////        fileInput.close();
////        outInputStream.close();
//        //     System.out.println(language.AccountAdded);
//    }

    @Override
    public int getLastID() {
        return 0;
    }

    @Override
    public int getPass(String name) throws IOException {
        int pass = -1;
        ArrayList<Account> accounts = new ArrayList<Account>();
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
        try {
            accounts = (ArrayList<Account>) outInputStream.readObject();//getAccountsArray();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Account account = new Account(0,"",-1);
//        System.out.println(accounts);
        int i = 0;
//        boolean j=account.getName().equals(name);
        while (i < accounts.size() && !account.getName().equals(name)) {
            account = accounts.get(i);
            i++;
            pass = account.getName().equals(name) ? account.getPasswordHash() : -1;
        }
        fileInput.close();
        outInputStream.close();

        return pass;
    }

    @Override
    public boolean checkExistName(String name) throws IOException {
        boolean exist = false;
        int i = 0;
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
        Account account = new Account(0, "", 0);
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        try {
            accounts = (ArrayList<Account>) outInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (i < accounts.size() && !exist) {

            account = accounts.get(i);
            i++;
            exist = account.getName().equals(name);
        }
//        fileInput.close();
//        outInputStream.close();
        return exist;

    }
    @Override
    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
        int ID;
        ArrayList<Account> accounts = new ArrayList<Account>();
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        if (emptyBaseFile()) {
            accounts.add(new Account());
            oos.writeObject(accounts);

        }
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        oos.writeObject(accounts);
//        accounts = (ArrayList<Account>) ois.readObject();

//        accounts = returnAccounts();//(ArrayList<Account>) ois.readObject();//getAccountsArray();
        ID = accounts.size();
        ois.close();
        fis.close();
        fout.close();
        fout.close();
    }
//    public ArrayList returnAccounts() throws IOException {
//        FileInputStream fileInput = new FileInputStream(file);
//        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
//        ArrayList<Account> accounts = new ArrayList<Account>();
//        try {
//            accounts = (ArrayList<Account>) outInputStream.readObject();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        fileInput.close();
//        outInputStream.close();
//        return accounts;
//
//    }
}


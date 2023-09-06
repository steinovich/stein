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
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
//        FileInputStream fin = new FileInputStream(file);
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
//        boolean lowLengthFile = true;
        File fileBase = new File(file);
        int length = (int) fileBase.length();
//        boolean exist = fileBase.exists();
//        if (exist) {
//            lowLengthFile = fileBase.length()<5;
//        }
        return length < 10;
    }

    @Override
    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
        int ID;
        //ArrayList<Account> accounts = new ArrayList<Account>();
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Account account = new Account(0, "", 0);
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        //accounts = (ArrayList<Account>) ois.readObject();
        ID = accounts.size();
        account = new Account(ID, name, pass);
        accounts.add(account);
        oos.writeObject(accounts);
        fin.close();
        ois.close();
        fout.close();
        oos.close();
        //     System.out.println(language.AccountAdded);
    }

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
        Account account = accounts.get(0);
        int i = 0;
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
            System.out.println(accounts);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (i < accounts.size() && !exist) {

            account = accounts.get(i);
            i++;
            exist = account.getName().equals(name);
        }
        fileInput.close();
        outInputStream.close();
        return exist;

    }


    public String getAccount(String part, String name) {
        return null;
    }

    public ArrayList<Account> getAccountsArray() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        ois.readObject();
        ArrayList<Account> accounts = (ArrayList<Account>) ois.readObject();
        fin.close();
        ois.close();
        return accounts;
    }


//    public boolean deleteAccount(String name) throws IOException, ClassNotFoundException {
//
//
//        accounts = (ArrayList<Account>) ois.readObject();
//        int i = 0;
//        int Id=accounts.size()-1;
//        boolean result=false;
//        Account account = accounts.get(0);
//        while (i < accounts.size() && !account.getName().equals(name)) {
//            account = accounts.get(i);
//            Id = account.getId();
//            i++;
//            result= account.getName().equals(name);
//        }
//        accounts.remove(Id);
//        oos.writeObject(accounts);
//
//        System.out.println(language.AccountDeleted);
//        return result;
//    }
}


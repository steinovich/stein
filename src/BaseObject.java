import java.io.*;
import java.util.ArrayList;

public class BaseObject implements BaseInterface {
    String file = "account.bin";
    Language language;
    private FileOutputStream fout = new FileOutputStream(file);
    private ObjectOutputStream oos = new ObjectOutputStream(fout);
    private FileInputStream fin = null;
    private ObjectInputStream ois = null;
    ArrayList<Account> accounts;

    public BaseObject(Language language) throws IOException {
        this.language = language;
        accounts = new ArrayList<Account>();
        fout = new FileOutputStream(file);
        oos = new ObjectOutputStream(fout);
        fin = new FileInputStream(file);
        ois = new ObjectInputStream(fin);

        accounts = new ArrayList<Account>();
        if (emptyBase()) {
            createBase();
            accounts = new ArrayList<Account>();
            Account accountNull=new Account();
            accounts.add(accountNull);

        }
        //  accounts.add(new Account(0, "", 0));
//        System.out.println(accounts);
//        oos.writeObject(accounts);


    }

    public boolean createBase() throws IOException {
        boolean created;
        File fileBase = new File(file);
        created = fileBase.createNewFile();
        //  if (fileBase.exists()) {
        //       oos.writeObject(new ArrayList<Account>());
        System.out.println(language.createdBase);
        created = true;
        //created = false;
        return created;
    }

    @Override
    public boolean emptyBase() {
//        boolean lowLengthFile = true;
        File fileBase = new File(file);
//        boolean exist = fileBase.exists();
//        if (exist) {
//            lowLengthFile = fileBase.length()<5;
//        }
        return (int)fileBase.length() < 5;
    }

    @Override
    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
        int ID;
        //      System.out.println(ois.readObject());
        accounts =(ArrayList<Account>) ois.readObject();
        //  System.out.println(ois.readObject());
        ID = accounts.size();
        Account account = new Account(ID, name, pass);
        accounts.add(account);
        oos.writeObject(accounts);
                System.out.println(language.AccountAdded);
    }

    @Override
    public int getLastID() {
        return 0;
    }

    @Override
    public int getPass(String name) throws IOException {
        int pass = -1;
        int i = 0;
        ArrayList<Account> accounts = null;
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
        try {
            accounts = (ArrayList<Account>) outInputStream.readObject();//getAccountsArray();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Account account = accounts.get(0);
        while (i < accounts.size() && !account.getName().equals(name)) {
            account = accounts.get(i);
            i++;
            pass = account.getName().equals(name) ? account.getPasswordHash() : -1;
        }
        return pass;
    }

    @Override
    public boolean checkExistName(String name) throws IOException {
        boolean exist = false;
        int i = 0;
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream outInputStream = new ObjectInputStream(fileInput);
        Account account = new Account(0, "", 0);
//        accounts.add(account);
        ArrayList<Account> accounts = null;
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
        return exist;

    }


    public String getAccount(String part, String name) {
        return null;
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


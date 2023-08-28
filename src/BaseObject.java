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

        if (emptyBase()) {
            createOutputFile();
        }
        fout = new FileOutputStream(file);
        oos = new ObjectOutputStream(fout);
        fin = new FileInputStream(file);
        ois = new ObjectInputStream(fin);

        accounts = new ArrayList<>();


    }

    @Override
    public boolean createOutputFile() {
        boolean created;
        if (emptyBase()) {
            try {
                oos.writeObject(accounts);
                System.out.println(language.createdBase);
                created = true;
            } catch (IOException e) {
                System.out.println(language.errorCreateBase);
                created = false;
                throw new RuntimeException(e);
            }
            return true;
        } else return false;
    }

    @Override
    public boolean emptyBase() {
        File fileBase = new File(file);
        return fileBase.exists();
 //       return fileBase.exists() && accounts.size() != 0;
    }

    @Override
    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
        int ID;
        accounts = (ArrayList<Account>) ois.readObject();
        ID = accounts.size();
        Account account = new Account(ID, name, pass);
        accounts.add(account);
        oos.writeObject(accounts);
        //        System.out.println(language.AccountAdded);
    }

    @Override
    public int getLastID() {
        return accounts.size();
    }

    @Override
    public int getPass(String name) {
        int pass = -1;
        int i = 0;
        Account account = accounts.get(0);
        while (i < accounts.size() && !account.getName().equals(name)) {
            account = accounts.get(i);
            i++;
            pass = account.getName().equals(name) ? account.getPasswordHash() : -1;
        }
        return pass;
    }

    @Override
    public boolean checkExistName(String name) {
        boolean exist = false;
        int i = 0;
        Account account = accounts.get(0);
        while (i < accounts.size() && !account.getName().equals(name)) {
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

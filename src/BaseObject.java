import java.io.*;
import java.util.ArrayList;

/**
 * ll
 */

public class BaseObject implements BaseInterface {
    String file = "account.bin";
    Language language;

    public BaseObject(Language language) throws IOException {
        this.language = language;
        initBase();
    }

    public void initBase() throws IOException {
        File fileBase = new File(file);
        if (!fileBase.exists()) {
            fileBase.createNewFile();
            System.out.println(language.createdBase);
        }
    }

    @Override
    public boolean emptyBaseFile() {
        File fileBase = new File(file);
        boolean exist = fileBase.exists();
        int length = (int) fileBase.length();
        return !exist || length < 5;
    }


    @Override
    public int getLastID() throws IOException, ClassNotFoundException {
        return readAccounts().size();
    }

    @Override
    public int getPass(String name) throws IOException, ClassNotFoundException {
        int pass = -1;
        ArrayList<Account> accounts = readAccounts();
        Account account;
        boolean accountEqualsName;
        int i = 0;
        do {
            account = accounts.get(i);
            i++;
            accountEqualsName = account.getName().equals(name);
            pass = accountEqualsName ? account.getPasswordHash() : -1;
        } while (i < accounts.size() && !accountEqualsName);
        return pass;
    }

    @Override
    public boolean checkExistName(String name) throws IOException, ClassNotFoundException {
        boolean exist = false;
        ArrayList<Account> accounts = readAccounts();
        Account account;
        int i = 0;
        while (i < accounts.size() && !exist) {
            account = accounts.get(i);
            i++;
            exist = account.getName().equals(name);
        }
        return exist;

    }

    @Override
    public void addAccount(String name, int pass) throws IOException, ClassNotFoundException {
        int ID;
        if (emptyBaseFile()) {
            addFirstAccount(0, name, pass);
        } else {
            ID = getLastID();
            addNewAccount(ID, name, pass);
        }
    }


    public void addFirstAccount(int ID, String name, int pass) throws IOException {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(ID, name, pass));
        writeAccounts(accounts);
    }

    public void addNewAccount(int ID, String name, int pass) throws IOException, ClassNotFoundException {
        ArrayList<Account> accounts = readAccounts();
        accounts.add(new Account(ID, name, pass));
        writeAccounts(accounts);
    }


    public ArrayList readAccounts() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Account> accounts;

        accounts = (ArrayList<Account>) ois.readObject();

        fis.close();
        ois.close();
        return accounts;

    }

    public void writeAccounts(ArrayList<Account> accounts) throws IOException {
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(accounts);
        fout.close();
        fout.close();
    }
}


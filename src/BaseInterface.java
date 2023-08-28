import java.io.IOException;

public interface BaseInterface {

    boolean createOutputFile() throws IOException;

    boolean emptyBase();

    void addAccount(String name, int pass) throws IOException, ClassNotFoundException;

    int getLastID() throws IOException;

    int getPass(String name) throws IOException;

    boolean checkExistName(String name) throws IOException;

//    String getAccount(String part, String name) throws IOException;
//    boolean deleteAccount(String part, String name) throws IOException;

}
//09.07.23
//23.08.23
//baseAccount2


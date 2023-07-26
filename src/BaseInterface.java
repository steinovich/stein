import java.io.IOException;

public interface BaseInterface {

    boolean createOutputFile();

    boolean emptyBase();

    void addAccount(String name, int pass) throws IOException;

    int getLastID() throws IOException;

    int getPass(String name) throws IOException;

    boolean checkExistName(String name) throws IOException;

    String getAccount(String part, String name) throws IOException;

}
//09.07.23


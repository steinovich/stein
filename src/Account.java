import java.io.Serializable;

public class Account  implements Serializable{

    private int id;
    private String name;
    private int passwordHash;
    protected Account(int id, String name, int passwordHash){
        this.id=id;
        this.name=name;
        this.passwordHash=passwordHash;

    }
    public Account(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNameHash(String name) {
        this.name = name;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }
//    @Override
//    public String toString() {
//        return ("id=\t"+id+"\tname=\t"+name+"\tpassword=\t"+passwordHash);
////        return new StringBuffer(" ID : ")
////                .append(this.id).append(" Name : ")
////                .append(this.name).toString();
//    }
}

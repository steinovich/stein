//
//import java.util.ArrayList;
//
//public class Base2 {
//    private final ArrayList<Account> accArray = new ArrayList<>();
//
//    public boolean emptyBase() {
//        return accArray.size() == 0;
//    }
//
//    public void addAccount(String name, int pass) {
//        Account newAcc = new Account();
//        // newAcc.setAccountID(nextID);
//        newAcc.setAccountName(name);
//        newAcc.setAccountPassword(pass);
//        accArray.add(newAcc);
//    }
//
//    public int getPass(String name) {
//        int Password = 0;//begin number for default
//
////===========password search by name================
//        for (Account accounts : accArray) {
//            if (accounts.getName().equals(name)) {
//                Password = accounts.getPass();
//            }
//        }
//        return Password;
//    }
//
//    boolean checkExistName(String name) {
//        String accName;
//        boolean exist = false;
//        for (Account accounts : accArray) {
//            accName = accounts.getName();
//            if (accName.equals(name)) {
//                exist = true;
//            }
//        }
//        return (exist);
//    }
//
////////    void testConnection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
////////        String url = "jdbc:mysql://localhost/store";
////////        String username = "root";
////////        String password = "root";
////////        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
////////        try (Connection conn = DriverManager.getConnection(url, username, password)) {
////////
////////            System.out.println("Connection to Store DB succesfull!");
//////
//////        }
////    }
//}
//

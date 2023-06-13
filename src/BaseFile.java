//import java.io.File;
//import java.io.IOException;
//
//public class BaseFile {
//
//    public static void main(String[] args) {
//
//        // определяем объект для каталога
//        File base = new File("E://JavaBase//base.txt");
//        if (base.exists()) {
//            System.out.println("База данных существует");
//        } else {
//            System.out.println("База данных не найдена");
//            createNewBase();
//        }
//
//        if (!base.canRead()) {
//            System.out.println("File can not be read");
//        }
//        if (!base.canWrite())
//            System.out.println("File can not be written");
//
//
//    }
//    public boolean emptyBase() {
////        return accArray.size() == 0;
//    }
//    static void createNewBase(String directory,String fileName) {
//        File dir = new File(directory);
//        boolean created = dir.mkdir();
//        if(created)
//            System.out.println("Folder has been created");
//        else             System.out.println("Folder has been not created");
//        // создадим новый файл
//        File base = new File(directory+fileName);
//        try {
//            created = base.createNewFile();
//            if (created)
//                System.out.println("База данных  успешно создана");
//        } catch (IOException ex) {
//            System.out.println("Не удалось создать базу данных");
//            System.out.println(ex.getMessage());
//        }
//
//    }
//}
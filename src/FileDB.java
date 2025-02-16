import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDB {
    private String fileName;
    File db;
    FileWriter dbWrite;

    FileDB(String fileName) {
        this.fileName = fileName;
        createFile();
    }

    public void createFile() {
        try {
            this.db = new File(fileName);

            if (this.db.createNewFile()) System.out.println("File yaradildi: " + this.db.getName());
            else System.out.println("File artiq movcuddur");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertFile(String data) {
        try {
            dbWrite = new FileWriter(fileName, true);
            dbWrite.write(data + "\n");
            dbWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean sign(String email, String password) { // niyə burda error qaytarır?
        try {
            Scanner sc = new Scanner(db);
            while (sc.hasNextLine()) {
                String demail = sc.nextLine();
                if (sc.hasNextLine()) {
                    String dpassword = sc.nextLine();
                    if (demail.equals(email) && dpassword.equals(password)) {
                        return true;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int selectData(String data) {
        int dataIndex = 0;
        boolean status = false;

        try {

            Scanner sc = new Scanner(db);

            while (sc.hasNextLine()) {
                dataIndex++;
                String d = sc.nextLine();
                if (d.equals(data)) {
                    status = true;
                    break;
                }


                if (dataIndex == 3) dataIndex = 0;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return status ? dataIndex : 0;
    }
}

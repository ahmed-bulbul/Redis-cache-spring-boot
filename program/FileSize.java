import java.io.File;

public class FileSize {

    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            System.out.println(file.length());
        } catch (Exception e) {
        }
    }
}

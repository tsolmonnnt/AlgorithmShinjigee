import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public static void main(String[] args){
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tsolm\\OneDrive\\Documents\\Алгоритмийн шинжилгээ ба зохиомж\\Лаб\\Лаб1\\лаб 1-1\\sortTestCase.txt"))) {
      String line = reader.readLine();
      System.out.println("Unshsan mur: " + line);
  
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}

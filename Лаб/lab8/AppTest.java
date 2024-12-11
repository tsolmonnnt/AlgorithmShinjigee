import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppTest {

    private int[] parseArrayFromString(String line) {
        String[] parts = line.trim().split(",\\s*");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }

    private int parseIntFromString(String line) {
        String part = line.trim();
        int number;
        number = Integer.parseInt(part);
        return number;
    }

    @Test
    public void CoinChange() {
        App app = new App();
        try (BufferedReader reader = new BufferedReader(new FileReader("./coinChange.txt"))) {
            String line = reader.readLine();
            String[] tokens = line.split(":");
            int[] number = parseArrayFromString(tokens[0]);
            int value = parseIntFromString(tokens[1]);
            int expectedNumber = parseIntFromString(tokens[2]);

            int Answer = app.coinChange(number, value);
            System.out.println(Answer);
            reader.close();
            Assert.assertEquals(expectedNumber, Answer);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

    @Test
    public void CountPrime() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("./countPrime.txt"))) {
            String line = reader.readLine();
            String[] tokens = line.split(":");
            int number = parseIntFromString(tokens[0]);
            int expectedAnswer = parseIntFromString(tokens[1]);
            System.out.println(expectedAnswer);
            int Answer = app.countPrime(number);
            reader.close();
            Assert.assertEquals(expectedAnswer, Answer);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

    @Test
    public void Bikes() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("./bikes.txt"))) {
            // String line = reader.readLine();
            // String[] tokens = line.split(":");
            int[][] students = { { 0, 0 }, { 1, 1 } };
            int[][] bikes = { { 0, 1 }, { 4, 3 }, { 2, 1 } };
            int[] expectedAnswer = { 0, 2 };
            System.out.println(expectedAnswer);
            int[] Answer = app.Bikes(students, bikes);
            reader.close();
            Assert.assertArrayEquals(expectedAnswer, Answer);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

}

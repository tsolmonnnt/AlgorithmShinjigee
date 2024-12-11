import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public int coinChange(int[] coins, int amount) {
        int[] a = new int[amount + 1];
        Arrays.fill(a, amount + 1);
        a[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    a[i] = Math.min(a[i], 1 + a[i - coin]);
                }
            }
        }
        return a[amount] > amount ? -1 : a[amount];
    }

    public int countPrime(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime)
                count++;
        }
        return count;
    }

    public int[] Bikes(int[][] students, int[][] bikes) {
        int[] result = new int[students.length];
        Arrays.fill(result, -1);
        boolean[] gotBike = new boolean[bikes.length];
        List<int[]> distances = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = Math.abs(students[i][0] - bikes[j][0]) + Math.abs(students[i][1] - bikes[j][1]);
                distances.add(new int[] { dist, i, j });
            }
        }

        distances.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int[] dist : distances) {
            int student = dist[1], bike = dist[2];
            if (result[student] == -1 && !gotBike[bike]) {
                result[student] = bike;
                gotBike[bike] = true;
            }
        }

        return result;
    }
}
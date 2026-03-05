import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[] cards = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean[] reminders = new boolean[m];
            long curSum = 0;
            int flag = 0;
            for (int i = 0; i < n; i++) {
                curSum += cards[i];
                int reminder = (int) curSum % m;
                if (reminder == 0 || reminders[reminder]) flag = 1;
                reminders[reminder] = true;
            }
            System.out.println(flag);
        }
    }
}
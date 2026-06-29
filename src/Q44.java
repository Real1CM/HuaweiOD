import java.util.Arrays;
import java.util.Scanner;

public class Q44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String[] str = sc.nextLine().split(" ");

        int[] targetCounts = new int[10];
        for (int i = 0; i < str[0].length(); i++) {
            targetCounts[str[0].charAt(i) - '0']++;
        }

        for (int i = 1; i < 1000; i++) {
            int[] currentCounts = new int[10];
            for (int j = 0; j < Integer.parseInt(str[1]); j++) {
                String s = String.valueOf(i + j);
                for (char c : s.toCharArray()) {
                    currentCounts[c - '0']++;
                }
            }

            if(Arrays.equals(targetCounts, currentCounts)){
                System.out.println(i);
                return;
            }
        }
    }
}

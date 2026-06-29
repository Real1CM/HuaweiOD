import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q20 {
    /* 我的解法，但显然不是最优
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String source = sc.nextLine();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (target.indexOf(c) != -1) {
                indexes.add(i);
            }
        }

        int ans = -1;
        int[] dp = new int[indexes.size() + 1];
        dp[indexes.size()] = target.length();
        for (int i = indexes.size() - 1; i >= 0; i--) {
            int index = indexes.get(i);
            char c = source.charAt(index);

            dp[i] = dp[i + 1] - 1;

            while (c != target.charAt(dp[i])) {
                dp[i]++;
            }

            if (dp[i] == 0) {
                ans = index;
                break;
            }
        }
        System.out.println(ans);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String target = sc.nextLine();
        if (!sc.hasNextLine()) return;
        String source = sc.nextLine();

        int tId = target.length() - 1;
        int sId = source.length() - 1;

        if (tId > sId) {
            System.out.println("-1");
            return;
        }

        int flag = -1;
        while (tId >= 0 && sId >= 0) {
            if(target.charAt(tId) == source.charAt(sId)){
                if(tId == 0) {
                    flag = sId;
                    break;
                }
                tId--;
            }
            sId--;
        }

        System.out.println(flag);
    }
}
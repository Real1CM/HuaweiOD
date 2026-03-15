import java.util.*;

public class Q55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int[] totalCount = new int[10];
        for (int i = 0; i < n; i++) {
            totalCount[s.charAt(i) - '0']++;
        }

        int[] alreadyIn = new int[10];
        int[] remaning = totalCount.clone();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            int curNum = curChar - '0';

            if (alreadyIn[curNum] == 2) {
                remaning[curNum]--;
                continue;
            }

            while (sb.length() > 0) {
                char topChar = sb.charAt(sb.length() - 1);
                int topNum = topChar - '0';
                if (topNum < curNum && alreadyIn[topNum] + remaning[topNum] > 2) {
                    sb.deleteCharAt(sb.length() - 1);
                    alreadyIn[topNum]--;
                } else break;
            }

            sb.append(curChar);
            alreadyIn[curNum]++;
            remaning[curNum]--;
        }

        System.out.println(sb);
    }
}

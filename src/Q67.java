import java.util.Arrays;
import java.util.Scanner;

public class Q67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split("\\s+");

        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) num[i] = Integer.parseInt(s[i]);

        int group = num.length / 3;

        int[] sortNum = num.clone();
        Arrays.sort(sortNum);
        int[] T = new int[group];
        int idx = 0;
        for (int i = group; i < num.length - group; i++) T[idx++] = sortNum[i];

        boolean[] tUsed = new boolean[group];
        int stay = 0;
        for (int i = 0; i < num.length; i += 3) {
            int a = num[i];
            int b = num[i + 1];
            int c = num[i + 2];

            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                int curTar = num[i + j];

                for (int k = 0; k < group; k++) {
                    if (!tUsed[k] && T[k] == curTar) {
                        int l = (j == 0) ? b : a;
                        int r = (j == 2) ? b : c;

                        if (solve(curTar, l, r)) {
                            stay++;
                            tUsed[k] = true;
                            flag = true;
                            break;
                        }
                    }
                }

                if(flag) break;
            }
        }

        System.out.println(group - stay);
    }

    private static boolean solve(int tar, int l, int r) {
        if ((tar >= l && tar <= r) || (tar <= l && tar >= r)) return true;
        return false;
    }
}

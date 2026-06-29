import java.util.Scanner;

public class Q117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();

        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'C' || str.charAt(i) == 'G') maxCnt++;
        }

        int curCnt = maxCnt;
        int maxIdx = 0;
        for (int i = 0; i < str.length() - n; i++) {
            if (str.charAt(i + 5) == 'C' || str.charAt(i + 5) == 'G') curCnt++;
            if (str.charAt(i) == 'C' || str.charAt(i) == 'G') curCnt--;

            if (maxCnt < curCnt) {
                maxCnt = curCnt;
                maxIdx = i + 1;
            }
        }

        System.out.print(str.substring(maxIdx, maxIdx + n));
    }
}

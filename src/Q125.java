import java.util.Scanner;

public class Q125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");

        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i]);

        int ansL = -1, ansR = -1;
        int maxV = 0;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 2; j < arr.length; j++) {
                int minH = Math.min(arr[i], arr[j]);
                int curV = 0;
                boolean isValid = true;

                for (int k = i + 1; k < j; k++) {
                    if (arr[k] >= minH) {
                        isValid = false;
                        break;
                    }
                    curV += (minH - arr[k]);
                }

                if (isValid && curV > 0) {
                    int curDis = j - i;
                    if (curV > maxV) {
                        maxV = curV;
                        ansL = i;
                        ansR = j;
                        minDis = curDis;
                    } else if (curV == maxV) {
                        if (curDis < minDis) {
                            ansL = i;
                            ansR = j;
                            minDis = curDis;
                        }
                    }
                }
            }
        }

        if (maxV == 0) System.out.println(0);
        else System.out.println(ansL + " " + ansR + ":" + maxV);
    }
}

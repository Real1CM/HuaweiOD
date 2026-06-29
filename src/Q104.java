import java.util.Scanner;

public class Q104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        int lastCor = 0;
        int offset = 0;
        long res = 0;
        for (int i = 0; i < N; i++) {
            int curCor = sc.nextInt();
            res += (long)(curCor - lastCor) * Math.abs(offset);

            offset += sc.nextInt();
            lastCor = curCor;
        }

        res += (long)(E - lastCor) * Math.abs(offset);

        System.out.print(res);
    }
}
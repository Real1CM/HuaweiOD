import java.util.Scanner;

public class Q141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] r = new int[3][4];
        for (int i = 0; i < 3; i++) {
            r[i][0] = sc.nextInt();
            r[i][1] = sc.nextInt();
            r[i][2] = sc.nextInt();
            r[i][3] = sc.nextInt();
        }

        int xMin = Math.max(Math.max(r[0][0], r[1][0]), r[2][0]);
        int xMax = Math.min(Math.min(r[0][0] + r[0][2], r[1][0] + r[1][2]), r[2][0] + r[2][2]);

        int yMin = Math.max(Math.max(r[0][1] - r[0][3], r[1][1] - r[1][3]), r[2][1] - r[2][3]);
        int yMax = Math.min(Math.min(r[0][1], r[1][1]), r[2][1]);

        long w = xMax - xMin;
        long h = yMax - yMin;

        if (w > 0 && h > 0) System.out.println(w * h);
        else System.out.println(0);
    }
}

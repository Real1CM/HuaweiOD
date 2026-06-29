import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if (M < 3 || M > 10 || N < 3 || N > 100) {
            System.out.println("-1");
            return;
        }

        int[][] arr = new int[N][12];
        for (int i = 0; i < N; i++) arr[i][11] = i + 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(sc.nextLine(), ",");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j][0] += num;
                arr[j][num]++;
            }
        }

        Arrays.sort(arr, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(y[0], x[0]);
            else {
                for (int i = 10; i > 0; i--) {
                    if (x[i] != y[i]) return Integer.compare(y[i], x[i]);
                }
            }
            return 0;
        });

        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i][11]);
            System.out.print(i != 2 ? "," : "");
        }
    }
}

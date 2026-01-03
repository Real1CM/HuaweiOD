import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   //进程数
        int n = sc.nextInt();   //作业数
        int[] arr = new int[n];
        int[] process = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            process[j % m] += arr[j];
        }

        int max = 0;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, process[j]);
        }
        System.out.println(max);
    }
}

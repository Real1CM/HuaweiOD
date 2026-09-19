import java.util.Scanner;

public class Q254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine().trim();

        line = line.substring(1, line.length() - 1);

        String[] rows = line.split("\\],\\[");

        int n = rows.length;
        int[][] matrix = null;
        int m = 0;

        for (int i = 0; i < n; i++) {
            String rowStr = rows[i].replace("[", "").replace("]", "");
            String[] nums = rowStr.split(",");
            if (matrix == null) {
                m = nums.length;
                matrix = new int[n][m];
            }
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        if (matrix == null || n == 0 || m == 0) {
            return;
        }

        int minOfMax = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int colMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                colMax = Math.max(colMax, matrix[i][j]);
            }
            minOfMax = Math.min(minOfMax, colMax);
        }

        System.out.println(minOfMax);
    }
}
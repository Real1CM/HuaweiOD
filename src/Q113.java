import java.util.Scanner;

public class Q113 {
    private static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        int[] counts = new int[14];
        for (char c : input.toCharArray()) counts[getVal(c)]++;

        dfs(counts, 0);
        System.out.println(maxScore);
    }

    private static int getVal(char ch) {
        if (ch >= '1' && ch <= '9') return ch - '0';
        if (ch == '0') return 10;
        if (ch == 'J') return 11;
        if (ch == 'Q') return 12;
        if (ch == 'K') return 13;
        return 0;
    }

    private static void dfs(int[] counts, int currentScore) {
        for (int i = 1; i <= 9; i++) {
            if (counts[i] >= 1 && counts[i + 1] >= 1 && counts[i + 2] >= 1 && counts[i + 3] >= 1 && counts[i + 4] >= 1) {
                for (int j = 0; j < 5; j++) counts[i + j]--;
                int curScore = (5 * i + 10) * 2;
                dfs(counts, currentScore + curScore);
                for (int j = 0; j < 5; j++) counts[i + j]++;
            }
        }

        for (int i = 1; i <= 13; i++) {
            if (counts[i] >= 4) {
                counts[i] -= 4;
                dfs(counts, currentScore + (i * 4) * 3);
                counts[i] += 4;
            }
        }

        for (int i = 1; i <= 13; i++) {
            if (counts[i] >= 3) {
                counts[i] -= 3;
                dfs(counts, currentScore + (i * 3) * 2);
                counts[i] += 3;

            }
        }

        for (int i = 1; i <= 13; i++) {
            if (counts[i] >= 2) {
                counts[i] -= 2;
                dfs(counts, currentScore + (i * 2) * 2);
                counts[i] += 2;

            }
        }

        int single = 0;
        for (int i = 1; i <= 113; i++) {
            if (counts[i] > 0) single += counts[i];
        }

        maxScore = Math.max(maxScore, currentScore + single);
    }
}

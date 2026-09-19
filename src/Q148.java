import java.util.Scanner;

public class Q148 {
    static int screenW = 800, screenH = 600;
    static int logoW = 50, logoH = 25;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();

        int maxX = screenW - logoW;
        int maxY = screenH - logoH;

        int finalX = solve(x, t, maxX);
        int finalY = solve(y, t, maxY);
        System.out.println(finalX + " " + finalY);
    }

    private static int solve(int start, int t, int maxRange) {
        int cycle = maxRange * 2;

        int curCycle = (start + t) % cycle;

        if (curCycle > maxRange) return cycle - curCycle;
        else return curCycle;
    }
}
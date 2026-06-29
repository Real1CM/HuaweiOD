import java.util.*;

public class Q42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] points = new int[n][2];
        Set<String> pointSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            pointSet.add(points[i][0] + "," + points[i][1]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int x1 = points[i][0], x2 = points[i][1];
                int y1 = points[i][1], y2 = points[i][0];
                //(dx,dy)垂直于(-dy,dx)
                int dx = x1 - x2, dy = y1 - y2;

                int x3 = x1 - dy, y3 = y1 + dx;
                int x4 = x2 - dy, y4 = y1 + dy;

                if (pointSet.contains(x3 + "," + y3 + "," + x4 + "," + y4)) count++;
            }
        }

        System.out.println(count / 8);
    }
}

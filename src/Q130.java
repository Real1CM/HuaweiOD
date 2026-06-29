import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q130 {
    static int aStart = 8 * 60, aEnd = 10 * 60;
    static int bStart = 12 * 60, bEnd = 14 * 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curHour = sc.nextInt();
        int curMinute = sc.nextInt();
        int curTime = curHour * 60 + curMinute;
        int endHour = sc.nextInt();
        int endMinute = sc.nextInt();
        int endTime = endHour * 60 + endMinute;
        if (endHour >= 20) {
            endTime = 20 * 60;
        }


        int n = sc.nextInt();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int distant = sc.nextInt();
            int num = sc.nextInt();

            int money = distant * 10;

            int onWay = distant * 10;
            int tmpCurTime = curTime;
            boolean over = false;
            while (onWay > 0) {
                if (tmpCurTime > endTime) {
                    over = true;
                    break;
                }

                if (tmpCurTime >= aStart && tmpCurTime <= aEnd) {
                    num += 2;
                } else if (tmpCurTime >= bStart && tmpCurTime <= bEnd) {
                    num += 9;
                } else {
                    if (num > 0) num--;
                }

                tmpCurTime++;
                onWay--;
            }

            if (over) continue;

            int consume = num + distant * 10;
            if (consume > endTime) continue;
            res.add(new int[]{id, consume, money});
        }

        res.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            else return Integer.compare(a[0], b[0]);
        });

        System.out.println(res.size());
        for (int[] i : res) System.out.println(i[0] + " " + i[1] + " " + i[2]);
    }
}

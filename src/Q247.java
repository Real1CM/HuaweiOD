import java.util.*;

public class Q247 {
    static class App {
        String name;
        int prior;
        int start;
        int end;

        public App(String name, int prior, int start, int end) {
            this.name = name;
            this.prior = prior;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<App> registeredApp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().trim().split("\\s+");

            String name = token[0];
            int prior = Integer.parseInt(token[1]);
            int start = toMinutes(token[2]);
            int end = toMinutes(token[3]);

            if (start >= end) continue;


            App cur = new App(name, prior, start, end);
            boolean canRegister = true;

            for (int j = registeredApp.size() - 1; j >= 0; j--) {
                App existing = registeredApp.get(j);

                if (Math.max(cur.start, existing.start) < Math.min(cur.end, existing.end)) {
                    if (cur.prior > existing.prior) {
                        registeredApp.remove(j);
                    } else {
                        canRegister = false;
                        break;
                    }
                }
            }

            if (canRegister) registeredApp.add(cur);
        }

        String tarStr = sc.nextLine().trim();
        int tarTime = toMinutes(tarStr);

        String res = "NA";
        for (App a : registeredApp) {
            if (tarTime >= a.start && tarTime < a.end) {
                res = a.name;
                break;
            }
        }

        System.out.println(res);
    }

    private static int toMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

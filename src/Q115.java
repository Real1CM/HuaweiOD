import java.util.PriorityQueue;
import java.util.Scanner;

public class Q115 {
    static class Task {
        int id;
        int priority;

        public Task(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Task>[] printers = new PriorityQueue[6];
        for (int i = 1; i <= 5; i++) {
            printers[i] = new PriorityQueue<>((a, b) -> {
                if (a.priority != b.priority) return Integer.compare(b.priority, a.priority);
                else return Integer.compare(a.id, b.id);
            });
        }

        int taskCnt = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if ("IN".equals(type)) {
                int p = sc.nextInt();
                int num = sc.nextInt();
                taskCnt++;
                printers[p].offer(new Task(taskCnt, num));
            } else if ("OUT".equals(type)) {
                int p = sc.nextInt();
                if (printers[p].isEmpty()) System.out.println("NULL");
                else {
                    Task task = printers[i].poll();
                    System.out.println(task.id);
                }
            }
        }
    }
}

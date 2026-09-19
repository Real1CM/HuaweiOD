import java.util.*;

public class Q160 {
    static class FileNode {
        String name;
        int size;
        int cnt;
        int time;

        FileNode(String name, int size, int time) {
            this.name = name;
            this.size = size;
            this.time = time;
            this.cnt = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.nextLine();

        Map<String, FileNode> map = new HashMap<>();

        PriorityQueue<FileNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.cnt != b.cnt) return a.cnt - b.cnt;
            return a.time - b.time;
        });

        int curSize = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("\\s+");

            String op = s[0];
            String name = s[1];
            time++;

            if (op.equals("get")) {
                FileNode node = map.get(name);

                if (node != null) {
                    node.cnt++;
                    node.time = time;
                    pq.remove(node);
                    pq.offer(node);
                }
            } else {
                int size = Integer.parseInt(s[2]);

                if (map.containsKey(name)) continue;

                while (curSize + size > m) {
                    if (pq.isEmpty()) break;

                    FileNode remove = pq.poll();

                    map.remove(remove.name);
                    curSize -= remove.size;
                }

                if (curSize + size > m) continue;

                FileNode node = new FileNode(name, size, time);
                map.put(name, node);
                pq.offer(node);
                curSize += size;
            }
        }

        List<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans);

        if (ans.isEmpty()) System.out.println("NONE");
        else System.out.println(String.join(",", ans));
    }
}

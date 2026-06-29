import java.util.*;

public class Q121 {
    static class Folder {
        int id;
        int data;
        List<Integer> subIds;

        public Folder(int id, int data, String subStr) {
            this.id = id;
            this.data = data;
            this.subIds = new ArrayList<>();

            subStr = subStr.replace("(", "").replace(")", "").trim();
            if (!subStr.isEmpty()) {
                String[] parts = subStr.split(",");
                for (String p : parts) this.subIds.add(Integer.parseInt(p));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int tar = sc.nextInt();

        Map<Integer, Folder> folderMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int size = sc.nextInt();
            String subStr = sc.next();

            Folder folder = new Folder(id, size, subStr);
            folderMap.put(id, folder);
        }

        int sum = cal(tar, folderMap);
        System.out.print(sum);
    }

    private static int cal(int id, Map<Integer, Folder> folderMap) {
        if (!folderMap.containsKey(id)) return 0;

        Folder cur = folderMap.get(id);
        int sum = cur.data;

        for (int subId : cur.subIds) {
            sum += cal(subId, folderMap);
        }

        return sum;
    }
}

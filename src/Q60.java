import java.io.*;
import java.util.*;

public class Q60 {
    static class Record {
        int index;
        String originalStr;
        String id;
        int time;
        int dist;
        String actualDevice;
        String regDevice;
        boolean isAbnormal = false;

        public Record(int index, String str) {
            this.index = index;
            this.originalStr = str;
            String[] s = str.split(",");
            this.id = s[0];
            this.time = Integer.parseInt(s[1]);
            this.dist = Integer.parseInt(s[2]);
            this.actualDevice = s[3];
            this.regDevice = s[4];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        List<Record> records = new ArrayList<>();

        Map<String, List<Record>> users = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Record record = new Record(i, line);
            records.add(record);

            users.computeIfAbsent(record.id, k -> new ArrayList<>()).add(record);

            if (!record.regDevice.equals(record.actualDevice)) {
                record.isAbnormal = true;
            }
        }

        for (List<Record> r : users.values()) {
            int size = r.size();
            if (size < 2) continue;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Record r1 = r.get(i);
                    Record r2 = r.get(j);

                    if (Math.abs(r1.time - r2.time) < 60 && Math.abs(r1.dist - r2.dist) > 5) {
                        r1.isAbnormal = true;
                        r2.isAbnormal = true;
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (Record r : records) {
            if (r.isAbnormal) {
                res.add(r.originalStr);
            }
        }

        if (res.isEmpty()) {
            System.out.println("null");
        } else {
            System.out.println(String.join(";", res));
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q162 {
    static class IpRange {
        String city;
        long startIp;
        long endIp;
        long len;

        public IpRange(String city, String startStr, String endStr) {
            this.city = city;
            this.startIp = ipToLong(startStr);
            this.endIp = ipToLong(endStr);
            this.len = this.endIp - this.startIp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String line2 = br.readLine();

        StringTokenizer st = new StringTokenizer(line1, ";");
        List<IpRange> ranges = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            int eqIdx = token.indexOf("=");
            if (eqIdx == -1) continue;

            String cityName = token.substring(0, eqIdx);
            String[] ips = token.substring(eqIdx + 1).split(",");

            ranges.add(new IpRange(cityName, ips[0], ips[1]));
        }

        Collections.sort(ranges, new Comparator<IpRange>() {
            @Override
            public int compare(IpRange o1, IpRange o2) {
                return Long.compare(o1.len, o2.len);
            }
        });

        String[] queries = line2.split(",");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < queries.length; i++) {
            long queryIp = ipToLong(queries[i].trim());
            String matched = "";

            for (IpRange r : ranges) {
                if (queryIp >= r.startIp && queryIp <= r.endIp) {
                    matched = r.city;
                    break;
                }
            }

            sb.append(matched);
            if (i < queries.length - 1) sb.append(",");
        }

        System.out.println(sb);
    }

    private static long ipToLong(String str) {
        String[] parts = str.split("\\.");
        long ip = 0;
        for (int i = 0; i < 4; i++) {
            ip = (ip << 8) + Integer.parseInt(parts[i]);
        }
        return ip;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q264 {
    static class Event {
        int time;
        int delta;

        public Event(int time, int delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int taskNum = Integer.parseInt(br.readLine().trim());
        List<Event> events = new ArrayList<>(taskNum * 2);

        for (int i = 0; i < taskNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            int parallelism = Integer.parseInt(st.nextToken());

            events.add(new Event(startTime, parallelism));
            events.add(new Event(endTime, -parallelism));
        }

        Collections.sort(events, (a, b) -> {
            if (a.time != b.time) return Integer.compare(a.time, b.time);
            return Integer.compare(a.delta, b.delta);
        });

        int maxServer = 0;
        int curServer = 0;
        for (Event event : events) {
            curServer += event.delta;
            if (curServer > maxServer) maxServer = curServer;
        }

        System.out.println(maxServer);
    }
}

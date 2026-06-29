import java.util.*;

public class Q53 {
    static class Component {
        int reliability;
        int price;

        Component(int reliability, int price) {
            this.reliability = reliability;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int N = sc.nextInt();
        int total = sc.nextInt();

        Map<Integer, List<Component>> map = new HashMap<>();
        TreeSet<Integer> reliabilitySet = new TreeSet<>();

        for (int i = 0; i < total; i++) {
            int type = sc.nextInt();
            if (type >= N) continue;

            map.computeIfAbsent(type, k -> new ArrayList<>()).add(new Component(sc.nextInt(), sc.nextInt()));
            reliabilitySet.add(type);
        }

        List<Integer> relList = new ArrayList<>(reliabilitySet);
        int left = 0, right = reliabilitySet.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int targetRel = relList.get(mid);

            if (solve(targetRel, S, N, map)) {
                ans = targetRel;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static boolean solve(int targetRel, int budget, int N, Map<Integer, List<Component>> map) {
        long totalCost = 0;

        for (int i = 0; i < N; i++) {
            List<Component> components = map.get(i);
            if (components == null) return false;

            int minPrice = Integer.MAX_VALUE;
            boolean found = false;
            for (Component component : components) {
                if (component.reliability >= targetRel) {
                    if (component.price < minPrice) {
                        minPrice = component.price;
                        found = true;
                    }
                }
            }

            if (!found) return false;
            totalCost += minPrice;
        }
        return totalCost <= budget;
    }
}

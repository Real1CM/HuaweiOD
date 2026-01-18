import java.util.*;

public class Q32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer[]> arr = new ArrayList<>();

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (sc.hasNextInt()) {
                int m = sc.nextInt();
                arr.add(new Integer[]{n, m});
            }
        }

        if (arr.size() < 2) return;

        List<Integer[]> arr2 = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int l = Math.max(arr.get(i)[0], arr.get(j)[0]);
                int r = Math.min(arr.get(i)[1], arr.get(j)[1]);

                if(l <= r) arr2.add(new Integer[]{l, r});
            }
        }

        if (arr2.isEmpty()) return;

        arr2.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<Integer[]> arr3 = new ArrayList<>();
        Integer[] cur = arr2.getFirst();

        for (int i = 1; i < arr2.size(); i++) {
            if(cur[1] > arr2.get(i)[0]) {
                cur[1] = Math.max(cur[1], arr2.get(i)[1]);
            } else {
                arr3.add(cur);
                cur = arr2.get(i);
            }
        }
        arr3.add(cur);

        for (int i = 0; i < arr3.size(); i++) {
            System.out.println(arr3.get(i)[0] + " " + arr3.get(i)[1]);
        }
    }
}

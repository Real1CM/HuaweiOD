import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().trim();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        if (!line.equals("[]")) {
            String[] str = line.replace("[", "").replace("]", "").split(",");
            for (String s : str) {
                int val = Integer.parseInt(s.trim());
                if (val >= 0 && val <= 3) listA.add(val);
                else if (val >= 4 && val <= 7) listB.add(val);
            }
        }
        int num = sc.nextInt();

        int cntA = listA.size();
        int cntB = listB.size();

        List<List<Integer>> res = new ArrayList<>();

        if (num == 1) {
            int[] order = {1, 3, 2, 4};
            for (int tar : order) {
                boolean found = false;
                if (cntA == tar) {
                    getComb(listA, 1, res);
                    found = true;
                }
                if (cntB == tar) {
                    getComb(listB, 1, res);
                    found = true;
                }
                if (found) break;
            }
        } else if (num == 2) {
            int[] order = {2, 4, 3};
            for (int tar : order) {
                boolean found = false;
                if (cntA == tar) {
                    getComb(listA, 2, res);
                    found = true;
                }
                if (cntB == tar) {
                    getComb(listB, 2, res);
                    found = true;
                }
                if (found) break;
            }
        } else if (num == 4) {
            if (cntA == 4) getComb(listA, 4, res);
            if (cntB == 4) getComb(listB, 4, res);
        } else if (num == 8) {
            if (cntA == 4 && cntB == 4) {
                List<Integer> all = new ArrayList<>();
                all.addAll(listA);
                all.addAll(listB);
                res.add(all);
            }
        }

        System.out.println(res);
    }

    private static void getComb(List<Integer> list, int k, List<List<Integer>> res) {
        back(list, k, 0, new ArrayList<>(), res);
    }

    private static void back(List<Integer> list, int k, int start, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            cur.add(list.get(i));
            back(list, k, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}

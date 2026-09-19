import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q212 {
    static int total = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tar = sc.nextInt();

        List<int[]> alloc = new ArrayList<>();
        while (sc.hasNextInt()) {
            int offset = sc.nextInt();
            int curByte = sc.nextInt();

            alloc.add(new int[]{offset, curByte});
        }

        alloc.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> free = new ArrayList<>();
        int curPtr = 0;
        for (int[] b : alloc) {
            int start = b[0];
            int size = b[1];

            if (start > curPtr) free.add(new int[]{curPtr, start - curPtr});

            curPtr = start + size;
        }

        if (curPtr < total) free.add(new int[]{curPtr, total - curPtr});

        int bestOffset = -1;
        int minFreeSize = Integer.MAX_VALUE;

        for (int[] f : free) {
            int offset = f[0];
            int size = f[1];

            if (size >= tar) {
                if (size < minFreeSize) {
                    minFreeSize = size;
                    bestOffset = offset;
                }
            }
        }

        System.out.println(bestOffset);
    }
}

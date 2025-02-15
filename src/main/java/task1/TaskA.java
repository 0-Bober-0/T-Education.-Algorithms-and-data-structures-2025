package task1;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[sc.nextInt()];
        int k = sc.nextInt();

        for (int i = 0; i < n.length; i++)
            n[i] = sc.nextInt();

        for (int i = 0; i < k; i++)
            if (isBinary(n, sc.nextInt()))
                System.out.println("YES");
            else
                System.out.println("NO");
    }

    private static boolean isBinary(int[] n, int k) {
        int start = 0;
        int end = n.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (n[mid] < k)
                start = mid + 1;
            else if (n[mid] == k)
                return true;
            else
                end = mid - 1;
        }
        return false;
    }
}

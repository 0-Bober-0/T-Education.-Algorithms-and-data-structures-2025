

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[sc.nextInt()];
        int k = sc.nextInt();

        for (int i = 0; i < n.length; i++)
            n[i] = sc.nextInt();

        for (int i = 0; i < k; i++)
            System.out.println(isBinary(n, sc.nextInt()));
    }

    private static int isBinary(int[] n, int k) {
        int start = 0;
        int end = n.length - 1;
        int result = n[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            if (Math.abs(n[mid] - k) < Math.abs(result - k))
                result = n[mid];
            else if ((Math.abs(n[mid] - k) == Math.abs(result - k)) && (n[mid] < result))
                result = n[mid];

            if (n[mid] < k)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return result;
    }
}

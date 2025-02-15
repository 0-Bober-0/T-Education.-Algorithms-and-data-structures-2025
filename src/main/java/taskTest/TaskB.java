package taskTest;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[sc.nextInt()];
        int k = sc.nextInt();

        for (int i = 0; i < n.length; i++)
            n[i] = sc.nextInt();

        Arrays.sort(n);

        if (k == 0)
            if (n[0] > 1)
                System.out.println(1);
        else
                System.out.println("-1");

        else {
            int x = n[k - 1];
            if (k < n.length && n[k] == x)
                System.out.println("-1");
            else
                System.out.println(x);
        }
    }
}

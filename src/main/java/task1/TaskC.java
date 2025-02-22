package task1;


import java.util.Scanner;
import static java.lang.System.out;

public class TaskC {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        isBinary(sc.nextInt());
    }

    private static void isBinary(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            out.println(mid);
            out.flush();

            if (sc.next().equals("<"))
                end = mid - 1;
            else
                start = mid + 1;
        }
        out.print("! " + (start - 1));
    }
}

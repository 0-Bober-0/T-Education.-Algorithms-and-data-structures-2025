

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class TaskG {
    private static StringBuilder sb;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> res = new ArrayList<>();

            for (int i = 1; i <= n; i++)
                res.add(i);

            for (int i = 0; i < n; i++) {
                int temp = res.get(i);
                res.set(i, res.get(i / 2));
                res.set(i / 2, temp);
            }

            sb = new StringBuilder();

            for (int val : res)
                sb.append(val).append(" ");

            out.println(sb.toString().trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.System.out;

public class TaskH {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        List<Character> chars = new ArrayList<>();

        for (char c : s.toCharArray()) chars.add(c);


        Collections.sort(chars);

        StringBuilder half = new StringBuilder();
        Character middle = null;

        while (!chars.isEmpty()) {
            char c = chars.remove(0);
            int index = chars.indexOf(c);

            if (index == -1) {
                if (middle == null)
                    middle = c;
            } else {
                half.append(c);
                chars.remove(index);
            }
        }

        String reversedHalf = new StringBuilder(half).reverse().toString();

        String result = half.toString();

        if (middle != null) result += middle;

        result += reversedHalf;

        out.println(result);

    }
}




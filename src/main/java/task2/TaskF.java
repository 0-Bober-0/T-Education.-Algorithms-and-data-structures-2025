package task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TaskF {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        Deque<String> deque = new ArrayDeque<>();
        Map<String, Integer> indexMap = new HashMap<>();

        int headOffset = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] cmd = reader.readLine().split(" ");

            switch (cmd[0]) {
                case "1":
                    deque.addLast(cmd[1]);
                    indexMap.put(cmd[1], deque.size() - 1 + headOffset);
                    break;
                case "2":
                    if (!deque.isEmpty()) {
                        String removed = deque.removeFirst();
                        indexMap.remove(removed);
                        headOffset++;
                    }
                    break;
                case "3":
                    if (!deque.isEmpty()) {
                        String removed = deque.removeLast();
                        indexMap.remove(removed);
                    }
                    break;
                case "4":
                    String key = cmd[1];
                    Integer relativeIndex = indexMap.get(key);
                    if (relativeIndex != null)
                        output.append(relativeIndex - headOffset).append("\n");
                    else
                        output.append("-1\n");
                    break;
                case "5":
                    if (!deque.isEmpty())
                        output.append(deque.peekFirst()).append("\n");
                    break;
            }
        }
        writer.write(output.toString());
        writer.flush();
    }
}

package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import static java.lang.System.out;

class TaskG {
    private final Deque<Integer> left;
    private final Deque<Integer> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TaskG q = new TaskG();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "+" -> q.push(Integer.parseInt(st.nextToken()));
                case "-" -> q.pop();
                case "*" -> q.middlePush(Integer.parseInt(st.nextToken()));
            }

        }
        br.close();
    }

    public TaskG() {
        this.left = new ArrayDeque<>();
        this.right = new ArrayDeque<>();
    }

    public void push(int value) {
        left.addFirst(value);
    }

    public void middlePush(int value) {
        while (right.size() < left.size())
            right.addFirst(left.removeLast());

        left.addLast(value);
    }

    public void pop() {
        while (right.size() < left.size())
            right.addFirst(left.removeLast());

        out.println(right.removeLast());
    }
}


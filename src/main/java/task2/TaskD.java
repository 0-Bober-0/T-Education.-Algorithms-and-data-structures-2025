

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class TaskD {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] balls = new int[n];
            for (int i = 0; i < n; i++) {
                balls[i] = Integer.parseInt(st.nextToken());
            }

            long count = 0;
            Deque<BallCount> stack = new ArrayDeque<>();

            for (int ball : balls) {
                if (stack.isEmpty()) {
                    stack.push(new BallCount(ball, 1));
                    continue;
                }

                BallCount top = stack.peek();
                if (top.ball == ball) {
                    stack.push(new BallCount(ball, top.count + 1));
                } else if (top.count >= 3) {
                    count += top.count;
                    for (int i = 0; i < top.count; i++) {
                        stack.pop();
                    }

                    if (stack.isEmpty() || stack.peek().ball != ball) {
                        stack.push(new BallCount(ball, 1));
                    } else {
                        stack.push(new BallCount(ball, stack.peek().count + 1));
                    }
                } else {
                    stack.push(new BallCount(ball, 1));
                }
            }

            while (!stack.isEmpty() && stack.peek().count >= 3) {
                count += stack.peek().count;
                for (int i = 0; i < stack.peek().count; i++) {
                    stack.pop();
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class BallCount {
        int ball;
        int count;

        public BallCount(int ball, int count) {
            this.ball = ball;
            this.count = count;
        }
    }
}
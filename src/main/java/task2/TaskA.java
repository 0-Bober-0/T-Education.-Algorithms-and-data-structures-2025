package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskA {
    private int[] stack = new int[0];
    private int size = 0; // Keep track of the current size of the stack

    private void push(int a) {
        // Resize the stack only when necessary
        if (size == stack.length) {
            int newCapacity = stack.length == 0 ? 1 : stack.length * 2;
            int[] newStack = new int[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        }

        stack[size++] = a;
    }

    private void delete() {
        if (size > 0) {
            size--;
        }
    }

    private int min() {
        if (size == 0) {
            return -1;
        }

        int min_ = stack[0];
        for (int i = 1; i < size; i++) {
            if (min_ > stack[i]) {
                min_ = stack[i];
            }
        }
        return min_;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  //Use BufferedReader for reading integers.
        TaskA a = new TaskA();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // Use StringTokenizer
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                a.push(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                a.delete();
            } else {
                System.out.println(a.min());
            }
        }
    }
}

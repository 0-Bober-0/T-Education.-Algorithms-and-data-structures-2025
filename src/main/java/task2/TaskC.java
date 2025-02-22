package task2;

import java.util.Scanner;
import java.util.Stack;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String[] s = sc.nextLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+") || s[i].equals("-") || s[i].equals("*")) {
                int a = stack.pop(), b = stack.pop();
                if (s[i].equals("+"))
                    stack.push(b + a);
                else if (s[i].equals("-"))
                    stack.push(b - a);
                else if (s[i].equals("*"))
                    stack.push(b * a);
            } else
                stack.push(Integer.parseInt(s[i]));
        }
        System.out.println(stack.pop());
    }
}

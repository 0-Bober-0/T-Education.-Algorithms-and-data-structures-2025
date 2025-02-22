package task1;

import java.util.*;
import java.util.function.IntConsumer;

public class TaskF {
    private static int count = 0;
    private static Scanner sc;

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                count += left.length - i;
                arr[k++] = right[j++];
            }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        mergeSort(arr);

        System.out.println(count);
        Arrays.stream(arr).iterator().forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
    }
}
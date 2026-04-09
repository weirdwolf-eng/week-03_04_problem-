import java.util.*;

public class Problem3TradeVolumeAnalysis {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int mergeTwoArrays(int[] a, int[] b) {
        int total = 0;
        for (int x : a) total += x;
        for (int x : b) total += x;
        return total;
    }

    public static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] trades = {500, 100, 300};

        System.out.println("Merge Sort (Ascending):");
        mergeSort(trades, 0, trades.length - 1);
        display(trades);

        int[] trades2 = {500, 100, 300};

        System.out.println("Quick Sort (Descending):");
        quickSort(trades2, 0, trades2.length - 1);
        display(trades2);

        int[] morning = {100, 200};
        int[] afternoon = {300, 400};

        int total = mergeTwoArrays(morning, afternoon);
        System.out.println("Total Volume: " + total);
    }
}
import java.util.*;

public class Problem5AccountIDLookup {

    public static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i + " (comparisons: " + comparisons + ")");
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchLast(String[] arr, String target) {
        int comparisons = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Last Index: " + i + " (comparisons: " + comparisons + ")");
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found at Index: " + mid + " (comparisons: " + comparisons + ")");
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};

        System.out.println("Linear Search:");
        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        Arrays.sort(logs);

        System.out.println("Binary Search:");
        int index = binarySearch(logs, "accB");

        System.out.println("Occurrences: " + countOccurrences(logs, "accB"));
    }
}
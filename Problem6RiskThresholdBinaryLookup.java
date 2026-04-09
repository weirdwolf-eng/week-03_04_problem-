
public class Problem6RiskThresholdBinaryLookup {

    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index " + i + " (comparisons: " + comparisons + ")");
                return i;
            }
        }
        System.out.println("Linear Not Found (comparisons: " + comparisons + ")");
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary Found at index " + mid + " (comparisons: " + comparisons + ")");
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Not Found (comparisons: " + comparisons + ")");
        return -1;
    }

    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        System.out.println("Linear Search:");
        linearSearch(risks, 30);

        System.out.println("Binary Search:");
        binarySearch(risks, 30);

        System.out.println("Floor: " + floor(risks, 30));
        System.out.println("Ceiling: " + ceiling(risks, 30));
        System.out.println("Insertion Point: " + insertionPoint(risks, 30));
    }
}
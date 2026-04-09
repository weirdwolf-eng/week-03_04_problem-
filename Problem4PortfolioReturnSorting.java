import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }
}

public class Problem4PortfolioReturnSorting {

    public static void mergeSort(List<Asset> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    public static void merge(List<Asset> list, int left, int mid, int right) {
        List<Asset> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).returnRate <= list.get(j).returnRate) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    public static void quickSort(List<Asset> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static int partition(List<Asset> list, int low, int high) {
        Asset pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            Asset current = list.get(j);

            if (current.returnRate > pivot.returnRate ||
               (current.returnRate == pivot.returnRate &&
                current.volatility < pivot.volatility)) {

                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public static void display(List<Asset> list) {
        for (Asset a : list) {
            System.out.println(a.name + " : " + a.returnRate + "% , vol=" + a.volatility);
        }
    }

    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();

        assets.add(new Asset("AAPL", 12, 5));
        assets.add(new Asset("TSLA", 8, 7));
        assets.add(new Asset("GOOG", 15, 4));

        System.out.println("Merge Sort (Ascending Return):");
        mergeSort(assets, 0, assets.size() - 1);
        display(assets);

        System.out.println("Quick Sort (Desc Return + Low Volatility):");
        quickSort(assets, 0, assets.size() - 1);
        display(assets);
    }
}
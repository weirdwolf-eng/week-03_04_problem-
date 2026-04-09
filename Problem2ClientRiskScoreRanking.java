import java.util.*;

class Client {
    String name;
    int riskScore;
    double balance;

    Client(String name, int riskScore, double balance) {
        this.name = name;
        this.riskScore = riskScore;
        this.balance = balance;
    }
}

public class Problem2ClientRiskScoreRanking {

    public static void bubbleSort(List<Client> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).riskScore > list.get(j + 1).riskScore) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(List<Client> list) {
        for (int i = 1; i < list.size(); i++) {
            Client key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (list.get(j).riskScore < key.riskScore ||
                    (list.get(j).riskScore == key.riskScore &&
                     list.get(j).balance < key.balance))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void display(List<Client> list) {
        for (Client c : list) {
            System.out.println(c.name + " : " + c.riskScore + " , " + c.balance);
        }
    }

    public static void topClients(List<Client> list, int k) {
        System.out.println("Top " + k + " High Risk Clients:");
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            Client c = list.get(i);
            System.out.println(c.name + " -> " + c.riskScore);
        }
    }

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        clients.add(new Client("A", 20, 1000));
        clients.add(new Client("B", 50, 2000));
        clients.add(new Client("C", 80, 1500));

        System.out.println("Bubble Sort (Ascending Risk):");
        bubbleSort(clients);
        display(clients);

        System.out.println("Insertion Sort (Descending Risk + Balance):");
        insertionSort(clients);
        display(clients);

        topClients(clients, 3);
    }
}

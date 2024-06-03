package knapsack.problem;

import java.util.List;

public class Result {
    List<Integer> itemNumbers;
    List<Integer> itemCounts;
    int totalValue;
    int totalWeight;
    List<Item> itemsInKnapsack;

    public Result(List<Integer> itemNumbers, List<Integer> itemCounts, int totalValue, int totalWeight, List<Item> itemsInKnapsack) {
        this.itemNumbers = itemNumbers;
        this.itemCounts = itemCounts;
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
        this.itemsInKnapsack = itemsInKnapsack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Result:\n");
        sb.append("Total Value: ").append(totalValue).append("\n");
        sb.append("Total Weight: ").append(totalWeight).append("\n");
        sb.append("------\nItems in the Knapsack:\n");
        for (int i = 0; i < itemNumbers.size(); i++) {
            sb.append("Item ").append(itemNumbers.get(i)).append(": Count ").append(itemCounts.get(i)).append("\n");
        }
        sb.append("------\nDetailed items in the knapsack:\n");
        for (Item item : itemsInKnapsack) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
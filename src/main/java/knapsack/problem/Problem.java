package knapsack.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private int numberOfItems;
    private int seed;
    private int lowerBound;
    private int upperBound;
    List<Item> items;

    public Problem(int numberOfItems, int seed, int lowerBound, int upperBound) {
        this.numberOfItems = numberOfItems;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();
        generateItems();
    }

    private void generateItems() {
        Random random = new Random(seed);
        for (int i = 0; i < numberOfItems; i++) {
            int value = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int weight = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            items.add(new Item(i + 1, value, weight));
        }
    }

    public Result solve(int capacity) {
        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        int currentWeight = 0;
        int totalValue = 0;
        List<Integer> itemNumbers = new ArrayList<>();
        List<Integer> itemCounts = new ArrayList<>();
        List<Item> itemsInKnapsack = new ArrayList<>();
        for (Item item : items) {
            int count = (capacity - currentWeight) / item.weight;
            if (count > 0) {
                currentWeight += count * item.weight;
                totalValue += count * item.value;
                itemNumbers.add(item.id);
                itemCounts.add(count);
                for (int j = 0; j < count; j++) {
                    itemsInKnapsack.add(item);
                }
                if (currentWeight >= capacity) break;
            }
        }
        return new Result(itemNumbers, itemCounts, totalValue, currentWeight, itemsInKnapsack);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nGenerated items:\n");
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
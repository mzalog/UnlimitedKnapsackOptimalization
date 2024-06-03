package knapsack.problem;

public class Item {
    int id;
    int value;
    int weight;

    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", value=" + value + ", weight=" + weight + ']';
    }
}
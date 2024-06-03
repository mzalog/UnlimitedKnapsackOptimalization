package knapsack.problem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class ProblemTest {

     @Test
    public void testProblemGeneration() {
        Problem problem = new Problem(10, 42, 1, 10);
        assertEquals(10, problem.items.size());
        for (Item item : problem.items) {
            assertTrue(item.value >= 1 && item.value <= 10);
            assertTrue(item.weight >= 1 && item.weight <= 10);
        }
    }

    @Test
    public void testSolveNonEmptyKnapsack() {
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.solve(50);
        assertTrue(result.totalWeight <= 50);
        assertTrue(result.totalValue > 0);
        assertTrue(result.itemNumbers.size() > 0);
    }

    @Test
    public void testSolveEmptyKnapsack() {
        Problem problem = new Problem(10, 1, 100, 200); // Items too heavy for the knapsack
        Result result = problem.solve(50);
        assertEquals(0, result.totalWeight);
        assertEquals(0, result.totalValue);
        assertTrue(result.itemNumbers.isEmpty());
    }

    @Test
    public void testItemRange() {
        Problem problem = new Problem(10, 42, 1, 10);
        for (Item item : problem.items) {
            assertTrue(item.value >= 1 && item.value <= 10);
            assertTrue(item.weight >= 1 && item.weight <= 10);
        }
    }

    @Test
    public void testSpecificInstance() {
        Problem problem = new Problem(10, 1, 1, 10);
        problem.items.clear();
        problem.items.add(new Item(1, 10, 5));  // Value 10, Weight 5
        problem.items.add(new Item(2, 5, 3));   // Value 5, Weight 3
        Result result = problem.solve(10);
        assertEquals(20, result.totalValue);  // 2 items of value 10 each (10 + 10)
        assertEquals(10, result.totalWeight);  // 2 items of weight 5 each (5 + 5)
    }
        @Test
    public void testLargeNumberOfItems() {
        Problem problem = new Problem(100000, 42, 1, 10);
        Result result = problem.solve(500000);
        assertTrue(result.totalWeight <= 500000);
        assertTrue(result.totalValue > 0);
        assertFalse(result.itemNumbers.isEmpty());
    }

    @Test
    public void testItemsAreSortedByValueWeightRatio() {
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.solve(50);

        double lastRatio = Double.MAX_VALUE;
        for (int i = 0; i < result.itemsInKnapsack.size(); i++) {
            Item item = result.itemsInKnapsack.get(i);
            double currentRatio = (double) item.value / item.weight;
            assertTrue(currentRatio <= lastRatio);
            lastRatio = currentRatio;
        }
    }

}

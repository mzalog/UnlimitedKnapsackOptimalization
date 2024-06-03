package knapsack.problem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int numberOfItems = scanner.nextInt();

        System.out.print("Enter the seed value: ");
        int seed = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int lowerBound = 1;
        int upperBound = 10;

        Problem problem = new Problem(numberOfItems, seed, lowerBound, upperBound);
        System.out.println(problem);

        Result result = problem.solve(capacity);
        System.out.println(result);

        scanner.close();
    }
}
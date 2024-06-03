package knapsack.problem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobieranie ilości przedmiotów
        System.out.print("Enter the number of items: ");
        int numberOfItems = scanner.nextInt();

        // Pobieranie wartości seeda
        System.out.print("Enter the seed value: ");
        int seed = scanner.nextInt();

        // Pobieranie pojemności plecaka
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        // Ustalanie zakresu wartości i wag przedmiotów (na podstawie instrukcji)
        int lowerBound = 1;
        int upperBound = 10;

        // Tworzenie problemu plecakowego
        Problem problem = new Problem(numberOfItems, seed, lowerBound, upperBound);
        System.out.println(problem);

        // Rozwiązywanie problemu
        Result result = problem.solve(capacity);
        System.out.println(result);

        scanner.close();
    }
}
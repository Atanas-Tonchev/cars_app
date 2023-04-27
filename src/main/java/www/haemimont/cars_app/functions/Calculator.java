package www.haemimont.cars_app.functions;


import java.util.Scanner;

public class Calculator {

    RandomGenerator generator = new RandomGenerator();

    public void AverageSum() {
        boolean quit = false;
        String toQuit;

        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        Scanner scanner = new Scanner(System.in);

        while (!quit) {

            System.out.println("Please input Param:");
            double param = scanner.nextDouble();
            System.out.println("Please input Count:");
            int count = scanner.nextInt();

            double price = generator.getRandomPrice();
            System.out.println("Generated price: " +price);
            double sum = (price * param) / count;
            System.out.println("The average sum is: " + sum);

            // get the end time
            long end = System.currentTimeMillis();

            // execution time
            long execution = end - start;
            System.out.println("Execution time: " + execution + " ms");
            scanner.nextLine();
            System.out.println("Press 'Q' to quit or any key to continue");
            toQuit = scanner.next();
            if (toQuit.equalsIgnoreCase("Q"))
                quit = true;
        }
        scanner.close();
        System.out.println("Good Bye");

    }
}

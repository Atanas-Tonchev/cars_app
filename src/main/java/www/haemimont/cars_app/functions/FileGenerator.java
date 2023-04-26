package www.haemimont.cars_app.functions;
import www.haemimont.cars_app.types.TypeA;
import www.haemimont.cars_app.types.TypeB;
import java.io.*;
import java.util.Scanner;

public class FileGenerator {
        String fileName = "src/main/java/www/haemimont/cars_app/file/Cars.txt";

        public void writeToFile (int id,String model,int year,double price) {
            TypeA typeA = new TypeA(id,model,year,price);
            TypeB typeB = new TypeB(id,model,year,price);
            try {
                if(fileName.isEmpty()){
                    FileWriter fileWriter = new FileWriter(fileName);
                    fileWriter.write(String.valueOf(typeA));
                    fileWriter.write("\n");
                    fileWriter.write(String.valueOf(typeB));
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("File has been written for the first time");
                }else {
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write("\n");

                    fileWriter.write(String.valueOf(typeA));
                    fileWriter.write("\n");
                    fileWriter.write(String.valueOf(typeB));
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("File has been written again");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void readFromFile(){
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fileReader);

                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Error file not found");
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("Error reading from file");
                throw new RuntimeException(e);
            }
        }

    public static void main(String[] args) {
        FileGenerator file = new FileGenerator();
        boolean quit = false;
        String toQuit;
        String model;
        int year;
        double price;
        int id;


        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        Scanner scanner = new Scanner(System.in);
        while (!quit) {
            System.out.println("Set ID,Mode,Year and Price:");
            id = scanner.nextInt();
            model = scanner.next();
            year = scanner.nextInt();
            price = scanner.nextDouble();

            file.writeToFile(id,model,year,price);
            scanner.nextLine();

            System.out.println("Press 'Q' to quit or any key to set more cars");
            toQuit = scanner.next();
            if (toQuit.equalsIgnoreCase("Q"))
                quit = true;

        }
        scanner.close();
        System.out.println("Good Bye");
        System.out.println("There is all data in the file");
        file.readFromFile();



        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");
    }
}

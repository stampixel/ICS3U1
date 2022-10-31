import java.util.Random;

public class ImportRandom {
    public static void main(String[] args) {
        // cConstruct the  Object
        Random randint = new Random();

        // Geberate a random number between 1 and 100

        int num = randint.nextInt(100) + 1;
        
    }
}

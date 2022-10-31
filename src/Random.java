/*
@author kevin.tang
2022.10.11
 */
public class Random {
    /*
    Demonstrating the 2 methods for creating Random Numbers
     */
    public static void main(String[] args) {
        // METHOD 1 ==> the Math class

        int randint = (int) (Math.random()*100)+1;
        /*
        Math.random()
        Returns a double value with a positiove sign,
        greater than or equal to 0.0 and less than 1.0
        0 <= randint < 1
         */
        // (int) ==> is required to change the number to an integer
        // Multiply the number by 100 to get the uppr limit
        // We add 1 to include 100 in the set.
        // This also removes 0 from the set

        // Generatea 1000 random numbers betwwen 0 and 100
        for (int i=0; i < 1000; i++) {
            randint = (int) (Math.random()*100)+1;
            System.out.print(randint + " ");
            if (i % 25 == 0) {
                System.out.println();
            }
        }
        System.out.println(randint);

    }
    public static void main2(String[] args) {
        int randint = (int) (Math.random()*100)+1;
        System.out.println(randint);
    }
}

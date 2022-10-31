public class test {
    public static void main(String[] args) {
        // Think of the *2 as the number of possibilities
        // The floor number is 99, menaing starting from 99
        int randint = (int) (Math.random()*2)+99;
        System.out.println(randint);
    }
}

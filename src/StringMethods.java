public class StringMethods {
    /**
     * Demonstrate all the exmaples from the slides.
     * @param args
     */
    public static void main(String[] args) {
        // Initialize a string
        String word = "Computer";

        // length()
        String s = "smooth";
        System.out.println(s.length());

        // Assign a new value
        s = "Marie";
        /**
         * Returns the char value at the specified index.
         * An index ranges from 0 to length(
-1         */
        System.out.println(s.charAt(0));
        /**
         * indexOf(char c)
         * Returns the index within this string
         * of tehe first occorence of the specificied char
         */
        s = "Toronto";
        System.out.println(s.indexOf("T"));

        /**
         * substring(int start)
         * substring(int start, int pastEnd)
         * start va;ieinlcuded, end vaue not included
         */
        s = "Brian Auyeung";
        // 0000000001211
        // 0123456789012
        System.out.println(s.substring(3));
        System.out.println(s.substring(2, 5));
    }
}

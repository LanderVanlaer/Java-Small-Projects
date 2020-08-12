package me.landervanlaer.math;

public class Number {
    /**
     * Get a random value between 2 numbers.
     * <p>This method uses {@link Math#random()}</p>
     *
     * @param min The minimum value (included)
     * @param max The maximum value (excluded)
     * @return A random number
     */
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Re-maps a number from a range to another
     *
     * @param value The number that needs to be converted
     * @param min1  The minimum value of the first range
     * @param max1  The maximum value of the first range
     * @param min2  The minimum value of the second range
     * @param max2  The maximum value of the second range
     * @return The remapped number
     */
    public static double map(double value, double min1, double max1, double min2, double max2) {
        return (value - min1) / (max1 - min1) * (max2 - min2) + min2;
    }

    /**
     * Check ifs the given {@link String} can be converted to an {@link Integer}
     *
     * @param input The string to see if it can be converted to an interger
     * @return {@code true} if it can be converted, {@code false} if you can not
     */
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

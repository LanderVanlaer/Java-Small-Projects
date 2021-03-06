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

    /**
     * Checks if the given {@code int} is a prime number.
     *
     * @param number The number that has to be checked
     * @return Whether the given integer is a prime number or not.
     */
    public static boolean isPrimeNumber(final long number) {
        if(number == 2L) return true;
        if(number <= 1L || number % 2L == 0) return false;

        final long half = number / 2L;
        for(long i = 3L; i < half; i += 2L)
            if(number % i == 0)
                return false;

        return true;
    }

    /**
     * Searches for the nearest prime number that is smaller than the given number.
     * If the number is less than or equal to {@code 1}, then {@code 1} is returned.
     *
     * @param i The number from which to look
     * @return The nearest prime number smaller than the given number
     * @see #isPrimeNumber(long)
     */
    public static int getClosestPrimeNumber(int i) {
        if(i <= 1) return 1;
        if(Number.isPrimeNumber(i)) return i;
        return getClosestPrimeNumber(i - 1);
    }

    /**
     * Constrains a value between a min and max value
     *
     * @param n   number to constrain
     * @param min minimum limit
     * @param max maximum limit
     * @return The constrained number
     */
    public static double constrain(double n, double min, double max) {
        if(n <= min) return min;
        return Math.min(n, max);
    }

    /**
     * Constrains a value between a min and max value
     *
     * @param n   number to constrain
     * @param min minimum limit
     * @param max maximum limit
     * @return The constrained number
     */
    public static int constrain(int n, int min, int max) {
        if(n <= min) return min;
        return Math.min(n, max);
    }

    /**
     * Constrains a value between a min and max value
     *
     * @param n   number to constrain
     * @param min minimum limit
     * @param max maximum limit
     * @return The constrained number
     */
    public static float constrain(float n, float min, float max) {
        if(n <= min) return min;
        return Math.min(n, max);
    }

    /**
     * Constrains a value between a min and max value
     *
     * @param n   number to constrain
     * @param min minimum limit
     * @param max maximum limit
     * @return The constrained number
     */
    public static long constrain(long n, long min, long max) {
        if(n <= min) return min;
        return Math.min(n, max);
    }
}

public class QuantityMeasurementApp {

    // Inner class representing Feet measurement
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals() method
        @Override
        public boolean equals(Object obj) {

            // Check same reference (reflexive)
            if (this == obj) {
                return true;
            }

            // Check null and type safety
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Cast safely
            Feet other = (Feet) obj;

            // Compare using Double.compare()
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        // Test cases
        System.out.println("Same Value (1.0 vs 1.0): " + f1.equals(f2)); // true
        System.out.println("Different Value (1.0 vs 2.0): " + f1.equals(f3)); // false
        System.out.println("Null Comparison: " + f1.equals(null)); // false
        System.out.println("Same Reference: " + f1.equals(f1)); // true
    }
}
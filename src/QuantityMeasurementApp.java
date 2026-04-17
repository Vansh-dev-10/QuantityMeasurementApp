public class QuantityMeasurementApp {

    // Feet class
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inches class
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Static method to compare Feet
    public static boolean compareFeet(double val1, double val2) {
        Feet f1 = new Feet(val1);
        Feet f2 = new Feet(val2);
        return f1.equals(f2);
    }

    // Static method to compare Inches
    public static boolean compareInches(double val1, double val2) {
        Inches i1 = new Inches(val1);
        Inches i2 = new Inches(val2);
        return i1.equals(i2);
    }

    // Main method for testing
    public static void main(String[] args) {

        // Feet test cases
        System.out.println("Feet same (1.0 vs 1.0): " + compareFeet(1.0, 1.0));
        System.out.println("Feet different (1.0 vs 2.0): " + compareFeet(1.0, 2.0));

        // Inches test cases
        System.out.println("Inches same (12.0 vs 12.0): " + compareInches(12.0, 12.0));
        System.out.println("Inches different (12.0 vs 24.0): " + compareInches(12.0, 24.0));

        // Null comparison
        Inches i = new Inches(5.0);
        System.out.println("Null comparison: " + i.equals(null));

        // Same reference
        System.out.println("Same reference: " + i.equals(i));
    }
}
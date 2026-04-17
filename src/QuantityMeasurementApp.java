public class QuantityMeasurementApp {

    // ================= UC1: Feet Class =================
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

    // ================= UC2: Inches Class =================
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

    // ================= Static Methods =================

    // UC1: Compare Feet
    public static boolean compareFeet(double val1, double val2) {
        Feet f1 = new Feet(val1);
        Feet f2 = new Feet(val2);
        return f1.equals(f2);
    }

    // UC2: Compare Inches
    public static boolean compareInches(double val1, double val2) {
        Inches i1 = new Inches(val1);
        Inches i2 = new Inches(val2);
        return i1.equals(i2);
    }

    // ================= Main Method =================
    public static void main(String[] args) {

        // -------- UC1 Tests (Feet) --------
        System.out.println("UC1 - Feet same (1.0 vs 1.0): " + compareFeet(1.0, 1.0));
        System.out.println("UC1 - Feet different (1.0 vs 2.0): " + compareFeet(1.0, 2.0));

        Feet f = new Feet(5.0);
        System.out.println("UC1 - Null comparison: " + f.equals(null));
        System.out.println("UC1 - Same reference: " + f.equals(f));

        // -------- UC2 Tests (Inches) --------
        System.out.println("UC2 - Inches same (12.0 vs 12.0): " + compareInches(12.0, 12.0));
        System.out.println("UC2 - Inches different (12.0 vs 24.0): " + compareInches(12.0, 24.0));

        Inches i = new Inches(10.0);
        System.out.println("UC2 - Null comparison: " + i.equals(null));
        System.out.println("UC2 - Same reference: " + i.equals(i));
    }
}
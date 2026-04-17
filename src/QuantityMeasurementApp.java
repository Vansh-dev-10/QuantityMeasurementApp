public class QuantityMeasurementApp {

    // ================= UC3 & UC4: Enum for Units =================
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),        // 1 inch = 1/12 feet
        YARDS(3.0),              // 1 yard = 3 feet
        CENTIMETERS(0.0328084);  // 1 cm ≈ 0.0328084 feet

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    // ================= UC3 & UC4: Generic Quantity Class =================
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj) return true;

            // Null & Type check
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            // Value-based equality after conversion
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }
    }

    // ================= UC1: Feet Equality =================
    public static boolean compareFeet(double val1, double val2) {
        Quantity q1 = new Quantity(val1, LengthUnit.FEET);
        Quantity q2 = new Quantity(val2, LengthUnit.FEET);
        return q1.equals(q2);
    }

    // ================= UC2: Inches Equality =================
    public static boolean compareInches(double val1, double val2) {
        Quantity q1 = new Quantity(val1, LengthUnit.INCH);
        Quantity q2 = new Quantity(val2, LengthUnit.INCH);
        return q1.equals(q2);
    }

    // ================= Main Method (All UC Tests) =================
    public static void main(String[] args) {

        // -------- UC1: Feet --------
        System.out.println("UC1 - Feet same (1.0 vs 1.0): " + compareFeet(1.0, 1.0));
        System.out.println("UC1 - Feet different (1.0 vs 2.0): " + compareFeet(1.0, 2.0));

        // -------- UC2: Inches --------
        System.out.println("UC2 - Inches same (12.0 vs 12.0): " + compareInches(12.0, 12.0));
        System.out.println("UC2 - Inches different (12.0 vs 24.0): " + compareInches(12.0, 24.0));

        // -------- UC3: Cross Unit (Feet ↔ Inches) --------
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);
        System.out.println("UC3 - 1 ft == 12 inch: " + q1.equals(q2));

        // -------- UC4: Yards --------
        Quantity q3 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q4 = new Quantity(3.0, LengthUnit.FEET);
        System.out.println("UC4 - 1 yard == 3 feet: " + q3.equals(q4));

        Quantity q5 = new Quantity(36.0, LengthUnit.INCH);
        System.out.println("UC4 - 1 yard == 36 inches: " + q3.equals(q5));

        // -------- UC4: Centimeters --------
        Quantity q6 = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity q7 = new Quantity(0.393701, LengthUnit.INCH);
        System.out.println("UC4 - 1 cm == 0.393701 inch: " + q6.equals(q7));

        // -------- Different values --------
        Quantity q8 = new Quantity(2.0, LengthUnit.FEET);
        System.out.println("Different values (1 ft vs 2 ft): " + q1.equals(q8));

        // -------- Transitive Property --------
        Quantity a = new Quantity(1.0, LengthUnit.YARDS);
        Quantity b = new Quantity(3.0, LengthUnit.FEET);
        Quantity c = new Quantity(36.0, LengthUnit.INCH);
        System.out.println("Transitive (yard == feet == inch): " +
                (a.equals(b) && b.equals(c) && a.equals(c)));

        // -------- Same Reference --------
        System.out.println("Same reference: " + a.equals(a));

        // -------- Null Comparison --------
        System.out.println("Compare with null: " + a.equals(null));

        // -------- Invalid Unit --------
        try {
            Quantity invalid = new Quantity(5.0, null);
        } catch (Exception e) {
            System.out.println("Invalid unit handled: " + e.getMessage());
        }
    }
}
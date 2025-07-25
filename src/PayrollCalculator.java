public class PayrollCalculator {

    public static void main(String[] args) {
        // Test data
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Test individual
        System.out.println("Pay for Alice (FULL_TIME, 45 hrs @ $25): " + calculateWeeklyPay("FULL_TIME", 45, 25));
        System.out.println("Tax on $1500 with insurance: " + calculateTaxDeduction(1500, true));

        // Process full payroll
        processPayroll(types, hours, rates, names);
    }
    // Method to calculate weekly pay
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid input.");
            return 0;
        }

        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double overtime = (hoursWorked - 40) * (hourlyRate * 1.5);
                    return (40 * hourlyRate) + overtime;
                }

            case "PART_TIME":
                if (hoursWorked > 25) hoursWorked = 25;
                return hoursWorked * hourlyRate;

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                if (hoursWorked > 20) hoursWorked = 20;
                double discountedRate = hourlyRate * 0.8;
                return hoursWorked * discountedRate;

            default:
                System.out.println("Invalid employee type.");
                return 0;
        }
    }

    // Method to calculate tax deduction
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    // Method to process multiple employees
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int n = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double totalPay = 0;
        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String highestPaid = "";
        String lowestPaid = "";
        int overtimeCount = 0;

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-12s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Net Pay");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double grossPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(grossPay, false); // assuming no insurance for now
            double netPay = grossPay - tax;

            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], rates[i], netPay);

            if (netPay > maxPay) {
                maxPay = netPay;
                highestPaid = names[i];
            }

            if (netPay < minPay) {
                minPay = netPay;
                lowestPaid = names[i];
            }

            if (hours[i] > 40) overtimeCount++;

            totalPay += netPay;
        }

        double avgPay = totalPay / n;

        System.out.println("\nSummary:");
        System.out.println("Highest Paid: " + highestPaid + " ($" + maxPay + ")");
        System.out.println("Lowest Paid: " + lowestPaid + " ($" + minPay + ")");
        System.out.println("Average Net Pay: $" + avgPay);
        System.out.println("Employees with Overtime: " + overtimeCount);
    }


}

import java.util.Scanner;

public class SmartAttendanceSystem {

    static int attendance = 0; // 30 days stored in one integer

    // Mark student present
    static void markPresent(int day) {
        attendance |= (1 << (day - 1));
    }

    // Mark student absent
    static void markAbsent(int day) {
        attendance &= ~(1 << (day - 1));
    }

    // Check attendance
    static boolean isPresent(int day) {
        return (attendance & (1 << (day - 1))) != 0;
    }

    // Display all attendance
    static void displayAttendance() {
        for (int day = 1; day <= 30; day++) {
            System.out.println(
                "Day " + day + ": " +
                (isPresent(day) ? "Present" : "Absent")
            );
        }
    }

    // Analytics
    static void showAnalytics() {
        int presentDays = Integer.bitCount(attendance);
        int absentDays = 30 - presentDays;
        double percentage = (presentDays / 30.0) * 100;

        System.out.println("Present Days: " + presentDays);
        System.out.println("Absent Days : " + absentDays);
        System.out.printf("Attendance %%: %.2f%%\n", percentage);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Smart Attendance System ===");
            System.out.println("1. Mark Present");
            System.out.println("2. Mark Absent");
            System.out.println("3. Check Attendance");
            System.out.println("4. Display Attendance");
            System.out.println("5. Show Analytics");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter day (1-30): ");
                    markPresent(sc.nextInt());
                }

                case 2 -> {
                    System.out.print("Enter day (1-30): ");
                    markAbsent(sc.nextInt());
                }

                case 3 -> {
                    System.out.print("Enter day (1-30): ");
                    int day = sc.nextInt();
                    System.out.println(
                            isPresent(day) ? "Present" : "Absent"
                    );
                }

                case 4 -> displayAttendance();

                case 5 -> showAnalytics();

                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}

import java.util.*;

class Expense {
    double amount;
    String description;
    String date;

    public Expense(double amount, String description, String date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public void display() {
        System.out.println("₹" + amount + " - " + description + " (" + date + ")");
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Total Spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Clear newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: showTotal(); break;
                case 4: System.out.println("Thank you! Exiting..."); return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    static void addExpense() {
        System.out.print("Enter amount (₹): ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        System.out.print("Enter date (e.g., 2025-05-09): ");
        String date = sc.nextLine();

        expenses.add(new Expense(amount, description, date));
        System.out.println("✅ Expense added!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("\nYour Expenses:");
        for (Expense e : expenses) {
            e.display();
        }
    }

    static void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("💸 Total Spent: ₹" + total);
    }
}

package main;

// import java.util;
import java.util.Scanner;

public class bS2 {

    public void getCategory() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the category of your budget?");
        System.out.println(
                "1.Income 2.Expenses 3.Transportation 4.Food 5.Entertainment 6.Shopping 7.Health 8.Debts 9.Education");
        String category = in.nextLine();
        in.close();
    }

    public double getBudgetAmount() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the budget amount for this category?");
        int budgetAmount = in.nextInt();
        in.close();
        return 0;
    }

    public double getProgress() {
        Scanner in = new Scanner(System.in);

        System.out.println("How much have you spent for this category?");
        int progressAmount = in.nextInt();
        System.out.println("How much is the budget?");
        int budgetAmount = in.nextInt();
        if (progressAmount < budgetAmount) {
            int progress = budgetAmount - progressAmount;
            System.out.println("The remaining amount is: " + progress + "/=");
            in.close();
            return 0;

        } else if (progressAmount > budgetAmount) {
            int progress = budgetAmount - progressAmount;
            System.out.println("You are above budget by: " + progress + "/=");
            in.close();
            return 0;
        } else {
            System.out.println("Invalid input!");
        }
        in.close();
        return 0;

    }

    // public static void main(String[] args) {
    //     bS2 budget = new bS2();
    //     budget.getCategory("Housing");
    //     budget.getBudgetAmount(1000);
    //     budget.getProgress(12, 122, 1000);

    // }
}

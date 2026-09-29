import java.util.Scanner;

/**
 * A grocery management system that uses parallel arrays
 * to store item names, prices, and stock quantities.
 *
 * The program allows the user to view the inventory,
 * restock an existing item, and exit the program.
 *
 * @author Sandip Yadav
 */
public class GroceryManagementSystem {

    /**
     * Displays all non-empty items in the inventory.
     *
     * @param names  array containing item names
     * @param prices array containing item prices
     * @param stocks array containing item stock quantities
     */
    public static void printInventory(String[] names,
                                      double[] prices,
                                      int[] stocks) {

        System.out.println("\n--- Grocery Inventory ---");

        for (int i = 0; i < names.length; i++) {

            if (names[i] != null) {
                System.out.printf(
                    "%s - $%.2f - Stock: %d%n",
                    names[i],
                    prices[i],
                    stocks[i]
                );
            } else {
                // This slot in the parallel arrays is empty.
            }
        }
    }

    /**
     * Searches for an item and adds the specified amount
     * to its current stock.
     *
     * @param names  array containing item names
     * @param stocks array containing item stock quantities
     * @param target name of the item to restock
     * @param amount amount to add to the item's stock
     */
    public static void restockItem(String[] names,
                                   int[] stocks,
                                   String target,
                                   int amount) {

        boolean found = false;

        for (int i = 0; i < names.length; i++) {

            if (names[i] != null
                    && names[i].equalsIgnoreCase(target)) {

                stocks[i] += amount;

                System.out.println(
                    target + " was successfully restocked."
                );

                System.out.println(
                    "New stock: " + stocks[i]
                );

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    /**
     * Main method that creates the grocery inventory
     * and displays the user menu.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Parallel arrays required by the assignment.
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Starting inventory.
        itemNames[0] = "Apple";
        itemPrices[0] = 1.50;
        itemStocks[0] = 10;

        itemNames[1] = "Milk";
        itemPrices[1] = 3.25;
        itemStocks[1] = 5;

        itemNames[2] = "Bread";
        itemPrices[2] = 2.75;
        itemStocks[2] = 8;

        while (true) {

            System.out.println("\n=== Grocery Management System ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                printInventory(
                    itemNames,
                    itemPrices,
                    itemStocks
                );

            } else if (choice == 2) {

                System.out.print("Enter item name: ");
                String target = input.nextLine();

                System.out.print("Enter amount to add: ");
                int amount = input.nextInt();
                input.nextLine();

                restockItem(
                    itemNames,
                    itemStocks,
                    target,
                    amount
                );

            } else if (choice == 3) {

                System.out.println("Exiting program.");
                break;

            } else {

                System.out.println(
                    "Invalid choice. Please enter 1, 2, or 3."
                );
            }
        }

        input.close();
    }
}
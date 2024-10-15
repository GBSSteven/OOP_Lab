import java.util.Scanner;

public class Parliament {

    public static void main(String[] args) {
        boolean main_loop = true;
        Scanner sc = new Scanner(System.in); // Single Scanner instance

        while (main_loop) {
            System.out.println("1. Lok Sabha");
            System.out.println("2. Rajya Sabha");
            System.out.println("3. Exit");
            System.out.print("Enter a number from the above options: ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    handleLokSabha(sc);
                    break;
                case 2:
                    handleRajyaSabha(sc);
                    break;
                case 3:
                    main_loop = false;
                    System.out.println("Exiting Parliament...");
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }
        }
        sc.close(); // Close the Scanner at the end of the program
    }

    // Handle Lok Sabha menu
    private static void handleLokSabha(Scanner sc) {
        boolean lok_loop = true;
        LokSabha lokSabha = new LokSabha(); // Object creation for LokSabha

        while (lok_loop) {
            System.out.println(
                    "_______________________________________________________________________________________");
            System.out.println("Lok Sabha Menu");
            System.out.println("\n1. Check max number of members");
            System.out.println("2. Pass bill");
            System.out.println("3. Back");
            System.out.print("Enter a number from the above options: ");
            int lok_input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (lok_input) {
                case 1:
                    System.out.println("Max number of members in Lok Sabha is: " + lokSabha.getTotalMembers());
                    break;
                case 2:
                    lokSabha.passBill();
                    break;
                case 3:
                    lok_loop = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }
        }
    }

    // Handle Rajya Sabha menu
    private static void handleRajyaSabha(Scanner sc) {
        boolean rajya_loop = true;
        RajyaSabha rajyaSabha = new RajyaSabha(); // Object creation for RajyaSabha

        while (rajya_loop) {
            System.out.println(
                    "_______________________________________________________________________________________");
            System.out.println("Rajya Sabha Menu");
            System.out.println("1. Check max number of members");
            System.out.println("2. Pass bill");
            System.out.println("3. Back");
            System.out.print("Enter a number from the above options: ");
            int rajya_input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (rajya_input) {
                case 1:
                    System.out.println("Max number of members in Rajya Sabha is: " + rajyaSabha.getTotalMembers());
                    break;
                case 2:
                    rajyaSabha.passBill();
                    break;
                case 3:
                    rajya_loop = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }
        }
    }
}


//Author: Steven Rodrigues
//Roll no: 50
// Program to implement Parliament
//start date:
//modified date:23/07/2024
//description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes.
import java.util.Scanner;

public class Parliament {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        boolean main_loop = true;
        boolean lok_loop = true;
        boolean rajya_loop = true;

        int input;
        Scanner sc = new Scanner(System.in);

        while (main_loop) {

            System.out.println("1.Lok Sabha");
            System.out.println("2.Rajya Sabha");
            System.out.println("3. Exit");
            System.out.println("Enter a number from the above options");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    int lok_input;

                    while (lok_loop) {
                        System.out.println(
                                "_______________________________________________________________________________________");
                        System.out.println("Lok Sabha Menu");
                        System.out.println("1.Check max number of members");
                        System.out.println("2.Pass bill");
                        System.out.println("3.Back");
                        System.out.println("Enter a number from the above options");
                        lok_input = sc.nextInt();
                        LokSabha ls = new LokSabha();
                        switch (lok_input) {
                            case 1:
                                System.out.println(
                                        "Max number of members that can be in the Lok Sabha is : " + ls.total_members);
                                break;
                            case 2:
                                ls.passBill();
                                break;
                            case 3:
                                lok_loop = false;
                                break;
                            default:
                                System.out.println("Wrong input");
                        }
                    }
                    break;
                case 2:
                    int rajya_input;

                    while (rajya_loop) {
                        System.out.println(
                                "_______________________________________________________________________________________");
                        System.out.println("Rajya Sabha Menu");
                        System.out.println("1.Check max number of members");
                        System.out.println("2.Pass bill");
                        System.out.println("3.Back");
                        System.out.println("Enter a number from the above options");
                        rajya_input = sc.nextInt();
                        RajyaSabha rs = new RajyaSabha();
                        switch (rajya_input) {
                            case 1:
                                System.out.println("Max number of members that can be in the Rajya Sabha is : "
                                        + rs.total_members);
                                break;
                            case 2:
                                rs.passBill();
                                break;
                            case 3:
                                rajya_loop = false;
                                break;
                            default:
                                System.out.println("Wrong input");
                        }
                    }
                    break;
                case 3:
                    main_loop = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
        sc.close();
    }
}
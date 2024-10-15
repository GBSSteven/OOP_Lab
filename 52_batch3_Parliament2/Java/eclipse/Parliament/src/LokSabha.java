import java.util.Scanner;

class LokSabha extends House {

    public LokSabha() {
        super(545); // Lok Sabha has 545 members
    }

    // Overriding the passBill method for LokSabha
    @Override
    public void passBill() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the Lok Sabha bill: ");
        String name = sc.nextLine();
        System.out.print("Enter a short description of the Lok Sabha bill: ");
        String des = sc.nextLine();

        if (name != null && !name.isEmpty() && des != null && !des.isEmpty()) {
            System.out.println("Lok Sabha Bill Passed");
            System.out.println("Bill Name: " + name);
            System.out.println("Description: " + des);
        } else {
            System.out.println("Invalid input. Enter the name and description of the bill.");
        }
    }
}
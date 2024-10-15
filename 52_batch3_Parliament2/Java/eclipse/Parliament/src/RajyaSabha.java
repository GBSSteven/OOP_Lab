import java.util.Scanner;

class RajyaSabha extends House {

    public RajyaSabha() {
        super(250); // Rajya Sabha has 250 members
    }

    // Overriding the passBill method for RajyaSabha
    @Override
    public void passBill() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the Rajya Sabha bill: ");
        String name = sc.nextLine();
        System.out.print("Enter a short description of the Rajya Sabha bill: ");
        String des = sc.nextLine();

        if (name != null && !name.isEmpty() && des != null && !des.isEmpty()) {
            System.out.println("Rajya Sabha Bill Passed");
            System.out.println("Bill Name: " + name);
            System.out.println("Description: " + des);
        } else {
            System.out.println("Invalid input. Enter the name and description of the bill.");
        }
    }
}

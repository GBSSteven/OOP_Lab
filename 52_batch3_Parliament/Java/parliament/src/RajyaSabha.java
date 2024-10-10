//Author: Steven Rodrigues
//Roll no: 50
// Program to implement Parliament
//start date:
//modified date:23/07/2024
//description: Contains a method called passBill() which is used to pass a bill from the rajya sabha by taking name of the bill and description of the bill

import java.util.Scanner;

public class RajyaSabha {
    final int total_members = 250;

    static void passBill() {
        String name, des;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the bill:");
        name = sc.nextLine();
        System.out.print("Enter a short description of the bill:");
        des = sc.nextLine();
        if (name != null && des != null) {
            System.out.println("Rajya Sabha bill\n Name: " + name + "\nDescription: " + des);
            System.out.println("bill passed");
        } else {
            System.out.println("Invalid input. Enter the name and description of the bill");
        }
    }
}

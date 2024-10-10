// Author: Steven Rodrigues
// Roll no: 50
// Program to implement Parliament
// start date:
// modified date:23/07/2024
// description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.
using System;

abstract class House {
    protected int total_members;

    public House(int total_members) {
        this.total_members = total_members;
    }

    public int GetTotalMembers() {
        return total_members;
    }

    public abstract void PassBill(); // Abstract method
}

class LokSabha : House {
    public LokSabha() : base(545) { }

    public override void PassBill() {
        Console.Write("Enter the name of the Lok Sabha bill: ");
        string name = Console.ReadLine() ?? " ";
        Console.Write("Enter a short description of the Lok Sabha bill: ");
        string des = Console.ReadLine() ?? " ";

        if (!string.IsNullOrEmpty(name) && !string.IsNullOrEmpty(des)) {
            Console.WriteLine("Lok Sabha Bill Passed");
            Console.WriteLine($"Bill Name: {name}");
            Console.WriteLine($"Description: {des}");
        } else {
            Console.WriteLine("Invalid input. Enter the name and description of the bill.");
        }
    }
}

class RajyaSabha : House {
    public RajyaSabha() : base(250) { }

    public override void PassBill() {
        Console.Write("Enter the name of the Rajya Sabha bill: ");
        string name = Console.ReadLine() ?? " ";
        Console.Write("Enter a short description of the Rajya Sabha bill: ");
        string des = Console.ReadLine() ?? " ";

        if (!string.IsNullOrEmpty(name) && !string.IsNullOrEmpty(des)) {
            Console.WriteLine("Rajya Sabha Bill Passed");
            Console.WriteLine($"Bill Name: {name}");
            Console.WriteLine($"Description: {des}");
        } else {
            Console.WriteLine("Invalid input. Enter the name and description of the bill.");
        }
    }
}

class Parliament {

    static void HandleLokSabha() {
        LokSabha lokSabha = new LokSabha();
        bool lok_loop = true;

        while (lok_loop) {
            Console.WriteLine("1. Check max number of members");
            Console.WriteLine("2. Pass bill");
            Console.WriteLine("3. Back");
            Console.Write("Enter a number from the above options: ");
            int lok_input = int.Parse(Console.ReadLine() ?? " ");

            switch (lok_input) {
                case 1:
                    Console.WriteLine("Max number of members in Lok Sabha is: " + lokSabha.GetTotalMembers());
                    break;
                case 2:
                    lokSabha.PassBill();
                    break;
                case 3:
                    lok_loop = false;
                    break;
                default:
                    Console.WriteLine("Wrong input, please try again.");
                    break;
            }
        }
    }

    static void HandleRajyaSabha() {
        RajyaSabha rajyaSabha = new RajyaSabha();
        bool rajya_loop = true;

        while (rajya_loop) {
            Console.WriteLine("1. Check max number of members");
            Console.WriteLine("2. Pass bill");
            Console.WriteLine("3. Back");
            Console.Write("Enter a number from the above options: ");
            int rajya_input = int.Parse(Console.ReadLine() ?? " ");

            switch (rajya_input) {
                case 1:
                    Console.WriteLine("Max number of members in Rajya Sabha is: " + rajyaSabha.GetTotalMembers());
                    break;
                case 2:
                    rajyaSabha.PassBill();
                    break;
                case 3:
                    rajya_loop = false;
                    break;
                default:
                    Console.WriteLine("Wrong input, please try again.");
                    break;
            }
        }
    }

    public static void Main() {
        bool main_loop = true;

        while (main_loop) {
            Console.WriteLine("1. Lok Sabha");
            Console.WriteLine("2. Rajya Sabha");
            Console.WriteLine("3. Exit");
            Console.Write("Enter a number from the above options: ");
            int input = int.Parse(Console.ReadLine() ?? " ");

            switch (input) {
                case 1:
                    HandleLokSabha();
                    break;
                case 2:
                    HandleRajyaSabha();
                    break;
                case 3:
                    main_loop = false;
                    Console.WriteLine("Exiting Parliament...");
                    break;
                default:
                    Console.WriteLine("Wrong input, please try again.");
                    break;
            }
        }
    }
}

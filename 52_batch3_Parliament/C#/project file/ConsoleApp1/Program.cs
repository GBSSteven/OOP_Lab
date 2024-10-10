
// Author: Steven Rodrigues
// Roll no: 50
//  Program to implement Parliament
// start date:
// modified date:23/07/2024
// description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.

using System;

class LokSabha
{
    public const int TotalMembers = 545;

    public static void PassBill()
    {
        Console.Write("Enter the name of the bill: ");

        string name = Console.ReadLine() ?? " ";
        Console.Write("Enter a short description of the bill: ");
        string des = Console.ReadLine() ?? " ";
        if (!string.IsNullOrWhiteSpace(name) && !string.IsNullOrWhiteSpace(des))
        {
            Console.WriteLine($"Lok Sabha bill\nName: {name}\nDescription: {des}");
            Console.WriteLine("bill passed");
        }
        else
        {
            Console.WriteLine("Invalid input. Enter the name and description of the bill");
        }
    }
}

class RajyaSabha
{
    public const int TotalMembers = 250;

    public static void PassBill()
    {
        Console.Write("Enter the name of the bill: ");
        string name = Console.ReadLine() ?? " ";
        Console.Write("Enter a short description of the bill: ");
        string des = Console.ReadLine() ?? " ";
        if (!string.IsNullOrWhiteSpace(name) && !string.IsNullOrWhiteSpace(des))
        {
            Console.WriteLine($"Rajya Sabha bill\nName: {name}\nDescription: {des}");
            Console.WriteLine("bill passed");
        }
        else
        {
            Console.WriteLine("Invalid input. Enter the name and description of the bill");
        }
    }
}

class Parliament
{
    static void Main()
    {
        bool mainLoop = true;
        bool lokLoop = true;
        bool rajyaLoop = true;

        while (mainLoop)
        {
            Console.WriteLine("1. Lok Sabha");
            Console.WriteLine("2. Rajya Sabha");
            Console.WriteLine("3. Exit");
            Console.Write("Enter a number from the above options: ");
            int input = int.Parse(Console.ReadLine() ?? "4");
            switch (input)
            {
                case 1:
                    while (lokLoop)
                    {
                        Console.WriteLine("_______________________________________________________________________________________");
                        Console.WriteLine("Lok Sabha Menu");
                        Console.WriteLine("1. Check max number of members");
                        Console.WriteLine("2. Pass bill");
                        Console.WriteLine("3. Back");
                        Console.Write("Enter a number from the above options: ");

                        int lokInput = int.Parse(Console.ReadLine() ?? "4");

                        switch (lokInput)
                        {
                            case 1:
                                Console.WriteLine($"Max number of members that can be in the Lok Sabha is: {LokSabha.TotalMembers}");
                                break;
                            case 2:
                                LokSabha.PassBill();
                                break;
                            case 3:
                                lokLoop = false;
                                break;
                            default:
                                Console.WriteLine("Wrong input");
                                break;
                        }
                    }
                    lokLoop = true; // Reset for next use
                    break;

                case 2:
                    while (rajyaLoop)
                    {
                        Console.WriteLine("_______________________________________________________________________________________");
                        Console.WriteLine("Rajya Sabha Menu");
                        Console.WriteLine("1. Check max number of members");
                        Console.WriteLine("2. Pass bill");
                        Console.WriteLine("3. Back");
                        Console.Write("Enter a number from the above options: ");
                        int rajyaInput = int.Parse(Console.ReadLine() ?? "4");

                        switch (rajyaInput)
                        {
                            case 1:
                                Console.WriteLine($"Max number of members that can be in the Rajya Sabha is: {RajyaSabha.TotalMembers}");
                                break;
                            case 2:
                                RajyaSabha.PassBill();
                                break;
                            case 3:
                                rajyaLoop = false;
                                break;
                            default:
                                Console.WriteLine("Wrong input");
                                break;
                        }
                    }
                    rajyaLoop = true; // Reset for next use
                    break;

                case 3:
                    mainLoop = false;
                    break;

                default:
                    Console.WriteLine("Wrong input");
                    break;
            }
        }
    }
}

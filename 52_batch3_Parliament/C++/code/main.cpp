
// Author: Steven Rodrigues
// Roll no: 50
//  Program to implement Parliament
// start date:
// modified date:23/07/2024
// description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.

#include <iostream>
#include <string>

class LokSabha
{
public:
    const int total_members = 545;

public:
    static void passLBill()
    {
        std::string name, des;
        std::cout << "Enter the name of the bill: \n";
        std::getline(std::cin >> std::ws, name);
        std::cout << "Enter a short description of the bill: ";
        std::getline(std::cin, des);
        if (!name.empty() && !des.empty())
        {
            std::cout << "Lok Sabha bill\nName: " << name << "\nDescription: " << des << std::endl;
            std::cout << "bill passed" << std::endl;
        }
        else
        {
            std::cout << "Invalid input. Enter the name and description of the bill" << std::endl;
        }
    }
};

class RajyaSabha
{
public:
    const int total_members = 250;

public:
    static void passRBill()
    {
        std::string name, des;
        std::cout << "Enter the name of the bill: ";
        std::getline(std::cin >> std::ws, name);
        std::cout << "Enter a short description of the bill: ";
        std::getline(std::cin, des);
        if (!name.empty() && !des.empty())
        {
            std::cout << "Rajya Sabha bill\nName: " << name << "\nDescription: " << des << std::endl;
            std::cout << "bill passed" << std::endl;
        }
        else
        {
            std::cout << "Invalid input. Enter the name and description of the bill" << std::endl;
        }
    }
};

int main()
{
    bool main_loop = true;
    bool lok_loop = true;
    bool rajya_loop = true;

    int input;
    std::string temp;

    while (main_loop)
    {
        std::cout << "1. Lok Sabha\n";
        std::cout << "2. Rajya Sabha\n";
        std::cout << "3. Exit\n";
        std::cout << "Enter a number from the above options: ";
        std::cin >> input;

        switch (input)
        {
        case 1:
        {
            int lok_input;

            while (lok_loop)
            {
                std::cout << "_______________________________________________________________________________________\n";
                std::cout << "Lok Sabha Menu\n";
                std::cout << "1. Check max number of members\n";
                std::cout << "2. Pass bill\n";
                std::cout << "3. Back\n";
                std::cout << "Enter a number from the above options: ";
                std::cin >> lok_input;

                LokSabha ls;

                switch (lok_input)
                {
                case 1:
                    std::cout << "Max number of members that can be in the Lok Sabha is: " << ls.total_members << std::endl;
                    break;
                case 2:
                    LokSabha::passLBill();
                    break;
                case 3:
                    lok_loop = false;
                    break;
                default:
                    std::cout << "Wrong input\n";
                }
            }
            lok_loop = true; // Reset for next use
            break;
        }
        case 2:
        {
            int rajya_input;

            while (rajya_loop)
            {
                std::cout << "_______________________________________________________________________________________\n";
                std::cout << "Rajya Sabha Menu\n";
                std::cout << "1. Check max number of members\n";
                std::cout << "2. Pass bill\n";
                std::cout << "3. Back\n";
                std::cout << "Enter a number from the above options: ";
                std::cin >> rajya_input;

                RajyaSabha rs;

                switch (rajya_input)
                {
                case 1:
                    std::cout << "Max number of members that can be in the Rajya Sabha is: " << rs.total_members << std::endl;
                    break;
                case 2:
                    RajyaSabha::passRBill();
                    break;
                case 3:
                    rajya_loop = false;
                    break;
                default:
                    std::cout << "Wrong input\n";
                }
            }
            rajya_loop = true; // Reset for next use
            break;
        }
        case 3:
            main_loop = false;
            break;
        default:
            std::cout << "Wrong input\n";
        }
    }

    return 0;
}

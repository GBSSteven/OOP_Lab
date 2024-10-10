
// Author: Steven Rodrigues
// Roll no: 50
//  Program to implement Parliament
// start date:
// modified date:23/07/2024
// description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.
#include <iostream>
#include <string>

using namespace std;

// Abstract base class House
class House {
protected:
    int total_members;

public:
    House(int total_members) : total_members(total_members) {}

    int getTotalMembers() {
        return total_members;
    }

    virtual void passBill() = 0; // Pure virtual function
};

class LokSabha : public House {
public:
    LokSabha() : House(545) {}

    void passBill() override {
        string name, des;
        cout << "Enter the name of the Lok Sabha bill: ";
        getline(cin, name);
        cout << "Enter a short description of the Lok Sabha bill: ";
        getline(cin, des);

        if (!name.empty() && !des.empty()) {
            cout << "Lok Sabha Bill Passed\n";
            cout << "Bill Name: " << name << "\n";
            cout << "Description: " << des << "\n";
        } else {
            cout << "Invalid input. Enter the name and description of the bill.\n";
        }
    }
};

class RajyaSabha : public House {
public:
    RajyaSabha() : House(250) {}

    void passBill() override {
        string name, des;
        cout << "Enter the name of the Rajya Sabha bill: ";
        getline(cin, name);
        cout << "Enter a short description of the Rajya Sabha bill: ";
        getline(cin, des);

        if (!name.empty() && !des.empty()) {
            cout << "Rajya Sabha Bill Passed\n";
            cout << "Bill Name: " << name << "\n";
            cout << "Description: " << des << "\n";
        } else {
            cout << "Invalid input. Enter the name and description of the bill.\n";
        }
    }
};

void handleLokSabha() {
    LokSabha lokSabha;
    bool lok_loop = true;

    while (lok_loop) {
        int lok_input;
        cout << "1. Check max number of members\n";
        cout << "2. Pass bill\n";
        cout << "3. Back\n";
        cout << "Enter a number from the above options: ";
        cin >> lok_input;
        cin.ignore(); // To consume the newline

        switch (lok_input) {
        case 1:
            cout << "Max number of members in Lok Sabha is: " << lokSabha.getTotalMembers() << "\n";
            break;
        case 2:
            lokSabha.passBill();
            break;
        case 3:
            lok_loop = false;
            break;
        default:
            cout << "Wrong input, please try again.\n";
        }
    }
}

void handleRajyaSabha() {
    RajyaSabha rajyaSabha;
    bool rajya_loop = true;

    while (rajya_loop) {
        int rajya_input;
        cout << "1. Check max number of members\n";
        cout << "2. Pass bill\n";
        cout << "3. Back\n";
        cout << "Enter a number from the above options: ";
        cin >> rajya_input;
        cin.ignore(); // To consume the newline

        switch (rajya_input) {
        case 1:
            cout << "Max number of members in Rajya Sabha is: " << rajyaSabha.getTotalMembers() << "\n";
            break;
        case 2:
            rajyaSabha.passBill();
            break;
        case 3:
            rajya_loop = false;
            break;
        default:
            cout << "Wrong input, please try again.\n";
        }
    }
}

int main() {
    bool main_loop = true;
    int input;

    while (main_loop) {
        cout << "1. Lok Sabha\n";
        cout << "2. Rajya Sabha\n";
        cout << "3. Exit\n";
        cout << "Enter a number from the above options: ";
        cin >> input;
        cin.ignore(); // To consume the newline

        switch (input) {
        case 1:
            handleLokSabha();
            break;
        case 2:
            handleRajyaSabha();
            break;
        case 3:
            main_loop = false;
            cout << "Exiting Parliament...\n";
            break;
        default:
            cout << "Wrong input, please try again.\n";
        }
    }
    return 0;
}

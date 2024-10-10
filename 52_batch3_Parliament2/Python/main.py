
# Author: Steven Rodrigues
# Roll no: 50
# Program to implement Parliament
# start date:
# modified date:23/07/2024
# description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.
from abc import ABC, abstractmethod

class House(ABC):
    def __init__(self, total_members):
        self.total_members = total_members

    def get_total_members(self):
        return self.total_members

    @abstractmethod
    def pass_bill(self):
        pass

class LokSabha(House):
    def __init__(self):
        super().__init__(545)

    def pass_bill(self):
        name = input("Enter the name of the Lok Sabha bill: ")
        des = input("Enter a short description of the Lok Sabha bill: ")

        if name and des:
            print("Lok Sabha Bill Passed")
            print(f"Bill Name: {name}")
            print(f"Description: {des}")
        else:
            print("Invalid input. Enter the name and description of the bill.")

class RajyaSabha(House):
    def __init__(self):
        super().__init__(250)

    def pass_bill(self):
        name = input("Enter the name of the Rajya Sabha bill: ")
        des = input("Enter a short description of the Rajya Sabha bill: ")

        if name and des:
            print("Rajya Sabha Bill Passed")
            print(f"Bill Name: {name}")
            print(f"Description: {des}")
        else:
            print("Invalid input. Enter the name and description of the bill.")

def handle_lok_sabha():
    lok_sabha = LokSabha()
    lok_loop = True

    while lok_loop:
        print("1. Check max number of members")
        print("2. Pass bill")
        print("3. Back")
        lok_input = int(input("Enter a number from the above options: "))

        if lok_input == 1:
            print("Max number of members in Lok Sabha is:", lok_sabha.get_total_members())
        elif lok_input == 2:
            lok_sabha.pass_bill()
        elif lok_input == 3:
            lok_loop = False
        else:
            print("Wrong input, please try again.")

def handle_rajya_sabha():
    rajya_sabha = RajyaSabha()
    rajya_loop = True

    while rajya_loop:
        print("1. Check max number of members")
        print("2. Pass bill")
        print("3. Back")
        rajya_input = int(input("Enter a number from the above options: "))

        if rajya_input == 1:
            print("Max number of members in Rajya Sabha is:", rajya_sabha.get_total_members())
        elif rajya_input == 2:
            rajya_sabha.pass_bill()
        elif rajya_input == 3:
            rajya_loop = False
        else:
            print("Wrong input, please try again.")

def main():
    main_loop = True

    while main_loop:
        print("1. Lok Sabha")
        print("2. Rajya Sabha")
        print("3. Exit")
        input_option = int(input("Enter a number from the above options: "))

        if input_option == 1:
            handle_lok_sabha()
        elif input_option == 2:
            handle_rajya_sabha()
        elif input_option == 3:
            main_loop = False
            print("Exiting Parliament...")
        else:
            print("Wrong input, please try again.")

if __name__ == "__main__":
    main()

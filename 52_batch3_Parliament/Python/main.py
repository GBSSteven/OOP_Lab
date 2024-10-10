
# Author: Steven Rodrigues
# Roll no: 50
# Program to implement Parliament
# start date:
# modified date:23/07/2024
# description: Displays a menu to the user and creates objects of the LokSabha and RajyaSabha classes that contains a method called passBill() which is used to pass a bill from the lok sabha or rajya sabha by taking name of the bill and description of the bill.

class LokSabha:
    total_members = 545

    @staticmethod
    def pass_l_bill():
        name = input("Enter the name of the bill: \n")
        des = input("Enter a short description of the bill: ")
        if name and des:
            print(f"Lok Sabha bill\nName: {name}\nDescription: {des}")
            print("Bill passed")
        else:
            print("Invalid input. Enter the name and description of the bill")


class RajyaSabha:
    total_members = 250

    @staticmethod
    def pass_r_bill():
        name = input("Enter the name of the bill: ")
        des = input("Enter a short description of the bill: ")
        if name and des:
            print(f"Rajya Sabha bill\nName: {name}\nDescription: {des}")
            print("Bill passed")
        else:
            print("Invalid input. Enter the name and description of the bill")


def main():
    main_loop = True
    lok_loop = True
    rajya_loop = True

    while main_loop:
        print("1. Lok Sabha")
        print("2. Rajya Sabha")
        print("3. Exit")
        input_option = int(input("Enter a number from the above options: "))

        if input_option == 1:
            while lok_loop:
                print("_______________________________________________________________________________________")
                print("Lok Sabha Menu")
                print("1. Check max number of members")
                print("2. Pass bill")
                print("3. Back")
                lok_input = int(input("Enter a number from the above options: "))

                if lok_input == 1:
                    print(f"Max number of members that can be in the Lok Sabha is: {LokSabha.total_members}")
                elif lok_input == 2:
                    LokSabha.pass_l_bill()
                elif lok_input == 3:
                    lok_loop = False
                else:
                    print("Wrong input")

            lok_loop = True  # Reset for next use

        elif input_option == 2:
            while rajya_loop:
                print("_______________________________________________________________________________________")
                print("Rajya Sabha Menu")
                print("1. Check max number of members")
                print("2. Pass bill")
                print("3. Back")
                rajya_input = int(input("Enter a number from the above options: "))

                if rajya_input == 1:
                    print(f"Max number of members that can be in the Rajya Sabha is: {RajyaSabha.total_members}")
                elif rajya_input == 2:
                    RajyaSabha.pass_r_bill()
                elif rajya_input == 3:
                    rajya_loop = False
                else:
                    print("Wrong input")

            rajya_loop = True  # Reset for next use

        elif input_option == 3:
            main_loop = False

        else:
            print("Wrong input")

if __name__ == "__main__":
    main()

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to "+ Bank.bankName);
        int userRole = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please Select your options \n 1. Login as Manager \n 2. Login as Employee \n 3. Login as Customer \n 4. exit");
            userRole = scanner.nextInt();

            switch (userRole) {
                case 1:
                    Bank.loginAsManager();
                    break;
                case 2:
                    Employee.loginAsEmployee();
                    break;
                case 3:
                    Customer.loginAsCustomer();
                    break;
                case 4:
                    System.out.println("See you again");
                    break;
                default:
                    System.out.println("Invalid Entry, try again");

            }
        } while (userRole <1 || userRole >4);
    }
}

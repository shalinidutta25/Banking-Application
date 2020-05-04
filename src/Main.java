import java.util.Scanner;

public class Main
{
    public static Employee createEmployee()
    {
        System.out.println("Enter the name of the Employee to register into the System");
        Scanner scanner=new Scanner(System.in);
        String employeeName=scanner.next();
        System.out.println("Enter Pan Card details of the employee");
        int panCardNo=scanner.nextInt();
        System.out.println("Generate a pin for the employee");
        int pin=scanner.nextInt();

        Employee employee=new Employee(employeeName,panCardNo,pin);
        return  employee;

    }

    public static String enterDeleteEmployeeName()
    {
        System.out.println("Select the name of the employee you want to delete from system: ");
        Scanner scanner=new Scanner(System.in);
        String empName=scanner.next();
        return empName;
    }
    public static void main(String[] args)
    {
        int menuNumber;
        Bank bank = new Bank();
        System.out.println("Welcome to : " + bank.bankName);

        Scanner scanner = new Scanner(System.in);
                do
                    {
                        System.out.println("Select an option: \n 1. Add Employee\n 2. Delete Employee\n 3. Exit");
                    menuNumber= scanner.nextInt();

                    switch (menuNumber)
                    {
                        case 1:
                        {
                            bank.addEmployee(createEmployee());
                            break;
                        }
                        case 2:
                        {
                            bank.deleteEmployee(enterDeleteEmployeeName());
                            break;
                        }
                    }
                    }
                while (menuNumber<3);

                System.out.println("thanks");





    }
}

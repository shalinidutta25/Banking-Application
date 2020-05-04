import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private final String bankUsername = "Shalini";
    private final int bankPassword = 1425;
    public  static final String bankName = "Shalini's Bank";
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;

    Bank() {
        employees = new ArrayList<>();
        customers = new ArrayList<>();
    }

    private void addEmployee(Employee employee) {
        if (checkDuplicateEmployee(employee) == false) {
           employees.add(employee);
        } else {
           System.out.println("Duplicate Pancard found");
        }
    }

    private Boolean checkDuplicateEmployee(Employee employee) {
        for (Employee emp: employees) {
            if(emp.getPancardNo().equals(employee.getPancardNo())) {
                return true;
            }
        }
        return  false;
    }

    private void deleteEmployee(String panCardNo) {
        int index = -1;
        for (int i = 0; i<employees.size(); i++) {
            if(employees.get(i).getPancardNo().equals(panCardNo)) {
                index = i;
                break;
            }
        }
        if(index >= 0) {
            employees.remove(index);
            System.out.println("Employee removed successfully");
        } else  {
            System.out.println("Employee not found");
        }
    }

    private void displayEmployeeList() {
        System.out.println("Name     | Pancard No     ");
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeName()+"     | "+employee.getPancardNo()+"\n");
        }
    }

    private void displayCustomerList() {
        System.out.println("Name     | Pancard No     ");
        for (Customer customer :customers) {
            System.out.println(customer.getCustomerName()+"     | "+customer.getCustomePanCardNumber()+"\n");
        }
    }

    public static void loginAsManager() {
        System.out.println("Welcome Manager");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter you username :");
        String username = scanner.nextLine();
        System.out.println("Please enter your password");
        int password = scanner.nextInt();
        Bank bank = new Bank();
        if (username.equals(bank.bankUsername) && password == bank.bankPassword) {
            bank.displayEmployeeMenuOptions();
        } else {
            System.out.println("Wrong Username or Password");
            loginAsManager();
        }
    }

    private void displayEmployeeMenuOptions() {
        int menuChoice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose your options : \n 1. Add new Employee \n 2. Delete and employee \n 3. Display Employee List \n 4. Display Customer List \n 5. Exit");
            menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    addEmployee(createEmployee());
                    break;
                case 2:
                    deleteEmployee(panCardNumberToDelete());
                    break;
                case 3:
                    displayEmployeeList();
                    break;
                case 4:
                    displayCustomerList();
                    break;
                case 5:
                    System.out.println("See you again");
                    break;
                default:
                    System.out.println("Wrong Entry, try again");
            }
        } while (menuChoice != 5);
    }

    private String panCardNumberToDelete() {
        System.out.println("Enter Pancard Number :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Employee createEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee Name :");
        String employeeName = scanner.nextLine();
        System.out.println("Enter Employee PanCard Number :");
        String panCardNo = scanner.nextLine();
        //Will make pin auto generate later
        System.out.println("Enter Employee Pin :");
        int pin = scanner.nextInt();

        return  new Employee(employeeName,panCardNo,pin);
    }
}

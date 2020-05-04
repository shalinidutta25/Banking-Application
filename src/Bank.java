import java.util.ArrayList;

public class Bank
{
    final String bankName="Axis Bank";
    ArrayList<Employee>employees=new ArrayList<>();
    ArrayList<Customer>customers;

    public void addEmployee(Employee emp)
    {
        if(checkDuplicateEmployee(emp)==true)
        {
            System.out.println("duplicate found");
        }
        else
            {
                employees.add(emp);
            }


    }

    public boolean checkDuplicateEmployee(Employee emp)
    {
        for(Employee abc : employees)
        {
            if(emp.panCardNo==abc.panCardNo)
            {
                return true;
            }
        }
        return  false;

    }


    public void deleteEmployee(String empName)
    {
        int index=-8;
        //System.out.println(empName);

        for(int i=0; i<employees.size(); i++)
        {
            if(employees.get(i).employeeName.equals(empName))
            {
                index=i;
                break;
            }
        }
        if(index>=0)
        {
            employees.remove(index);
            System.out.println("Entry deleted");
        }
        else
            {
                System.out.println("Wrong entry");
        }

    }


}

import domain.Employee;
import observers.HRDepartment;
import observers.IObserver;
import observers.PayrollDepartment;
import subjects.EmployeeManagementSystem;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        IObserver payroll = new PayrollDepartment();
        IObserver hrSystem = new HRDepartment();

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.registerObserver(payroll);
        ems.registerObserver(hrSystem);

        Employee bob = new Employee("Bob", new Date(), 3500, true);
        ems.hireNewEmployee(bob);

        ems.modifyEmployeeName(6, "George");
    }
}

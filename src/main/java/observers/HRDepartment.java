package observers;

import domain.Employee;

public class HRDepartment implements IObserver {

    public void callMe(Employee employee, String msg) {
        System.out.println("HR department notified.");
        System.out.println(msg + employee.getName());
    }
}

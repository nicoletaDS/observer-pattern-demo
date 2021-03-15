package subjects;

import domain.Employee;
import domain.EmployeeDAO;
import observers.IObserver;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem implements ISubject {

    private List<IObserver> observers;
    private List<Employee> employees;

    private EmployeeDAO employeeDAO;

    private Employee employee;
    private String msg;

    public EmployeeManagementSystem(){
        observers = new ArrayList<>();
        employeeDAO = new EmployeeDAO();
        employees = employeeDAO.generateEmployees();
    }

    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.callMe(employee, msg);
        }
    }

    public void hireNewEmployee(Employee employee) {
        this.employee = employee;
        msg = "New Hire: ";
        employees.add(employee);
        notifyObservers();
    }

    public void modifyEmployeeName(int employeeID, String newName) {
        boolean notify = false;

        for (Employee emp : employees) {
            if (employeeID == emp.getEmployeeID()) {
                emp.setName(newName);
                this.employee = emp;
                this.msg = "Employee name has been modified: ";
                notify = true;
            }
        }
        if (notify)
            notifyObservers();
    }

}

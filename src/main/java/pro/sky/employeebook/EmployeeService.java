package pro.sky.employeebook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Татьяна", "Адаменко"),
            new Employee("Рената", "Андреева"),
            new Employee("Наталья", "Баринова")
    ));

    public List<Employee> index(){
        return employees;
    }

    public Employee add (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        if (!employees.add(new Employee(firstName, lastName))){
            //никогда не будет выброшено
            throw new EmployeeStorageIsFullException();
        }
        return employee;
    }

    public Employee remove(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee find(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}

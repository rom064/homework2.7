package pro.sky.homework27.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework27.employees.Employee;
import pro.sky.homework27.exception.ArrayIsFull;
import pro.sky.homework27.exception.EmployeeAlreadyAdded;
import pro.sky.homework27.exception.EmployeeNotFound;
import pro.sky.homework27.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 5;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAdded("Сотрудник уже есть в стиске!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new ArrayIsFull("Список заполнен!");
        }
        employees.put(employeeKey, new Employee(firstName, lastName));
        return employees.get(employeeKey);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAdded("Такой сотрудник есть в списке!");
        }
        employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFound("Такого сотрудника нет в списке!");
        }
        return employees.get(employeeKey);
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}

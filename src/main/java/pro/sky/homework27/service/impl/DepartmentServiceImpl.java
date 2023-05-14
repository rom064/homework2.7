package pro.sky.homework27.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework27.employees.Employee;
import pro.sky.homework27.service.DepartmentService;
import pro.sky.homework27.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> departmentId == null || employee.getDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

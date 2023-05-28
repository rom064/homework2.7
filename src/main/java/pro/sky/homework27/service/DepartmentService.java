package pro.sky.homework27.service;

import pro.sky.homework27.employees.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);

    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId);

}

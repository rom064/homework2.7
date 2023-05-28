package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.homework27.employees.Employee;
import pro.sky.homework27.service.DepartmentService;

import java.util.List;
import java.util.Map;
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(
            @RequestParam(name = "departmentId", required = false)Integer departmentId
    ) {
        return departmentService.getGroupedByDepartmentEmployees(departmentId);
    }
}

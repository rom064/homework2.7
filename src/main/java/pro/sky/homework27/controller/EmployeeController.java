package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework27.employees.Employee;
import pro.sky.homework27.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department
    ) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public void removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Map<String, Employee> getEmployees() {
        return employeeService.getEmployees();
    }



}

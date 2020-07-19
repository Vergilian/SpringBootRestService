package ru.mart.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mart.spring.model.Employee;
import ru.mart.spring.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired()
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() == 0) {
            this.employeeService.addEmployee(employee);
        } else {
            this.employeeService.removeEmployeeId(id);
        }
        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployyes(@PathVariable("id") long id) {
        this.employeeService.removeEmployeeId(id);

        return "redirect:/employeers";
    }

    @RequestMapping("edit/{id}")
    public String editEmployees(@PathVariable("id") long id, Model model) {
        model.addAttribute("employye", this.employeeService.getEmployeeId(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return ("employees");
    }

    @RequestMapping("employeedata/{id}")
    public String employyeData(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", this.employeeService.getEmployeeId(id));
        return ("employeedata");
    }
}
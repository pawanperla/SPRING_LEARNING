package org.Employee_DAO.Controllers;

import java.util.*;

import org.Employee_DAO.Entity.Employee;
import org.Employee_DAO.Service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeServiceImp.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeServiceImp.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee ID Not Found! :" + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employeeToAdd) {
        employeeToAdd.setId(0);
        return employeeServiceImp.save(employeeToAdd);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeToUpdate) {
        return employeeServiceImp.save(employeeToUpdate);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeServiceImp.deleteById(employeeId);
        return "Deleted Id : " + employeeId;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee employee = employeeServiceImp.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee ID Not Found! :" + employeeId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee ID is not allowed in Request Body");
        }

        Employee patchedEmployee = apply(patchPayload, employee);

        return employeeServiceImp.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        // Convert employee Object to JSON Object Node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert Patch Payload map to JSON Object Node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge Patch Nodes data to Employee Node
        employeeNode.setAll(patchNode);

        // Convert JSON Object Node to Employee Object
        Employee employeeFromObjectNode = objectMapper.convertValue(employeeNode, Employee.class);

        // return employee;
        return employeeFromObjectNode;
    }

}

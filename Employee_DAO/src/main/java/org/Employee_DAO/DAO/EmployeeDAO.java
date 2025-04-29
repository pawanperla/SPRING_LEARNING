package org.Employee_DAO.DAO;

import java.util.List;

import org.Employee_DAO.Entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

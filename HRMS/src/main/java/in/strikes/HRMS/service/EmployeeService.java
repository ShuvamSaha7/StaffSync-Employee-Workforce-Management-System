package in.strikes.HRMS.service;




import in.strikes.HRMS.entity.Employee;

import java.util.List;


public interface EmployeeService {


    Employee saveEmployee(Employee employee);


    List<Employee> getAllEmployees();


    Employee getEmployeeById(Long id);


    Employee updateEmployee(Long id, Employee employee);


    void deleteEmployee(Long id);


    List<Employee> searchEmployee(String keyword);


}
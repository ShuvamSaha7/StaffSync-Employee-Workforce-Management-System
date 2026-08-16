package in.strikes.HRMS.repository;

import in.strikes.HRMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {


    // Search employee by name
    List<Employee> findByNameContainingIgnoreCase(String name);


    // Search by department
    List<Employee> findByDepartment(String department);


    // Check duplicate email
    boolean existsByEmail(String email);


}
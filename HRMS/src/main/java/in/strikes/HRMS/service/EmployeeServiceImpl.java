package in.strikes.HRMS.service;




import in.strikes.HRMS.entity.Employee;
import in.strikes.HRMS.exception.EmployeeNotFoundException;
import in.strikes.HRMS.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImpl
        implements EmployeeService {



    private final EmployeeRepository repository;



    public EmployeeServiceImpl(EmployeeRepository repository){

        this.repository = repository;

    }





    // Save Employee

    @Override
    public Employee saveEmployee(Employee employee){


        if(repository.existsByEmail(employee.getEmail())){

            throw new RuntimeException(
                    "Email already exists"
            );

        }


        return repository.save(employee);

    }







    // Get All Employees

    @Override
    public List<Employee> getAllEmployees(){


        return repository.findAll();

    }








    // Get Employee By ID

    @Override
    public Employee getEmployeeById(Long id){


        return repository.findById(id)

                .orElseThrow(

                        () -> new EmployeeNotFoundException(
                                "Employee not found with id : " + id
                        )

                );

    }









    // Update Employee

    @Override
    public Employee updateEmployee(
            Long id,
            Employee employee
    ){


        Employee oldEmployee =
                getEmployeeById(id);




        oldEmployee.setName(
                employee.getName()
        );


        oldEmployee.setEmail(
                employee.getEmail()
        );


        oldEmployee.setPhone(
                employee.getPhone()
        );


        oldEmployee.setDepartment(
                employee.getDepartment()
        );


        oldEmployee.setProject(
                employee.getProject()
        );


        oldEmployee.setDesignation(
                employee.getDesignation()
        );


        oldEmployee.setSalary(
                employee.getSalary()
        );


        oldEmployee.setJoiningDate(
                employee.getJoiningDate()
        );



        return repository.save(oldEmployee);


    }









    // Delete Employee

    @Override
    public void deleteEmployee(Long id){


        Employee employee =
                getEmployeeById(id);


        repository.delete(employee);


    }









    // Search Employee

    @Override
    public List<Employee> searchEmployee(
            String keyword
    ){


        return repository
                .findByNameContainingIgnoreCase(keyword);


    }



}
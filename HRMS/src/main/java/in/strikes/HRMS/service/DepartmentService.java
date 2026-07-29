package in.strikes.HRMS.service;


import in.strikes.HRMS.entity.Department;
import in.strikes.HRMS.exception.DepartmentNotFoundException;
import in.strikes.HRMS.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;



    public DepartmentService(
            DepartmentRepository departmentRepository
    ){

        this.departmentRepository = departmentRepository;

    }



    // View All

    public List<Department> getAllDepartments(){

        return departmentRepository.findAll();

    }




    // View Single Department

    public Department getDepartmentById(Long id){


        return departmentRepository.findById(id)

                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department not found : "+id
                        ));

    }





    // Add Department

    public void saveDepartment(
            Department department
    ){

        departmentRepository.save(department);

    }





    // Update Department

    public Department updateDepartment(
            Long id,
            Department department
    ){


        Department oldDepartment =
                getDepartmentById(id);



        oldDepartment.setName(
                department.getName()
        );


        oldDepartment.setDescription(
                department.getDescription()
        );



        return departmentRepository.save(oldDepartment);

    }






    // Delete Department

    public void deleteDepartment(Long id){


        Department department =
                getDepartmentById(id);


        departmentRepository.delete(department);


    }






    // Search Department

    public List<Department> searchDepartment(
            String keyword
    ){


        return departmentRepository
                .findByNameContainingIgnoreCase(keyword);

    }


}
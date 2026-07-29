package in.strikes.HRMS.controller;



import in.strikes.HRMS.entity.Employee;
import in.strikes.HRMS.service.DepartmentService;
import in.strikes.HRMS.service.EmployeeService;


import in.strikes.HRMS.service.ProjectService;
import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/employees")
public class EmployeeController {



    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    private final ProjectService projectService;



    public EmployeeController(
            EmployeeService employeeService , DepartmentService departmentService ,ProjectService projectService
    ){

        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.projectService = projectService;

    }



    // Show all employees

    @GetMapping
    public String getAllEmployees(Model model){


        model.addAttribute(
                "employees",
                employeeService.getAllEmployees()
        );


        return "employees";

    }





    // Add employee page

    @GetMapping("/add")
    public String addEmployeePage(Model model){


        model.addAttribute(
                "employee",
                new Employee()
        );


        model.addAttribute(
                "departments",
                departmentService.getAllDepartments()
        );

        model.addAttribute(
                "projects",
                projectService.getAllProjects()
        );


        return "add_employee";

    }





    // Save employee

    @PostMapping("/save")
    public String saveEmployee(

            @Valid
            @ModelAttribute("employee")
            Employee employee,


            BindingResult result , Model model

    ){



        if(result.hasErrors()){


            model.addAttribute(
                    "departments",
                    departmentService.getAllDepartments()
            );


            return "add_employee";

        }



        employeeService.saveEmployee(employee);



        return "redirect:/employees";


    }






    // Edit page

    @GetMapping("/edit/{id}")
    public String editEmployee(

            @PathVariable Long id,

            Model model

    ){


        model.addAttribute(
                "employee",
                employeeService.getEmployeeById(id)
        );

        model.addAttribute(
                "departments",
                departmentService.getAllDepartments()
        );

        model.addAttribute(
                "projects",
                projectService.getAllProjects()
        );


        return "edit_employee";

    }






    // Update employee

    @PostMapping("/update/{id}")
    public String updateEmployee(

            @PathVariable Long id,


            @Valid
            @ModelAttribute("employee")
            Employee employee,


            BindingResult result, Model model

    ){


        if(result.hasErrors()){


            model.addAttribute(
                    "departments",
                    departmentService.getAllDepartments()
            );


            return "edit_employee";

        }






        employeeService.updateEmployee(
                id,
                employee
        );



        return "redirect:/employees";


    }






    // Delete employee

    @GetMapping("/delete/{id}")
    public String deleteEmployee(

            @PathVariable Long id

    ){


        employeeService.deleteEmployee(id);



        return "redirect:/employees";


    }






    // Search employee

    @GetMapping("/search")
    public String searchEmployee(

            @RequestParam String keyword,

            Model model

    ){


        model.addAttribute(
                "employees",
                employeeService.searchEmployee(keyword)
        );


        return "employees";


    }



}
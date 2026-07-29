package in.strikes.HRMS.controller;




import in.strikes.HRMS.service.DepartmentService;
import in.strikes.HRMS.service.EmployeeService;
import in.strikes.HRMS.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DashboardController {



    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    private final ProjectService projectService;




    public DashboardController(
            EmployeeService employeeService,
            DepartmentService departmentService,
            ProjectService projectService
    ){

        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.projectService = projectService;

    }





    @GetMapping("/dashboard")
    public String dashboard(Model model){



        model.addAttribute(
                "employeeCount",
                employeeService.getAllEmployees().size()
        );



        model.addAttribute(
                "departmentCount",
                departmentService.getAllDepartments().size()
        );



        model.addAttribute(
                "projectCount",
                projectService.getAllProjects().size()
        );



        return "dashboard";

    }


}
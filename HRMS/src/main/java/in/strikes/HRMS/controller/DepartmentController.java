package in.strikes.HRMS.controller;


import in.strikes.HRMS.entity.Department;
import in.strikes.HRMS.service.DepartmentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class DepartmentController {



    private final DepartmentService departmentService;



    public DepartmentController(
            DepartmentService departmentService
    ){

        this.departmentService = departmentService;

    }





    // Department List

    @GetMapping("/departments")
    public String departments(Model model){


        model.addAttribute(
                "departments",
                departmentService.getAllDepartments()
        );


        return "departments";

    }





    // Add Page

    @GetMapping("/departments/add")
    public String addDepartmentPage(
            Model model
    ){


        model.addAttribute(
                "department",
                new Department()
        );


        return "add_department";

    }






    // Save Department

    @PostMapping("/departments/save")
    public String saveDepartment(
            @ModelAttribute Department department
    ){


        departmentService.saveDepartment(department);


        return "redirect:/departments";

    }







    // View Department

    @GetMapping("/departments/view/{id}")
    public String viewDepartment(
            @PathVariable Long id,
            Model model
    ){


        Department department =
                departmentService.getDepartmentById(id);



        model.addAttribute(
                "department",
                department
        );


        return "view_department";

    }







    // Edit Page

    @GetMapping("/departments/edit/{id}")
    public String editDepartment(
            @PathVariable Long id,
            Model model
    ){


        Department department =
                departmentService.getDepartmentById(id);



        model.addAttribute(
                "department",
                department
        );


        return "edit_department";

    }








    // Update Department


    @PostMapping("/departments/update/{id}")
    public String updateDepartment(
            @PathVariable Long id,
            @ModelAttribute Department department
    ){


        departmentService.updateDepartment(
                id,
                department
        );


        return "redirect:/departments";

    }








    // Delete Department


    @GetMapping("/departments/delete/{id}")
    public String deleteDepartment(
            @PathVariable Long id
    ){


        departmentService.deleteDepartment(id);


        return "redirect:/departments";

    }







    // Search Department


    @GetMapping("/departments/search")
    public String searchDepartment(
            @RequestParam String keyword,
            Model model
    ){


        model.addAttribute(
                "departments",
                departmentService.searchDepartment(keyword)
        );


        return "departments";

    }


}
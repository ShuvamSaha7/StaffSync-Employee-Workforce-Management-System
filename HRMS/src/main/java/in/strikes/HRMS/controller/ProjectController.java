package in.strikes.HRMS.controller;


import in.strikes.HRMS.entity.Project;
import in.strikes.HRMS.service.ProjectService;
import in.strikes.HRMS.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/projects")
public class ProjectController {


    private final ProjectService projectService;

    private final DepartmentService departmentService;



    public ProjectController(
            ProjectService projectService,
            DepartmentService departmentService
    ) {

        this.projectService = projectService;
        this.departmentService = departmentService;

    }



    // Show all projects

    @GetMapping
    public String getAllProjects(Model model) {


        model.addAttribute(
                "projects",
                projectService.getAllProjects()
        );


        return "projects";

    }





    // Add project page

    @GetMapping("/add")
    public String addProjectPage(Model model) {


        model.addAttribute(
                "project",
                new Project()
        );


        model.addAttribute(
                "departments",
                departmentService.getAllDepartments()
        );


        return "add_project";

    }





    // Save project

    @PostMapping("/save")
    public String saveProject(

            @Valid
            @ModelAttribute("project")
            Project project,

            BindingResult result,

            Model model

    ) {


        if(result.hasErrors()) {


            model.addAttribute(
                    "departments",
                    departmentService.getAllDepartments()
            );


            return "add_project";

        }



        projectService.saveProject(project);


        return "redirect:/projects";

    }





    // Edit page

    @GetMapping("/edit/{id}")
    public String editProject(

            @PathVariable Long id,

            Model model

    ) {


        model.addAttribute(
                "project",
                projectService.getProjectById(id)
        );


        model.addAttribute(
                "departments",
                departmentService.getAllDepartments()
        );


        return "edit_project";

    }





    // Update project

    @PostMapping("/update/{id}")
    public String updateProject(

            @PathVariable Long id,

            @Valid
            @ModelAttribute("project")
            Project project,

            BindingResult result,

            Model model

    ) {


        if(result.hasErrors()) {


            model.addAttribute(
                    "departments",
                    departmentService.getAllDepartments()
            );


            return "edit_project";

        }



        projectService.updateProject(id, project);


        return "redirect:/projects";

    }





    // Delete project

    @GetMapping("/delete/{id}")
    public String deleteProject(

            @PathVariable Long id

    ) {


        projectService.deleteProject(id);


        return "redirect:/projects";

    }





    // Search project

    @GetMapping("/search")
    public String searchProject(

            @RequestParam String keyword,

            Model model

    ) {


        model.addAttribute(
                "projects",
                projectService.searchProject(keyword)
        );


        return "projects";

    }

}
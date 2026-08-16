package in.strikes.HRMS.controller;

import in.strikes.HRMS.entity.Leave;
import in.strikes.HRMS.service.EmployeeService;
import in.strikes.HRMS.service.LeaveService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveService leaveService;
    private final EmployeeService employeeService;


    public LeaveController(
            LeaveService leaveService,
            EmployeeService employeeService) {

        this.leaveService = leaveService;
        this.employeeService = employeeService;
    }


    // ================= LIST =================

    @GetMapping
    public String getAllLeaves(Model model) {

        model.addAttribute(
                "leaves",
                leaveService.getAllLeaves()
        );

        return "leave";
    }


    // ================= ADD PAGE =================

    @GetMapping("/add")
    public String addLeaveForm(Model model) {

        model.addAttribute(
                "leave",
                new Leave()
        );

        model.addAttribute(
                "employees",
                employeeService.getAllEmployees()
        );

        return "add_leave";
    }


    // ================= SAVE =================

    @PostMapping("/save")
    public String saveLeave(
            @Valid @ModelAttribute("leave") Leave leave,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeService.getAllEmployees()
            );

            return "add_leave";
        }

        leaveService.saveLeave(leave);

        return "redirect:/leaves";
    }


    // ================= EDIT PAGE =================

    @GetMapping("/edit/{id}")
    public String editLeave(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "leave",
                leaveService.getLeaveById(id)
        );

        model.addAttribute(
                "employees",
                employeeService.getAllEmployees()
        );

        return "edit_leave";
    }


    // ================= UPDATE =================

    @PostMapping("/update/{id}")
    public String updateLeave(
            @PathVariable Long id,
            @Valid @ModelAttribute("leave") Leave leave,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeService.getAllEmployees()
            );

            return "edit_leave";
        }

        leaveService.updateLeave(id, leave);

        return "redirect:/leaves";
    }


    // ================= DELETE =================

    @GetMapping("/delete/{id}")
    public String deleteLeave(
            @PathVariable Long id) {

        leaveService.deleteLeave(id);

        return "redirect:/leaves";
    }

}
package in.strikes.HRMS.controller;

import in.strikes.HRMS.entity.Payroll;
import in.strikes.HRMS.repository.EmployeeRepository;
import in.strikes.HRMS.service.PayrollService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payroll")
public class PayrollController {

    private final PayrollService payrollService;
    private final EmployeeRepository employeeRepository;

    public PayrollController(
            PayrollService payrollService,
            EmployeeRepository employeeRepository) {

        this.payrollService = payrollService;
        this.employeeRepository = employeeRepository;
    }

    // Show all payroll
    @GetMapping
    public String getAllPayroll(Model model) {

        model.addAttribute(
                "payrollList",
                payrollService.getAllPayroll()
        );

        return "payroll";
    }

    // Add payroll page
    @GetMapping("/add")
    public String addPayrollPage(Model model) {

        model.addAttribute(
                "payroll",
                new Payroll()
        );

        model.addAttribute(
                "employees",
                employeeRepository.findAll()
        );

        return "add_payroll";
    }

    // Save payroll
    @PostMapping("/save")
    public String savePayroll(
            @Valid @ModelAttribute("payroll")
            Payroll payroll,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeRepository.findAll()
            );

            return "add_payroll";
        }

        payrollService.savePayroll(payroll);

        return "redirect:/payroll";
    }

    // Edit payroll page
    @GetMapping("/edit/{id}")
    public String editPayroll(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "payroll",
                payrollService.getPayrollById(id)
        );

        model.addAttribute(
                "employees",
                employeeRepository.findAll()
        );

        return "edit_payroll";
    }

    // Update payroll
    @PostMapping("/update/{id}")
    public String updatePayroll(
            @PathVariable Long id,
            @Valid @ModelAttribute("payroll")
            Payroll payroll,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeRepository.findAll()
            );

            return "edit_payroll";
        }

        payrollService.updatePayroll(
                id,
                payroll
        );

        return "redirect:/payroll";
    }

    // Delete payroll
    @GetMapping("/delete/{id}")
    public String deletePayroll(
            @PathVariable Long id) {

        payrollService.deletePayroll(id);

        return "redirect:/payroll";
    }
}

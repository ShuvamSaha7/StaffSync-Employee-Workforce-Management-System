package in.strikes.HRMS.controller;

import in.strikes.HRMS.entity.Attendance;
import in.strikes.HRMS.repository.EmployeeRepository;
import in.strikes.HRMS.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final EmployeeRepository employeeRepository;

    public AttendanceController(
            AttendanceService attendanceService,
            EmployeeRepository employeeRepository) {

        this.attendanceService = attendanceService;
        this.employeeRepository = employeeRepository;
    }

    // Show all attendance
    @GetMapping
    public String getAllAttendance(Model model) {

        model.addAttribute(
                "attendanceList",
                attendanceService.getAllAttendance()
        );

        return "attendance";
    }

    // Add attendance page
    @GetMapping("/add")
    public String addAttendancePage(Model model) {

        model.addAttribute(
                "attendance",
                new Attendance()
        );

        model.addAttribute(
                "employees",
                employeeRepository.findAll()
        );

        return "add_attendance";
    }

    // Save attendance
    @PostMapping("/save")
    public String saveAttendance(
            @Valid @ModelAttribute("attendance")
            Attendance attendance,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeRepository.findAll()
            );

            return "add_attendance";
        }

        attendanceService.saveAttendance(attendance);

        return "redirect:/attendance";
    }

    // Edit attendance page
    @GetMapping("/edit/{id}")
    public String editAttendance(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "attendance",
                attendanceService.getAttendanceById(id)
        );

        model.addAttribute(
                "employees",
                employeeRepository.findAll()
        );

        return "edit_attendance";
    }

    // Update attendance
    @PostMapping("/update/{id}")
    public String updateAttendance(
            @PathVariable Long id,
            @Valid @ModelAttribute("attendance")
            Attendance attendance,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "employees",
                    employeeRepository.findAll()
            );

            return "edit_attendance";
        }

        attendanceService.updateAttendance(
                id,
                attendance
        );

        return "redirect:/attendance";
    }

    // Delete attendance
    @GetMapping("/delete/{id}")
    public String deleteAttendance(
            @PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return "redirect:/attendance";
    }
}
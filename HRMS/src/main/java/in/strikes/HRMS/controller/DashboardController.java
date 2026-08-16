package in.strikes.HRMS.controller;

import in.strikes.HRMS.service.DepartmentService;
import in.strikes.HRMS.service.EmployeeService;
import in.strikes.HRMS.service.ProjectService;
import in.strikes.HRMS.service.PayrollService;
import in.strikes.HRMS.service.AttendanceService;
import in.strikes.HRMS.service.LeaveService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    private final ProjectService projectService;

    private final PayrollService payrollService;

    private final AttendanceService attendanceService;

    private final LeaveService leaveService;


    public DashboardController(
            EmployeeService employeeService,
            DepartmentService departmentService,
            ProjectService projectService,
            PayrollService payrollService,
            AttendanceService attendanceService,
            LeaveService leaveService
    ) {

        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.projectService = projectService;
        this.payrollService = payrollService;
        this.attendanceService = attendanceService;
        this.leaveService = leaveService;

    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Employee count
        model.addAttribute(
                "employeeCount",
                employeeService.getAllEmployees().size()
        );


        // Department count
        model.addAttribute(
                "departmentCount",
                departmentService.getAllDepartments().size()
        );


        // Project count
        model.addAttribute(
                "projectCount",
                projectService.getAllProjects().size()
        );


        // Payroll count
        model.addAttribute(
                "payrollCount",
                payrollService.getAllPayroll().size()
        );


        // Attendance count
        model.addAttribute(
                "attendanceCount",
                attendanceService.getAllAttendance().size()
        );


        // Leave count
        model.addAttribute(
                "leaveCount",
                leaveService.getAllLeaves().size()
        );


        return "dashboard";

    }

}
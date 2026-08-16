package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Payroll;

import java.util.List;

public interface PayrollService {

    Payroll savePayroll(Payroll payroll);

    List<Payroll> getAllPayroll();

    Payroll getPayrollById(Long id);

    Payroll updatePayroll(Long id, Payroll payroll);

    void deletePayroll(Long id);

    List<Payroll> getPayrollByEmployee(Long employeeId);
}

package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Payroll;
import in.strikes.HRMS.exception.PayrollNotFoundException;
import in.strikes.HRMS.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl
        implements PayrollService {

    private final PayrollRepository repository;

    public PayrollServiceImpl(
            PayrollRepository repository) {

        this.repository = repository;
    }

    @Override
    public Payroll savePayroll(Payroll payroll) {

        Long employeeId =
                payroll.getEmployee().getId();

        // Prevent duplicate payroll
        if (repository.existsByEmployeeIdAndPayrollMonth(
                employeeId,
                payroll.getPayrollMonth())) {

            throw new RuntimeException(
                    "Payroll already exists for this employee and month"
            );
        }

        /*
         * Basic salary comes from Employee
         */
        if (payroll.getEmployee().getSalary() != null) {

            payroll.setBasicSalary(
                    payroll.getEmployee().getSalary()
            );
        }

        /*
         * Net Salary Calculation
         *
         * Basic Salary + Allowance - Deduction
         */
        double basicSalary =
                payroll.getBasicSalary();

        double allowance =
                payroll.getAllowance();

        double deduction =
                payroll.getDeduction();

        double netSalary =
                basicSalary
                        + allowance
                        - deduction;

        payroll.setNetSalary(netSalary);

        return repository.save(payroll);
    }

    @Override
    public List<Payroll> getAllPayroll() {

        return repository.findAll();
    }

    @Override
    public Payroll getPayrollById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new PayrollNotFoundException(
                                "Payroll not found with id: " + id
                        )
                );
    }

    @Override
    public Payroll updatePayroll(
            Long id,
            Payroll payroll) {

        Payroll existing =
                getPayrollById(id);

        existing.setEmployee(
                payroll.getEmployee()
        );

        existing.setPayrollMonth(
                payroll.getPayrollMonth()
        );

        /*
         * Get latest salary from Employee
         */
        if (payroll.getEmployee().getSalary() != null) {

            existing.setBasicSalary(
                    payroll.getEmployee().getSalary()
            );
        }

        existing.setAllowance(
                payroll.getAllowance()
        );

        existing.setDeduction(
                payroll.getDeduction()
        );

        existing.setPaymentDate(
                payroll.getPaymentDate()
        );

        existing.setStatus(
                payroll.getStatus()
        );

        /*
         * Recalculate net salary
         */
        double netSalary =
                existing.getBasicSalary()
                        + existing.getAllowance()
                        - existing.getDeduction();

        existing.setNetSalary(netSalary);

        return repository.save(existing);
    }

    @Override
    public void deletePayroll(Long id) {

        Payroll payroll =
                getPayrollById(id);

        repository.delete(payroll);
    }

    @Override
    public List<Payroll> getPayrollByEmployee(
            Long employeeId) {

        return repository.findByEmployeeId(employeeId);
    }
}

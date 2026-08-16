package in.strikes.HRMS.repository;

import in.strikes.HRMS.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository
        extends JpaRepository<Payroll, Long> {

    List<Payroll> findByEmployeeId(Long employeeId);

    boolean existsByEmployeeIdAndPayrollMonth(
            Long employeeId,
            String payrollMonth
    );
}
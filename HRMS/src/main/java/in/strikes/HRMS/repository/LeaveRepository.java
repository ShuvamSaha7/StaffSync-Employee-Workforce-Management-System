package in.strikes.HRMS.repository;

import in.strikes.HRMS.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

    // Find leaves of a particular employee
    List<Leave> findByEmployeeId(Long employeeId);

    // Search by leave status
    List<Leave> findByStatusIgnoreCase(String status);

}

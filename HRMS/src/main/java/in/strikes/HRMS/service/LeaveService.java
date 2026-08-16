package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Leave;

import java.util.List;

public interface LeaveService {

    Leave saveLeave(Leave leave);

    List<Leave> getAllLeaves();

    Leave getLeaveById(Long id);

    Leave updateLeave(Long id, Leave leave);

    void deleteLeave(Long id);

    List<Leave> getLeavesByEmployee(Long employeeId);

    List<Leave> getLeavesByStatus(String status);
}

package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Leave;
import in.strikes.HRMS.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave not found with id: " + id));
    }

    @Override
    public Leave updateLeave(Long id, Leave leave) {

        Leave existingLeave = getLeaveById(id);

        existingLeave.setEmployee(leave.getEmployee());
        existingLeave.setLeaveType(leave.getLeaveType());
        existingLeave.setStartDate(leave.getStartDate());
        existingLeave.setEndDate(leave.getEndDate());
        existingLeave.setReason(leave.getReason());
        existingLeave.setStatus(leave.getStatus());

        return leaveRepository.save(existingLeave);
    }

    @Override
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    @Override
    public List<Leave> getLeavesByEmployee(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Leave> getLeavesByStatus(String status) {
        return leaveRepository.findByStatusIgnoreCase(status);
    }
}

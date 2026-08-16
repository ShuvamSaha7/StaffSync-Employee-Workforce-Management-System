package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Attendance;
import in.strikes.HRMS.exception.AttendanceNotFoundException;
import in.strikes.HRMS.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl
        implements AttendanceService {

    private final AttendanceRepository repository;

    public AttendanceServiceImpl(
            AttendanceRepository repository) {

        this.repository = repository;
    }

    @Override
    public Attendance saveAttendance(
            Attendance attendance) {

        boolean exists =
                repository.existsByEmployeeIdAndAttendanceDate(
                        attendance.getEmployee().getId(),
                        attendance.getAttendanceDate()
                );

        if (exists) {

            throw new RuntimeException(
                    "Attendance already exists for this employee on this date"
            );
        }

        return repository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {

        return repository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new AttendanceNotFoundException(
                                "Attendance not found with id: " + id
                        )
                );
    }

    @Override
    public Attendance updateAttendance(
            Long id,
            Attendance attendance) {

        Attendance existing =
                getAttendanceById(id);

        existing.setEmployee(
                attendance.getEmployee()
        );

        existing.setAttendanceDate(
                attendance.getAttendanceDate()
        );

        existing.setCheckIn(
                attendance.getCheckIn()
        );

        existing.setCheckOut(
                attendance.getCheckOut()
        );

        existing.setStatus(
                attendance.getStatus()
        );

        existing.setRemarks(
                attendance.getRemarks()
        );

        return repository.save(existing);
    }

    @Override
    public void deleteAttendance(Long id) {

        Attendance attendance =
                getAttendanceById(id);

        repository.delete(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(
            Long employeeId) {

        return repository.findByEmployeeId(employeeId);
    }
}

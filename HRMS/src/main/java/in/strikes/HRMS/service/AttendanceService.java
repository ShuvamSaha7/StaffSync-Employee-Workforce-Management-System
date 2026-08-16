package in.strikes.HRMS.service;

import in.strikes.HRMS.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    Attendance saveAttendance(Attendance attendance);

    List<Attendance> getAllAttendance();

    Attendance getAttendanceById(Long id);

    Attendance updateAttendance(Long id, Attendance attendance);

    void deleteAttendance(Long id);

    List<Attendance> getAttendanceByEmployee(Long employeeId);
}

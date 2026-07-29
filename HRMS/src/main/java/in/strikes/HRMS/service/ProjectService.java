package in.strikes.HRMS.service;



import in.strikes.HRMS.entity.Project;

import java.util.List;

public interface ProjectService {

    Project saveProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);

    List<Project> searchProject(String keyword);

}
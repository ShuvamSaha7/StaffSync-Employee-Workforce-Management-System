package in.strikes.HRMS.repository;


import in.strikes.HRMS.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByProjectNameContainingIgnoreCase(String keyword);

    boolean existsByProjectName(String projectName);

}
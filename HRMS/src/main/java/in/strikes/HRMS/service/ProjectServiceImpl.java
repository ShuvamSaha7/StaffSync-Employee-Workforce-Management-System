package in.strikes.HRMS.service;


import in.strikes.HRMS.entity.Project;
import in.strikes.HRMS.exception.ProjectNotFoundException;
import in.strikes.HRMS.repository.ProjectRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository repository;


    public ProjectServiceImpl(ProjectRepository repository){

        this.repository = repository;

    }





    // Save Project

    @Override
    public Project saveProject(Project project){


        if(repository.existsByProjectName(project.getProjectName())){


            throw new RuntimeException(
                    "Project already exists"
            );


        }


        return repository.save(project);

    }





    // Get All Projects

    @Override
    public List<Project> getAllProjects(){


        return repository.findAll();


    }





    // Get Project By ID

    @Override
    public Project getProjectById(Long id){


        return repository.findById(id)

                .orElseThrow(

                        () -> new ProjectNotFoundException(
                                "Project not found with id : " + id
                        )

                );

    }





    // Update Project

    @Override
    public Project updateProject(
            Long id,
            Project project
    ){


        Project oldProject =
                getProjectById(id);



        oldProject.setProjectName(
                project.getProjectName()
        );


        oldProject.setDescription(
                project.getDescription()
        );


        oldProject.setStartDate(
                project.getStartDate()
        );


        oldProject.setEndDate(
                project.getEndDate()
        );


        oldProject.setStatus(
                project.getStatus()
        );


        // Department Mapping Update
        oldProject.setDepartment(
                project.getDepartment()
        );


        return repository.save(oldProject);


    }





    // Delete Project

    @Override
    public void deleteProject(Long id){


        Project project =
                getProjectById(id);


        repository.delete(project);


    }





    // Search Project

    @Override
    public List<Project> searchProject(
            String keyword
    ){


        return repository
                .findByProjectNameContainingIgnoreCase(keyword);


    }


}
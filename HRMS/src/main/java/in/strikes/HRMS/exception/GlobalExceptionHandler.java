package in.strikes.HRMS.exception;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(
            EmployeeNotFoundException ex,
            Model model
    ) {


        model.addAttribute(
                "errorMessage",
                ex.getMessage()
        );


        return "error";

    }




    @ExceptionHandler(Exception.class)
    public String handleAllException(
            Exception ex,
            Model model
    ) {

        model.addAttribute(
                "errorMessage",
                ex.getMessage()
        );

        ex.printStackTrace();

        return "error";
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public String handleDepartmentNotFound(
            DepartmentNotFoundException ex,
            Model model){


        model.addAttribute(
                "errorMessage",
                ex.getMessage()
        );


        return "error";

    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public String handleProjectNotFound(

            ProjectNotFoundException ex,

            Model model

    ) {

        model.addAttribute(
                "errorMessage",
                ex.getMessage()
        );

        return "error";

    }


}
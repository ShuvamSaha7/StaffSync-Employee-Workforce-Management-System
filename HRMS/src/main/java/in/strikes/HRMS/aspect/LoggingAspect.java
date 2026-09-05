package in.strikes.HRMS.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.staffsync.HRM.service.*.*(..))")
    public void beforeServiceMethod(JoinPoint joinPoint) {

        logger.info(
                "Service method started: {}",
                joinPoint.getSignature().getName()
        );
    }

    @AfterReturning(
            pointcut = "execution(* com.staffsync.HRM.service.*.*(..))",
            returning = "result"
    )
    public void afterServiceMethod(
            JoinPoint joinPoint,
            Object result) {

        logger.info(
                "Service method completed: {}",
                joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(
            pointcut = "execution(* com.staffsync.HRM.service.*.*(..))",
            throwing = "exception"
    )
    public void afterException(
            JoinPoint joinPoint,
            Exception exception) {

        logger.error(
                "Exception in method {}: {}",
                joinPoint.getSignature().getName(),
                exception.getMessage()
        );
    }
}
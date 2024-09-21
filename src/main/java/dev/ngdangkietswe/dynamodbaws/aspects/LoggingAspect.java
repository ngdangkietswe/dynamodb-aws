package dev.ngdangkietswe.dynamodbaws.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

@Log4j2
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(dev.ngdangkietswe.dynamodbaws.apis..*)")
    public void apiPointcut() {
    }

    @Around("apiPointcut()")
    public Object logApi(ProceedingJoinPoint joinPoint) {
        try {
            var now = System.currentTimeMillis();
            var result = joinPoint.proceed();
            log.info("API {} executed in {} ms", joinPoint.getSignature().getName(), System.currentTimeMillis() - now);
            return result;
        } catch (Throwable e) {
            log.error("Failed to log api. Error detail: {}", e.getMessage());
            return null;
        }
    }
}

package com.geekbrains.restonlinestore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Before("@annotation(com.geekbrains.restonlinestore.annotation.ToLog)")
    public void logMassageBeforeMethod(JoinPoint point){
        System.out.println("Method: " + point.getSignature().getName() + " starts");
    }
    @AfterReturning("@annotation(com.geekbrains.restonlinestore.annotation.ToLog)")
    public void logMassageAfterMethod(JoinPoint point){
        System.out.println("Method: " + point.getSignature().getName() + " is completed");
    }
    @AfterThrowing(value = "@annotation(com.geekbrains.restonlinestore.annotation.ToLog)", throwing = "e")
    public void ThrowingFromMethod(JoinPoint point, Exception e){
        System.err.println("Error: " + e.getMessage() + " in method: " + point.getSignature().getName());
    }
}

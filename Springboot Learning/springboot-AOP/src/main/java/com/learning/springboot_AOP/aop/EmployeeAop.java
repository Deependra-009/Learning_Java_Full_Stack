package com.learning.springboot_AOP.aop;

import com.learning.springboot_AOP.entity.EmployeeEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Aspect
@Component
public class EmployeeAop {

    @Before("execution(* com.learning.springboot_AOP.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before Advice ===> "+joinPoint.getSignature() +" "+LocalDateTime.now());
    }

    @After("execution(* com.learning.springboot_AOP.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After Advice ===> "+joinPoint.getSignature() +" "+LocalDateTime.now());
    }

    @AfterReturning(
            value="execution(* com.learning.springboot_AOP.services.EmployeeService.getAllEmployee(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, List<EmployeeEntity> result){
        System.out.println("After Returning Advice ===> "+joinPoint.getSignature() +" "+LocalDateTime.now());
        System.out.println(result);
    }

    @AfterThrowing(
            value="execution(* com.learning.springboot_AOP.services.EmployeeService.addEmployee(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        System.out.println("After Throwing Advice ===> "+joinPoint.getSignature() +" "+LocalDateTime.now());
        System.out.println(exception.getMessage());
    }

    @Around("execution(* com.learning.springboot_AOP.services.EmployeeService.addEmployee(..))")
    public String aroundAdvice(ProceedingJoinPoint joinPoint){
        System.out.println("Around Advice ===> "+joinPoint.getSignature() +" "+LocalDateTime.now());
        try{
            return joinPoint.proceed().toString();
        }catch(Throwable e){
            System.out.println("around advice exception "+e.getMessage());
        }
        return null;
    }





}

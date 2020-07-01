package com.example.demo.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {
    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);

    //프로레스 시작, 종료시 기능함
    @Around("execution(* com.example.demo.controller.AopController.*(..))")
    public void doSomethingAround(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("AOP Test : First Around");
//        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        pjp.proceed();
        logger.info("AOP Test : Second Around");
//        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    }

    //메소드 시작하기전 기능함
    @Before("execution(* com.example.demo.controller.AopController.*(..))")
    public void doSomethingBefore() {
        logger.info("AOP Test : Before ");
    }

    //메소드가 끝난뒤 기능함
    @After("execution(* com.example.demo.controller.AopController.*(..))")
    public void doSomethingAfter() {
        logger.info("AOP Test : After");
    }

    //메소드 실행중 예외가 발생한뒤 기능함
    @AfterThrowing("execution(* com.example.demo.controller.AopController.*(..))")
    public void doSomethingAfterThrowing(){
        logger.info("AOP Test : AfterThrowing");
    }

    //메소드가 성공적으로 완료된후 기능함
    @AfterReturning("execution(* com.example.demo.controller.AopController.*(..))")
    public void doSomethingAfterReturning() {
        logger.info("AOP Test : AfterReturning ");
    }

}
package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//공통 관심 사항(시간 측정)을 핵심 관심 사항(회원가입, 회원 조회)과 분리
@Aspect
@Component
public class TimeTraceAop {

    //hello.hello_spring 패키지 하위 전부 적용 (SpringConfig는 순환참조 문제 때문에 제외)
    @Around("execution(* hello.hello_spring..*(..)) && !target(hello.hello_spring.service.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}

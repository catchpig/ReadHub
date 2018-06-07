package zhuazhu.readhub.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import zhuazhu.readhub.aop.annotaion.SingleClick;

/**
 * @author zhuazhu
 **/
@Aspect
public class SingleClickAspectJ {
    @Pointcut("execution(@zhuazhu.readhub.aop.annotaion.SingleClick  * *(..))")
    public void method(){}
    private int id;
    private long lastTime;
    @Around("method()")
    public void aroundSingleClick(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SingleClick singleClick = methodSignature.getMethod().getAnnotation(SingleClick.class);
        long newTime = System.currentTimeMillis();
        if(id!=singleClick.id()){
            id = singleClick.id();
            joinPoint.proceed();
            return;
        }
        if(newTime-lastTime>singleClick.time()){
            lastTime = newTime;
            joinPoint.proceed();
            return;
        }
    }
}

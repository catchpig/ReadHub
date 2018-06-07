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
    private int mId;
    private long mLastTime;
    @Pointcut("execution(@zhuazhu.readhub.aop.annotaion.SingleClick  * *(..))")
    public void method(){}
    @Around("method()")
    public void aroundSingleClick(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SingleClick singleClick = methodSignature.getMethod().getAnnotation(SingleClick.class);
        long nowTime = System.currentTimeMillis();
        int id = singleClick.id();
        /**
         * id不相同,可以执行
         */
        if(mId !=id){
            mId = id;
            joinPoint.proceed();
            return;
        }
        /**
         * 点击时间大于间隔时间,可以执行
         */
        if(nowTime- mLastTime >singleClick.time()){
            mLastTime = nowTime;
            joinPoint.proceed();
            return;
        }
    }
}

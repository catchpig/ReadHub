package zhuazhu.readhub.aop.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

import zhuazhu.readhub.aop.annotaion.SingleClick;
import zhuazhu.readhub.log.Logger;

/**
 * @author zhuazhu
 **/
@Aspect
public class SingleClickAspectJ {
    private static final String TAG = "SingleClickAspectJ";
    private int mId;
    private long mLastTime;
    @Pointcut("@annotation(zhuazhu.readhub.aop.annotaion.SingleClick)")
    public void annotationSingleClickType(){}
    @Pointcut("execution(@zhuazhu.readhub.aop.annotaion.SingleClick  * *(..)) && annotationSingleClickType()")
    public void method(){}
    @Around("method()")
    public void aroundSingleClick(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SingleClick singleClick = methodSignature.getMethod().getAnnotation(SingleClick.class);
        if(singleClick==null) {
            joinPoint.proceed();
            return;
        }
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

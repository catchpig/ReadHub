package zhuazhu.readhub.aop.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防止重复点击注解
 * @author zhuazhu
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleClick {
    /**
     * 间隔时间
     * @return
     */
    int time() default 1000;
    int id() default -1;
}

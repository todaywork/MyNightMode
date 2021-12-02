package com.zzl.mynightdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zhenglin.zhu on 2021/11/24.
 */
@Aspect
public class AspectBehavior {

    //指定使用BehaviorTrace注解的所有包下所有类的所有方法，为一个切面
    @Pointcut("execution(@com.zzl.mynightdemo.BehaviorTrace * *(..))")
    public void methodAnnotatedWithBehaviorTrace() {
    }

    //争对上面切面methodAnnotatedWithBehaviorTrace的所有点进行处理
    @Around("methodAnnotatedWithBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) {
        Object ret = null;

        try {
            //获取方法签名
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            //获取注解
            BehaviorTrace annotation = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);

            //执行之前记录下时间
            long startTime = System.currentTimeMillis();
            //方法执行
            ret = joinPoint.proceed();
            //方法执行完后的耗时
            long diffTime = System.currentTimeMillis() - startTime;

            String clzName = methodSignature.getDeclaringType().getSimpleName();
            String methodName = methodSignature.getName();

            Log.d("aruba", String.format("功能：%s 类：%s中方法：%s执行耗时:%d ms", annotation.value(), clzName, methodName, diffTime));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return ret;
    }

}

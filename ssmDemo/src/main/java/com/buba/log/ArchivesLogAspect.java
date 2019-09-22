package com.buba.log;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.buba.annotation.ArchivesLog;
import com.buba.pojo.Log;
import com.buba.service.BookService;

@Aspect
@Component
public class ArchivesLogAspect {
	
	@Resource
	BookService bookService;
	/**
	 * 	定义切点
	 */
	@Pointcut("@annotation(com.buba.annotation.ArchivesLog)")
	public void pointCut() {
	}
	
	/**
	 * 	方法正常执行后触发，记录日志
	 * @param joinpoint
	 * @throws ClassNotFoundException 
	 */
	@AfterReturning("pointCut()")
	public void after(JoinPoint joinPoint) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String operteContent = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                	// 操作说明
                    operteContent = method.getAnnotation(ArchivesLog.class).operteContent();
                    break;
                }
            }
        }
        Log log = new Log();
        log.setOperteContent(operteContent);
        log.setUserName("张三");
        log.setClassName(targetName);
        log.setExceptionMessage("无异常");
        log.setMethodName(methodName);
        bookService.addLog(log);
	}
	
	/**
	 * 	发生异常走此方法
	 * @param joinpoint
	 * @param e
	 * @throws ClassNotFoundException 
	 */
	@AfterThrowing(pointcut="pointCut()",throwing="e")
	public void throwing(JoinPoint joinPoint,Exception e) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String operteContent = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                	// 操作说明
                    operteContent = method.getAnnotation(ArchivesLog.class).operteContent();
                    break;
                }
            }
        }
        Log log = new Log();
        log.setOperteContent(operteContent);
        log.setUserName("张三");
        log.setClassName(targetName);
        log.setExceptionMessage(e.getMessage());
        log.setMethodName(methodName);
        bookService.addLog(log);
	}
}

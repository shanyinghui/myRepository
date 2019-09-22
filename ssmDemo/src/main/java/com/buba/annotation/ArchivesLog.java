package com.buba.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  自定义注解：用于把用户操作记录到日志中
 * @author 单迎辉
 *
 * 2019年9月20日 上午10:56:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ArchivesLog {
	/**
	 * 	操作说明
	 * @return
	 */
	public String operteContent() default "";
}

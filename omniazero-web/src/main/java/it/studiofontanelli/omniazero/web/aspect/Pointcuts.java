package it.studiofontanelli.omniazero.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {
	
	@Pointcut(value="execution(* it.studiofontanelli.omniazero.web.controller..*.*(..))")
    public void inControllerLayer() {}
	
}

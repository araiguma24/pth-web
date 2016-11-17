package jp.co.stylez.pth.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {
	/**
	 * コントローラー開始ログ出力
	 * 
	 * @param jp
	 */
	@Before("execution(* *..*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("コントローラ開始： " + jp.getSignature());
	}

	/**
	 * コントローラー終了ログ出力
	 * 
	 * @param jp
	 */
	@AfterReturning("execution(* *..*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("コントローラ正常終了： " + jp.getSignature());
	}

	/**
	 * 例外発生時ログ出力
	 * 
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(value = "execution(* *..*Controller.*(..))", throwing = "e")
	public void endLog(JoinPoint jp, Exception e) {
		System.out.println("コントローラ異常終了： " + jp.getSignature());
		e.printStackTrace();
	}
}
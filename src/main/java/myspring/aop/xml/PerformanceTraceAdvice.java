package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

//Around Advice
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 객체의 이름
		String targetName = joinPoint.getTarget().getClass().getName();
		System.out.println(targetName + " 객체 시작");
		
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().getName();		
		System.out.println(signatureString + " 메서드 시작");
		
		//타겟 메서드의 아규먼트 정보
		for(Object arg: joinPoint.getArgs()) {
			System.out.println(signatureString + " 메서드의 아규먼트 값 " + arg);
		}
		
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();
		
		try {
			//new Object[] {new String("dooly")}
			//타겟의 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			
			System.out.println(signatureString + " 메서드 종료");
			System.out.println(targetName + " " + signatureString + " 메서드의 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}

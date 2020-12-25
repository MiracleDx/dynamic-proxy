package org.dx.dyncmicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.Instant;

/**
 * JdkDynamicProxy
 *
 * @author: Dongx
 * Description:
 * Created in: 2020-12-25 上午9:52
 * Modified by:
 */
public class JdkDynamicProxy implements InvocationHandler {
	
	/** 
	 * 代理的目标类 
	 */
	private Object target;
	
	JdkDynamicProxy(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Instant startTime = Instant.now();
		Object result = method.invoke(this.target, args);
		System.out.println(String.format("执行结果是：%s \r\n执行耗时：%sms", result, Duration.between(startTime, Instant.now()).toMillis()));
		return result;
	}

	/**
	 * 获取代理对象实例
	 * @param target 需要代理的目标类
	 * @param <T> 返回值类型
	 * @return
	 */
	public static <T> T getProxyInstance(Object target) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), new JdkDynamicProxy(target));
	}
}

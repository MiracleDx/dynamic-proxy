package org.dx.dyncmicproxy;

import org.dx.dyncmicproxy.proxy.JdkDynamicProxy;

import java.util.concurrent.Callable;

/**
 * Main
 *
 * @author: Dongx
 * Description:
 * Created in: 2020-12-25 上午10:07
 * Modified by:
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Solution solution = JdkDynamicProxy.getProxyInstance(new SolutionImpl());
		solution.execute(() -> System.out.println(123));
		System.out.println(" ----> ");
		solution.execute(() -> 123456);
		System.out.println(" ----> ");
		solution.execute(new Task(123321));
	}
	
	static class Task<T> implements Callable {

		Task(T obj) {
			this.obj = obj;
		}
		
		private T obj;
		
		@Override
		public Object call() throws Exception {
			char[] chars = String.valueOf(obj).toCharArray();
			if ((chars.length <= 10 || chars.length > 106) && chars.length % 2 != 0) {
				return false;
			}

			int x = 0;
			int y = 0;

			for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
				x += chars[i];
				y += chars[j];
			}
			return x == y;
		}
	}
}

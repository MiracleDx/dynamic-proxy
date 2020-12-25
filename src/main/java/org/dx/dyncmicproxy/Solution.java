package org.dx.dyncmicproxy;

import java.util.concurrent.Callable;

/**
 * Solution
 *
 * @author: Dongx
 * Description:
 * Created in: 2020-12-25 上午9:51
 * Modified by:
 */
public interface Solution {
	
	Object execute(Callable task) throws Exception;
	
	void execute(Runnable task) throws Exception;
}

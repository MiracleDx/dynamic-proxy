package org.dx.dyncmicproxy;

import java.util.concurrent.Callable;

/**
 * SolutionImpl
 *
 * @author: Dongx
 * Description:
 * Created in: 2020-12-25 上午10:06
 * Modified by:
 */
public class SolutionImpl implements Solution {
	
	@Override
	public Object execute(Callable task) throws Exception {
		return task.call();
	}

	@Override
	public void execute(Runnable task) throws Exception {
		task.run();
	}
}

package com.cibernos.transactionshandler.testlisteners;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionsHandlerContrellerTestListener implements TestExecutionListener {

	public void beforeTestClass(TestContext testContext) throws Exception {
		log.info("beforeTestClass : {}", testContext.getTestClass());
	};

}

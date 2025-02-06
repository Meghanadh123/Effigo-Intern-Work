package com.example.SpringBatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

import com.example.SpringBatch.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

@Component
public class CustomSkipListener implements SkipListener<Employee, Number> {

	   Logger logger = LoggerFactory.getLogger(CustomSkipListener.class);

	    @Override // item reader
	    public void onSkipInRead(Throwable throwable) {
	        logger.info("A failure on read {} ", throwable.getMessage());
	    }

	    @Override // item writer
	    public void onSkipInWrite(Number item, Throwable throwable) {
	        logger.info("A failure on write {} , {}", throwable.getMessage(), item);
	    }

	    @SneakyThrows
	    @Override // item processor
	    public void onSkipInProcess(Employee employee, Throwable throwable) {
	        logger.info("Item {}  was skipped due to the exception  {}", new ObjectMapper().writeValueAsString(employee),
	                throwable.getMessage());
	    }
}

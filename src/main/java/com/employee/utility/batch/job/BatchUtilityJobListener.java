package com.employee.utility.batch.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityJobListener. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:46 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityJobListener implements JobExecutionListener {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(BatchUtilityJobListener.class);

    /**
     * DateTime startTime.
     */
    private DateTime startTime, stopTime;

    /**
     * <pre>
     * <b>Description : </b>
     * This method is called before batch job is triggered.
     *
     * @param jobExecution , may be null
     * </pre>
     */
    @Override
    public void beforeJob(final JobExecution jobExecution) {
        startTime = new DateTime();
        logger.info("Employee Batch Job starts at : " + startTime);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * This method is called after batch job is triggered.
     *
     * @param jobExecution , may be null
     * </pre>
     */
    @Override
    public void afterJob(final JobExecution jobExecution) {
        stopTime = new DateTime();
        logger.info("Employee Batch Job stops at : " + stopTime);
        logger.info("Total time take in millis : " + getTimeInMillis(startTime, stopTime));

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("Employee Batch job completed successfully");
        }
        else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            logger.info("Employee Batch job failed with following exceptions ");
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for (Throwable th : exceptionList) {
                logger.error("job execution exception :" + th.getLocalizedMessage());
            }
        }
    }

    /**
     * <pre>
     * <b>Description : </b>
     * getTimeInMillis.
     *
     * @param start , may be null
     * @param stop , may be null
     * @return long , null if not found
     * </pre>
     */
    private long getTimeInMillis(final DateTime start, final DateTime stop) {
        return stop.getMillis() - start.getMillis();
    }

}

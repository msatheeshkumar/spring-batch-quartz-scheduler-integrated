package com.employee.utility.batch.quartz;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.employee.utility.batch.exceptions.BatchUtilityException;
import com.employee.utility.batch.job.BatchUtilityJob;

/**
 * <pre>
 * <b>Description : </b>
 * SchedulerJob. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:49:20 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
@DisallowConcurrentExecution
public class SchedulerJob extends QuartzJobBean {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(SchedulerJob.class);

    /**
     * String batchJob.
     */
    private String batchJob;

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'batchJobParam' attribute value.
     *
     * @param batchJobParam , may be null
     * </pre>
     */
    public void setBatchJob(final String batchJobParam) {
        this.batchJob = batchJobParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * executeInternal.
     *
     * @param context , may be null
     * </pre>
     */
    @Override
    protected void executeInternal(final JobExecutionContext context) {
        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        BatchUtilityJob job = applicationContext.getBean(batchJob, BatchUtilityJob.class);
        logger.info("Quartz job started: " + job);

        try {
            job.performJob();

        }
        catch (BatchUtilityException ex) {
            logger.error("Job " + batchJob + " could not be executed : ", ex);
        }
        logger.info("Quartz job end");
    }
}

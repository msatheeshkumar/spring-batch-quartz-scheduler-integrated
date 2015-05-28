package com.employee.utility.batch.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;

import com.employee.utility.batch.exceptions.BatchUtilityException;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityJob. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:40 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityJob {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(BatchUtilityJob.class);

    /**
     * String jobName.
     */
    private String jobName;

    /**
     * JobLocator jobLocator.
     */
    private JobLocator jobLocator;

    /**
     * JobLauncher jobLauncher.
     */
    private JobLauncher jobLauncher;

    /**
     * <pre>
     * <b>Description : </b>
     * init.
     *
     * </pre>
     */
    public void init() {
    }

    /**
     * <pre>
     * <b>Description : </b>
     * This method registers job name and is to trigger batch job.
     *
     * @throws BatchUtilityException , in case of exception.
     * </pre>
     */
    public void performJob() throws BatchUtilityException {
        logger.info("Starting Employee Job");
        try {

            Map<String, JobParameter> map = new HashMap<String, JobParameter>();
            map.put("date", new JobParameter(new Date()));

            JobExecution result = jobLauncher.run(jobLocator.getJob(jobName), new JobParameters(map));
            logger.info("Employee Batch Job Job completetion details : " + result.toString());
        }
        catch (JobExecutionException ex) {
            logger.error("Employee Batch Job halted with following excpetion :", ex);
            throw new BatchUtilityException("Employee Batch Job halted with following excpetion :", ex);
        }
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'jobNameParam' attribute value.
     *
     * @param jobNameParam , may be null
     * </pre>
     */
    public void setJobName(final String jobNameParam) {
        this.jobName = jobNameParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'jobLocatorParam' attribute value.
     *
     * @param jobLocatorParam , may be null
     * </pre>
     */
    public void setJobLocator(final JobLocator jobLocatorParam) {
        this.jobLocator = jobLocatorParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'jobLauncherParam' attribute value.
     *
     * @param jobLauncherParam , may be null
     * </pre>
     */
    public void setJobLauncher(final JobLauncher jobLauncherParam) {
        this.jobLauncher = jobLauncherParam;
    }

}

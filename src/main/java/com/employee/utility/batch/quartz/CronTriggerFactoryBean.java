package com.employee.utility.batch.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.FactoryBean;

import com.employee.utility.batch.exceptions.BatchUtilityException;

/**
 * <pre>
 * <b>Description : </b>
 * CronTriggerFactoryBean. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:49:14 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class CronTriggerFactoryBean implements FactoryBean<Trigger> {

    /**
     * String jobName.
     */
    private final String jobName;

    /**
     * String cronExpression.
     */
    private final String cronExpression;

    /**
     * <pre>
     * <b>Description : </b>
     * CronTriggerFactoryBean.
     *
     * @param jobName , may be null
     * @param cronExpression , may be null
     * </pre>
     */
    public CronTriggerFactoryBean(final String jobName, final String cronExpression) {
        this.jobName = jobName;
        this.cronExpression = cronExpression;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'Trigger' attribute value.
     *
     * @return Trigger , null if not found
     * @throws BatchUtilityException , in case of exception.
     * </pre>
     */
    @Override
    public Trigger getObject() throws BatchUtilityException {

        return TriggerBuilder.newTrigger().forJob(jobName, "DEFAULT").withIdentity(jobName + "Trigger",
            "DEFAULT").withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'Class<?>' attribute value.
     *
     * @return Class<?> , null if not found
     * </pre>
     */
    @Override
    public Class<?> getObjectType() {
        return Trigger.class;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * isSingleton.
     *
     * @return boolean , null if not found
     * </pre>
     */
    @Override
    public boolean isSingleton() {
        return false;
    }

}

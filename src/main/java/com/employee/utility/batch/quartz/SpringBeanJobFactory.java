package com.employee.utility.batch.quartz;

import org.quartz.SchedulerContext;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.context.ApplicationContext;

/**
 * <pre>
 * <b>Description : </b>
 * SpringBeanJobFactory. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:49:25 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class SpringBeanJobFactory extends org.springframework.scheduling.quartz.SpringBeanJobFactory {

    /**
     * String[] ignoredUnknownProperties.
     */
    private String[] ignoredUnknownProperties;

    /**
     * SchedulerContext schedulerContext.
     */
    private SchedulerContext schedulerContext;

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'ignoredUnknownPropertiesParam' attribute value.
     *
     * @param ignoredUnknownPropertiesParam , may be null
     * </pre>
     */
    @Override
    public void setIgnoredUnknownProperties(final String[] ignoredUnknownPropertiesParam) {
        super.setIgnoredUnknownProperties(ignoredUnknownProperties);
        this.ignoredUnknownProperties = ignoredUnknownPropertiesParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'schedulerContextParam' attribute value.
     *
     * @param schedulerContextParam , may be null
     * </pre>
     */
    @Override
    public void setSchedulerContext(final SchedulerContext schedulerContextParam) {
        super.setSchedulerContext(schedulerContext);
        this.schedulerContext = schedulerContextParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * An implementation of SpringBeanJobFactory that retrieves the bean from
     * the Spring context so that autowiring and transactions work
     * This method is overriden.
     * 
     * @param bundle , may be null
     * @return Object , null if not found
     * @throws Exception , in case of exception.
     * </pre>
     */
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        ApplicationContext ctx = (ApplicationContext) schedulerContext.get("applicationContext");
        Object job = ctx.getBean(bundle.getJobDetail().getJobClass().getName());
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(job);
        if (isEligibleForPropertyPopulation(bw.getWrappedInstance())) {
            MutablePropertyValues pvs = new MutablePropertyValues();
            if (this.schedulerContext != null) {
                pvs.addPropertyValues(this.schedulerContext);
            }
            pvs.addPropertyValues(bundle.getJobDetail().getJobDataMap());
            pvs.addPropertyValues(bundle.getTrigger().getJobDataMap());
            if (this.ignoredUnknownProperties != null) {
                for (String propName : this.ignoredUnknownProperties) {
                    if (pvs.contains(propName) && !bw.isWritableProperty(propName)) {
                        pvs.removePropertyValue(propName);
                    }
                }
                bw.setPropertyValues(pvs);
            }
            else {
                bw.setPropertyValues(pvs, true);
            }
        }
        return job;
    }

}

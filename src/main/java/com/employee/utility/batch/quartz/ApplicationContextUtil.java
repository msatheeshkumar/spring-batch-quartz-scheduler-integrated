package com.employee.utility.batch.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <pre>
 * <b>Description : </b>
 * ApplicationContextUtil. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:49:07 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    /**
     * ApplicationContextUtil instance.
     */
    private static ApplicationContextUtil instance;

    /**
     * ApplicationContext applicationContext.
     */
    private ApplicationContext applicationContext;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'ApplicationContextUtil' attribute value.
     *
     * @return ApplicationContextUtil , null if not found
     * </pre>
     */
    private static synchronized ApplicationContextUtil getInstance() {

        if (instance == null) {
            instance = new ApplicationContextUtil();
        }

        return instance;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'applicationContext' attribute value.
     *
     * @param applicationContext , may be null
     * @throws BeansException , in case of exception.
     * </pre>
     */
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        if (getInstance().applicationContext == null) {
            getInstance().applicationContext = applicationContext;
        }

    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'ApplicationContext' attribute value.
     *
     * @return ApplicationContext , null if not found
     * </pre>
     */
    public static ApplicationContext getApplicationContext() {
        return getInstance().applicationContext;
    }

}

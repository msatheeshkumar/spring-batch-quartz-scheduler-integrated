package com.employee.utility.batch;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.utility.batch.util.BatchUtilityContants;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityMain. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:04 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityMain {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(BatchUtilityMain.class);

    /**
     * <pre>
     * <b>Description : </b>
     * This main method initiates quartz and spring batch job
     *
     * @param args , may be null
     * </pre>
     */
    @SuppressWarnings("resource")
    public static void main(final String[] args) {
        ApplicationContext context = null;
        try {
            logger.info("Employee batch utility intializing...");
            
            // bean injection
            context = new ClassPathXmlApplicationContext(BatchUtilityContants.APPLN_CONTEXT_QUARTZ_PATH);
            logger.info("Employee batch utility has been intialized successfully!");
        }
        catch (Exception e) {
            logger.error("Error While initializing employee batch utility", e);
        }
    }
}

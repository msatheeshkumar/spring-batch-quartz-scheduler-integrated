package com.employee.utility.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.employee.utility.batch.exceptions.BatchUtilityException;
import com.employee.utility.batch.model.Employee;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityItemProcessor. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:47:57 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityItemProcessor implements ItemProcessor<Employee, Employee> {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(BatchUtilityItemProcessor.class);

    /**
     * <pre>
     * <b>Description : </b>
     * This method is called by listener process.
     *
     * @param employee , may be null
     * @return Employee , null if not found
     * @throws BatchUtilityException , in case of exception.
     * </pre>
     */
    @Override
    public Employee process(final Employee employee) throws BatchUtilityException {
        logger.info("Processing Employee Reesult : " + employee);

        /*
         * Only return employee records which are more than 180 days old
         * since we have set the condition in SP's WHERE clause, We don't need to validate here.
         */
        /*if(employee.getExpired() > 180){
        	return null;
        }*/

        return employee;
    }
}

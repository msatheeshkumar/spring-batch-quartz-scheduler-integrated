package com.employee.utility.batch;

import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.employee.utility.batch.exceptions.BatchUtilityException;
import com.employee.utility.batch.model.Employee;
import com.employee.utility.batch.util.BatchUtilityContants;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityWriter. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:12 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityWriter implements ItemWriter<Employee> {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(BatchUtilityWriter.class);

    /**
     * JdbcTemplate jdbcTemplate.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityWriter.
     *
     * @param dataSource_p , may be null
     * </pre>
     */
    public BatchUtilityWriter(final DataSource dataSource_p) {
        this.jdbcTemplate = new JdbcTemplate(dataSource_p);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Method takes a list of employees model objects and uses JDBC template to
     * either insert or update them in the database.
     * 
     * @param employees , may be null
     * @throws BatchUtilityException , in case of exception.
     * </pre>
     */
    public void write(final List<? extends Employee> employees) throws BatchUtilityException {
        for (Employee employee : employees) {
            try {
                jdbcTemplate.update(BatchUtilityContants.INSERT_EMLOYEE_ARCHIVE, employee.getEmployeeId(),
                    employee.getEmployeeName(), employee.getDob(), employee.getDepartment(), Calendar
                        .getInstance().getTime());
            }
            catch (DataAccessException e) {
                logger.error("Error while inserting employee records", e);
                throw new BatchUtilityException("Error while inserting employee records", e);
            }
        }
    }

}

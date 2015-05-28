package com.employee.utility.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.employee.utility.batch.model.Employee;
import com.employee.utility.batch.util.BatchUtilityContants;

/**
 * <pre>
 * <b>Description : </b>
 * EmployeeRowMapper. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:20 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    /**
     * Logger logger.
     */
    private static final Logger logger = Logger.getLogger(EmployeeRowMapper.class);

    /**
     * <pre>
     * <b>Description : </b>
     * This method retrieve the SP output values and set them in POJO class.
     *
     * @param rs , may be null
     * @param rowNum , may be null
     * @return Employee , null if not found
     * @throws SQLException , in case of exception.
     * </pre>
     */
    public Employee mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        Employee employee = null;
        try {
            employee = new Employee();

            employee.setEmployeeId(rs.getInt(BatchUtilityContants.SP_OUT_EMPLOYEE_ID));
            employee.setEmployeeName(rs.getString(BatchUtilityContants.SP_OUT_NAME));
            employee.setDob(rs.getDate(BatchUtilityContants.SP_OUT_DOB));
            employee.setDepartment(rs.getString(BatchUtilityContants.SP_OUT_DEPARTMENT));
        }
        catch (SQLException e) {
            logger.error("Error while access db value", e);
        }
        return employee;
    }
}

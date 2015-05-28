package com.employee.utility.batch;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 * <pre>
 * <b>Description : </b>
 * BatchPreparedStatementSetter. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:47:12 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchPreparedStatementSetter implements PreparedStatementSetter {

    /**
     * int dayLimit.
     */
    private int dayLimit;
    /**
     * int fetchLimit.
     */
    private int fetchLimit;

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'dayLimitParam' attribute value.
     *
     * @param dayLimitParam , may be null
     * </pre>
     */
    public void setDayLimit(final int dayLimitParam) {
        this.dayLimit = dayLimitParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'fetchLimitParam' attribute value.
     *
     * @param fetchLimitParam , may be null
     * </pre>
     */
    public void setFetchLimit(final int fetchLimitParam) {
        this.fetchLimit = fetchLimitParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the stored procedure input parameter values.
     *
     * @param aPs , may be null
     * @throws SQLException , in case of exception.
     * </pre>
     */
    public void setValues(final PreparedStatement aPs) throws SQLException {
        CallableStatement lCallableStatement = (CallableStatement) aPs;
        //lCallableStatement .registerOutParameter(1, Types.VARCHAR);
        lCallableStatement.setInt(1, dayLimit);       // set value in first input parameter of SP
        lCallableStatement.setInt(2, fetchLimit);     // set value in second input parameter of SP
    }
}

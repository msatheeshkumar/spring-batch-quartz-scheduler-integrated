package com.employee.utility.batch.util;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityContants. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:49:36 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityContants {

    /**
     * String APPLN_CONTEXT_QUARTZ_PATH.
     */
    public static final String APPLN_CONTEXT_QUARTZ_PATH = "com/employee/utility/batch/resources/batch-quartz-context.xml";
    /**
     * String INSERT_EMLOYEE_ARCHIVE.
     */
    public static final String INSERT_EMLOYEE_ARCHIVE = "INSERT INTO EMPLOYEE_DETAILS_ARCHIVED"
        + " (EMPLOYEE_ID, NAME, DOB, DEPARTMENT, ARCHIVED_DATE) VALUES(?, ?, ?, ?, ?)";
    /**
     * String SP_OUT_EMPLOYEE_ID.
     */
    public static final String SP_OUT_EMPLOYEE_ID = "EMPLOYEE_ID";
    /**
     * String SP_OUT_NAME.
     */
    public static final String SP_OUT_NAME = "NAME";
    /**
     * String SP_OUT_DOB.
     */
    public static final String SP_OUT_DOB = "DOB";
    /**
     * String SP_OUT_DEPARTMENT.
     */
    public static final String SP_OUT_DEPARTMENT = "DEPARTMENT";

}

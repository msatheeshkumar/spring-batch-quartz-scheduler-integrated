package com.employee.utility.batch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * <b>Description : </b>
 * Employee. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:57 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {

    /**
     * long employeeId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    /**
     * String employeeName.
     */
    @Column(name = "NAME", nullable = false)
    private String employeeName;

    /**
     * Date dob.
     */
    @Column(name = "DOB", nullable = false)
    private Date dob;

    /**
     * String department.
     */
    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'long' attribute value.
     *
     * @return long , null if not found
     * </pre>
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'employeeIdParam' attribute value.
     *
     * @param employeeIdParam , may be null
     * </pre>
     */
    public void setEmployeeId(final long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'employeeNameParam' attribute value.
     *
     * @param employeeNameParam , may be null
     * </pre>
     */
    public void setEmployeeName(final String employeeNameParam) {
        this.employeeName = employeeNameParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getDepartment() {
        return department;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'departmentParam' attribute value.
     *
     * @param departmentParam , may be null
     * </pre>
     */
    public void setDepartment(final String departmentParam) {
        this.department = departmentParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'Date' attribute value.
     *
     * @return Date , null if not found
     * </pre>
     */
    public Date getDob() {
        return dob;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'dobParam' attribute value.
     *
     * @param dobParam , may be null
     * </pre>
     */
    public void setDob(final Date dobParam) {
        this.dob = dobParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * hashCode.
     *
     * @return int , null if not found
     * </pre>
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (employeeId ^ (employeeId >>> employeeId));
        return result;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * equals.
     *
     * @param obj , may be null
     * @return boolean , null if not found
     * </pre>
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (employeeId != other.employeeId)
            return false;
        return true;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * toString.
     *
     * @return String , null if not found
     * </pre>
     */
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dob=" + dob
            + ", department=" + department + "]";
    }

}

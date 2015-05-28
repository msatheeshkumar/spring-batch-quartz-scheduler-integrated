package com.employee.utility.batch.exceptions;

/**
 * <pre>
 * <b>Description : </b>
 * BatchUtilityException. 
 *
 * @version $Revision: 001 $ $Date: 2015-04-09 02:48:30 $
 * @author $Author: Satheesh Kumar M $
 * </pre>
 */
public class BatchUtilityException extends Exception {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityException.
     *
     * </pre>
     */
    public BatchUtilityException() {
    }

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityException.
     *
     * @param message , may be null
     * </pre>
     */
    public BatchUtilityException(final String message) {
        super(message);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityException.
     *
     * @param cause , may be null
     * </pre>
     */
    public BatchUtilityException(final Throwable cause) {
        super(cause);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityException.
     *
     * @param message , may be null
     * @param cause , may be null
     * </pre>
     */
    public BatchUtilityException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * BatchUtilityException.
     *
     * @param message , may be null
     * @param cause , may be null
     * @param enableSuppression , may be null
     * @param writableStackTrace , may be null
     * </pre>
     */
    public BatchUtilityException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

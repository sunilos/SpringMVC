package com.sunilos.exception;

import org.springframework.dao.DataAccessException;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class DuplicateRecordException extends DataAccessException {
    /**
     * @param msg
     *            error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}
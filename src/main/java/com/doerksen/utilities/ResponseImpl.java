package com.doerksen.utilities;

import com.google.common.base.Preconditions;

import static org.apache.http.HttpStatus.*;

public class ResponseImpl<T> implements Response<T> {

    private T object;
    private int statusCode;
    private boolean success;
    private String message;
    private Throwable throwable;

    /**
     * For use by Jackson only
     */
    public ResponseImpl() {}

    public ResponseImpl(final T object) {
        this(object, SC_OK);
    }

    /**
     * Creates a success response with the object
     * @param object
     * @param statusCode - please use org.apache.http.HttpStatus for consistency
     */
    public ResponseImpl(final T object,
                        final int statusCode) {
        Preconditions.checkNotNull(object);
        this.object = object;
        this.statusCode = statusCode;
        success = true;
    }

    public ResponseImpl(final String message,
                        final int statusCode) {
        Preconditions.checkNotNull(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    /**
     * /**
     * @param message
     * @param statusCode - please use org.apache.http.HttpStatus for consistency
     * @param throwable
     */
    public ResponseImpl(final String message,
                        final int statusCode,
                        final Throwable throwable) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(throwable);
        this.message = message;
        this.statusCode = statusCode;
        this.throwable = throwable;
    }

    public T getObject() {
        return object;
    }

    public boolean isError() {
        return !success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String message() {
        return message;
    }

    public int statusCode() {
        return statusCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}

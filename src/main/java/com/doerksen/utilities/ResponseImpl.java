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
        this(object, statusCode, true);
    }

    /**
     * Create a success/error response with the object and status code
     * @param object
     * @param statusCode - please use org.apache.http.HttpStatus for consistency
     * @param success
     */
    public ResponseImpl(final T object,
                        final int statusCode,
                        final boolean success) {
        Preconditions.checkNotNull(object);
        this.object = object;
        this.statusCode = statusCode;
        this.success = success;
    }

    /**
     * Creates a failure message with an error message, status code and throwable
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

    /**
     * Creates a success response; for when you only care about the pass/fail result.
     * @param statusCode - required so the caller can branch based on a particular code if needed
     * @return
     */
    public static Response<String> success(final int statusCode) {
        return new ResponseImpl<>("success", statusCode);
    }

    /**
     * Creates a failure response; for when you only care about the pass/fail result.
     * @param statusCode - required so the caller can branch based on a particular code if needed
     * @return
     */
    public static Response<String> error(final int statusCode) {
        return new ResponseImpl<>("error", statusCode, false);
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

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}

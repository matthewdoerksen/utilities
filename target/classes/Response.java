package com.doerksen.base_project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@JsonSerialize(include= Inclusion.NON_NULL)
public interface Response<T> {
    T getObject();

    @JsonIgnore
    boolean isError();

    boolean isSuccess();

    String getMessage();

    int getStatusCode();

    @JsonIgnore
    Throwable getThrowable();
}

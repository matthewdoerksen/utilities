package com.doerksen.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@JsonSerialize(include= Inclusion.NON_NULL)
@JsonDeserialize(as = ResponseImpl.class)
public interface Response<T> {
    T getObject();

    @JsonIgnore
    boolean isError();

    boolean isSuccess();

    String message();

    int statusCode();

    @JsonIgnore
    Throwable getThrowable();
}

package com.doerksen.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonDeserializerHelper {

    private final ObjectMapper mapper;

    /**
     * Force clients to create their own instance so they can mess with the mapper parameters (if they choose).
     */
    public JsonDeserializerHelper() {
        this.mapper = new ObjectMapper();
    }

    /**
     * It is your responsibility to ensure the class passed in and the object being assigned to match.
     *
     * The conversion was influenced by this post/answer: http://stackoverflow.com/a/19262843
     *
     * @param json - json string to convert to a class of a given type
     * @param target - the class to convert the string to
     * @param <T>   - enforces type check at compile time to help validate the class being passed in and the type being returned match up
     * @return - an object of type T
     * @throws IOException
     */
    public <T> T convert(String json, Class<T> target) throws IOException {
        return mapper.readValue(json, mapper.getTypeFactory().constructType(target));
    }
}

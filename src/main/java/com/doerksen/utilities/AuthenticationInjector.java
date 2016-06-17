package com.doerksen.utilities;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class AuthenticationInjector implements ClientRequestFilter {

    private static final String APPLICATION_NAME_HEADER = "app_name";
    private static final String APPLICATION_ACCESS_TOKEN = "access_token";

    private final String applicationName;
    private final String accessToken;

    public AuthenticationInjector(final String applicationName,
                                  final String accessToken) {
        this.applicationName = applicationName;
        this.accessToken = accessToken;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add(APPLICATION_NAME_HEADER, applicationName);
        requestContext.getHeaders().add(APPLICATION_ACCESS_TOKEN, accessToken);
    }
}

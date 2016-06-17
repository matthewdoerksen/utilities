package com.doerksen.utilities;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ResourceWebTargetBuilder<T>  {

    private final Class<T> resource;
    private final String host;
    private final String port;
    private String applicationName;
    private String accessToken;

    public ResourceWebTargetBuilder(final Class<T> resource,
                                    final String host,
                                    final String port) {
        this.resource = resource;
        this.host = host;
        this.port = port;
    }

    public ResourceWebTargetBuilder<T> withCredentials(final String applicationName,
                                final String accessToken) {
        this.applicationName = applicationName;
        this.accessToken = accessToken;
        return this;
    }

    public T build() {
        Client client = ClientBuilder.newClient();
        if (StringUtils.isNotBlank(applicationName) && StringUtils.isNotBlank(accessToken)) {
            client.register(new AuthenticationInjector(applicationName, accessToken));
        }
        String URI = "http://" + host + ":" + port;
        return WebResourceFactory.newResource(resource, client.target(URI));
    }
}

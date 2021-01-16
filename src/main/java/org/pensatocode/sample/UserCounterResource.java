package org.pensatocode.sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("user")
public class UserCounterResource {

    @Inject
    AppCounterResource appCounterResource;

    @GET
    @Path("counter")
    public int getCounter() {
        return appCounterResource.getCount();
    }

    @GET
    @Path("name")
    public String getName() {
        return "Fake username";
    }
}
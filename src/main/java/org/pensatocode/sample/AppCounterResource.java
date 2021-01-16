package org.pensatocode.sample;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Path("app")
public class AppCounterResource {

    final AtomicInteger counter = new AtomicInteger();

    @GET
    @Path("counter")
    @Produces("text/plain")
    public int getCount() {
        return counter.incrementAndGet();
    }
}

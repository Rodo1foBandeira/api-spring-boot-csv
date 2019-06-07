package APIGet.APIGet;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import APIGet.Resource.SchoolResource;
 
@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(SchoolResource.class);
    }
}
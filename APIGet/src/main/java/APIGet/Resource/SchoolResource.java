package APIGet.Resource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import model.School;
import repo.ISchoolRepo;

import java.net.URISyntaxException;
import java.util.List;
 
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "school")
@Path("/school")
public class SchoolResource {

	@Autowired
	ISchoolRepo repo;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<School> listarTodos() {        
        return (List<School>)repo.findAll();
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(School request) throws URISyntaxException{
		int statusCode;
        if (request.getId() == 0)
        {
        	statusCode = 201;
        }else {
        	statusCode = 200;
        }
    	repo.save(request);    	
        return Response.status(statusCode).entity(request).build();
	}
}

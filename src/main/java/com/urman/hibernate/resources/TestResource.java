package com.urman.hibernate.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urman.hibernate.service.TestService;

import net.sf.json.JSONObject;

@Path("v1/test")
@Service
public class TestResource {

	@Autowired
	TestService testServiceHelper;

	public static Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

	@GET
	@Path("/staticResponse")
	public String staticResponse() {
		return "Hello Docker";
	}

	@POST
	@Path("/corsBypass")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testCors(String url) {
		String response = StringUtils.EMPTY;
		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet(url);

			// add request headers
			request.addHeader("loginsessionkey", null);
			request.addHeader("X-Requested-With", null);

			CloseableHttpResponse responseHttp = httpClient.execute(request);
			response = EntityUtils.toString(responseHttp.getEntity());
			System.out.println(response);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return Response.status(Response.Status.OK).entity(response).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/getCustomerIds")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerIds() {
		List<String> customerIds = null;
		try {
			customerIds = testServiceHelper.getAllCustomerIds();
		} catch (Exception e) {
			LOGGER.error("could not create account because of " + e.getMessage(), e);
			JSONObject error = new JSONObject();
			error.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}

		return Response.status(Response.Status.OK).entity(customerIds).build();
	}

	

}

package com.urman.hibernate.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urman.hibernate.pojo.CustomerPersonalInfo;
import com.urman.hibernate.service.TestService;
import com.urman.hibernate.util.BaseException;

import net.sf.json.JSONObject;

@Path("v1/customer")
@Service
public class CustomerResource {

	public static Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);

	@Autowired
	TestService testService;

	@POST
	@Path("/createCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addCustomerAccountInfo(CustomerPersonalInfo customer) {

		try {
			testService.createCustomer(customer);

		} catch (Exception e) {
			LOGGER.error("could not create customer because of " + e.getMessage(), e);
			JSONObject error = new JSONObject();
			error.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();

		}
		return Response.status(Response.Status.CREATED).entity(customer).build();
	}

	@GET
	@Path("/customerinfo/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response showCustomerInfo(@PathParam("customerId") long customerId) {
		CustomerPersonalInfo result = new CustomerPersonalInfo();
		try {
			CustomerPersonalInfo customer = testService.getCustomerInfo(customerId);
			if (null == customer) {
				throw new BaseException("customer not found");
			}
			BeanUtils.copyProperties(customer, result);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JSONObject error = new JSONObject();
			error.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		return Response.status(Response.Status.OK).entity(result).build();
	}

	@POST
	@Path("/getCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getCustomerList(JSONObject json) {
		List<CustomerPersonalInfo> customers = null;
		@SuppressWarnings("unchecked")
		List<Long> customerIds = json.getJSONArray("customerIdList");
		customers = testService.getCustomerList(customerIds);
		List<CustomerPersonalInfo> result = new ArrayList<>();
		BeanUtils.copyProperties(customers, result);
		return Response.status(Response.Status.OK).entity(result).build();
	}

}

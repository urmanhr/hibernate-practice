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

import com.urman.hibernate.pojo.AccountInfo;
import com.urman.hibernate.service.TestService;
import com.urman.hibernate.util.BaseException;

import net.sf.json.JSONObject;

@Path("v1/account")
@Service
public class AccountResource {

	public static Logger LOGGER = LoggerFactory.getLogger(AccountResource.class);

	@Autowired
	TestService testService;

	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addCustomerAccountInfo(AccountInfo accountInfo) {

		try {
			testService.createAccount(accountInfo);

		} catch (Exception e) {
			LOGGER.error("could not create account because of " + e.getMessage(), e);
			JSONObject error = new JSONObject();
			error.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();

		}
		return Response.status(Response.Status.CREATED).entity(accountInfo).build();
	}

	@GET
	@Path("/accountinfo/{accountNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response showAccountInfo(@PathParam("accountNumber") Long accountNumber) {
		AccountInfo result = new AccountInfo();
		try {
			AccountInfo accountInfo = testService.getAccountInfo(accountNumber);
			if (null == accountInfo) {
				throw new BaseException("accounts not found");
			}
			BeanUtils.copyProperties(accountInfo, result);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JSONObject error = new JSONObject();
			error.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		return Response.status(Response.Status.OK).entity(result).build();
	}

	@POST
	@Path("/getAccounts")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getAccountList(JSONObject json) {
		List<AccountInfo> accountList = null;
		@SuppressWarnings("unchecked")
		List<Long> accountIds = json.getJSONArray("accountIdList");
		accountList = testService.getAccountList(accountIds);
		List<AccountInfo> result = new ArrayList<>(0);
		BeanUtils.copyProperties(accountList, result);

		return Response.status(Response.Status.OK).entity(result).build();
	}
}

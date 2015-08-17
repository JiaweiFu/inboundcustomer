/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 */

package com.sap.inboundcustomer.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import com.hybris.datahub.dto.item.ResultData;
import com.sap.inboundcustomer.domain.YaasCustomer;
import com.sap.inboundcustomer.facade.InboundFacade;

@Path("/data-feeds/{feedName}/items/InboundRawCustomer")
@Consumes(MediaType.APPLICATION_JSON)
public class ImportCustomerResource
{
    private static final Logger logger = LoggerFactory.getLogger(ImportCustomerResource.class);

    private InboundFacade inboundFacade;

    @POST
    public Response inboundCustomer(@PathParam("feedName") final String feedName, final YaasCustomer in)
    // public Response inboundCustomer(@PathParam("feedName") final String
    // feedName, final RawCustomer in)
    {
	logger.info("Received request to import csv data for type InboundRawCustomer into data feed " + feedName);

	final ResultData result = inboundFacade.importItem(feedName, "InboundRawCustomer", in);

	logger.info("Total number processed: " + result.getNumberProcessed());
	return Response.ok(result).build();
    }

    @Required
    public void setInboundFacade(final InboundFacade inboundFacade)
    {
	this.inboundFacade = inboundFacade;
    }
}

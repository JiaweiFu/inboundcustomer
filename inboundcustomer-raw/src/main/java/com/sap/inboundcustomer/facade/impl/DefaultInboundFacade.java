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

package com.sap.inboundcustomer.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

import com.hybris.datahub.dto.item.ResultData;
import com.sap.inboundcustomer.domain.YaasBaseItem;
import com.sap.inboundcustomer.facade.InboundFacade;

public class DefaultInboundFacade implements InboundFacade
{
    private static final Logger logger = LoggerFactory.getLogger(DefaultInboundFacade.class);
    // private CsvDataLoadingValidator dataLoadingValidator;
    // private DataHubFeedService dataHubFeedService;
    // private CsvReaderService csvReaderService;
    // private CsvRawFragmentConversionService csvRawFragmentConversionService;
    // private DataLoadingService dataLoadingService;
    private MessageChannel rawFragmentInputChannel;

    // private PlatformTransactionManager transactionManager;

    @Override
    public ResultData importItem(final String feedName, final String itemType, final YaasBaseItem input)
    {

	logger.info(input.toString());

	final List<Map<String, String>> rawFragments = input.createRawFragments();

	logger.info("Importing " + rawFragments.size() + " raw fragments of type " + itemType + " into data feed "
		+ feedName);

	logger.info(rawFragments.get(0).toString());
	rawFragmentInputChannel.send(new GenericMessage<Object>(rawFragments,
		constructMessageHeader(itemType, feedName)));

	final ResultData result = new ResultData();
	result.setNumberProcessed(rawFragments.size());
	return result;
    }

    private Map<String, Object> constructMessageHeader(final String itemType, final String feedName)
    {
	final Map<String, Object> header = new HashMap<>();
	header.put("itemType", itemType);
	header.put("feedName", feedName);
	return header;
    }

    /*
     * @Required public void setCsvReaderService(final CsvReaderService
     * csvReaderService) { this.csvReaderService = csvReaderService; }
     * @Required public void setCsvRawFragmentConversionService(final
     * CsvRawFragmentConversionService csvRawFragmentConversionService) {
     * this.csvRawFragmentConversionService = csvRawFragmentConversionService; }
     */
    @Required
    public void setRawFragmentInputChannel(final MessageChannel rawFragmentInputChannel)
    {
	this.rawFragmentInputChannel = rawFragmentInputChannel;
    }

    /*
     * @Required public void setTransactionManager(final
     * PlatformTransactionManager transactionManager) { this.transactionManager
     * = transactionManager; }
     */

    /*
     * @Required public void setDataLoadingValidator(final
     * CsvDataLoadingValidator dataLoadingValidator) { this.dataLoadingValidator
     * = dataLoadingValidator; }
     */
    /*
     * @Required public void setDataLoadingService(final DataLoadingService
     * dataLoadingService) { this.dataLoadingService = dataLoadingService; }
     * @Required public void setDataHubFeedService(final DataHubFeedService
     * dataHubFeedService) { this.dataHubFeedService = dataHubFeedService; }
     */
}

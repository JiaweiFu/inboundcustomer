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

package com.sap.inboundcustomer.facade;

import com.hybris.datahub.dto.item.ResultData;
import com.sap.inboundcustomer.domain.YaasBaseItem;

public interface InboundFacade
{
    /**
     * Imports the contents of the input stream as raw fragments of the type
     * provided into a data feed matching the id provided
     *
     * @param feedName
     *            The data feed the data will input into
     * @param itemType
     *            The type of raw fragment data contained in the input
     * @param csvInput
     *            The input containing the raw fragment data
     * @throws IllegalArgumentException
     *             if feedId doesn't correspond to an existing data feed
     */
    public ResultData importItem(final String feedName, final String itemType, final YaasBaseItem in);
}

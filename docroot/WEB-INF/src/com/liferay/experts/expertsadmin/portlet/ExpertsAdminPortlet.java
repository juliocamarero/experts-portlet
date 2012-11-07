/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.experts.expertsadmin.portlet;

import com.liferay.experts.service.TagAssignmentLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Ryan Park
 */
public class ExpertsAdminPortlet extends MVCPortlet {

	public void addTagAssignment(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long userId = ParamUtil.getLong(actionRequest, "userId");
		String assetTagName = ParamUtil.getString(
			actionRequest, "assetTagName");

		TagAssignmentLocalServiceUtil.addTagAssignment(
			userId, assetTagName, true);
	}

}
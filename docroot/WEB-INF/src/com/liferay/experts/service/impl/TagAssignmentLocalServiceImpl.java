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

package com.liferay.experts.service.impl;

import com.liferay.experts.model.TagAssignment;
import com.liferay.experts.service.base.TagAssignmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetTag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ryan Park
 */
public class TagAssignmentLocalServiceImpl
	extends TagAssignmentLocalServiceBaseImpl {

	public TagAssignment addTagAssignment(
			long userId, String assetTagName, boolean locked)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long tagAssignmentId = counterLocalService.increment();

		TagAssignment tagAssignment = tagAssignmentPersistence.create(
			tagAssignmentId);

		tagAssignment.setCompanyId(user.getCompanyId());
		tagAssignment.setUserId(user.getUserId());
		tagAssignment.setUserName(user.getFullName());

		Group group = groupLocalService.getCompanyGroup(user.getCompanyId());

		AssetTag assetTag = assetTagPersistence.fetchByG_N(
			group.getGroupId(), assetTagName);

		if (assetTag == null) {
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGuestPermissions(true);
			serviceContext.setScopeGroupId(group.getGroupId());

			assetTag = assetTagLocalService.addTag(
				userId, assetTagName, null, serviceContext);
		}

		tagAssignment.setAssetTagId(assetTag.getTagId());
		tagAssignment.setAssetTagName(assetTag.getName());

		tagAssignment.setLocked(locked);

		tagAssignmentPersistence.update(tagAssignment, false);

		return tagAssignment;
	}

	public List<TagAssignment> getTagAssignments(
			long companyId, String[] assetTagNames)
		throws PortalException, SystemException {

		Group group = groupLocalService.getCompanyGroup(companyId);

		long[] assetTagIds = assetTagLocalService.getTagIds(
			group.getGroupId(), assetTagNames);

		// TODO: Optimize with a finder

		List<TagAssignment> tagAssignments = new ArrayList<TagAssignment>();

		for (long assetTagId : assetTagIds) {
			tagAssignments.addAll(
				tagAssignmentPersistence.findByAssetTagId(assetTagId));
		}

		return tagAssignments;
	}

}
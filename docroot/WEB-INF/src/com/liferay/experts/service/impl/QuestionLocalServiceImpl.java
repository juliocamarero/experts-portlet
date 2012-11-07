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

import com.liferay.experts.model.Question;
import com.liferay.experts.model.QuestionAssignment;
import com.liferay.experts.model.TagAssignment;
import com.liferay.experts.service.base.QuestionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;

import java.util.Date;
import java.util.List;

/**
 * @author Ryan Park
 */
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {

	public Question addQuestion(
			long userId, String title, String content, Date dueDate,
			JSONObject data, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long questionId = counterLocalService.increment();

		Question question = questionPersistence.create(questionId);

		question.setCompanyId(user.getCompanyId());
		question.setUserId(user.getUserId());
		question.setUserName(user.getFullName());
		question.setCreateDate(now);
		question.setModifiedDate(now);
		question.setTitle(title);
		question.setContent(content);
		question.setDueDate(dueDate);

		if (data != null) {
			question.setData(data.toString());
		}

		questionPersistence.update(question, false);

		updateAsset(user, question, serviceContext.getAssetTagNames());

		updateQuestionAssignments(question, serviceContext.getAssetTagNames());

		return question;
	}

	public Question updateQuestion(
			long questionId, String title, String content, Date dueDate,
			JSONObject data)
		throws PortalException, SystemException {

		Question question = questionPersistence.findByPrimaryKey(questionId);

		question.setModifiedDate(new Date());
		question.setTitle(title);
		question.setContent(content);
		question.setDueDate(dueDate);

		if (data != null) {
			question.setData(data.toString());
		}
		else {
			question.setData(StringPool.BLANK);
		}

		questionPersistence.update(question, false);

		return question;
	}

	private void updateAsset(
			User user, Question question, String[] assetTagNames)
		throws PortalException, SystemException {

		long[] assetCategoryIds = new long[0];

		Group group = groupLocalService.getCompanyGroup(user.getCompanyId());

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			user.getUserId(), group.getGroupId(), question.getCreateDate(),
			question.getModifiedDate(), Question.class.getName(),
			question.getQuestionId(), question.getUuid(), 0, assetCategoryIds,
			assetTagNames, true, null, null, null, ContentTypes.TEXT_HTML,
			question.getTitle(), question.getContent(), question.getTitle(),
			null, null, 0, 0, null, false);
	}

	private void updateQuestionAssignments(
			Question question, String[] assetTagNames)
		throws PortalException, SystemException {

		questionAssignmentLocalService.deleteQuestionAssignments(
			question.getQuestionId(), true);

		List<TagAssignment> tagAssignments =
			tagAssignmentLocalService.getTagAssignments(
				question.getCompanyId(), assetTagNames);

		for (TagAssignment tagAssignment : tagAssignments) {
			QuestionAssignment questionAssignment =
				questionAssignmentPersistence.fetchByUI_QI(
					tagAssignment.getUserId(), question.getQuestionId());

			if (questionAssignment == null) {
				questionAssignmentLocalService.addQuestionAssignment(
					tagAssignment.getUserId(), question.getQuestionId(), true);
			}
			else {
				questionAssignmentLocalService.updateQuestionAssignment(
					questionAssignment.getQuestionAssignmentId(), true);
			}
		}
	}

}
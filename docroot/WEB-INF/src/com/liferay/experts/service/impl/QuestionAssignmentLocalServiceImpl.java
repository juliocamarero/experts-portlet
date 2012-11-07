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

import com.liferay.experts.model.QuestionAssignment;
import com.liferay.experts.service.base.QuestionAssignmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.Date;
import java.util.List;

/**
 * @author Ryan Park
 */
public class QuestionAssignmentLocalServiceImpl
	extends QuestionAssignmentLocalServiceBaseImpl {

	public QuestionAssignment addQuestionAssignment(
			long userId, long questionId, boolean locked)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long questionAssignmentId = counterLocalService.increment();

		QuestionAssignment questionAssignment =
			questionAssignmentPersistence.create(questionAssignmentId);

		questionAssignment.setCompanyId(user.getCompanyId());
		questionAssignment.setUserId(user.getUserId());
		questionAssignment.setUserName(user.getFullName());
		questionAssignment.setModifiedDate(now);
		questionAssignment.setQuestionId(questionId);
		questionAssignment.setLocked(locked);

		questionAssignmentPersistence.update(questionAssignment, false);

		return questionAssignment;
	}

	public void deleteQuestionAssignments(long questionId, boolean locked)
		throws PortalException, SystemException {

		List<QuestionAssignment> questionAssignments =
			questionAssignmentPersistence.findByQI_L(questionId, locked);

		for (QuestionAssignment questionAssignment : questionAssignments) {
			questionAssignmentPersistence.remove(
				questionAssignment.getQuestionAssignmentId());
		}
	}

	public List<QuestionAssignment> getQuestionAssignments(
			long userId, int start, int end)
		throws SystemException {

		return questionAssignmentPersistence.findByUserId(userId);
	}

	public int getQuestionAssignmentsCount(long userId) throws SystemException {
		return questionAssignmentPersistence.countByUserId(userId);
	}

	public QuestionAssignment updateQuestionAssignment(
			long questionAssignmentId, boolean locked)
		throws PortalException, SystemException {

		QuestionAssignment questionAssignment =
			questionAssignmentPersistence.findByPrimaryKey(
				questionAssignmentId);

		questionAssignment.setModifiedDate(new Date());
		questionAssignment.setLocked(locked);

		questionAssignmentPersistence.update(questionAssignment, false);

		return questionAssignment;
	}

}
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

import com.liferay.experts.model.Answer;
import com.liferay.experts.service.base.AnswerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

import java.util.Date;

/**
 * @author Ryan Park
 */
public class AnswerLocalServiceImpl extends AnswerLocalServiceBaseImpl {

	public Answer addAnswer(
			long userId, long questionId, String content, JSONObject data)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long answerId = counterLocalService.increment();

		Answer answer = answerPersistence.create(answerId);

		answer.setCompanyId(user.getCompanyId());
		answer.setUserId(user.getUserId());
		answer.setUserName(user.getFullName());
		answer.setCreateDate(now);
		answer.setModifiedDate(now);
		answer.setQuestionId(questionId);
		answer.setContent(content);

		if (data != null) {
			answer.setData(data.toString());
		}

		answerPersistence.update(answer, false);

		return answer;
	}

	public Answer fetchAnswerByQuestionId(long questionId)
		throws SystemException {

		return answerPersistence.fetchByQuestionId(questionId);
	}

	public Answer updateAnswer(long answerId, String content, JSONObject data)
		throws PortalException, SystemException {

		Answer answer = answerPersistence.findByPrimaryKey(answerId);

		answer.setModifiedDate(new Date());
		answer.setContent(content);

		if (data != null) {
			answer.setData(data.toString());
		}
		else {
			answer.setData(StringPool.BLANK);
		}

		answerPersistence.update(answer, false);

		return answer;
	}

}
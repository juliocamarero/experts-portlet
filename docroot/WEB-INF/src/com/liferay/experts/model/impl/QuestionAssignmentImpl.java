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

package com.liferay.experts.model.impl;

import com.liferay.experts.model.Question;
import com.liferay.experts.service.QuestionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Ryan Park
 */
public class QuestionAssignmentImpl extends QuestionAssignmentBaseImpl {

	public QuestionAssignmentImpl() {
	}

	public Question getQuestion() throws PortalException, SystemException {
		return QuestionLocalServiceUtil.getQuestion(getQuestionId());
	}

}
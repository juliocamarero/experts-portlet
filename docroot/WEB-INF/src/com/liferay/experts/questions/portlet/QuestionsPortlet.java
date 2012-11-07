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

package com.liferay.experts.questions.portlet;

import com.liferay.experts.model.Answer;
import com.liferay.experts.service.AnswerLocalServiceUtil;
import com.liferay.experts.service.QuestionLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Ryan Park
 */
public class QuestionsPortlet extends MVCPortlet {

	public void addQuestion(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String title = ParamUtil.getString(actionRequest, "title");
		String content = ParamUtil.getString(actionRequest, "content");
		String data = ParamUtil.getString(actionRequest, "data");

		JSONObject jsonObject = null;

		if (Validator.isNotNull(data)) {
			jsonObject = JSONFactoryUtil.createJSONObject(data);
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		QuestionLocalServiceUtil.addQuestion(
			themeDisplay.getUserId(), title, content, null, jsonObject,
			serviceContext);
	}

	public void updateAnswer(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {

		long questionId = ParamUtil.getLong(actionRequest, "questionId");
		String content = ParamUtil.getString(actionRequest, "content");
		String data = ParamUtil.getString(actionRequest, "data");

		JSONObject jsonObject = null;

		if (Validator.isNotNull(data)) {
			jsonObject = JSONFactoryUtil.createJSONObject(data);
		}

		Answer answer = AnswerLocalServiceUtil.fetchAnswerByQuestionId(
			questionId);

		if (answer == null) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			AnswerLocalServiceUtil.addAnswer(
				themeDisplay.getUserId(), questionId, content, jsonObject);
		}
		else {
			AnswerLocalServiceUtil.updateAnswer(
				answer.getAnswerId(), content, jsonObject);
		}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
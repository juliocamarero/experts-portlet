<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String mode = ParamUtil.getString(request, "mode", "view");

long questionId = ParamUtil.getLong(request, "questionId");

Question question = QuestionLocalServiceUtil.getQuestion(questionId);

Answer answer = AnswerLocalServiceUtil.fetchAnswerByQuestionId(question.getQuestionId());
%>

<div class="question-container">
	<div class="answer-label">
		<liferay-ui:message key="label.answer" />
	</div>
	<h1 class="title"><%= question.getTitle() %></h1>

	<div class="question">
		<%= question.getContent() %>
	</div>
</div>

<div class="answer-container">
	<div class="answer-label">
		<liferay-ui:message key="label.answer" />
	</div>

	<c:choose>
		<c:when test='<%= mode.equals("edit") || (answer == null) %>'>
			<liferay-portlet:actionURL name="updateAnswer" var="updateAnswerURL" />

			<aui:form action="<%= updateAnswerURL %>" method="post" name="fm">
				<aui:input name="mvcPath" type="hidden" value="/questions/view_questions.jsp" />

				<liferay-portlet:renderURL var="viewQuestionURL">
					<portlet:param name="mvcPath" value="/questions/view_question.jsp" />
					<portlet:param name="mode" value="view" />
					<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<aui:input name="redirect" type="hidden" value="<%= viewQuestionURL %>" />
				<aui:input name="mode" type="hidden" value="edit" />
				<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />

				<aui:model-context bean="<%= answer %>" model="<%= Answer.class %>" />

				<aui:input name="content" />

				<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>
			</aui:form>
		</c:when>
		<c:otherwise>
			<div class="answer">
				<%= answer.getContent() %>
			</div>

			<div class="actions">
				<liferay-portlet:renderURL var="editAnswerURL">
					<portlet:param name="mvcPath" value="/questions/view_question.jsp" />
					<portlet:param name="mode" value="edit" />
					<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<a href="<%= editAnswerURL %>"><liferay-ui:message key="improve-answer" /></a>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<div class="statistics">
</div>

<div class="discussion">
	<portlet:actionURL name="updateDiscussion" var="updateDiscussionURL" />

	<liferay-ui:discussion
		className="<%= Question.class.getName() %>"
		classPK="<%= question.getQuestionId() %>"
		formAction="<%= updateDiscussionURL %>"
		formName='<%= "fm" + question.getQuestionId() %>'
		ratingsEnabled="<%= false %>"
		redirect="<%= currentURL %>"
		subject="<%= question.getTitle() %>"
		userId="<%= question.getUserId() %>"
	/>
</div>
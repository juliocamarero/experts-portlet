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

<liferay-ui:header
	title="latest-questions"
/>

<liferay-ui:search-container
	emptyResultsMessage="no-questions-were-found"
>
	<liferay-ui:search-container-results
		results="<%= QuestionLocalServiceUtil.getQuestions(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= QuestionLocalServiceUtil.getQuestionsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.experts.model.Question"
		keyProperty="questionId"
		modelVar="question"
	>
		<liferay-ui:search-container-column-text>
			<div class="title">
				<liferay-portlet:renderURL var="viewQuestionURL">
					<portlet:param name="mvcPath" value="/questions/view_question.jsp" />
					<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<a href="<%= viewQuestionURL %>"><%= HtmlUtil.escape(question.getTitle()) %></a>
			</div>

			<div class="preview-content">
				<%= StringUtil.shorten(HtmlUtil.stripHtml(question.getContent()), 200) %>
			</div>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
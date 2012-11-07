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

<portlet:actionURL name="addQuestion" var="addQuestionURL" />

<aui:form action="<%= addQuestionURL %>" method="post" name="fm">
	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/questions/view.jsp" />
	</portlet:renderURL>

	<aui:input name="redirect" type="hidden" value="<%= viewURL %>" />

	<liferay-ui:header
		backURL="viewURL"
		title="new-question"
	/>

	<aui:model-context model="<%= Question.class %>" />

	<div class="instructions">
		<liferay-ui:message key="describe-the-problem-in-140-characters-or-less,-think-twitter" />
	</div>

	<aui:input label="<%= StringPool.BLANK %>" name="title" />

	<div class="instructions">
		<liferay-ui:message key="whats-the-beef" />
	</div>

	<aui:input label="<%= StringPool.BLANK %>" name="content" />

	<div class="instructions">
		<liferay-ui:message key="how-may-i-direct-your-issue" />

		<span>
			<liferay-ui:message key="using-a-couple-good-tags-greatly-increases-your-changes-of-finding-an-answer" />
		</span>
	</div>

	<aui:input label="<%= StringPool.BLANK %>" name="tags" type="assetTags" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
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
String tabs1 = ParamUtil.getString(request, "tabs1", "dashboard");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("tabs1", tabs1);
%>

<liferay-portlet:renderURL var="editQuestionURL">
	<portlet:param name="mvcPath" value="/questions/edit_question.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:tabs
	names="dashboard,latest,ask-a-question"
	param="tabs1"
	url="<%= portletURL.toString() %>"
	url2="<%= editQuestionURL %>"
/>

<c:choose>
	<c:when test='<%= tabs1.equals("dashboard") %>'>
		<liferay-util:include page="/questions/view_dashboard.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/questions/view_questions.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>
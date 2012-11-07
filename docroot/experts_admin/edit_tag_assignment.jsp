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

<liferay-util:include page="/experts_admin/toolbar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<portlet:actionURL name="addTagAssignment" var="addTagAssignmentURL" />

<aui:form action="<%= addTagAssignmentURL %>" method="post" name="fm">
	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/experts_admin/view.jsp" />
	</portlet:renderURL>

	<aui:input name="redirect" type="hidden" value="<%= viewURL %>" />

	<liferay-ui:header
		title="new-tag-assignment"
	/>

	<aui:select label="user" name="userId">
		<aui:option label="" value="0" />

		<%
		List<User> users = UserLocalServiceUtil.getCompanyUsers(themeDisplay.getCompanyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (User selUser : users) {
			if (selUser.isDefaultUser()) {
				continue;
			}
		%>

			<aui:option label="<%= HtmlUtil.escape(selUser.getFullName()) %>" value="<%= selUser.getUserId() %>" />

		<%
		}
		%>

	</aui:select>

	<aui:input label="tag" name="assetTagName" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
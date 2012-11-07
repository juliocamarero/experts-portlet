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
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<div class="lfr-portlet-toolbar">
	<liferay-portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/experts_admin/view.jsp" />
	</liferay-portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewURL %>"><liferay-ui:message key="view-all" /></a>
	</span>

	<liferay-portlet:renderURL var="addTagAssignmentURL">
		<portlet:param name="mvcPath" value="/experts_admin/edit_tag_assignment.jsp" />
		<portlet:param name="backURL" value="<%= viewURL %>" />
	</liferay-portlet:renderURL>

	<span class="lfr-toolbar-button add-button <%= toolbarItem.equals("add") ? "current" : StringPool.BLANK %>">
		<a href="<%= addTagAssignmentURL %>"><liferay-ui:message key="add" /></a>
	</span>
</div>
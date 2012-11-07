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

<liferay-ui:search-container
	emptyResultsMessage="no-tag-assignments-were-found"
>
	<liferay-ui:search-container-results
		results="<%= TagAssignmentLocalServiceUtil.getTagAssignments(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= TagAssignmentLocalServiceUtil.getTagAssignmentsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.experts.model.TagAssignment"
		escapedModel="<%= true %>"
		keyProperty="tagAssignmentId"
		modelVar="tagAssignment"
	>
		<liferay-ui:search-container-column-text
			name="tag"
			value="<%= tagAssignment.getAssetTagName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="user"
			value="<%= PortalUtil.getUserName(tagAssignment.getUserId(), tagAssignment.getUserName()) %>"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
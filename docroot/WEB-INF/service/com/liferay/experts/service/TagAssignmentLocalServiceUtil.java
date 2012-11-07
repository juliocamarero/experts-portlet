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

package com.liferay.experts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the tag assignment local service. This utility wraps {@link com.liferay.experts.service.impl.TagAssignmentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignmentLocalService
 * @see com.liferay.experts.service.base.TagAssignmentLocalServiceBaseImpl
 * @see com.liferay.experts.service.impl.TagAssignmentLocalServiceImpl
 * @generated
 */
public class TagAssignmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.experts.service.impl.TagAssignmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tag assignment to the database. Also notifies the appropriate model listeners.
	*
	* @param tagAssignment the tag assignment
	* @return the tag assignment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment addTagAssignment(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTagAssignment(tagAssignment);
	}

	/**
	* Creates a new tag assignment with the primary key. Does not add the tag assignment to the database.
	*
	* @param tagAssignmentId the primary key for the new tag assignment
	* @return the new tag assignment
	*/
	public static com.liferay.experts.model.TagAssignment createTagAssignment(
		long tagAssignmentId) {
		return getService().createTagAssignment(tagAssignmentId);
	}

	/**
	* Deletes the tag assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment that was removed
	* @throws PortalException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment deleteTagAssignment(
		long tagAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTagAssignment(tagAssignmentId);
	}

	/**
	* Deletes the tag assignment from the database. Also notifies the appropriate model listeners.
	*
	* @param tagAssignment the tag assignment
	* @return the tag assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment deleteTagAssignment(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTagAssignment(tagAssignment);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.experts.model.TagAssignment fetchTagAssignment(
		long tagAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTagAssignment(tagAssignmentId);
	}

	/**
	* Returns the tag assignment with the primary key.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment
	* @throws PortalException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment getTagAssignment(
		long tagAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagAssignment(tagAssignmentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tag assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @return the range of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> getTagAssignments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagAssignments(start, end);
	}

	/**
	* Returns the number of tag assignments.
	*
	* @return the number of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int getTagAssignmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagAssignmentsCount();
	}

	/**
	* Updates the tag assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tagAssignment the tag assignment
	* @return the tag assignment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment updateTagAssignment(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTagAssignment(tagAssignment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.experts.model.TagAssignment addTagAssignment(
		long userId, java.lang.String assetTagName, boolean locked)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addTagAssignment(userId, assetTagName, locked);
	}

	public static java.util.List<com.liferay.experts.model.TagAssignment> getTagAssignments(
		long companyId, java.lang.String[] assetTagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagAssignments(companyId, assetTagNames);
	}

	public static void clearService() {
		_service = null;
	}

	public static TagAssignmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TagAssignmentLocalService.class.getName());

			if (invokableLocalService instanceof TagAssignmentLocalService) {
				_service = (TagAssignmentLocalService)invokableLocalService;
			}
			else {
				_service = new TagAssignmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TagAssignmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TagAssignmentLocalService service) {
	}

	private static TagAssignmentLocalService _service;
}
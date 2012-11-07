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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link QuestionAssignmentLocalService}.
 * </p>
 *
 * @author    Ryan Park
 * @see       QuestionAssignmentLocalService
 * @generated
 */
public class QuestionAssignmentLocalServiceWrapper
	implements QuestionAssignmentLocalService,
		ServiceWrapper<QuestionAssignmentLocalService> {
	public QuestionAssignmentLocalServiceWrapper(
		QuestionAssignmentLocalService questionAssignmentLocalService) {
		_questionAssignmentLocalService = questionAssignmentLocalService;
	}

	/**
	* Adds the question assignment to the database. Also notifies the appropriate model listeners.
	*
	* @param questionAssignment the question assignment
	* @return the question assignment that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment addQuestionAssignment(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.addQuestionAssignment(questionAssignment);
	}

	/**
	* Creates a new question assignment with the primary key. Does not add the question assignment to the database.
	*
	* @param questionAssignmentId the primary key for the new question assignment
	* @return the new question assignment
	*/
	public com.liferay.experts.model.QuestionAssignment createQuestionAssignment(
		long questionAssignmentId) {
		return _questionAssignmentLocalService.createQuestionAssignment(questionAssignmentId);
	}

	/**
	* Deletes the question assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment that was removed
	* @throws PortalException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment deleteQuestionAssignment(
		long questionAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.deleteQuestionAssignment(questionAssignmentId);
	}

	/**
	* Deletes the question assignment from the database. Also notifies the appropriate model listeners.
	*
	* @param questionAssignment the question assignment
	* @return the question assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment deleteQuestionAssignment(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.deleteQuestionAssignment(questionAssignment);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionAssignmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.experts.model.QuestionAssignment fetchQuestionAssignment(
		long questionAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.fetchQuestionAssignment(questionAssignmentId);
	}

	/**
	* Returns the question assignment with the primary key.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment
	* @throws PortalException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment getQuestionAssignment(
		long questionAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getQuestionAssignment(questionAssignmentId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the question assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @return the range of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> getQuestionAssignments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getQuestionAssignments(start, end);
	}

	/**
	* Returns the number of question assignments.
	*
	* @return the number of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int getQuestionAssignmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getQuestionAssignmentsCount();
	}

	/**
	* Updates the question assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionAssignment the question assignment
	* @return the question assignment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment updateQuestionAssignment(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.updateQuestionAssignment(questionAssignment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _questionAssignmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_questionAssignmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionAssignmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.liferay.experts.model.QuestionAssignment addQuestionAssignment(
		long userId, long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.addQuestionAssignment(userId,
			questionId, locked);
	}

	public void deleteQuestionAssignments(long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_questionAssignmentLocalService.deleteQuestionAssignments(questionId,
			locked);
	}

	public java.util.List<com.liferay.experts.model.QuestionAssignment> getQuestionAssignments(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getQuestionAssignments(userId,
			start, end);
	}

	public int getQuestionAssignmentsCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.getQuestionAssignmentsCount(userId);
	}

	public com.liferay.experts.model.QuestionAssignment updateQuestionAssignment(
		long questionAssignmentId, boolean locked)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignmentLocalService.updateQuestionAssignment(questionAssignmentId,
			locked);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public QuestionAssignmentLocalService getWrappedQuestionAssignmentLocalService() {
		return _questionAssignmentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedQuestionAssignmentLocalService(
		QuestionAssignmentLocalService questionAssignmentLocalService) {
		_questionAssignmentLocalService = questionAssignmentLocalService;
	}

	public QuestionAssignmentLocalService getWrappedService() {
		return _questionAssignmentLocalService;
	}

	public void setWrappedService(
		QuestionAssignmentLocalService questionAssignmentLocalService) {
		_questionAssignmentLocalService = questionAssignmentLocalService;
	}

	private QuestionAssignmentLocalService _questionAssignmentLocalService;
}
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
 * This class is a wrapper for {@link QuestionAssignmentService}.
 * </p>
 *
 * @author    Ryan Park
 * @see       QuestionAssignmentService
 * @generated
 */
public class QuestionAssignmentServiceWrapper
	implements QuestionAssignmentService,
		ServiceWrapper<QuestionAssignmentService> {
	public QuestionAssignmentServiceWrapper(
		QuestionAssignmentService questionAssignmentService) {
		_questionAssignmentService = questionAssignmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _questionAssignmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_questionAssignmentService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionAssignmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public QuestionAssignmentService getWrappedQuestionAssignmentService() {
		return _questionAssignmentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedQuestionAssignmentService(
		QuestionAssignmentService questionAssignmentService) {
		_questionAssignmentService = questionAssignmentService;
	}

	public QuestionAssignmentService getWrappedService() {
		return _questionAssignmentService;
	}

	public void setWrappedService(
		QuestionAssignmentService questionAssignmentService) {
		_questionAssignmentService = questionAssignmentService;
	}

	private QuestionAssignmentService _questionAssignmentService;
}
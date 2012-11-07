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

package com.liferay.experts.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QuestionAssignment}.
 * </p>
 *
 * @author    Ryan Park
 * @see       QuestionAssignment
 * @generated
 */
public class QuestionAssignmentWrapper implements QuestionAssignment,
	ModelWrapper<QuestionAssignment> {
	public QuestionAssignmentWrapper(QuestionAssignment questionAssignment) {
		_questionAssignment = questionAssignment;
	}

	public Class<?> getModelClass() {
		return QuestionAssignment.class;
	}

	public String getModelClassName() {
		return QuestionAssignment.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionAssignmentId", getQuestionAssignmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("questionId", getQuestionId());
		attributes.put("locked", getLocked());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionAssignmentId = (Long)attributes.get("questionAssignmentId");

		if (questionAssignmentId != null) {
			setQuestionAssignmentId(questionAssignmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Boolean locked = (Boolean)attributes.get("locked");

		if (locked != null) {
			setLocked(locked);
		}
	}

	/**
	* Returns the primary key of this question assignment.
	*
	* @return the primary key of this question assignment
	*/
	public long getPrimaryKey() {
		return _questionAssignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question assignment.
	*
	* @param primaryKey the primary key of this question assignment
	*/
	public void setPrimaryKey(long primaryKey) {
		_questionAssignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question assignment ID of this question assignment.
	*
	* @return the question assignment ID of this question assignment
	*/
	public long getQuestionAssignmentId() {
		return _questionAssignment.getQuestionAssignmentId();
	}

	/**
	* Sets the question assignment ID of this question assignment.
	*
	* @param questionAssignmentId the question assignment ID of this question assignment
	*/
	public void setQuestionAssignmentId(long questionAssignmentId) {
		_questionAssignment.setQuestionAssignmentId(questionAssignmentId);
	}

	/**
	* Returns the company ID of this question assignment.
	*
	* @return the company ID of this question assignment
	*/
	public long getCompanyId() {
		return _questionAssignment.getCompanyId();
	}

	/**
	* Sets the company ID of this question assignment.
	*
	* @param companyId the company ID of this question assignment
	*/
	public void setCompanyId(long companyId) {
		_questionAssignment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this question assignment.
	*
	* @return the user ID of this question assignment
	*/
	public long getUserId() {
		return _questionAssignment.getUserId();
	}

	/**
	* Sets the user ID of this question assignment.
	*
	* @param userId the user ID of this question assignment
	*/
	public void setUserId(long userId) {
		_questionAssignment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this question assignment.
	*
	* @return the user uuid of this question assignment
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignment.getUserUuid();
	}

	/**
	* Sets the user uuid of this question assignment.
	*
	* @param userUuid the user uuid of this question assignment
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_questionAssignment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this question assignment.
	*
	* @return the user name of this question assignment
	*/
	public java.lang.String getUserName() {
		return _questionAssignment.getUserName();
	}

	/**
	* Sets the user name of this question assignment.
	*
	* @param userName the user name of this question assignment
	*/
	public void setUserName(java.lang.String userName) {
		_questionAssignment.setUserName(userName);
	}

	/**
	* Returns the modified date of this question assignment.
	*
	* @return the modified date of this question assignment
	*/
	public java.util.Date getModifiedDate() {
		return _questionAssignment.getModifiedDate();
	}

	/**
	* Sets the modified date of this question assignment.
	*
	* @param modifiedDate the modified date of this question assignment
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_questionAssignment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the question ID of this question assignment.
	*
	* @return the question ID of this question assignment
	*/
	public long getQuestionId() {
		return _questionAssignment.getQuestionId();
	}

	/**
	* Sets the question ID of this question assignment.
	*
	* @param questionId the question ID of this question assignment
	*/
	public void setQuestionId(long questionId) {
		_questionAssignment.setQuestionId(questionId);
	}

	/**
	* Returns the locked of this question assignment.
	*
	* @return the locked of this question assignment
	*/
	public boolean getLocked() {
		return _questionAssignment.getLocked();
	}

	/**
	* Returns <code>true</code> if this question assignment is locked.
	*
	* @return <code>true</code> if this question assignment is locked; <code>false</code> otherwise
	*/
	public boolean isLocked() {
		return _questionAssignment.isLocked();
	}

	/**
	* Sets whether this question assignment is locked.
	*
	* @param locked the locked of this question assignment
	*/
	public void setLocked(boolean locked) {
		_questionAssignment.setLocked(locked);
	}

	public boolean isNew() {
		return _questionAssignment.isNew();
	}

	public void setNew(boolean n) {
		_questionAssignment.setNew(n);
	}

	public boolean isCachedModel() {
		return _questionAssignment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_questionAssignment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _questionAssignment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _questionAssignment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_questionAssignment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _questionAssignment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_questionAssignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionAssignmentWrapper((QuestionAssignment)_questionAssignment.clone());
	}

	public int compareTo(
		com.liferay.experts.model.QuestionAssignment questionAssignment) {
		return _questionAssignment.compareTo(questionAssignment);
	}

	@Override
	public int hashCode() {
		return _questionAssignment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.experts.model.QuestionAssignment> toCacheModel() {
		return _questionAssignment.toCacheModel();
	}

	public com.liferay.experts.model.QuestionAssignment toEscapedModel() {
		return new QuestionAssignmentWrapper(_questionAssignment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _questionAssignment.toString();
	}

	public java.lang.String toXmlString() {
		return _questionAssignment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_questionAssignment.persist();
	}

	public com.liferay.experts.model.Question getQuestion()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionAssignment.getQuestion();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public QuestionAssignment getWrappedQuestionAssignment() {
		return _questionAssignment;
	}

	public QuestionAssignment getWrappedModel() {
		return _questionAssignment;
	}

	public void resetOriginalValues() {
		_questionAssignment.resetOriginalValues();
	}

	private QuestionAssignment _questionAssignment;
}
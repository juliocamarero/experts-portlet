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
 * This class is a wrapper for {@link Question}.
 * </p>
 *
 * @author    Ryan Park
 * @see       Question
 * @generated
 */
public class QuestionWrapper implements Question, ModelWrapper<Question> {
	public QuestionWrapper(Question question) {
		_question = question;
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("questionId", getQuestionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("dueDate", getDueDate());
		attributes.put("data", getData());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	* Returns the primary key of this question.
	*
	* @return the primary key of this question
	*/
	public long getPrimaryKey() {
		return _question.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question.
	*
	* @param primaryKey the primary key of this question
	*/
	public void setPrimaryKey(long primaryKey) {
		_question.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this question.
	*
	* @return the uuid of this question
	*/
	public java.lang.String getUuid() {
		return _question.getUuid();
	}

	/**
	* Sets the uuid of this question.
	*
	* @param uuid the uuid of this question
	*/
	public void setUuid(java.lang.String uuid) {
		_question.setUuid(uuid);
	}

	/**
	* Returns the question ID of this question.
	*
	* @return the question ID of this question
	*/
	public long getQuestionId() {
		return _question.getQuestionId();
	}

	/**
	* Sets the question ID of this question.
	*
	* @param questionId the question ID of this question
	*/
	public void setQuestionId(long questionId) {
		_question.setQuestionId(questionId);
	}

	/**
	* Returns the company ID of this question.
	*
	* @return the company ID of this question
	*/
	public long getCompanyId() {
		return _question.getCompanyId();
	}

	/**
	* Sets the company ID of this question.
	*
	* @param companyId the company ID of this question
	*/
	public void setCompanyId(long companyId) {
		_question.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this question.
	*
	* @return the user ID of this question
	*/
	public long getUserId() {
		return _question.getUserId();
	}

	/**
	* Sets the user ID of this question.
	*
	* @param userId the user ID of this question
	*/
	public void setUserId(long userId) {
		_question.setUserId(userId);
	}

	/**
	* Returns the user uuid of this question.
	*
	* @return the user uuid of this question
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _question.getUserUuid();
	}

	/**
	* Sets the user uuid of this question.
	*
	* @param userUuid the user uuid of this question
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_question.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this question.
	*
	* @return the user name of this question
	*/
	public java.lang.String getUserName() {
		return _question.getUserName();
	}

	/**
	* Sets the user name of this question.
	*
	* @param userName the user name of this question
	*/
	public void setUserName(java.lang.String userName) {
		_question.setUserName(userName);
	}

	/**
	* Returns the create date of this question.
	*
	* @return the create date of this question
	*/
	public java.util.Date getCreateDate() {
		return _question.getCreateDate();
	}

	/**
	* Sets the create date of this question.
	*
	* @param createDate the create date of this question
	*/
	public void setCreateDate(java.util.Date createDate) {
		_question.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this question.
	*
	* @return the modified date of this question
	*/
	public java.util.Date getModifiedDate() {
		return _question.getModifiedDate();
	}

	/**
	* Sets the modified date of this question.
	*
	* @param modifiedDate the modified date of this question
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_question.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this question.
	*
	* @return the title of this question
	*/
	public java.lang.String getTitle() {
		return _question.getTitle();
	}

	/**
	* Sets the title of this question.
	*
	* @param title the title of this question
	*/
	public void setTitle(java.lang.String title) {
		_question.setTitle(title);
	}

	/**
	* Returns the content of this question.
	*
	* @return the content of this question
	*/
	public java.lang.String getContent() {
		return _question.getContent();
	}

	/**
	* Sets the content of this question.
	*
	* @param content the content of this question
	*/
	public void setContent(java.lang.String content) {
		_question.setContent(content);
	}

	/**
	* Returns the due date of this question.
	*
	* @return the due date of this question
	*/
	public java.util.Date getDueDate() {
		return _question.getDueDate();
	}

	/**
	* Sets the due date of this question.
	*
	* @param dueDate the due date of this question
	*/
	public void setDueDate(java.util.Date dueDate) {
		_question.setDueDate(dueDate);
	}

	/**
	* Returns the data of this question.
	*
	* @return the data of this question
	*/
	public java.lang.String getData() {
		return _question.getData();
	}

	/**
	* Sets the data of this question.
	*
	* @param data the data of this question
	*/
	public void setData(java.lang.String data) {
		_question.setData(data);
	}

	public boolean isNew() {
		return _question.isNew();
	}

	public void setNew(boolean n) {
		_question.setNew(n);
	}

	public boolean isCachedModel() {
		return _question.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_question.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _question.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _question.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_question.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _question.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_question.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionWrapper((Question)_question.clone());
	}

	public int compareTo(com.liferay.experts.model.Question question) {
		return _question.compareTo(question);
	}

	@Override
	public int hashCode() {
		return _question.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.experts.model.Question> toCacheModel() {
		return _question.toCacheModel();
	}

	public com.liferay.experts.model.Question toEscapedModel() {
		return new QuestionWrapper(_question.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _question.toString();
	}

	public java.lang.String toXmlString() {
		return _question.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_question.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Question getWrappedQuestion() {
		return _question;
	}

	public Question getWrappedModel() {
		return _question;
	}

	public void resetOriginalValues() {
		_question.resetOriginalValues();
	}

	private Question _question;
}
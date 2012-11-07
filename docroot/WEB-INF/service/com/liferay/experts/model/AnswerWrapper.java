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
 * This class is a wrapper for {@link Answer}.
 * </p>
 *
 * @author    Ryan Park
 * @see       Answer
 * @generated
 */
public class AnswerWrapper implements Answer, ModelWrapper<Answer> {
	public AnswerWrapper(Answer answer) {
		_answer = answer;
	}

	public Class<?> getModelClass() {
		return Answer.class;
	}

	public String getModelClassName() {
		return Answer.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("answerId", getAnswerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("questionId", getQuestionId());
		attributes.put("content", getContent());
		attributes.put("data", getData());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
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

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	* Returns the primary key of this answer.
	*
	* @return the primary key of this answer
	*/
	public long getPrimaryKey() {
		return _answer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this answer.
	*
	* @param primaryKey the primary key of this answer
	*/
	public void setPrimaryKey(long primaryKey) {
		_answer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this answer.
	*
	* @return the uuid of this answer
	*/
	public java.lang.String getUuid() {
		return _answer.getUuid();
	}

	/**
	* Sets the uuid of this answer.
	*
	* @param uuid the uuid of this answer
	*/
	public void setUuid(java.lang.String uuid) {
		_answer.setUuid(uuid);
	}

	/**
	* Returns the answer ID of this answer.
	*
	* @return the answer ID of this answer
	*/
	public long getAnswerId() {
		return _answer.getAnswerId();
	}

	/**
	* Sets the answer ID of this answer.
	*
	* @param answerId the answer ID of this answer
	*/
	public void setAnswerId(long answerId) {
		_answer.setAnswerId(answerId);
	}

	/**
	* Returns the company ID of this answer.
	*
	* @return the company ID of this answer
	*/
	public long getCompanyId() {
		return _answer.getCompanyId();
	}

	/**
	* Sets the company ID of this answer.
	*
	* @param companyId the company ID of this answer
	*/
	public void setCompanyId(long companyId) {
		_answer.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this answer.
	*
	* @return the user ID of this answer
	*/
	public long getUserId() {
		return _answer.getUserId();
	}

	/**
	* Sets the user ID of this answer.
	*
	* @param userId the user ID of this answer
	*/
	public void setUserId(long userId) {
		_answer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this answer.
	*
	* @return the user uuid of this answer
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _answer.getUserUuid();
	}

	/**
	* Sets the user uuid of this answer.
	*
	* @param userUuid the user uuid of this answer
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_answer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this answer.
	*
	* @return the user name of this answer
	*/
	public java.lang.String getUserName() {
		return _answer.getUserName();
	}

	/**
	* Sets the user name of this answer.
	*
	* @param userName the user name of this answer
	*/
	public void setUserName(java.lang.String userName) {
		_answer.setUserName(userName);
	}

	/**
	* Returns the create date of this answer.
	*
	* @return the create date of this answer
	*/
	public java.util.Date getCreateDate() {
		return _answer.getCreateDate();
	}

	/**
	* Sets the create date of this answer.
	*
	* @param createDate the create date of this answer
	*/
	public void setCreateDate(java.util.Date createDate) {
		_answer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this answer.
	*
	* @return the modified date of this answer
	*/
	public java.util.Date getModifiedDate() {
		return _answer.getModifiedDate();
	}

	/**
	* Sets the modified date of this answer.
	*
	* @param modifiedDate the modified date of this answer
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_answer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the question ID of this answer.
	*
	* @return the question ID of this answer
	*/
	public long getQuestionId() {
		return _answer.getQuestionId();
	}

	/**
	* Sets the question ID of this answer.
	*
	* @param questionId the question ID of this answer
	*/
	public void setQuestionId(long questionId) {
		_answer.setQuestionId(questionId);
	}

	/**
	* Returns the content of this answer.
	*
	* @return the content of this answer
	*/
	public java.lang.String getContent() {
		return _answer.getContent();
	}

	/**
	* Sets the content of this answer.
	*
	* @param content the content of this answer
	*/
	public void setContent(java.lang.String content) {
		_answer.setContent(content);
	}

	/**
	* Returns the data of this answer.
	*
	* @return the data of this answer
	*/
	public java.lang.String getData() {
		return _answer.getData();
	}

	/**
	* Sets the data of this answer.
	*
	* @param data the data of this answer
	*/
	public void setData(java.lang.String data) {
		_answer.setData(data);
	}

	public boolean isNew() {
		return _answer.isNew();
	}

	public void setNew(boolean n) {
		_answer.setNew(n);
	}

	public boolean isCachedModel() {
		return _answer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_answer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _answer.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _answer.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_answer.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _answer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_answer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnswerWrapper((Answer)_answer.clone());
	}

	public int compareTo(com.liferay.experts.model.Answer answer) {
		return _answer.compareTo(answer);
	}

	@Override
	public int hashCode() {
		return _answer.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.experts.model.Answer> toCacheModel() {
		return _answer.toCacheModel();
	}

	public com.liferay.experts.model.Answer toEscapedModel() {
		return new AnswerWrapper(_answer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _answer.toString();
	}

	public java.lang.String toXmlString() {
		return _answer.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_answer.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Answer getWrappedAnswer() {
		return _answer;
	}

	public Answer getWrappedModel() {
		return _answer;
	}

	public void resetOriginalValues() {
		_answer.resetOriginalValues();
	}

	private Answer _answer;
}
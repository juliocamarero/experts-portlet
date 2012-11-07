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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Question service. Represents a row in the &quot;Experts_Question&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.experts.model.impl.QuestionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.experts.model.impl.QuestionImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see Question
 * @see com.liferay.experts.model.impl.QuestionImpl
 * @see com.liferay.experts.model.impl.QuestionModelImpl
 * @generated
 */
public interface QuestionModel extends AuditedModel, BaseModel<Question> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a question model instance should use the {@link Question} interface instead.
	 */

	/**
	 * Returns the primary key of this question.
	 *
	 * @return the primary key of this question
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this question.
	 *
	 * @param primaryKey the primary key of this question
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this question.
	 *
	 * @return the uuid of this question
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this question.
	 *
	 * @param uuid the uuid of this question
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the question ID of this question.
	 *
	 * @return the question ID of this question
	 */
	public long getQuestionId();

	/**
	 * Sets the question ID of this question.
	 *
	 * @param questionId the question ID of this question
	 */
	public void setQuestionId(long questionId);

	/**
	 * Returns the company ID of this question.
	 *
	 * @return the company ID of this question
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this question.
	 *
	 * @param companyId the company ID of this question
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this question.
	 *
	 * @return the user ID of this question
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this question.
	 *
	 * @param userId the user ID of this question
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this question.
	 *
	 * @return the user uuid of this question
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this question.
	 *
	 * @param userUuid the user uuid of this question
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this question.
	 *
	 * @return the user name of this question
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this question.
	 *
	 * @param userName the user name of this question
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this question.
	 *
	 * @return the create date of this question
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this question.
	 *
	 * @param createDate the create date of this question
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this question.
	 *
	 * @return the modified date of this question
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this question.
	 *
	 * @param modifiedDate the modified date of this question
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this question.
	 *
	 * @return the title of this question
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this question.
	 *
	 * @param title the title of this question
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this question.
	 *
	 * @return the content of this question
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this question.
	 *
	 * @param content the content of this question
	 */
	public void setContent(String content);

	/**
	 * Returns the due date of this question.
	 *
	 * @return the due date of this question
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this question.
	 *
	 * @param dueDate the due date of this question
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the data of this question.
	 *
	 * @return the data of this question
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this question.
	 *
	 * @param data the data of this question
	 */
	public void setData(String data);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Question question);

	public int hashCode();

	public CacheModel<Question> toCacheModel();

	public Question toEscapedModel();

	public String toString();

	public String toXmlString();
}
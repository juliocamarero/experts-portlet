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

import com.liferay.experts.service.QuestionAssignmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Park
 */
public class QuestionAssignmentClp extends BaseModelImpl<QuestionAssignment>
	implements QuestionAssignment {
	public QuestionAssignmentClp() {
	}

	public Class<?> getModelClass() {
		return QuestionAssignment.class;
	}

	public String getModelClassName() {
		return QuestionAssignment.class.getName();
	}

	public long getPrimaryKey() {
		return _questionAssignmentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setQuestionAssignmentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_questionAssignmentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getQuestionAssignmentId() {
		return _questionAssignmentId;
	}

	public void setQuestionAssignmentId(long questionAssignmentId) {
		_questionAssignmentId = questionAssignmentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public boolean getLocked() {
		return _locked;
	}

	public boolean isLocked() {
		return _locked;
	}

	public void setLocked(boolean locked) {
		_locked = locked;
	}

	public com.liferay.experts.model.Question getQuestion() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getQuestionAssignmentRemoteModel() {
		return _questionAssignmentRemoteModel;
	}

	public void setQuestionAssignmentRemoteModel(
		BaseModel<?> questionAssignmentRemoteModel) {
		_questionAssignmentRemoteModel = questionAssignmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionAssignmentLocalServiceUtil.addQuestionAssignment(this);
		}
		else {
			QuestionAssignmentLocalServiceUtil.updateQuestionAssignment(this);
		}
	}

	@Override
	public QuestionAssignment toEscapedModel() {
		return (QuestionAssignment)Proxy.newProxyInstance(QuestionAssignment.class.getClassLoader(),
			new Class[] { QuestionAssignment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionAssignmentClp clone = new QuestionAssignmentClp();

		clone.setQuestionAssignmentId(getQuestionAssignmentId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setModifiedDate(getModifiedDate());
		clone.setQuestionId(getQuestionId());
		clone.setLocked(getLocked());

		return clone;
	}

	public int compareTo(QuestionAssignment questionAssignment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				questionAssignment.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QuestionAssignmentClp questionAssignment = null;

		try {
			questionAssignment = (QuestionAssignmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = questionAssignment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{questionAssignmentId=");
		sb.append(getQuestionAssignmentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", locked=");
		sb.append(getLocked());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.experts.model.QuestionAssignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionAssignmentId</column-name><column-value><![CDATA[");
		sb.append(getQuestionAssignmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locked</column-name><column-value><![CDATA[");
		sb.append(getLocked());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _modifiedDate;
	private long _questionId;
	private boolean _locked;
	private BaseModel<?> _questionAssignmentRemoteModel;
}
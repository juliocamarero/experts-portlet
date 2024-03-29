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

package com.liferay.experts.model.impl;

import com.liferay.experts.model.QuestionAssignment;
import com.liferay.experts.model.QuestionAssignmentModel;
import com.liferay.experts.model.QuestionAssignmentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the QuestionAssignment service. Represents a row in the &quot;Experts_QuestionAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.experts.model.QuestionAssignmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuestionAssignmentImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see QuestionAssignmentImpl
 * @see com.liferay.experts.model.QuestionAssignment
 * @see com.liferay.experts.model.QuestionAssignmentModel
 * @generated
 */
@JSON(strict = true)
public class QuestionAssignmentModelImpl extends BaseModelImpl<QuestionAssignment>
	implements QuestionAssignmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a question assignment model instance should use the {@link com.liferay.experts.model.QuestionAssignment} interface instead.
	 */
	public static final String TABLE_NAME = "Experts_QuestionAssignment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "questionAssignmentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "questionId", Types.BIGINT },
			{ "locked", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Experts_QuestionAssignment (questionAssignmentId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,modifiedDate DATE null,questionId LONG,locked BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Experts_QuestionAssignment";
	public static final String ORDER_BY_JPQL = " ORDER BY questionAssignment.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Experts_QuestionAssignment.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.experts.model.QuestionAssignment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.experts.model.QuestionAssignment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.experts.model.QuestionAssignment"),
			true);
	public static long LOCKED_COLUMN_BITMASK = 1L;
	public static long QUESTIONID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static QuestionAssignment toModel(QuestionAssignmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		QuestionAssignment model = new QuestionAssignmentImpl();

		model.setQuestionAssignmentId(soapModel.getQuestionAssignmentId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setQuestionId(soapModel.getQuestionId());
		model.setLocked(soapModel.getLocked());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<QuestionAssignment> toModels(
		QuestionAssignmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<QuestionAssignment> models = new ArrayList<QuestionAssignment>(soapModels.length);

		for (QuestionAssignmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.experts.model.QuestionAssignment"));

	public QuestionAssignmentModelImpl() {
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

	public Class<?> getModelClass() {
		return QuestionAssignment.class;
	}

	public String getModelClassName() {
		return QuestionAssignment.class.getName();
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

	@JSON
	public long getQuestionAssignmentId() {
		return _questionAssignmentId;
	}

	public void setQuestionAssignmentId(long questionAssignmentId) {
		_questionAssignmentId = questionAssignmentId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_columnBitmask |= QUESTIONID_COLUMN_BITMASK;

		if (!_setOriginalQuestionId) {
			_setOriginalQuestionId = true;

			_originalQuestionId = _questionId;
		}

		_questionId = questionId;
	}

	public long getOriginalQuestionId() {
		return _originalQuestionId;
	}

	@JSON
	public boolean getLocked() {
		return _locked;
	}

	public boolean isLocked() {
		return _locked;
	}

	public void setLocked(boolean locked) {
		_columnBitmask |= LOCKED_COLUMN_BITMASK;

		if (!_setOriginalLocked) {
			_setOriginalLocked = true;

			_originalLocked = _locked;
		}

		_locked = locked;
	}

	public boolean getOriginalLocked() {
		return _originalLocked;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			QuestionAssignment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public QuestionAssignment toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (QuestionAssignment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		QuestionAssignmentImpl questionAssignmentImpl = new QuestionAssignmentImpl();

		questionAssignmentImpl.setQuestionAssignmentId(getQuestionAssignmentId());
		questionAssignmentImpl.setCompanyId(getCompanyId());
		questionAssignmentImpl.setUserId(getUserId());
		questionAssignmentImpl.setUserName(getUserName());
		questionAssignmentImpl.setModifiedDate(getModifiedDate());
		questionAssignmentImpl.setQuestionId(getQuestionId());
		questionAssignmentImpl.setLocked(getLocked());

		questionAssignmentImpl.resetOriginalValues();

		return questionAssignmentImpl;
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

		QuestionAssignment questionAssignment = null;

		try {
			questionAssignment = (QuestionAssignment)obj;
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
	public void resetOriginalValues() {
		QuestionAssignmentModelImpl questionAssignmentModelImpl = this;

		questionAssignmentModelImpl._originalUserId = questionAssignmentModelImpl._userId;

		questionAssignmentModelImpl._setOriginalUserId = false;

		questionAssignmentModelImpl._originalQuestionId = questionAssignmentModelImpl._questionId;

		questionAssignmentModelImpl._setOriginalQuestionId = false;

		questionAssignmentModelImpl._originalLocked = questionAssignmentModelImpl._locked;

		questionAssignmentModelImpl._setOriginalLocked = false;

		questionAssignmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<QuestionAssignment> toCacheModel() {
		QuestionAssignmentCacheModel questionAssignmentCacheModel = new QuestionAssignmentCacheModel();

		questionAssignmentCacheModel.questionAssignmentId = getQuestionAssignmentId();

		questionAssignmentCacheModel.companyId = getCompanyId();

		questionAssignmentCacheModel.userId = getUserId();

		questionAssignmentCacheModel.userName = getUserName();

		String userName = questionAssignmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			questionAssignmentCacheModel.userName = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			questionAssignmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			questionAssignmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		questionAssignmentCacheModel.questionId = getQuestionId();

		questionAssignmentCacheModel.locked = getLocked();

		return questionAssignmentCacheModel;
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

	private static ClassLoader _classLoader = QuestionAssignment.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			QuestionAssignment.class
		};
	private long _questionAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _modifiedDate;
	private long _questionId;
	private long _originalQuestionId;
	private boolean _setOriginalQuestionId;
	private boolean _locked;
	private boolean _originalLocked;
	private boolean _setOriginalLocked;
	private long _columnBitmask;
	private QuestionAssignment _escapedModelProxy;
}
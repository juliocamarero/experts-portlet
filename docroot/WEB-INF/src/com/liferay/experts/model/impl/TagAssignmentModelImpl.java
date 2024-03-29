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

import com.liferay.experts.model.TagAssignment;
import com.liferay.experts.model.TagAssignmentModel;
import com.liferay.experts.model.TagAssignmentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TagAssignment service. Represents a row in the &quot;Experts_TagAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.experts.model.TagAssignmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TagAssignmentImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignmentImpl
 * @see com.liferay.experts.model.TagAssignment
 * @see com.liferay.experts.model.TagAssignmentModel
 * @generated
 */
@JSON(strict = true)
public class TagAssignmentModelImpl extends BaseModelImpl<TagAssignment>
	implements TagAssignmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tag assignment model instance should use the {@link com.liferay.experts.model.TagAssignment} interface instead.
	 */
	public static final String TABLE_NAME = "Experts_TagAssignment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tagAssignmentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "assetTagId", Types.BIGINT },
			{ "assetTagName", Types.VARCHAR },
			{ "locked", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Experts_TagAssignment (tagAssignmentId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,assetTagId LONG,assetTagName VARCHAR(75) null,locked BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Experts_TagAssignment";
	public static final String ORDER_BY_JPQL = " ORDER BY tagAssignment.assetTagName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Experts_TagAssignment.assetTagName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.experts.model.TagAssignment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.experts.model.TagAssignment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.experts.model.TagAssignment"),
			true);
	public static long ASSETTAGID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TagAssignment toModel(TagAssignmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TagAssignment model = new TagAssignmentImpl();

		model.setTagAssignmentId(soapModel.getTagAssignmentId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setAssetTagId(soapModel.getAssetTagId());
		model.setAssetTagName(soapModel.getAssetTagName());
		model.setLocked(soapModel.getLocked());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TagAssignment> toModels(TagAssignmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TagAssignment> models = new ArrayList<TagAssignment>(soapModels.length);

		for (TagAssignmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.experts.model.TagAssignment"));

	public TagAssignmentModelImpl() {
	}

	public long getPrimaryKey() {
		return _tagAssignmentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTagAssignmentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_tagAssignmentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return TagAssignment.class;
	}

	public String getModelClassName() {
		return TagAssignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagAssignmentId", getTagAssignmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("assetTagId", getAssetTagId());
		attributes.put("assetTagName", getAssetTagName());
		attributes.put("locked", getLocked());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagAssignmentId = (Long)attributes.get("tagAssignmentId");

		if (tagAssignmentId != null) {
			setTagAssignmentId(tagAssignmentId);
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

		Long assetTagId = (Long)attributes.get("assetTagId");

		if (assetTagId != null) {
			setAssetTagId(assetTagId);
		}

		String assetTagName = (String)attributes.get("assetTagName");

		if (assetTagName != null) {
			setAssetTagName(assetTagName);
		}

		Boolean locked = (Boolean)attributes.get("locked");

		if (locked != null) {
			setLocked(locked);
		}
	}

	@JSON
	public long getTagAssignmentId() {
		return _tagAssignmentId;
	}

	public void setTagAssignmentId(long tagAssignmentId) {
		_tagAssignmentId = tagAssignmentId;
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
	public long getAssetTagId() {
		return _assetTagId;
	}

	public void setAssetTagId(long assetTagId) {
		_columnBitmask |= ASSETTAGID_COLUMN_BITMASK;

		if (!_setOriginalAssetTagId) {
			_setOriginalAssetTagId = true;

			_originalAssetTagId = _assetTagId;
		}

		_assetTagId = assetTagId;
	}

	public long getOriginalAssetTagId() {
		return _originalAssetTagId;
	}

	@JSON
	public String getAssetTagName() {
		if (_assetTagName == null) {
			return StringPool.BLANK;
		}
		else {
			return _assetTagName;
		}
	}

	public void setAssetTagName(String assetTagName) {
		_columnBitmask = -1L;

		_assetTagName = assetTagName;
	}

	@JSON
	public boolean getLocked() {
		return _locked;
	}

	public boolean isLocked() {
		return _locked;
	}

	public void setLocked(boolean locked) {
		_locked = locked;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TagAssignment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TagAssignment toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (TagAssignment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TagAssignmentImpl tagAssignmentImpl = new TagAssignmentImpl();

		tagAssignmentImpl.setTagAssignmentId(getTagAssignmentId());
		tagAssignmentImpl.setCompanyId(getCompanyId());
		tagAssignmentImpl.setUserId(getUserId());
		tagAssignmentImpl.setUserName(getUserName());
		tagAssignmentImpl.setAssetTagId(getAssetTagId());
		tagAssignmentImpl.setAssetTagName(getAssetTagName());
		tagAssignmentImpl.setLocked(getLocked());

		tagAssignmentImpl.resetOriginalValues();

		return tagAssignmentImpl;
	}

	public int compareTo(TagAssignment tagAssignment) {
		int value = 0;

		value = getAssetTagName().compareTo(tagAssignment.getAssetTagName());

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

		TagAssignment tagAssignment = null;

		try {
			tagAssignment = (TagAssignment)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tagAssignment.getPrimaryKey();

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
		TagAssignmentModelImpl tagAssignmentModelImpl = this;

		tagAssignmentModelImpl._originalUserId = tagAssignmentModelImpl._userId;

		tagAssignmentModelImpl._setOriginalUserId = false;

		tagAssignmentModelImpl._originalAssetTagId = tagAssignmentModelImpl._assetTagId;

		tagAssignmentModelImpl._setOriginalAssetTagId = false;

		tagAssignmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TagAssignment> toCacheModel() {
		TagAssignmentCacheModel tagAssignmentCacheModel = new TagAssignmentCacheModel();

		tagAssignmentCacheModel.tagAssignmentId = getTagAssignmentId();

		tagAssignmentCacheModel.companyId = getCompanyId();

		tagAssignmentCacheModel.userId = getUserId();

		tagAssignmentCacheModel.userName = getUserName();

		String userName = tagAssignmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tagAssignmentCacheModel.userName = null;
		}

		tagAssignmentCacheModel.assetTagId = getAssetTagId();

		tagAssignmentCacheModel.assetTagName = getAssetTagName();

		String assetTagName = tagAssignmentCacheModel.assetTagName;

		if ((assetTagName != null) && (assetTagName.length() == 0)) {
			tagAssignmentCacheModel.assetTagName = null;
		}

		tagAssignmentCacheModel.locked = getLocked();

		return tagAssignmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{tagAssignmentId=");
		sb.append(getTagAssignmentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", assetTagId=");
		sb.append(getAssetTagId());
		sb.append(", assetTagName=");
		sb.append(getAssetTagName());
		sb.append(", locked=");
		sb.append(getLocked());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.experts.model.TagAssignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagAssignmentId</column-name><column-value><![CDATA[");
		sb.append(getTagAssignmentId());
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
			"<column><column-name>assetTagId</column-name><column-value><![CDATA[");
		sb.append(getAssetTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetTagName</column-name><column-value><![CDATA[");
		sb.append(getAssetTagName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locked</column-name><column-value><![CDATA[");
		sb.append(getLocked());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TagAssignment.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			TagAssignment.class
		};
	private long _tagAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private long _assetTagId;
	private long _originalAssetTagId;
	private boolean _setOriginalAssetTagId;
	private String _assetTagName;
	private boolean _locked;
	private long _columnBitmask;
	private TagAssignment _escapedModelProxy;
}
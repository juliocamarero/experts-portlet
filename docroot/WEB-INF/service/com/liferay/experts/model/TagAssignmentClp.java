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

import com.liferay.experts.service.TagAssignmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Park
 */
public class TagAssignmentClp extends BaseModelImpl<TagAssignment>
	implements TagAssignment {
	public TagAssignmentClp() {
	}

	public Class<?> getModelClass() {
		return TagAssignment.class;
	}

	public String getModelClassName() {
		return TagAssignment.class.getName();
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

	public long getTagAssignmentId() {
		return _tagAssignmentId;
	}

	public void setTagAssignmentId(long tagAssignmentId) {
		_tagAssignmentId = tagAssignmentId;
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

	public long getAssetTagId() {
		return _assetTagId;
	}

	public void setAssetTagId(long assetTagId) {
		_assetTagId = assetTagId;
	}

	public String getAssetTagName() {
		return _assetTagName;
	}

	public void setAssetTagName(String assetTagName) {
		_assetTagName = assetTagName;
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

	public BaseModel<?> getTagAssignmentRemoteModel() {
		return _tagAssignmentRemoteModel;
	}

	public void setTagAssignmentRemoteModel(
		BaseModel<?> tagAssignmentRemoteModel) {
		_tagAssignmentRemoteModel = tagAssignmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TagAssignmentLocalServiceUtil.addTagAssignment(this);
		}
		else {
			TagAssignmentLocalServiceUtil.updateTagAssignment(this);
		}
	}

	@Override
	public TagAssignment toEscapedModel() {
		return (TagAssignment)Proxy.newProxyInstance(TagAssignment.class.getClassLoader(),
			new Class[] { TagAssignment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TagAssignmentClp clone = new TagAssignmentClp();

		clone.setTagAssignmentId(getTagAssignmentId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setAssetTagId(getAssetTagId());
		clone.setAssetTagName(getAssetTagName());
		clone.setLocked(getLocked());

		return clone;
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

		TagAssignmentClp tagAssignment = null;

		try {
			tagAssignment = (TagAssignmentClp)obj;
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

	private long _tagAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _assetTagId;
	private String _assetTagName;
	private boolean _locked;
	private BaseModel<?> _tagAssignmentRemoteModel;
}
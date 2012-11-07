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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TagAssignment}.
 * </p>
 *
 * @author    Ryan Park
 * @see       TagAssignment
 * @generated
 */
public class TagAssignmentWrapper implements TagAssignment,
	ModelWrapper<TagAssignment> {
	public TagAssignmentWrapper(TagAssignment tagAssignment) {
		_tagAssignment = tagAssignment;
	}

	public Class<?> getModelClass() {
		return TagAssignment.class;
	}

	public String getModelClassName() {
		return TagAssignment.class.getName();
	}

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

	/**
	* Returns the primary key of this tag assignment.
	*
	* @return the primary key of this tag assignment
	*/
	public long getPrimaryKey() {
		return _tagAssignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tag assignment.
	*
	* @param primaryKey the primary key of this tag assignment
	*/
	public void setPrimaryKey(long primaryKey) {
		_tagAssignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tag assignment ID of this tag assignment.
	*
	* @return the tag assignment ID of this tag assignment
	*/
	public long getTagAssignmentId() {
		return _tagAssignment.getTagAssignmentId();
	}

	/**
	* Sets the tag assignment ID of this tag assignment.
	*
	* @param tagAssignmentId the tag assignment ID of this tag assignment
	*/
	public void setTagAssignmentId(long tagAssignmentId) {
		_tagAssignment.setTagAssignmentId(tagAssignmentId);
	}

	/**
	* Returns the company ID of this tag assignment.
	*
	* @return the company ID of this tag assignment
	*/
	public long getCompanyId() {
		return _tagAssignment.getCompanyId();
	}

	/**
	* Sets the company ID of this tag assignment.
	*
	* @param companyId the company ID of this tag assignment
	*/
	public void setCompanyId(long companyId) {
		_tagAssignment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tag assignment.
	*
	* @return the user ID of this tag assignment
	*/
	public long getUserId() {
		return _tagAssignment.getUserId();
	}

	/**
	* Sets the user ID of this tag assignment.
	*
	* @param userId the user ID of this tag assignment
	*/
	public void setUserId(long userId) {
		_tagAssignment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tag assignment.
	*
	* @return the user uuid of this tag assignment
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagAssignment.getUserUuid();
	}

	/**
	* Sets the user uuid of this tag assignment.
	*
	* @param userUuid the user uuid of this tag assignment
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tagAssignment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tag assignment.
	*
	* @return the user name of this tag assignment
	*/
	public java.lang.String getUserName() {
		return _tagAssignment.getUserName();
	}

	/**
	* Sets the user name of this tag assignment.
	*
	* @param userName the user name of this tag assignment
	*/
	public void setUserName(java.lang.String userName) {
		_tagAssignment.setUserName(userName);
	}

	/**
	* Returns the asset tag ID of this tag assignment.
	*
	* @return the asset tag ID of this tag assignment
	*/
	public long getAssetTagId() {
		return _tagAssignment.getAssetTagId();
	}

	/**
	* Sets the asset tag ID of this tag assignment.
	*
	* @param assetTagId the asset tag ID of this tag assignment
	*/
	public void setAssetTagId(long assetTagId) {
		_tagAssignment.setAssetTagId(assetTagId);
	}

	/**
	* Returns the asset tag name of this tag assignment.
	*
	* @return the asset tag name of this tag assignment
	*/
	public java.lang.String getAssetTagName() {
		return _tagAssignment.getAssetTagName();
	}

	/**
	* Sets the asset tag name of this tag assignment.
	*
	* @param assetTagName the asset tag name of this tag assignment
	*/
	public void setAssetTagName(java.lang.String assetTagName) {
		_tagAssignment.setAssetTagName(assetTagName);
	}

	/**
	* Returns the locked of this tag assignment.
	*
	* @return the locked of this tag assignment
	*/
	public boolean getLocked() {
		return _tagAssignment.getLocked();
	}

	/**
	* Returns <code>true</code> if this tag assignment is locked.
	*
	* @return <code>true</code> if this tag assignment is locked; <code>false</code> otherwise
	*/
	public boolean isLocked() {
		return _tagAssignment.isLocked();
	}

	/**
	* Sets whether this tag assignment is locked.
	*
	* @param locked the locked of this tag assignment
	*/
	public void setLocked(boolean locked) {
		_tagAssignment.setLocked(locked);
	}

	public boolean isNew() {
		return _tagAssignment.isNew();
	}

	public void setNew(boolean n) {
		_tagAssignment.setNew(n);
	}

	public boolean isCachedModel() {
		return _tagAssignment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tagAssignment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tagAssignment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tagAssignment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tagAssignment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tagAssignment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tagAssignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TagAssignmentWrapper((TagAssignment)_tagAssignment.clone());
	}

	public int compareTo(com.liferay.experts.model.TagAssignment tagAssignment) {
		return _tagAssignment.compareTo(tagAssignment);
	}

	@Override
	public int hashCode() {
		return _tagAssignment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.experts.model.TagAssignment> toCacheModel() {
		return _tagAssignment.toCacheModel();
	}

	public com.liferay.experts.model.TagAssignment toEscapedModel() {
		return new TagAssignmentWrapper(_tagAssignment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tagAssignment.toString();
	}

	public java.lang.String toXmlString() {
		return _tagAssignment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tagAssignment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TagAssignment getWrappedTagAssignment() {
		return _tagAssignment;
	}

	public TagAssignment getWrappedModel() {
		return _tagAssignment;
	}

	public void resetOriginalValues() {
		_tagAssignment.resetOriginalValues();
	}

	private TagAssignment _tagAssignment;
}
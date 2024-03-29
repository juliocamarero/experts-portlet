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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the TagAssignment service. Represents a row in the &quot;Experts_TagAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.experts.model.impl.TagAssignmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.experts.model.impl.TagAssignmentImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignment
 * @see com.liferay.experts.model.impl.TagAssignmentImpl
 * @see com.liferay.experts.model.impl.TagAssignmentModelImpl
 * @generated
 */
public interface TagAssignmentModel extends BaseModel<TagAssignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tag assignment model instance should use the {@link TagAssignment} interface instead.
	 */

	/**
	 * Returns the primary key of this tag assignment.
	 *
	 * @return the primary key of this tag assignment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tag assignment.
	 *
	 * @param primaryKey the primary key of this tag assignment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tag assignment ID of this tag assignment.
	 *
	 * @return the tag assignment ID of this tag assignment
	 */
	public long getTagAssignmentId();

	/**
	 * Sets the tag assignment ID of this tag assignment.
	 *
	 * @param tagAssignmentId the tag assignment ID of this tag assignment
	 */
	public void setTagAssignmentId(long tagAssignmentId);

	/**
	 * Returns the company ID of this tag assignment.
	 *
	 * @return the company ID of this tag assignment
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this tag assignment.
	 *
	 * @param companyId the company ID of this tag assignment
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tag assignment.
	 *
	 * @return the user ID of this tag assignment
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this tag assignment.
	 *
	 * @param userId the user ID of this tag assignment
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tag assignment.
	 *
	 * @return the user uuid of this tag assignment
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this tag assignment.
	 *
	 * @param userUuid the user uuid of this tag assignment
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tag assignment.
	 *
	 * @return the user name of this tag assignment
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this tag assignment.
	 *
	 * @param userName the user name of this tag assignment
	 */
	public void setUserName(String userName);

	/**
	 * Returns the asset tag ID of this tag assignment.
	 *
	 * @return the asset tag ID of this tag assignment
	 */
	public long getAssetTagId();

	/**
	 * Sets the asset tag ID of this tag assignment.
	 *
	 * @param assetTagId the asset tag ID of this tag assignment
	 */
	public void setAssetTagId(long assetTagId);

	/**
	 * Returns the asset tag name of this tag assignment.
	 *
	 * @return the asset tag name of this tag assignment
	 */
	@AutoEscape
	public String getAssetTagName();

	/**
	 * Sets the asset tag name of this tag assignment.
	 *
	 * @param assetTagName the asset tag name of this tag assignment
	 */
	public void setAssetTagName(String assetTagName);

	/**
	 * Returns the locked of this tag assignment.
	 *
	 * @return the locked of this tag assignment
	 */
	public boolean getLocked();

	/**
	 * Returns <code>true</code> if this tag assignment is locked.
	 *
	 * @return <code>true</code> if this tag assignment is locked; <code>false</code> otherwise
	 */
	public boolean isLocked();

	/**
	 * Sets whether this tag assignment is locked.
	 *
	 * @param locked the locked of this tag assignment
	 */
	public void setLocked(boolean locked);

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

	public int compareTo(TagAssignment tagAssignment);

	public int hashCode();

	public CacheModel<TagAssignment> toCacheModel();

	public TagAssignment toEscapedModel();

	public String toString();

	public String toXmlString();
}
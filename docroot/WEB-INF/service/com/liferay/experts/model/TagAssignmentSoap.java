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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.experts.service.http.TagAssignmentServiceSoap}.
 *
 * @author    Ryan Park
 * @see       com.liferay.experts.service.http.TagAssignmentServiceSoap
 * @generated
 */
public class TagAssignmentSoap implements Serializable {
	public static TagAssignmentSoap toSoapModel(TagAssignment model) {
		TagAssignmentSoap soapModel = new TagAssignmentSoap();

		soapModel.setTagAssignmentId(model.getTagAssignmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setAssetTagId(model.getAssetTagId());
		soapModel.setAssetTagName(model.getAssetTagName());
		soapModel.setLocked(model.getLocked());

		return soapModel;
	}

	public static TagAssignmentSoap[] toSoapModels(TagAssignment[] models) {
		TagAssignmentSoap[] soapModels = new TagAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TagAssignmentSoap[][] toSoapModels(TagAssignment[][] models) {
		TagAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TagAssignmentSoap[] toSoapModels(List<TagAssignment> models) {
		List<TagAssignmentSoap> soapModels = new ArrayList<TagAssignmentSoap>(models.size());

		for (TagAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagAssignmentSoap[soapModels.size()]);
	}

	public TagAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _tagAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setTagAssignmentId(pk);
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

	private long _tagAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private long _assetTagId;
	private String _assetTagName;
	private boolean _locked;
}
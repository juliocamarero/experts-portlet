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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TagAssignment in entity cache.
 *
 * @author Ryan Park
 * @see TagAssignment
 * @generated
 */
public class TagAssignmentCacheModel implements CacheModel<TagAssignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{tagAssignmentId=");
		sb.append(tagAssignmentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", assetTagId=");
		sb.append(assetTagId);
		sb.append(", assetTagName=");
		sb.append(assetTagName);
		sb.append(", locked=");
		sb.append(locked);
		sb.append("}");

		return sb.toString();
	}

	public TagAssignment toEntityModel() {
		TagAssignmentImpl tagAssignmentImpl = new TagAssignmentImpl();

		tagAssignmentImpl.setTagAssignmentId(tagAssignmentId);
		tagAssignmentImpl.setCompanyId(companyId);
		tagAssignmentImpl.setUserId(userId);

		if (userName == null) {
			tagAssignmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			tagAssignmentImpl.setUserName(userName);
		}

		tagAssignmentImpl.setAssetTagId(assetTagId);

		if (assetTagName == null) {
			tagAssignmentImpl.setAssetTagName(StringPool.BLANK);
		}
		else {
			tagAssignmentImpl.setAssetTagName(assetTagName);
		}

		tagAssignmentImpl.setLocked(locked);

		tagAssignmentImpl.resetOriginalValues();

		return tagAssignmentImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		tagAssignmentId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		assetTagId = objectInput.readLong();
		assetTagName = objectInput.readUTF();
		locked = objectInput.readBoolean();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tagAssignmentId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(assetTagId);

		if (assetTagName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assetTagName);
		}

		objectOutput.writeBoolean(locked);
	}

	public long tagAssignmentId;
	public long companyId;
	public long userId;
	public String userName;
	public long assetTagId;
	public String assetTagName;
	public boolean locked;
}
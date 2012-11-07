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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuestionAssignment in entity cache.
 *
 * @author Ryan Park
 * @see QuestionAssignment
 * @generated
 */
public class QuestionAssignmentCacheModel implements CacheModel<QuestionAssignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{questionAssignmentId=");
		sb.append(questionAssignmentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", locked=");
		sb.append(locked);
		sb.append("}");

		return sb.toString();
	}

	public QuestionAssignment toEntityModel() {
		QuestionAssignmentImpl questionAssignmentImpl = new QuestionAssignmentImpl();

		questionAssignmentImpl.setQuestionAssignmentId(questionAssignmentId);
		questionAssignmentImpl.setCompanyId(companyId);
		questionAssignmentImpl.setUserId(userId);

		if (userName == null) {
			questionAssignmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			questionAssignmentImpl.setUserName(userName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionAssignmentImpl.setModifiedDate(null);
		}
		else {
			questionAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		questionAssignmentImpl.setQuestionId(questionId);
		questionAssignmentImpl.setLocked(locked);

		questionAssignmentImpl.resetOriginalValues();

		return questionAssignmentImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		questionAssignmentId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		questionId = objectInput.readLong();
		locked = objectInput.readBoolean();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionAssignmentId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(questionId);
		objectOutput.writeBoolean(locked);
	}

	public long questionAssignmentId;
	public long companyId;
	public long userId;
	public String userName;
	public long modifiedDate;
	public long questionId;
	public boolean locked;
}
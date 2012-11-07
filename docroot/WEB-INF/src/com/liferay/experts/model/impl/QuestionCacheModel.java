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

import com.liferay.experts.model.Question;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author Ryan Park
 * @see Question
 * @generated
 */
public class QuestionCacheModel implements CacheModel<Question>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		if (uuid == null) {
			questionImpl.setUuid(StringPool.BLANK);
		}
		else {
			questionImpl.setUuid(uuid);
		}

		questionImpl.setQuestionId(questionId);
		questionImpl.setCompanyId(companyId);
		questionImpl.setUserId(userId);

		if (userName == null) {
			questionImpl.setUserName(StringPool.BLANK);
		}
		else {
			questionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			questionImpl.setCreateDate(null);
		}
		else {
			questionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionImpl.setModifiedDate(null);
		}
		else {
			questionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			questionImpl.setTitle(StringPool.BLANK);
		}
		else {
			questionImpl.setTitle(title);
		}

		if (content == null) {
			questionImpl.setContent(StringPool.BLANK);
		}
		else {
			questionImpl.setContent(content);
		}

		if (dueDate == Long.MIN_VALUE) {
			questionImpl.setDueDate(null);
		}
		else {
			questionImpl.setDueDate(new Date(dueDate));
		}

		if (data == null) {
			questionImpl.setData(StringPool.BLANK);
		}
		else {
			questionImpl.setData(data);
		}

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		questionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		dueDate = objectInput.readLong();
		data = objectInput.readUTF();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(questionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(dueDate);

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public String uuid;
	public long questionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String content;
	public long dueDate;
	public String data;
}
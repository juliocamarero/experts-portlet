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

import com.liferay.experts.model.Answer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Answer in entity cache.
 *
 * @author Ryan Park
 * @see Answer
 * @generated
 */
public class AnswerCacheModel implements CacheModel<Answer>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", answerId=");
		sb.append(answerId);
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
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	public Answer toEntityModel() {
		AnswerImpl answerImpl = new AnswerImpl();

		if (uuid == null) {
			answerImpl.setUuid(StringPool.BLANK);
		}
		else {
			answerImpl.setUuid(uuid);
		}

		answerImpl.setAnswerId(answerId);
		answerImpl.setCompanyId(companyId);
		answerImpl.setUserId(userId);

		if (userName == null) {
			answerImpl.setUserName(StringPool.BLANK);
		}
		else {
			answerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			answerImpl.setCreateDate(null);
		}
		else {
			answerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			answerImpl.setModifiedDate(null);
		}
		else {
			answerImpl.setModifiedDate(new Date(modifiedDate));
		}

		answerImpl.setQuestionId(questionId);

		if (content == null) {
			answerImpl.setContent(StringPool.BLANK);
		}
		else {
			answerImpl.setContent(content);
		}

		if (data == null) {
			answerImpl.setData(StringPool.BLANK);
		}
		else {
			answerImpl.setData(data);
		}

		answerImpl.resetOriginalValues();

		return answerImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		answerId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		questionId = objectInput.readLong();
		content = objectInput.readUTF();
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

		objectOutput.writeLong(answerId);
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
		objectOutput.writeLong(questionId);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public String uuid;
	public long answerId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long questionId;
	public String content;
	public String data;
}
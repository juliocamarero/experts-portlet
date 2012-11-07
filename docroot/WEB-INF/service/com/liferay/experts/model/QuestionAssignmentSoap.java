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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.experts.service.http.QuestionAssignmentServiceSoap}.
 *
 * @author    Ryan Park
 * @see       com.liferay.experts.service.http.QuestionAssignmentServiceSoap
 * @generated
 */
public class QuestionAssignmentSoap implements Serializable {
	public static QuestionAssignmentSoap toSoapModel(QuestionAssignment model) {
		QuestionAssignmentSoap soapModel = new QuestionAssignmentSoap();

		soapModel.setQuestionAssignmentId(model.getQuestionAssignmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setLocked(model.getLocked());

		return soapModel;
	}

	public static QuestionAssignmentSoap[] toSoapModels(
		QuestionAssignment[] models) {
		QuestionAssignmentSoap[] soapModels = new QuestionAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionAssignmentSoap[][] toSoapModels(
		QuestionAssignment[][] models) {
		QuestionAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionAssignmentSoap[] toSoapModels(
		List<QuestionAssignment> models) {
		List<QuestionAssignmentSoap> soapModels = new ArrayList<QuestionAssignmentSoap>(models.size());

		for (QuestionAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionAssignmentSoap[soapModels.size()]);
	}

	public QuestionAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _questionAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionAssignmentId(pk);
	}

	public long getQuestionAssignmentId() {
		return _questionAssignmentId;
	}

	public void setQuestionAssignmentId(long questionAssignmentId) {
		_questionAssignmentId = questionAssignmentId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
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

	private long _questionAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _modifiedDate;
	private long _questionId;
	private boolean _locked;
}
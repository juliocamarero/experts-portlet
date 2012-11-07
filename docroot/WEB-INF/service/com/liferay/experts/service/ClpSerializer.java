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

package com.liferay.experts.service;

import com.liferay.experts.model.AnswerClp;
import com.liferay.experts.model.QuestionAssignmentClp;
import com.liferay.experts.model.QuestionClp;
import com.liferay.experts.model.TagAssignmentClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"experts-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"experts-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "experts-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AnswerClp.class.getName())) {
			return translateInputAnswer(oldModel);
		}

		if (oldModelClassName.equals(QuestionClp.class.getName())) {
			return translateInputQuestion(oldModel);
		}

		if (oldModelClassName.equals(QuestionAssignmentClp.class.getName())) {
			return translateInputQuestionAssignment(oldModel);
		}

		if (oldModelClassName.equals(TagAssignmentClp.class.getName())) {
			return translateInputTagAssignment(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAnswer(BaseModel<?> oldModel) {
		AnswerClp oldClpModel = (AnswerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnswerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestion(BaseModel<?> oldModel) {
		QuestionClp oldClpModel = (QuestionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestionAssignment(BaseModel<?> oldModel) {
		QuestionAssignmentClp oldClpModel = (QuestionAssignmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionAssignmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTagAssignment(BaseModel<?> oldModel) {
		TagAssignmentClp oldClpModel = (TagAssignmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTagAssignmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.experts.model.impl.AnswerImpl")) {
			return translateOutputAnswer(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.experts.model.impl.QuestionImpl")) {
			return translateOutputQuestion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.experts.model.impl.QuestionAssignmentImpl")) {
			return translateOutputQuestionAssignment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.experts.model.impl.TagAssignmentImpl")) {
			return translateOutputTagAssignment(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.liferay.experts.NoSuchAnswerException")) {
			return new com.liferay.experts.NoSuchAnswerException();
		}

		if (className.equals("com.liferay.experts.NoSuchQuestionException")) {
			return new com.liferay.experts.NoSuchQuestionException();
		}

		if (className.equals(
					"com.liferay.experts.NoSuchQuestionAssignmentException")) {
			return new com.liferay.experts.NoSuchQuestionAssignmentException();
		}

		if (className.equals("com.liferay.experts.NoSuchTagAssignmentException")) {
			return new com.liferay.experts.NoSuchTagAssignmentException();
		}

		return throwable;
	}

	public static Object translateOutputAnswer(BaseModel<?> oldModel) {
		AnswerClp newModel = new AnswerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnswerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestion(BaseModel<?> oldModel) {
		QuestionClp newModel = new QuestionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestionAssignment(
		BaseModel<?> oldModel) {
		QuestionAssignmentClp newModel = new QuestionAssignmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionAssignmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTagAssignment(BaseModel<?> oldModel) {
		TagAssignmentClp newModel = new TagAssignmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTagAssignmentRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
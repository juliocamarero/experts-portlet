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

package com.liferay.experts.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.experts.model.QuestionAssignment;
import com.liferay.experts.service.AnswerLocalService;
import com.liferay.experts.service.AnswerService;
import com.liferay.experts.service.QuestionAssignmentLocalService;
import com.liferay.experts.service.QuestionAssignmentService;
import com.liferay.experts.service.QuestionLocalService;
import com.liferay.experts.service.QuestionService;
import com.liferay.experts.service.TagAssignmentLocalService;
import com.liferay.experts.service.TagAssignmentService;
import com.liferay.experts.service.persistence.AnswerPersistence;
import com.liferay.experts.service.persistence.QuestionAssignmentPersistence;
import com.liferay.experts.service.persistence.QuestionPersistence;
import com.liferay.experts.service.persistence.TagAssignmentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the question assignment remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.experts.service.impl.QuestionAssignmentServiceImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see com.liferay.experts.service.impl.QuestionAssignmentServiceImpl
 * @see com.liferay.experts.service.QuestionAssignmentServiceUtil
 * @generated
 */
public abstract class QuestionAssignmentServiceBaseImpl extends BaseServiceImpl
	implements QuestionAssignmentService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.experts.service.QuestionAssignmentServiceUtil} to access the question assignment remote service.
	 */

	/**
	 * Returns the answer local service.
	 *
	 * @return the answer local service
	 */
	public AnswerLocalService getAnswerLocalService() {
		return answerLocalService;
	}

	/**
	 * Sets the answer local service.
	 *
	 * @param answerLocalService the answer local service
	 */
	public void setAnswerLocalService(AnswerLocalService answerLocalService) {
		this.answerLocalService = answerLocalService;
	}

	/**
	 * Returns the answer remote service.
	 *
	 * @return the answer remote service
	 */
	public AnswerService getAnswerService() {
		return answerService;
	}

	/**
	 * Sets the answer remote service.
	 *
	 * @param answerService the answer remote service
	 */
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}

	/**
	 * Returns the answer persistence.
	 *
	 * @return the answer persistence
	 */
	public AnswerPersistence getAnswerPersistence() {
		return answerPersistence;
	}

	/**
	 * Sets the answer persistence.
	 *
	 * @param answerPersistence the answer persistence
	 */
	public void setAnswerPersistence(AnswerPersistence answerPersistence) {
		this.answerPersistence = answerPersistence;
	}

	/**
	 * Returns the question local service.
	 *
	 * @return the question local service
	 */
	public QuestionLocalService getQuestionLocalService() {
		return questionLocalService;
	}

	/**
	 * Sets the question local service.
	 *
	 * @param questionLocalService the question local service
	 */
	public void setQuestionLocalService(
		QuestionLocalService questionLocalService) {
		this.questionLocalService = questionLocalService;
	}

	/**
	 * Returns the question remote service.
	 *
	 * @return the question remote service
	 */
	public QuestionService getQuestionService() {
		return questionService;
	}

	/**
	 * Sets the question remote service.
	 *
	 * @param questionService the question remote service
	 */
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	/**
	 * Returns the question persistence.
	 *
	 * @return the question persistence
	 */
	public QuestionPersistence getQuestionPersistence() {
		return questionPersistence;
	}

	/**
	 * Sets the question persistence.
	 *
	 * @param questionPersistence the question persistence
	 */
	public void setQuestionPersistence(QuestionPersistence questionPersistence) {
		this.questionPersistence = questionPersistence;
	}

	/**
	 * Returns the question assignment local service.
	 *
	 * @return the question assignment local service
	 */
	public QuestionAssignmentLocalService getQuestionAssignmentLocalService() {
		return questionAssignmentLocalService;
	}

	/**
	 * Sets the question assignment local service.
	 *
	 * @param questionAssignmentLocalService the question assignment local service
	 */
	public void setQuestionAssignmentLocalService(
		QuestionAssignmentLocalService questionAssignmentLocalService) {
		this.questionAssignmentLocalService = questionAssignmentLocalService;
	}

	/**
	 * Returns the question assignment remote service.
	 *
	 * @return the question assignment remote service
	 */
	public QuestionAssignmentService getQuestionAssignmentService() {
		return questionAssignmentService;
	}

	/**
	 * Sets the question assignment remote service.
	 *
	 * @param questionAssignmentService the question assignment remote service
	 */
	public void setQuestionAssignmentService(
		QuestionAssignmentService questionAssignmentService) {
		this.questionAssignmentService = questionAssignmentService;
	}

	/**
	 * Returns the question assignment persistence.
	 *
	 * @return the question assignment persistence
	 */
	public QuestionAssignmentPersistence getQuestionAssignmentPersistence() {
		return questionAssignmentPersistence;
	}

	/**
	 * Sets the question assignment persistence.
	 *
	 * @param questionAssignmentPersistence the question assignment persistence
	 */
	public void setQuestionAssignmentPersistence(
		QuestionAssignmentPersistence questionAssignmentPersistence) {
		this.questionAssignmentPersistence = questionAssignmentPersistence;
	}

	/**
	 * Returns the tag assignment local service.
	 *
	 * @return the tag assignment local service
	 */
	public TagAssignmentLocalService getTagAssignmentLocalService() {
		return tagAssignmentLocalService;
	}

	/**
	 * Sets the tag assignment local service.
	 *
	 * @param tagAssignmentLocalService the tag assignment local service
	 */
	public void setTagAssignmentLocalService(
		TagAssignmentLocalService tagAssignmentLocalService) {
		this.tagAssignmentLocalService = tagAssignmentLocalService;
	}

	/**
	 * Returns the tag assignment remote service.
	 *
	 * @return the tag assignment remote service
	 */
	public TagAssignmentService getTagAssignmentService() {
		return tagAssignmentService;
	}

	/**
	 * Sets the tag assignment remote service.
	 *
	 * @param tagAssignmentService the tag assignment remote service
	 */
	public void setTagAssignmentService(
		TagAssignmentService tagAssignmentService) {
		this.tagAssignmentService = tagAssignmentService;
	}

	/**
	 * Returns the tag assignment persistence.
	 *
	 * @return the tag assignment persistence
	 */
	public TagAssignmentPersistence getTagAssignmentPersistence() {
		return tagAssignmentPersistence;
	}

	/**
	 * Sets the tag assignment persistence.
	 *
	 * @param tagAssignmentPersistence the tag assignment persistence
	 */
	public void setTagAssignmentPersistence(
		TagAssignmentPersistence tagAssignmentPersistence) {
		this.tagAssignmentPersistence = tagAssignmentPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return QuestionAssignment.class;
	}

	protected String getModelClassName() {
		return QuestionAssignment.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = questionAssignmentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AnswerLocalService.class)
	protected AnswerLocalService answerLocalService;
	@BeanReference(type = AnswerService.class)
	protected AnswerService answerService;
	@BeanReference(type = AnswerPersistence.class)
	protected AnswerPersistence answerPersistence;
	@BeanReference(type = QuestionLocalService.class)
	protected QuestionLocalService questionLocalService;
	@BeanReference(type = QuestionService.class)
	protected QuestionService questionService;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionAssignmentLocalService.class)
	protected QuestionAssignmentLocalService questionAssignmentLocalService;
	@BeanReference(type = QuestionAssignmentService.class)
	protected QuestionAssignmentService questionAssignmentService;
	@BeanReference(type = QuestionAssignmentPersistence.class)
	protected QuestionAssignmentPersistence questionAssignmentPersistence;
	@BeanReference(type = TagAssignmentLocalService.class)
	protected TagAssignmentLocalService tagAssignmentLocalService;
	@BeanReference(type = TagAssignmentService.class)
	protected TagAssignmentService tagAssignmentService;
	@BeanReference(type = TagAssignmentPersistence.class)
	protected TagAssignmentPersistence tagAssignmentPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private QuestionAssignmentServiceClpInvoker _clpInvoker = new QuestionAssignmentServiceClpInvoker();
}
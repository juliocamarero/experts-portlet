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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the answer local service. This utility wraps {@link com.liferay.experts.service.impl.AnswerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ryan Park
 * @see AnswerLocalService
 * @see com.liferay.experts.service.base.AnswerLocalServiceBaseImpl
 * @see com.liferay.experts.service.impl.AnswerLocalServiceImpl
 * @generated
 */
public class AnswerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.experts.service.impl.AnswerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the answer to the database. Also notifies the appropriate model listeners.
	*
	* @param answer the answer
	* @return the answer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer addAnswer(
		com.liferay.experts.model.Answer answer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAnswer(answer);
	}

	/**
	* Creates a new answer with the primary key. Does not add the answer to the database.
	*
	* @param answerId the primary key for the new answer
	* @return the new answer
	*/
	public static com.liferay.experts.model.Answer createAnswer(long answerId) {
		return getService().createAnswer(answerId);
	}

	/**
	* Deletes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param answerId the primary key of the answer
	* @return the answer that was removed
	* @throws PortalException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer deleteAnswer(long answerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnswer(answerId);
	}

	/**
	* Deletes the answer from the database. Also notifies the appropriate model listeners.
	*
	* @param answer the answer
	* @return the answer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer deleteAnswer(
		com.liferay.experts.model.Answer answer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnswer(answer);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.experts.model.Answer fetchAnswer(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnswer(answerId);
	}

	/**
	* Returns the answer with the primary key.
	*
	* @param answerId the primary key of the answer
	* @return the answer
	* @throws PortalException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer getAnswer(long answerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnswer(answerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @return the range of answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> getAnswers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnswers(start, end);
	}

	/**
	* Returns the number of answers.
	*
	* @return the number of answers
	* @throws SystemException if a system exception occurred
	*/
	public static int getAnswersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnswersCount();
	}

	/**
	* Updates the answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param answer the answer
	* @return the answer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer updateAnswer(
		com.liferay.experts.model.Answer answer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnswer(answer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.experts.model.Answer addAnswer(long userId,
		long questionId, java.lang.String content,
		com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAnswer(userId, questionId, content, data);
	}

	public static com.liferay.experts.model.Answer fetchAnswerByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnswerByQuestionId(questionId);
	}

	public static com.liferay.experts.model.Answer updateAnswer(long answerId,
		java.lang.String content, com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnswer(answerId, content, data);
	}

	public static void clearService() {
		_service = null;
	}

	public static AnswerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AnswerLocalService.class.getName());

			if (invokableLocalService instanceof AnswerLocalService) {
				_service = (AnswerLocalService)invokableLocalService;
			}
			else {
				_service = new AnswerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AnswerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AnswerLocalService service) {
	}

	private static AnswerLocalService _service;
}
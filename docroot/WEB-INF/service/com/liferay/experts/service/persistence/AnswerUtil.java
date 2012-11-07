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

package com.liferay.experts.service.persistence;

import com.liferay.experts.model.Answer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the answer service. This utility wraps {@link AnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see AnswerPersistence
 * @see AnswerPersistenceImpl
 * @generated
 */
public class AnswerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Answer answer) {
		getPersistence().clearCache(answer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Answer update(Answer answer) throws SystemException {
		return getPersistence().update(answer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Answer update(Answer answer, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(answer, serviceContext);
	}

	/**
	* Caches the answer in the entity cache if it is enabled.
	*
	* @param answer the answer
	*/
	public static void cacheResult(com.liferay.experts.model.Answer answer) {
		getPersistence().cacheResult(answer);
	}

	/**
	* Caches the answers in the entity cache if it is enabled.
	*
	* @param answers the answers
	*/
	public static void cacheResult(
		java.util.List<com.liferay.experts.model.Answer> answers) {
		getPersistence().cacheResult(answers);
	}

	/**
	* Creates a new answer with the primary key. Does not add the answer to the database.
	*
	* @param answerId the primary key for the new answer
	* @return the new answer
	*/
	public static com.liferay.experts.model.Answer create(long answerId) {
		return getPersistence().create(answerId);
	}

	/**
	* Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param answerId the primary key of the answer
	* @return the answer that was removed
	* @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer remove(long answerId)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(answerId);
	}

	public static com.liferay.experts.model.Answer updateImpl(
		com.liferay.experts.model.Answer answer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(answer);
	}

	/**
	* Returns the answer with the primary key or throws a {@link com.liferay.experts.NoSuchAnswerException} if it could not be found.
	*
	* @param answerId the primary key of the answer
	* @return the answer
	* @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByPrimaryKey(
		long answerId)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(answerId);
	}

	/**
	* Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param answerId the primary key of the answer
	* @return the answer, or <code>null</code> if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByPrimaryKey(
		long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(answerId);
	}

	/**
	* Returns all the answers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the answers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @return the range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the answers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the answers before and after the current answer in the ordered set where uuid = &#63;.
	*
	* @param answerId the primary key of the current answer
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next answer
	* @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer[] findByUuid_PrevAndNext(
		long answerId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(answerId, uuid, orderByComparator);
	}

	/**
	* Returns all the answers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the answers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @return the range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the answers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the answers before and after the current answer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param answerId the primary key of the current answer
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next answer
	* @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer[] findByUuid_C_PrevAndNext(
		long answerId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(answerId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Returns the answer where questionId = &#63; or throws a {@link com.liferay.experts.NoSuchAnswerException} if it could not be found.
	*
	* @param questionId the question ID
	* @return the matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByQuestionId(
		long questionId)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId);
	}

	/**
	* Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param questionId the question ID
	* @return the matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByQuestionId(questionId);
	}

	/**
	* Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param questionId the question ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByQuestionId(
		long questionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByQuestionId(questionId, retrieveFromCache);
	}

	/**
	* Returns all the answers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the answers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @return the range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the answers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first answer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer
	* @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last answer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching answer, or <code>null</code> if a matching answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the answers before and after the current answer in the ordered set where userId = &#63;.
	*
	* @param answerId the primary key of the current answer
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next answer
	* @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer[] findByUserId_PrevAndNext(
		long answerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(answerId, userId, orderByComparator);
	}

	/**
	* Returns all the answers.
	*
	* @return the answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.experts.model.Answer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.Answer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the answers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the answers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Removes the answer where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @return the answer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.Answer removeByQuestionId(
		long questionId)
		throws com.liferay.experts.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Removes all the answers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of answers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of answers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of answers where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns the number of answers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of answers.
	*
	* @return the number of answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AnswerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnswerPersistence)PortletBeanLocatorUtil.locate(com.liferay.experts.service.ClpSerializer.getServletContextName(),
					AnswerPersistence.class.getName());

			ReferenceRegistry.registerReference(AnswerUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AnswerPersistence persistence) {
	}

	private static AnswerPersistence _persistence;
}
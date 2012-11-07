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

import com.liferay.experts.model.Question;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see QuestionPersistenceImpl
 * @see QuestionUtil
 * @generated
 */
public interface QuestionPersistence extends BasePersistence<Question> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the question in the entity cache if it is enabled.
	*
	* @param question the question
	*/
	public void cacheResult(com.liferay.experts.model.Question question);

	/**
	* Caches the questions in the entity cache if it is enabled.
	*
	* @param questions the questions
	*/
	public void cacheResult(
		java.util.List<com.liferay.experts.model.Question> questions);

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public com.liferay.experts.model.Question create(long questionId);

	/**
	* Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @return the question that was removed
	* @throws com.liferay.experts.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question remove(long questionId)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.experts.model.Question updateImpl(
		com.liferay.experts.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question with the primary key or throws a {@link com.liferay.experts.NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws com.liferay.experts.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByPrimaryKey(long questionId)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question, or <code>null</code> if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByPrimaryKey(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the questions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the questions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the questions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the questions before and after the current question in the ordered set where uuid = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws com.liferay.experts.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question[] findByUuid_PrevAndNext(
		long questionId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the questions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the questions where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the questions where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the questions before and after the current question in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws com.liferay.experts.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question[] findByUuid_C_PrevAndNext(
		long questionId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the questions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the questions where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the questions where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws com.liferay.experts.NoSuchQuestionException if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the questions before and after the current question in the ordered set where userId = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws com.liferay.experts.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.Question[] findByUserId_PrevAndNext(
		long questionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the questions.
	*
	* @return the questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.Question> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the questions where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the questions where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the questions where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of questions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of questions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of questions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
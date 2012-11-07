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

import com.liferay.experts.model.QuestionAssignment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the question assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see QuestionAssignmentPersistenceImpl
 * @see QuestionAssignmentUtil
 * @generated
 */
public interface QuestionAssignmentPersistence extends BasePersistence<QuestionAssignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionAssignmentUtil} to access the question assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the question assignment in the entity cache if it is enabled.
	*
	* @param questionAssignment the question assignment
	*/
	public void cacheResult(
		com.liferay.experts.model.QuestionAssignment questionAssignment);

	/**
	* Caches the question assignments in the entity cache if it is enabled.
	*
	* @param questionAssignments the question assignments
	*/
	public void cacheResult(
		java.util.List<com.liferay.experts.model.QuestionAssignment> questionAssignments);

	/**
	* Creates a new question assignment with the primary key. Does not add the question assignment to the database.
	*
	* @param questionAssignmentId the primary key for the new question assignment
	* @return the new question assignment
	*/
	public com.liferay.experts.model.QuestionAssignment create(
		long questionAssignmentId);

	/**
	* Removes the question assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment that was removed
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment remove(
		long questionAssignmentId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.experts.model.QuestionAssignment updateImpl(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignment with the primary key or throws a {@link com.liferay.experts.NoSuchQuestionAssignmentException} if it could not be found.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByPrimaryKey(
		long questionAssignmentId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment, or <code>null</code> if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByPrimaryKey(
		long questionAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the question assignments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the question assignments where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @return the range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the question assignments where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignments before and after the current question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionAssignmentId the primary key of the current question assignment
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment[] findByQuestionId_PrevAndNext(
		long questionAssignmentId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the question assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the question assignments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @return the range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the question assignments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignments before and after the current question assignment in the ordered set where userId = &#63;.
	*
	* @param questionAssignmentId the primary key of the current question assignment
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment[] findByUserId_PrevAndNext(
		long questionAssignmentId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the question assignments where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the question assignments where questionId = &#63; and locked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @return the range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the question assignments where questionId = &#63; and locked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByQI_L_First(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByQI_L_First(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByQI_L_Last(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByQI_L_Last(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignments before and after the current question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionAssignmentId the primary key of the current question assignment
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment[] findByQI_L_PrevAndNext(
		long questionAssignmentId, long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or throws a {@link com.liferay.experts.NoSuchQuestionAssignmentException} if it could not be found.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment findByUI_QI(
		long userId, long questionId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByUI_QI(
		long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment fetchByUI_QI(
		long userId, long questionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the question assignments.
	*
	* @return the question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the question assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @return the range of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the question assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of question assignments
	* @param end the upper bound of the range of question assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.QuestionAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the question assignments where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the question assignments where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the question assignments where questionId = &#63; and locked = &#63; from the database.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQI_L(long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the question assignment where userId = &#63; and questionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the question assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.QuestionAssignment removeByUI_QI(
		long userId, long questionId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the question assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question assignments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question assignments where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByQI_L(long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question assignments where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUI_QI(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question assignments.
	*
	* @return the number of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
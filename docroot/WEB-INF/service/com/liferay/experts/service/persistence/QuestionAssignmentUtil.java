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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the question assignment service. This utility wraps {@link QuestionAssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see QuestionAssignmentPersistence
 * @see QuestionAssignmentPersistenceImpl
 * @generated
 */
public class QuestionAssignmentUtil {
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
	public static void clearCache(QuestionAssignment questionAssignment) {
		getPersistence().clearCache(questionAssignment);
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
	public static List<QuestionAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static QuestionAssignment update(
		QuestionAssignment questionAssignment) throws SystemException {
		return getPersistence().update(questionAssignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static QuestionAssignment update(
		QuestionAssignment questionAssignment, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(questionAssignment, serviceContext);
	}

	/**
	* Caches the question assignment in the entity cache if it is enabled.
	*
	* @param questionAssignment the question assignment
	*/
	public static void cacheResult(
		com.liferay.experts.model.QuestionAssignment questionAssignment) {
		getPersistence().cacheResult(questionAssignment);
	}

	/**
	* Caches the question assignments in the entity cache if it is enabled.
	*
	* @param questionAssignments the question assignments
	*/
	public static void cacheResult(
		java.util.List<com.liferay.experts.model.QuestionAssignment> questionAssignments) {
		getPersistence().cacheResult(questionAssignments);
	}

	/**
	* Creates a new question assignment with the primary key. Does not add the question assignment to the database.
	*
	* @param questionAssignmentId the primary key for the new question assignment
	* @return the new question assignment
	*/
	public static com.liferay.experts.model.QuestionAssignment create(
		long questionAssignmentId) {
		return getPersistence().create(questionAssignmentId);
	}

	/**
	* Removes the question assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment that was removed
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment remove(
		long questionAssignmentId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(questionAssignmentId);
	}

	public static com.liferay.experts.model.QuestionAssignment updateImpl(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(questionAssignment);
	}

	/**
	* Returns the question assignment with the primary key or throws a {@link com.liferay.experts.NoSuchQuestionAssignmentException} if it could not be found.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByPrimaryKey(
		long questionAssignmentId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(questionAssignmentId);
	}

	/**
	* Returns the question assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionAssignmentId the primary key of the question assignment
	* @return the question assignment, or <code>null</code> if a question assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByPrimaryKey(
		long questionAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(questionAssignmentId);
	}

	/**
	* Returns all the question assignments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId, start, end);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId(questionId, start, end, orderByComparator);
	}

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId_First(questionId, orderByComparator);
	}

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_First(questionId, orderByComparator);
	}

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId_Last(questionId, orderByComparator);
	}

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_Last(questionId, orderByComparator);
	}

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
	public static com.liferay.experts.model.QuestionAssignment[] findByQuestionId_PrevAndNext(
		long questionAssignmentId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId_PrevAndNext(questionAssignmentId,
			questionId, orderByComparator);
	}

	/**
	* Returns all the question assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last question assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

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
	public static com.liferay.experts.model.QuestionAssignment[] findByUserId_PrevAndNext(
		long questionAssignmentId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(questionAssignmentId, userId,
			orderByComparator);
	}

	/**
	* Returns all the question assignments where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @return the matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQI_L(questionId, locked);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQI_L(questionId, locked, start, end);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findByQI_L(
		long questionId, boolean locked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQI_L(questionId, locked, start, end, orderByComparator);
	}

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
	public static com.liferay.experts.model.QuestionAssignment findByQI_L_First(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQI_L_First(questionId, locked, orderByComparator);
	}

	/**
	* Returns the first question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByQI_L_First(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQI_L_First(questionId, locked, orderByComparator);
	}

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
	public static com.liferay.experts.model.QuestionAssignment findByQI_L_Last(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQI_L_Last(questionId, locked, orderByComparator);
	}

	/**
	* Returns the last question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByQI_L_Last(
		long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQI_L_Last(questionId, locked, orderByComparator);
	}

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
	public static com.liferay.experts.model.QuestionAssignment[] findByQI_L_PrevAndNext(
		long questionAssignmentId, long questionId, boolean locked,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQI_L_PrevAndNext(questionAssignmentId, questionId,
			locked, orderByComparator);
	}

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or throws a {@link com.liferay.experts.NoSuchQuestionAssignmentException} if it could not be found.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching question assignment
	* @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment findByUI_QI(
		long userId, long questionId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUI_QI(userId, questionId);
	}

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByUI_QI(
		long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUI_QI(userId, questionId);
	}

	/**
	* Returns the question assignment where userId = &#63; and questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching question assignment, or <code>null</code> if a matching question assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment fetchByUI_QI(
		long userId, long questionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUI_QI(userId, questionId, retrieveFromCache);
	}

	/**
	* Returns all the question assignments.
	*
	* @return the question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.experts.model.QuestionAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the question assignments where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Removes all the question assignments where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the question assignments where questionId = &#63; and locked = &#63; from the database.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQI_L(long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQI_L(questionId, locked);
	}

	/**
	* Removes the question assignment where userId = &#63; and questionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the question assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.QuestionAssignment removeByUI_QI(
		long userId, long questionId)
		throws com.liferay.experts.NoSuchQuestionAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUI_QI(userId, questionId);
	}

	/**
	* Removes all the question assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question assignments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns the number of question assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of question assignments where questionId = &#63; and locked = &#63;.
	*
	* @param questionId the question ID
	* @param locked the locked
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQI_L(long questionId, boolean locked)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQI_L(questionId, locked);
	}

	/**
	* Returns the number of question assignments where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the number of matching question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUI_QI(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUI_QI(userId, questionId);
	}

	/**
	* Returns the number of question assignments.
	*
	* @return the number of question assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuestionAssignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionAssignmentPersistence)PortletBeanLocatorUtil.locate(com.liferay.experts.service.ClpSerializer.getServletContextName(),
					QuestionAssignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionAssignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(QuestionAssignmentPersistence persistence) {
	}

	private static QuestionAssignmentPersistence _persistence;
}
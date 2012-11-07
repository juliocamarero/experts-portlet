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

import com.liferay.experts.model.TagAssignment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the tag assignment service. This utility wraps {@link TagAssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignmentPersistence
 * @see TagAssignmentPersistenceImpl
 * @generated
 */
public class TagAssignmentUtil {
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
	public static void clearCache(TagAssignment tagAssignment) {
		getPersistence().clearCache(tagAssignment);
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
	public static List<TagAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TagAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TagAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TagAssignment update(TagAssignment tagAssignment)
		throws SystemException {
		return getPersistence().update(tagAssignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TagAssignment update(TagAssignment tagAssignment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tagAssignment, serviceContext);
	}

	/**
	* Caches the tag assignment in the entity cache if it is enabled.
	*
	* @param tagAssignment the tag assignment
	*/
	public static void cacheResult(
		com.liferay.experts.model.TagAssignment tagAssignment) {
		getPersistence().cacheResult(tagAssignment);
	}

	/**
	* Caches the tag assignments in the entity cache if it is enabled.
	*
	* @param tagAssignments the tag assignments
	*/
	public static void cacheResult(
		java.util.List<com.liferay.experts.model.TagAssignment> tagAssignments) {
		getPersistence().cacheResult(tagAssignments);
	}

	/**
	* Creates a new tag assignment with the primary key. Does not add the tag assignment to the database.
	*
	* @param tagAssignmentId the primary key for the new tag assignment
	* @return the new tag assignment
	*/
	public static com.liferay.experts.model.TagAssignment create(
		long tagAssignmentId) {
		return getPersistence().create(tagAssignmentId);
	}

	/**
	* Removes the tag assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment that was removed
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment remove(
		long tagAssignmentId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(tagAssignmentId);
	}

	public static com.liferay.experts.model.TagAssignment updateImpl(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tagAssignment);
	}

	/**
	* Returns the tag assignment with the primary key or throws a {@link com.liferay.experts.NoSuchTagAssignmentException} if it could not be found.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByPrimaryKey(
		long tagAssignmentId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(tagAssignmentId);
	}

	/**
	* Returns the tag assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment, or <code>null</code> if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByPrimaryKey(
		long tagAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tagAssignmentId);
	}

	/**
	* Returns all the tag assignments where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @return the matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssetTagId(assetTagId);
	}

	/**
	* Returns a range of all the tag assignments where assetTagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetTagId the asset tag ID
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @return the range of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssetTagId(assetTagId, start, end);
	}

	/**
	* Returns an ordered range of all the tag assignments where assetTagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetTagId the asset tag ID
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssetTagId(assetTagId, start, end, orderByComparator);
	}

	/**
	* Returns the first tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByAssetTagId_First(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssetTagId_First(assetTagId, orderByComparator);
	}

	/**
	* Returns the first tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByAssetTagId_First(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssetTagId_First(assetTagId, orderByComparator);
	}

	/**
	* Returns the last tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByAssetTagId_Last(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssetTagId_Last(assetTagId, orderByComparator);
	}

	/**
	* Returns the last tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByAssetTagId_Last(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssetTagId_Last(assetTagId, orderByComparator);
	}

	/**
	* Returns the tag assignments before and after the current tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param tagAssignmentId the primary key of the current tag assignment
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment[] findByAssetTagId_PrevAndNext(
		long tagAssignmentId, long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssetTagId_PrevAndNext(tagAssignmentId, assetTagId,
			orderByComparator);
	}

	/**
	* Returns all the tag assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the tag assignments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @return the range of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the tag assignments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the tag assignments before and after the current tag assignment in the ordered set where userId = &#63;.
	*
	* @param tagAssignmentId the primary key of the current tag assignment
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment[] findByUserId_PrevAndNext(
		long tagAssignmentId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(tagAssignmentId, userId,
			orderByComparator);
	}

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or throws a {@link com.liferay.experts.NoSuchTagAssignmentException} if it could not be found.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment findByUI_ATI(
		long userId, long assetTagId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUI_ATI(userId, assetTagId);
	}

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByUI_ATI(
		long userId, long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUI_ATI(userId, assetTagId);
	}

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment fetchByUI_ATI(
		long userId, long assetTagId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUI_ATI(userId, assetTagId, retrieveFromCache);
	}

	/**
	* Returns all the tag assignments.
	*
	* @return the tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tag assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @return the range of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tag assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tag assignments
	* @param end the upper bound of the range of tag assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.experts.model.TagAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tag assignments where assetTagId = &#63; from the database.
	*
	* @param assetTagId the asset tag ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAssetTagId(long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAssetTagId(assetTagId);
	}

	/**
	* Removes all the tag assignments where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes the tag assignment where userId = &#63; and assetTagId = &#63; from the database.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the tag assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.experts.model.TagAssignment removeByUI_ATI(
		long userId, long assetTagId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUI_ATI(userId, assetTagId);
	}

	/**
	* Removes all the tag assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tag assignments where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAssetTagId(long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAssetTagId(assetTagId);
	}

	/**
	* Returns the number of tag assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of tag assignments where userId = &#63; and assetTagId = &#63;.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUI_ATI(long userId, long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUI_ATI(userId, assetTagId);
	}

	/**
	* Returns the number of tag assignments.
	*
	* @return the number of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TagAssignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TagAssignmentPersistence)PortletBeanLocatorUtil.locate(com.liferay.experts.service.ClpSerializer.getServletContextName(),
					TagAssignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(TagAssignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TagAssignmentPersistence persistence) {
	}

	private static TagAssignmentPersistence _persistence;
}
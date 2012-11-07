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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tag assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignmentPersistenceImpl
 * @see TagAssignmentUtil
 * @generated
 */
public interface TagAssignmentPersistence extends BasePersistence<TagAssignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagAssignmentUtil} to access the tag assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tag assignment in the entity cache if it is enabled.
	*
	* @param tagAssignment the tag assignment
	*/
	public void cacheResult(
		com.liferay.experts.model.TagAssignment tagAssignment);

	/**
	* Caches the tag assignments in the entity cache if it is enabled.
	*
	* @param tagAssignments the tag assignments
	*/
	public void cacheResult(
		java.util.List<com.liferay.experts.model.TagAssignment> tagAssignments);

	/**
	* Creates a new tag assignment with the primary key. Does not add the tag assignment to the database.
	*
	* @param tagAssignmentId the primary key for the new tag assignment
	* @return the new tag assignment
	*/
	public com.liferay.experts.model.TagAssignment create(long tagAssignmentId);

	/**
	* Removes the tag assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment that was removed
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment remove(long tagAssignmentId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.experts.model.TagAssignment updateImpl(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tag assignment with the primary key or throws a {@link com.liferay.experts.NoSuchTagAssignmentException} if it could not be found.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByPrimaryKey(
		long tagAssignmentId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tag assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagAssignmentId the primary key of the tag assignment
	* @return the tag assignment, or <code>null</code> if a tag assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByPrimaryKey(
		long tagAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tag assignments where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @return the matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findByAssetTagId(
		long assetTagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByAssetTagId_First(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByAssetTagId_First(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByAssetTagId_Last(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tag assignment in the ordered set where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByAssetTagId_Last(
		long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.experts.model.TagAssignment[] findByAssetTagId_PrevAndNext(
		long tagAssignmentId, long assetTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tag assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tag assignment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.experts.model.TagAssignment[] findByUserId_PrevAndNext(
		long tagAssignmentId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or throws a {@link com.liferay.experts.NoSuchTagAssignmentException} if it could not be found.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the matching tag assignment
	* @throws com.liferay.experts.NoSuchTagAssignmentException if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment findByUI_ATI(long userId,
		long assetTagId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByUI_ATI(long userId,
		long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tag assignment where userId = &#63; and assetTagId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment fetchByUI_ATI(long userId,
		long assetTagId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tag assignments.
	*
	* @return the tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.experts.model.TagAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.experts.model.TagAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tag assignments where assetTagId = &#63; from the database.
	*
	* @param assetTagId the asset tag ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAssetTagId(long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tag assignments where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tag assignment where userId = &#63; and assetTagId = &#63; from the database.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the tag assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.experts.model.TagAssignment removeByUI_ATI(long userId,
		long assetTagId)
		throws com.liferay.experts.NoSuchTagAssignmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tag assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tag assignments where assetTagId = &#63;.
	*
	* @param assetTagId the asset tag ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByAssetTagId(long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tag assignments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tag assignments where userId = &#63; and assetTagId = &#63;.
	*
	* @param userId the user ID
	* @param assetTagId the asset tag ID
	* @return the number of matching tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUI_ATI(long userId, long assetTagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tag assignments.
	*
	* @return the number of tag assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
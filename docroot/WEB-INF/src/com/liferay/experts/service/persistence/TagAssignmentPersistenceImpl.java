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

import com.liferay.experts.NoSuchTagAssignmentException;
import com.liferay.experts.model.TagAssignment;
import com.liferay.experts.model.impl.TagAssignmentImpl;
import com.liferay.experts.model.impl.TagAssignmentModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tag assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see TagAssignmentPersistence
 * @see TagAssignmentUtil
 * @generated
 */
public class TagAssignmentPersistenceImpl extends BasePersistenceImpl<TagAssignment>
	implements TagAssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TagAssignmentUtil} to access the tag assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TagAssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSETTAGID =
		new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAssetTagId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSETTAGID =
		new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAssetTagId", new String[] { Long.class.getName() },
			TagAssignmentModelImpl.ASSETTAGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSETTAGID = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssetTagId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			TagAssignmentModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UI_ATI = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUI_ATI",
			new String[] { Long.class.getName(), Long.class.getName() },
			TagAssignmentModelImpl.USERID_COLUMN_BITMASK |
			TagAssignmentModelImpl.ASSETTAGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UI_ATI = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUI_ATI",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TagAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tag assignment in the entity cache if it is enabled.
	 *
	 * @param tagAssignment the tag assignment
	 */
	public void cacheResult(TagAssignment tagAssignment) {
		EntityCacheUtil.putResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentImpl.class, tagAssignment.getPrimaryKey(),
			tagAssignment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_ATI,
			new Object[] {
				Long.valueOf(tagAssignment.getUserId()),
				Long.valueOf(tagAssignment.getAssetTagId())
			}, tagAssignment);

		tagAssignment.resetOriginalValues();
	}

	/**
	 * Caches the tag assignments in the entity cache if it is enabled.
	 *
	 * @param tagAssignments the tag assignments
	 */
	public void cacheResult(List<TagAssignment> tagAssignments) {
		for (TagAssignment tagAssignment : tagAssignments) {
			if (EntityCacheUtil.getResult(
						TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						TagAssignmentImpl.class, tagAssignment.getPrimaryKey()) == null) {
				cacheResult(tagAssignment);
			}
			else {
				tagAssignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tag assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TagAssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TagAssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tag assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TagAssignment tagAssignment) {
		EntityCacheUtil.removeResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentImpl.class, tagAssignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tagAssignment);
	}

	@Override
	public void clearCache(List<TagAssignment> tagAssignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TagAssignment tagAssignment : tagAssignments) {
			EntityCacheUtil.removeResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				TagAssignmentImpl.class, tagAssignment.getPrimaryKey());

			clearUniqueFindersCache(tagAssignment);
		}
	}

	protected void clearUniqueFindersCache(TagAssignment tagAssignment) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_ATI,
			new Object[] {
				Long.valueOf(tagAssignment.getUserId()),
				Long.valueOf(tagAssignment.getAssetTagId())
			});
	}

	/**
	 * Creates a new tag assignment with the primary key. Does not add the tag assignment to the database.
	 *
	 * @param tagAssignmentId the primary key for the new tag assignment
	 * @return the new tag assignment
	 */
	public TagAssignment create(long tagAssignmentId) {
		TagAssignment tagAssignment = new TagAssignmentImpl();

		tagAssignment.setNew(true);
		tagAssignment.setPrimaryKey(tagAssignmentId);

		return tagAssignment;
	}

	/**
	 * Removes the tag assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagAssignmentId the primary key of the tag assignment
	 * @return the tag assignment that was removed
	 * @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment remove(long tagAssignmentId)
		throws NoSuchTagAssignmentException, SystemException {
		return remove(Long.valueOf(tagAssignmentId));
	}

	/**
	 * Removes the tag assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tag assignment
	 * @return the tag assignment that was removed
	 * @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TagAssignment remove(Serializable primaryKey)
		throws NoSuchTagAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TagAssignment tagAssignment = (TagAssignment)session.get(TagAssignmentImpl.class,
					primaryKey);

			if (tagAssignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tagAssignment);
		}
		catch (NoSuchTagAssignmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TagAssignment removeImpl(TagAssignment tagAssignment)
		throws SystemException {
		tagAssignment = toUnwrappedModel(tagAssignment);

		Session session = null;

		try {
			session = openSession();

			if (tagAssignment.isCachedModel()) {
				tagAssignment = (TagAssignment)session.get(TagAssignmentImpl.class,
						tagAssignment.getPrimaryKeyObj());
			}

			if (tagAssignment != null) {
				session.delete(tagAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tagAssignment != null) {
			clearCache(tagAssignment);
		}

		return tagAssignment;
	}

	@Override
	public TagAssignment updateImpl(
		com.liferay.experts.model.TagAssignment tagAssignment)
		throws SystemException {
		tagAssignment = toUnwrappedModel(tagAssignment);

		boolean isNew = tagAssignment.isNew();

		TagAssignmentModelImpl tagAssignmentModelImpl = (TagAssignmentModelImpl)tagAssignment;

		Session session = null;

		try {
			session = openSession();

			if (tagAssignment.isNew()) {
				session.save(tagAssignment);

				tagAssignment.setNew(false);
			}
			else {
				session.merge(tagAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TagAssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tagAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSETTAGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tagAssignmentModelImpl.getOriginalAssetTagId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSETTAGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSETTAGID,
					args);

				args = new Object[] {
						Long.valueOf(tagAssignmentModelImpl.getAssetTagId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSETTAGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSETTAGID,
					args);
			}

			if ((tagAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tagAssignmentModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(tagAssignmentModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TagAssignmentImpl.class, tagAssignment.getPrimaryKey(),
			tagAssignment);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_ATI,
				new Object[] {
					Long.valueOf(tagAssignment.getUserId()),
					Long.valueOf(tagAssignment.getAssetTagId())
				}, tagAssignment);
		}
		else {
			if ((tagAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UI_ATI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tagAssignmentModelImpl.getOriginalUserId()),
						Long.valueOf(tagAssignmentModelImpl.getOriginalAssetTagId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UI_ATI, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_ATI, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_ATI,
					new Object[] {
						Long.valueOf(tagAssignment.getUserId()),
						Long.valueOf(tagAssignment.getAssetTagId())
					}, tagAssignment);
			}
		}

		return tagAssignment;
	}

	protected TagAssignment toUnwrappedModel(TagAssignment tagAssignment) {
		if (tagAssignment instanceof TagAssignmentImpl) {
			return tagAssignment;
		}

		TagAssignmentImpl tagAssignmentImpl = new TagAssignmentImpl();

		tagAssignmentImpl.setNew(tagAssignment.isNew());
		tagAssignmentImpl.setPrimaryKey(tagAssignment.getPrimaryKey());

		tagAssignmentImpl.setTagAssignmentId(tagAssignment.getTagAssignmentId());
		tagAssignmentImpl.setCompanyId(tagAssignment.getCompanyId());
		tagAssignmentImpl.setUserId(tagAssignment.getUserId());
		tagAssignmentImpl.setUserName(tagAssignment.getUserName());
		tagAssignmentImpl.setAssetTagId(tagAssignment.getAssetTagId());
		tagAssignmentImpl.setAssetTagName(tagAssignment.getAssetTagName());
		tagAssignmentImpl.setLocked(tagAssignment.isLocked());

		return tagAssignmentImpl;
	}

	/**
	 * Returns the tag assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tag assignment
	 * @return the tag assignment
	 * @throws com.liferay.portal.NoSuchModelException if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TagAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tag assignment with the primary key or throws a {@link com.liferay.experts.NoSuchTagAssignmentException} if it could not be found.
	 *
	 * @param tagAssignmentId the primary key of the tag assignment
	 * @return the tag assignment
	 * @throws com.liferay.experts.NoSuchTagAssignmentException if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment findByPrimaryKey(long tagAssignmentId)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByPrimaryKey(tagAssignmentId);

		if (tagAssignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + tagAssignmentId);
			}

			throw new NoSuchTagAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				tagAssignmentId);
		}

		return tagAssignment;
	}

	/**
	 * Returns the tag assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tag assignment
	 * @return the tag assignment, or <code>null</code> if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TagAssignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tag assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagAssignmentId the primary key of the tag assignment
	 * @return the tag assignment, or <code>null</code> if a tag assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByPrimaryKey(long tagAssignmentId)
		throws SystemException {
		TagAssignment tagAssignment = (TagAssignment)EntityCacheUtil.getResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				TagAssignmentImpl.class, tagAssignmentId);

		if (tagAssignment == _nullTagAssignment) {
			return null;
		}

		if (tagAssignment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tagAssignment = (TagAssignment)session.get(TagAssignmentImpl.class,
						Long.valueOf(tagAssignmentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tagAssignment != null) {
					cacheResult(tagAssignment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TagAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						TagAssignmentImpl.class, tagAssignmentId,
						_nullTagAssignment);
				}

				closeSession(session);
			}
		}

		return tagAssignment;
	}

	/**
	 * Returns all the tag assignments where assetTagId = &#63;.
	 *
	 * @param assetTagId the asset tag ID
	 * @return the matching tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TagAssignment> findByAssetTagId(long assetTagId)
		throws SystemException {
		return findByAssetTagId(assetTagId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<TagAssignment> findByAssetTagId(long assetTagId, int start,
		int end) throws SystemException {
		return findByAssetTagId(assetTagId, start, end, null);
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
	public List<TagAssignment> findByAssetTagId(long assetTagId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSETTAGID;
			finderArgs = new Object[] { assetTagId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSETTAGID;
			finderArgs = new Object[] { assetTagId, start, end, orderByComparator };
		}

		List<TagAssignment> list = (List<TagAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TagAssignment tagAssignment : list) {
				if ((assetTagId != tagAssignment.getAssetTagId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSETTAGID_ASSETTAGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TagAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetTagId);

				list = (List<TagAssignment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TagAssignment findByAssetTagId_First(long assetTagId,
		OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByAssetTagId_First(assetTagId,
				orderByComparator);

		if (tagAssignment != null) {
			return tagAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assetTagId=");
		msg.append(assetTagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagAssignmentException(msg.toString());
	}

	/**
	 * Returns the first tag assignment in the ordered set where assetTagId = &#63;.
	 *
	 * @param assetTagId the asset tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByAssetTagId_First(long assetTagId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TagAssignment> list = findByAssetTagId(assetTagId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TagAssignment findByAssetTagId_Last(long assetTagId,
		OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByAssetTagId_Last(assetTagId,
				orderByComparator);

		if (tagAssignment != null) {
			return tagAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assetTagId=");
		msg.append(assetTagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagAssignmentException(msg.toString());
	}

	/**
	 * Returns the last tag assignment in the ordered set where assetTagId = &#63;.
	 *
	 * @param assetTagId the asset tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByAssetTagId_Last(long assetTagId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAssetTagId(assetTagId);

		List<TagAssignment> list = findByAssetTagId(assetTagId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TagAssignment[] findByAssetTagId_PrevAndNext(long tagAssignmentId,
		long assetTagId, OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = findByPrimaryKey(tagAssignmentId);

		Session session = null;

		try {
			session = openSession();

			TagAssignment[] array = new TagAssignmentImpl[3];

			array[0] = getByAssetTagId_PrevAndNext(session, tagAssignment,
					assetTagId, orderByComparator, true);

			array[1] = tagAssignment;

			array[2] = getByAssetTagId_PrevAndNext(session, tagAssignment,
					assetTagId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TagAssignment getByAssetTagId_PrevAndNext(Session session,
		TagAssignment tagAssignment, long assetTagId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGASSIGNMENT_WHERE);

		query.append(_FINDER_COLUMN_ASSETTAGID_ASSETTAGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TagAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(assetTagId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TagAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tag assignments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TagAssignment> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TagAssignment> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<TagAssignment> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<TagAssignment> list = (List<TagAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TagAssignment tagAssignment : list) {
				if ((userId != tagAssignment.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TagAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<TagAssignment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TagAssignment findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByUserId_First(userId,
				orderByComparator);

		if (tagAssignment != null) {
			return tagAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagAssignmentException(msg.toString());
	}

	/**
	 * Returns the first tag assignment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TagAssignment> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TagAssignment findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByUserId_Last(userId,
				orderByComparator);

		if (tagAssignment != null) {
			return tagAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagAssignmentException(msg.toString());
	}

	/**
	 * Returns the last tag assignment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<TagAssignment> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TagAssignment[] findByUserId_PrevAndNext(long tagAssignmentId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = findByPrimaryKey(tagAssignmentId);

		Session session = null;

		try {
			session = openSession();

			TagAssignment[] array = new TagAssignmentImpl[3];

			array[0] = getByUserId_PrevAndNext(session, tagAssignment, userId,
					orderByComparator, true);

			array[1] = tagAssignment;

			array[2] = getByUserId_PrevAndNext(session, tagAssignment, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TagAssignment getByUserId_PrevAndNext(Session session,
		TagAssignment tagAssignment, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGASSIGNMENT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TagAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TagAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public TagAssignment findByUI_ATI(long userId, long assetTagId)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = fetchByUI_ATI(userId, assetTagId);

		if (tagAssignment == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", assetTagId=");
			msg.append(assetTagId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTagAssignmentException(msg.toString());
		}

		return tagAssignment;
	}

	/**
	 * Returns the tag assignment where userId = &#63; and assetTagId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param assetTagId the asset tag ID
	 * @return the matching tag assignment, or <code>null</code> if a matching tag assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment fetchByUI_ATI(long userId, long assetTagId)
		throws SystemException {
		return fetchByUI_ATI(userId, assetTagId, true);
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
	public TagAssignment fetchByUI_ATI(long userId, long assetTagId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, assetTagId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UI_ATI,
					finderArgs, this);
		}

		if (result instanceof TagAssignment) {
			TagAssignment tagAssignment = (TagAssignment)result;

			if ((userId != tagAssignment.getUserId()) ||
					(assetTagId != tagAssignment.getAssetTagId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_UI_ATI_USERID_2);

			query.append(_FINDER_COLUMN_UI_ATI_ASSETTAGID_2);

			query.append(TagAssignmentModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(assetTagId);

				List<TagAssignment> list = q.list();

				result = list;

				TagAssignment tagAssignment = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_ATI,
						finderArgs, list);
				}
				else {
					tagAssignment = list.get(0);

					cacheResult(tagAssignment);

					if ((tagAssignment.getUserId() != userId) ||
							(tagAssignment.getAssetTagId() != assetTagId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_ATI,
							finderArgs, tagAssignment);
					}
				}

				return tagAssignment;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_ATI,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (TagAssignment)result;
			}
		}
	}

	/**
	 * Returns all the tag assignments.
	 *
	 * @return the tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TagAssignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TagAssignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<TagAssignment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TagAssignment> list = (List<TagAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAGASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAGASSIGNMENT.concat(TagAssignmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TagAssignment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TagAssignment>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tag assignments where assetTagId = &#63; from the database.
	 *
	 * @param assetTagId the asset tag ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAssetTagId(long assetTagId) throws SystemException {
		for (TagAssignment tagAssignment : findByAssetTagId(assetTagId)) {
			remove(tagAssignment);
		}
	}

	/**
	 * Removes all the tag assignments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (TagAssignment tagAssignment : findByUserId(userId)) {
			remove(tagAssignment);
		}
	}

	/**
	 * Removes the tag assignment where userId = &#63; and assetTagId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param assetTagId the asset tag ID
	 * @return the tag assignment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public TagAssignment removeByUI_ATI(long userId, long assetTagId)
		throws NoSuchTagAssignmentException, SystemException {
		TagAssignment tagAssignment = findByUI_ATI(userId, assetTagId);

		return remove(tagAssignment);
	}

	/**
	 * Removes all the tag assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TagAssignment tagAssignment : findAll()) {
			remove(tagAssignment);
		}
	}

	/**
	 * Returns the number of tag assignments where assetTagId = &#63;.
	 *
	 * @param assetTagId the asset tag ID
	 * @return the number of matching tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAssetTagId(long assetTagId) throws SystemException {
		Object[] finderArgs = new Object[] { assetTagId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ASSETTAGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSETTAGID_ASSETTAGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetTagId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSETTAGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tag assignments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tag assignments where userId = &#63; and assetTagId = &#63;.
	 *
	 * @param userId the user ID
	 * @param assetTagId the asset tag ID
	 * @return the number of matching tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUI_ATI(long userId, long assetTagId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, assetTagId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UI_ATI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAGASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_UI_ATI_USERID_2);

			query.append(_FINDER_COLUMN_UI_ATI_ASSETTAGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(assetTagId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UI_ATI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tag assignments.
	 *
	 * @return the number of tag assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAGASSIGNMENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the tag assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.experts.model.TagAssignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TagAssignment>> listenersList = new ArrayList<ModelListener<TagAssignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TagAssignment>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TagAssignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnswerPersistence.class)
	protected AnswerPersistence answerPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionAssignmentPersistence.class)
	protected QuestionAssignmentPersistence questionAssignmentPersistence;
	@BeanReference(type = TagAssignmentPersistence.class)
	protected TagAssignmentPersistence tagAssignmentPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	private static final String _SQL_SELECT_TAGASSIGNMENT = "SELECT tagAssignment FROM TagAssignment tagAssignment";
	private static final String _SQL_SELECT_TAGASSIGNMENT_WHERE = "SELECT tagAssignment FROM TagAssignment tagAssignment WHERE ";
	private static final String _SQL_COUNT_TAGASSIGNMENT = "SELECT COUNT(tagAssignment) FROM TagAssignment tagAssignment";
	private static final String _SQL_COUNT_TAGASSIGNMENT_WHERE = "SELECT COUNT(tagAssignment) FROM TagAssignment tagAssignment WHERE ";
	private static final String _FINDER_COLUMN_ASSETTAGID_ASSETTAGID_2 = "tagAssignment.assetTagId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "tagAssignment.userId = ?";
	private static final String _FINDER_COLUMN_UI_ATI_USERID_2 = "tagAssignment.userId = ? AND ";
	private static final String _FINDER_COLUMN_UI_ATI_ASSETTAGID_2 = "tagAssignment.assetTagId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tagAssignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TagAssignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TagAssignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TagAssignmentPersistenceImpl.class);
	private static TagAssignment _nullTagAssignment = new TagAssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TagAssignment> toCacheModel() {
				return _nullTagAssignmentCacheModel;
			}
		};

	private static CacheModel<TagAssignment> _nullTagAssignmentCacheModel = new CacheModel<TagAssignment>() {
			public TagAssignment toEntityModel() {
				return _nullTagAssignment;
			}
		};
}
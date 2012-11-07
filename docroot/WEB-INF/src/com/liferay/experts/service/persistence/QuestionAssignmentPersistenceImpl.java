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

import com.liferay.experts.NoSuchQuestionAssignmentException;
import com.liferay.experts.model.QuestionAssignment;
import com.liferay.experts.model.impl.QuestionAssignmentImpl;
import com.liferay.experts.model.impl.QuestionAssignmentModelImpl;

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
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the question assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see QuestionAssignmentPersistence
 * @see QuestionAssignmentUtil
 * @generated
 */
public class QuestionAssignmentPersistenceImpl extends BasePersistenceImpl<QuestionAssignment>
	implements QuestionAssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionAssignmentUtil} to access the question assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionAssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			QuestionAssignmentModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			QuestionAssignmentModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QI_L = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQI_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QI_L = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQI_L",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			QuestionAssignmentModelImpl.QUESTIONID_COLUMN_BITMASK |
			QuestionAssignmentModelImpl.LOCKED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QI_L = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQI_L",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UI_QI = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUI_QI",
			new String[] { Long.class.getName(), Long.class.getName() },
			QuestionAssignmentModelImpl.USERID_COLUMN_BITMASK |
			QuestionAssignmentModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UI_QI = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUI_QI",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED,
			QuestionAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the question assignment in the entity cache if it is enabled.
	 *
	 * @param questionAssignment the question assignment
	 */
	public void cacheResult(QuestionAssignment questionAssignment) {
		EntityCacheUtil.putResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentImpl.class, questionAssignment.getPrimaryKey(),
			questionAssignment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_QI,
			new Object[] {
				Long.valueOf(questionAssignment.getUserId()),
				Long.valueOf(questionAssignment.getQuestionId())
			}, questionAssignment);

		questionAssignment.resetOriginalValues();
	}

	/**
	 * Caches the question assignments in the entity cache if it is enabled.
	 *
	 * @param questionAssignments the question assignments
	 */
	public void cacheResult(List<QuestionAssignment> questionAssignments) {
		for (QuestionAssignment questionAssignment : questionAssignments) {
			if (EntityCacheUtil.getResult(
						QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						QuestionAssignmentImpl.class,
						questionAssignment.getPrimaryKey()) == null) {
				cacheResult(questionAssignment);
			}
			else {
				questionAssignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionAssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionAssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionAssignment questionAssignment) {
		EntityCacheUtil.removeResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentImpl.class, questionAssignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(questionAssignment);
	}

	@Override
	public void clearCache(List<QuestionAssignment> questionAssignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionAssignment questionAssignment : questionAssignments) {
			EntityCacheUtil.removeResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				QuestionAssignmentImpl.class, questionAssignment.getPrimaryKey());

			clearUniqueFindersCache(questionAssignment);
		}
	}

	protected void clearUniqueFindersCache(
		QuestionAssignment questionAssignment) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_QI,
			new Object[] {
				Long.valueOf(questionAssignment.getUserId()),
				Long.valueOf(questionAssignment.getQuestionId())
			});
	}

	/**
	 * Creates a new question assignment with the primary key. Does not add the question assignment to the database.
	 *
	 * @param questionAssignmentId the primary key for the new question assignment
	 * @return the new question assignment
	 */
	public QuestionAssignment create(long questionAssignmentId) {
		QuestionAssignment questionAssignment = new QuestionAssignmentImpl();

		questionAssignment.setNew(true);
		questionAssignment.setPrimaryKey(questionAssignmentId);

		return questionAssignment;
	}

	/**
	 * Removes the question assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionAssignmentId the primary key of the question assignment
	 * @return the question assignment that was removed
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment remove(long questionAssignmentId)
		throws NoSuchQuestionAssignmentException, SystemException {
		return remove(Long.valueOf(questionAssignmentId));
	}

	/**
	 * Removes the question assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question assignment
	 * @return the question assignment that was removed
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAssignment remove(Serializable primaryKey)
		throws NoSuchQuestionAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QuestionAssignment questionAssignment = (QuestionAssignment)session.get(QuestionAssignmentImpl.class,
					primaryKey);

			if (questionAssignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionAssignment);
		}
		catch (NoSuchQuestionAssignmentException nsee) {
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
	protected QuestionAssignment removeImpl(
		QuestionAssignment questionAssignment) throws SystemException {
		questionAssignment = toUnwrappedModel(questionAssignment);

		Session session = null;

		try {
			session = openSession();

			if (questionAssignment.isCachedModel()) {
				questionAssignment = (QuestionAssignment)session.get(QuestionAssignmentImpl.class,
						questionAssignment.getPrimaryKeyObj());
			}

			if (questionAssignment != null) {
				session.delete(questionAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionAssignment != null) {
			clearCache(questionAssignment);
		}

		return questionAssignment;
	}

	@Override
	public QuestionAssignment updateImpl(
		com.liferay.experts.model.QuestionAssignment questionAssignment)
		throws SystemException {
		questionAssignment = toUnwrappedModel(questionAssignment);

		boolean isNew = questionAssignment.isNew();

		QuestionAssignmentModelImpl questionAssignmentModelImpl = (QuestionAssignmentModelImpl)questionAssignment;

		Session session = null;

		try {
			session = openSession();

			if (questionAssignment.isNew()) {
				session.save(questionAssignment);

				questionAssignment.setNew(false);
			}
			else {
				session.merge(questionAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuestionAssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((questionAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}

			if ((questionAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((questionAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QI_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getOriginalQuestionId()),
						Boolean.valueOf(questionAssignmentModelImpl.getOriginalLocked())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QI_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QI_L,
					args);

				args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getQuestionId()),
						Boolean.valueOf(questionAssignmentModelImpl.getLocked())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QI_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QI_L,
					args);
			}
		}

		EntityCacheUtil.putResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAssignmentImpl.class, questionAssignment.getPrimaryKey(),
			questionAssignment);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_QI,
				new Object[] {
					Long.valueOf(questionAssignment.getUserId()),
					Long.valueOf(questionAssignment.getQuestionId())
				}, questionAssignment);
		}
		else {
			if ((questionAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UI_QI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(questionAssignmentModelImpl.getOriginalUserId()),
						Long.valueOf(questionAssignmentModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UI_QI, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_QI, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_QI,
					new Object[] {
						Long.valueOf(questionAssignment.getUserId()),
						Long.valueOf(questionAssignment.getQuestionId())
					}, questionAssignment);
			}
		}

		return questionAssignment;
	}

	protected QuestionAssignment toUnwrappedModel(
		QuestionAssignment questionAssignment) {
		if (questionAssignment instanceof QuestionAssignmentImpl) {
			return questionAssignment;
		}

		QuestionAssignmentImpl questionAssignmentImpl = new QuestionAssignmentImpl();

		questionAssignmentImpl.setNew(questionAssignment.isNew());
		questionAssignmentImpl.setPrimaryKey(questionAssignment.getPrimaryKey());

		questionAssignmentImpl.setQuestionAssignmentId(questionAssignment.getQuestionAssignmentId());
		questionAssignmentImpl.setCompanyId(questionAssignment.getCompanyId());
		questionAssignmentImpl.setUserId(questionAssignment.getUserId());
		questionAssignmentImpl.setUserName(questionAssignment.getUserName());
		questionAssignmentImpl.setModifiedDate(questionAssignment.getModifiedDate());
		questionAssignmentImpl.setQuestionId(questionAssignment.getQuestionId());
		questionAssignmentImpl.setLocked(questionAssignment.isLocked());

		return questionAssignmentImpl;
	}

	/**
	 * Returns the question assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question assignment
	 * @return the question assignment
	 * @throws com.liferay.portal.NoSuchModelException if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question assignment with the primary key or throws a {@link com.liferay.experts.NoSuchQuestionAssignmentException} if it could not be found.
	 *
	 * @param questionAssignmentId the primary key of the question assignment
	 * @return the question assignment
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment findByPrimaryKey(long questionAssignmentId)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByPrimaryKey(questionAssignmentId);

		if (questionAssignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					questionAssignmentId);
			}

			throw new NoSuchQuestionAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				questionAssignmentId);
		}

		return questionAssignment;
	}

	/**
	 * Returns the question assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question assignment
	 * @return the question assignment, or <code>null</code> if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAssignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionAssignmentId the primary key of the question assignment
	 * @return the question assignment, or <code>null</code> if a question assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByPrimaryKey(long questionAssignmentId)
		throws SystemException {
		QuestionAssignment questionAssignment = (QuestionAssignment)EntityCacheUtil.getResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				QuestionAssignmentImpl.class, questionAssignmentId);

		if (questionAssignment == _nullQuestionAssignment) {
			return null;
		}

		if (questionAssignment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				questionAssignment = (QuestionAssignment)session.get(QuestionAssignmentImpl.class,
						Long.valueOf(questionAssignmentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (questionAssignment != null) {
					cacheResult(questionAssignment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						QuestionAssignmentImpl.class, questionAssignmentId,
						_nullQuestionAssignment);
				}

				closeSession(session);
			}
		}

		return questionAssignment;
	}

	/**
	 * Returns all the question assignments where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAssignment> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<QuestionAssignment> findByQuestionId(long questionId,
		int start, int end) throws SystemException {
		return findByQuestionId(questionId, start, end, null);
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
	public List<QuestionAssignment> findByQuestionId(long questionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId, start, end, orderByComparator };
		}

		List<QuestionAssignment> list = (List<QuestionAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QuestionAssignment questionAssignment : list) {
				if ((questionId != questionAssignment.getQuestionId())) {
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

			query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				list = (List<QuestionAssignment>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first question assignment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question assignment
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByQuestionId_First(questionId,
				orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
	}

	/**
	 * Returns the first question assignment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByQuestionId_First(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<QuestionAssignment> list = findByQuestionId(questionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByQuestionId_Last(questionId,
				orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
	}

	/**
	 * Returns the last question assignment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQuestionId(questionId);

		List<QuestionAssignment> list = findByQuestionId(questionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment[] findByQuestionId_PrevAndNext(
		long questionAssignmentId, long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = findByPrimaryKey(questionAssignmentId);

		Session session = null;

		try {
			session = openSession();

			QuestionAssignment[] array = new QuestionAssignmentImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, questionAssignment,
					questionId, orderByComparator, true);

			array[1] = questionAssignment;

			array[2] = getByQuestionId_PrevAndNext(session, questionAssignment,
					questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuestionAssignment getByQuestionId_PrevAndNext(Session session,
		QuestionAssignment questionAssignment, long questionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

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
			query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(questionAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the question assignments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAssignment> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<QuestionAssignment> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<QuestionAssignment> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<QuestionAssignment> list = (List<QuestionAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QuestionAssignment questionAssignment : list) {
				if ((userId != questionAssignment.getUserId())) {
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

			query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<QuestionAssignment>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first question assignment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question assignment
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByUserId_First(userId,
				orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
	}

	/**
	 * Returns the first question assignment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question assignment, or <code>null</code> if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<QuestionAssignment> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByUserId_Last(userId,
				orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
	}

	/**
	 * Returns the last question assignment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question assignment, or <code>null</code> if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<QuestionAssignment> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment[] findByUserId_PrevAndNext(
		long questionAssignmentId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = findByPrimaryKey(questionAssignmentId);

		Session session = null;

		try {
			session = openSession();

			QuestionAssignment[] array = new QuestionAssignmentImpl[3];

			array[0] = getByUserId_PrevAndNext(session, questionAssignment,
					userId, orderByComparator, true);

			array[1] = questionAssignment;

			array[2] = getByUserId_PrevAndNext(session, questionAssignment,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuestionAssignment getByUserId_PrevAndNext(Session session,
		QuestionAssignment questionAssignment, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

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
			query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(questionAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the question assignments where questionId = &#63; and locked = &#63;.
	 *
	 * @param questionId the question ID
	 * @param locked the locked
	 * @return the matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAssignment> findByQI_L(long questionId, boolean locked)
		throws SystemException {
		return findByQI_L(questionId, locked, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<QuestionAssignment> findByQI_L(long questionId, boolean locked,
		int start, int end) throws SystemException {
		return findByQI_L(questionId, locked, start, end, null);
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
	public List<QuestionAssignment> findByQI_L(long questionId, boolean locked,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QI_L;
			finderArgs = new Object[] { questionId, locked };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QI_L;
			finderArgs = new Object[] {
					questionId, locked,
					
					start, end, orderByComparator
				};
		}

		List<QuestionAssignment> list = (List<QuestionAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QuestionAssignment questionAssignment : list) {
				if ((questionId != questionAssignment.getQuestionId()) ||
						(locked != questionAssignment.getLocked())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_QI_L_QUESTIONID_2);

			query.append(_FINDER_COLUMN_QI_L_LOCKED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(locked);

				list = (List<QuestionAssignment>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first question assignment in the ordered set where questionId = &#63; and locked = &#63;.
	 *
	 * @param questionId the question ID
	 * @param locked the locked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question assignment
	 * @throws com.liferay.experts.NoSuchQuestionAssignmentException if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment findByQI_L_First(long questionId, boolean locked,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByQI_L_First(questionId,
				locked, orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(", locked=");
		msg.append(locked);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
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
	public QuestionAssignment fetchByQI_L_First(long questionId,
		boolean locked, OrderByComparator orderByComparator)
		throws SystemException {
		List<QuestionAssignment> list = findByQI_L(questionId, locked, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment findByQI_L_Last(long questionId, boolean locked,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByQI_L_Last(questionId,
				locked, orderByComparator);

		if (questionAssignment != null) {
			return questionAssignment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(", locked=");
		msg.append(locked);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionAssignmentException(msg.toString());
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
	public QuestionAssignment fetchByQI_L_Last(long questionId, boolean locked,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQI_L(questionId, locked);

		List<QuestionAssignment> list = findByQI_L(questionId, locked,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public QuestionAssignment[] findByQI_L_PrevAndNext(
		long questionAssignmentId, long questionId, boolean locked,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = findByPrimaryKey(questionAssignmentId);

		Session session = null;

		try {
			session = openSession();

			QuestionAssignment[] array = new QuestionAssignmentImpl[3];

			array[0] = getByQI_L_PrevAndNext(session, questionAssignment,
					questionId, locked, orderByComparator, true);

			array[1] = questionAssignment;

			array[2] = getByQI_L_PrevAndNext(session, questionAssignment,
					questionId, locked, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuestionAssignment getByQI_L_PrevAndNext(Session session,
		QuestionAssignment questionAssignment, long questionId, boolean locked,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

		query.append(_FINDER_COLUMN_QI_L_QUESTIONID_2);

		query.append(_FINDER_COLUMN_QI_L_LOCKED_2);

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
			query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		qPos.add(locked);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(questionAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public QuestionAssignment findByUI_QI(long userId, long questionId)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = fetchByUI_QI(userId, questionId);

		if (questionAssignment == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchQuestionAssignmentException(msg.toString());
		}

		return questionAssignment;
	}

	/**
	 * Returns the question assignment where userId = &#63; and questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @return the matching question assignment, or <code>null</code> if a matching question assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment fetchByUI_QI(long userId, long questionId)
		throws SystemException {
		return fetchByUI_QI(userId, questionId, true);
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
	public QuestionAssignment fetchByUI_QI(long userId, long questionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, questionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UI_QI,
					finderArgs, this);
		}

		if (result instanceof QuestionAssignment) {
			QuestionAssignment questionAssignment = (QuestionAssignment)result;

			if ((userId != questionAssignment.getUserId()) ||
					(questionId != questionAssignment.getQuestionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_UI_QI_USERID_2);

			query.append(_FINDER_COLUMN_UI_QI_QUESTIONID_2);

			query.append(QuestionAssignmentModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(questionId);

				List<QuestionAssignment> list = q.list();

				result = list;

				QuestionAssignment questionAssignment = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_QI,
						finderArgs, list);
				}
				else {
					questionAssignment = list.get(0);

					cacheResult(questionAssignment);

					if ((questionAssignment.getUserId() != userId) ||
							(questionAssignment.getQuestionId() != questionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UI_QI,
							finderArgs, questionAssignment);
					}
				}

				return questionAssignment;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UI_QI,
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
				return (QuestionAssignment)result;
			}
		}
	}

	/**
	 * Returns all the question assignments.
	 *
	 * @return the question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAssignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<QuestionAssignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<QuestionAssignment> findAll(int start, int end,
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

		List<QuestionAssignment> list = (List<QuestionAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTIONASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONASSIGNMENT.concat(QuestionAssignmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<QuestionAssignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<QuestionAssignment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the question assignments where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (QuestionAssignment questionAssignment : findByQuestionId(
				questionId)) {
			remove(questionAssignment);
		}
	}

	/**
	 * Removes all the question assignments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (QuestionAssignment questionAssignment : findByUserId(userId)) {
			remove(questionAssignment);
		}
	}

	/**
	 * Removes all the question assignments where questionId = &#63; and locked = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @param locked the locked
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQI_L(long questionId, boolean locked)
		throws SystemException {
		for (QuestionAssignment questionAssignment : findByQI_L(questionId,
				locked)) {
			remove(questionAssignment);
		}
	}

	/**
	 * Removes the question assignment where userId = &#63; and questionId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @return the question assignment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAssignment removeByUI_QI(long userId, long questionId)
		throws NoSuchQuestionAssignmentException, SystemException {
		QuestionAssignment questionAssignment = findByUI_QI(userId, questionId);

		return remove(questionAssignment);
	}

	/**
	 * Removes all the question assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (QuestionAssignment questionAssignment : findAll()) {
			remove(questionAssignment);
		}
	}

	/**
	 * Returns the number of question assignments where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of question assignments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONASSIGNMENT_WHERE);

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
	 * Returns the number of question assignments where questionId = &#63; and locked = &#63;.
	 *
	 * @param questionId the question ID
	 * @param locked the locked
	 * @return the number of matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQI_L(long questionId, boolean locked)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionId, locked };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QI_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_QI_L_QUESTIONID_2);

			query.append(_FINDER_COLUMN_QI_L_LOCKED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(locked);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QI_L,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of question assignments where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @return the number of matching question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUI_QI(long userId, long questionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UI_QI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUESTIONASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_UI_QI_USERID_2);

			query.append(_FINDER_COLUMN_UI_QI_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UI_QI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of question assignments.
	 *
	 * @return the number of question assignments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONASSIGNMENT);

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
	 * Initializes the question assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.experts.model.QuestionAssignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QuestionAssignment>> listenersList = new ArrayList<ModelListener<QuestionAssignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QuestionAssignment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuestionAssignmentImpl.class.getName());
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
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_QUESTIONASSIGNMENT = "SELECT questionAssignment FROM QuestionAssignment questionAssignment";
	private static final String _SQL_SELECT_QUESTIONASSIGNMENT_WHERE = "SELECT questionAssignment FROM QuestionAssignment questionAssignment WHERE ";
	private static final String _SQL_COUNT_QUESTIONASSIGNMENT = "SELECT COUNT(questionAssignment) FROM QuestionAssignment questionAssignment";
	private static final String _SQL_COUNT_QUESTIONASSIGNMENT_WHERE = "SELECT COUNT(questionAssignment) FROM QuestionAssignment questionAssignment WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "questionAssignment.questionId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "questionAssignment.userId = ?";
	private static final String _FINDER_COLUMN_QI_L_QUESTIONID_2 = "questionAssignment.questionId = ? AND ";
	private static final String _FINDER_COLUMN_QI_L_LOCKED_2 = "questionAssignment.locked = ?";
	private static final String _FINDER_COLUMN_UI_QI_USERID_2 = "questionAssignment.userId = ? AND ";
	private static final String _FINDER_COLUMN_UI_QI_QUESTIONID_2 = "questionAssignment.questionId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionAssignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionAssignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QuestionAssignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionAssignmentPersistenceImpl.class);
	private static QuestionAssignment _nullQuestionAssignment = new QuestionAssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QuestionAssignment> toCacheModel() {
				return _nullQuestionAssignmentCacheModel;
			}
		};

	private static CacheModel<QuestionAssignment> _nullQuestionAssignmentCacheModel =
		new CacheModel<QuestionAssignment>() {
			public QuestionAssignment toEntityModel() {
				return _nullQuestionAssignment;
			}
		};
}
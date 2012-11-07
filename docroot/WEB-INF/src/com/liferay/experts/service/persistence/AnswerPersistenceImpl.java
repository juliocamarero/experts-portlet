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

import com.liferay.experts.NoSuchAnswerException;
import com.liferay.experts.model.Answer;
import com.liferay.experts.model.impl.AnswerImpl;
import com.liferay.experts.model.impl.AnswerModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see AnswerPersistence
 * @see AnswerUtil
 * @generated
 */
public class AnswerPersistenceImpl extends BasePersistenceImpl<Answer>
	implements AnswerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnswerUtil} to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnswerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AnswerModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AnswerModelImpl.UUID_COLUMN_BITMASK |
			AnswerModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_QUESTIONID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByQuestionId",
			new String[] { Long.class.getName() },
			AnswerModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			AnswerModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	public void cacheResult(Answer answer) {
		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
			new Object[] { Long.valueOf(answer.getQuestionId()) }, answer);

		answer.resetOriginalValues();
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public void cacheResult(List<Answer> answers) {
		for (Answer answer : answers) {
			if (EntityCacheUtil.getResult(
						AnswerModelImpl.ENTITY_CACHE_ENABLED, AnswerImpl.class,
						answer.getPrimaryKey()) == null) {
				cacheResult(answer);
			}
			else {
				answer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all answers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnswerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnswerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the answer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Answer answer) {
		EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(answer);
	}

	@Override
	public void clearCache(List<Answer> answers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Answer answer : answers) {
			EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answer.getPrimaryKey());

			clearUniqueFindersCache(answer);
		}
	}

	protected void clearUniqueFindersCache(Answer answer) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID,
			new Object[] { Long.valueOf(answer.getQuestionId()) });
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param answerId the primary key for the new answer
	 * @return the new answer
	 */
	public Answer create(long answerId) {
		Answer answer = new AnswerImpl();

		answer.setNew(true);
		answer.setPrimaryKey(answerId);

		String uuid = PortalUUIDUtil.generate();

		answer.setUuid(uuid);

		return answer;
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer that was removed
	 * @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer remove(long answerId)
		throws NoSuchAnswerException, SystemException {
		return remove(Long.valueOf(answerId));
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer that was removed
	 * @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer remove(Serializable primaryKey)
		throws NoSuchAnswerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Answer answer = (Answer)session.get(AnswerImpl.class, primaryKey);

			if (answer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(answer);
		}
		catch (NoSuchAnswerException nsee) {
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
	protected Answer removeImpl(Answer answer) throws SystemException {
		answer = toUnwrappedModel(answer);

		Session session = null;

		try {
			session = openSession();

			if (answer.isCachedModel()) {
				answer = (Answer)session.get(AnswerImpl.class,
						answer.getPrimaryKeyObj());
			}

			if (answer != null) {
				session.delete(answer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (answer != null) {
			clearCache(answer);
		}

		return answer;
	}

	@Override
	public Answer updateImpl(com.liferay.experts.model.Answer answer)
		throws SystemException {
		answer = toUnwrappedModel(answer);

		boolean isNew = answer.isNew();

		AnswerModelImpl answerModelImpl = (AnswerModelImpl)answer;

		if (Validator.isNull(answer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			answer.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (answer.isNew()) {
				session.save(answer);

				answer.setNew(false);
			}
			else {
				session.merge(answer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnswerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { answerModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { answerModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						answerModelImpl.getOriginalUuid(),
						Long.valueOf(answerModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						answerModelImpl.getUuid(),
						Long.valueOf(answerModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(answerModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(answerModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
				new Object[] { Long.valueOf(answer.getQuestionId()) }, answer);
		}
		else {
			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(answerModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
					new Object[] { Long.valueOf(answer.getQuestionId()) },
					answer);
			}
		}

		return answer;
	}

	protected Answer toUnwrappedModel(Answer answer) {
		if (answer instanceof AnswerImpl) {
			return answer;
		}

		AnswerImpl answerImpl = new AnswerImpl();

		answerImpl.setNew(answer.isNew());
		answerImpl.setPrimaryKey(answer.getPrimaryKey());

		answerImpl.setUuid(answer.getUuid());
		answerImpl.setAnswerId(answer.getAnswerId());
		answerImpl.setCompanyId(answer.getCompanyId());
		answerImpl.setUserId(answer.getUserId());
		answerImpl.setUserName(answer.getUserName());
		answerImpl.setCreateDate(answer.getCreateDate());
		answerImpl.setModifiedDate(answer.getModifiedDate());
		answerImpl.setQuestionId(answer.getQuestionId());
		answerImpl.setContent(answer.getContent());
		answerImpl.setData(answer.getData());

		return answerImpl;
	}

	/**
	 * Returns the answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer
	 * @throws com.liferay.portal.NoSuchModelException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the answer with the primary key or throws a {@link com.liferay.experts.NoSuchAnswerException} if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer
	 * @throws com.liferay.experts.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByPrimaryKey(long answerId)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByPrimaryKey(answerId);

		if (answer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + answerId);
			}

			throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				answerId);
		}

		return answer;
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByPrimaryKey(long answerId) throws SystemException {
		Answer answer = (Answer)EntityCacheUtil.getResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answerId);

		if (answer == _nullAnswer) {
			return null;
		}

		if (answer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				answer = (Answer)session.get(AnswerImpl.class,
						Long.valueOf(answerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (answer != null) {
					cacheResult(answer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
						AnswerImpl.class, answerId, _nullAnswer);
				}

				closeSession(session);
			}
		}

		return answer;
	}

	/**
	 * Returns all the answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Answer> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<Answer> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Answer answer : list) {
				if (!Validator.equals(uuid, answer.getUuid())) {
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

			query.append(_SQL_SELECT_ANSWER_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Answer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUuid_First(uuid, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Answer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUuid_Last(uuid, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Answer> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer[] findByUuid_PrevAndNext(long answerId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByPrimaryKey(answerId);

		Session session = null;

		try {
			session = openSession();

			Answer[] array = new AnswerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, answer, uuid,
					orderByComparator, true);

			array[1] = answer;

			array[2] = getByUuid_PrevAndNext(session, answer, uuid,
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

	protected Answer getByUuid_PrevAndNext(Session session, Answer answer,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANSWER_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

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
			query.append(AnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(answer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Answer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the answers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Answer> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	public List<Answer> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Answer answer : list) {
				if (!Validator.equals(uuid, answer.getUuid()) ||
						(companyId != answer.getCompanyId())) {
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

			query.append(_SQL_SELECT_ANSWER_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_C_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_C_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				list = (List<Answer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first answer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
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
	public Answer fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Answer> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
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
	public Answer fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		List<Answer> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer[] findByUuid_C_PrevAndNext(long answerId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByPrimaryKey(answerId);

		Session session = null;

		try {
			session = openSession();

			Answer[] array = new AnswerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, answer, uuid,
					companyId, orderByComparator, true);

			array[1] = answer;

			array[2] = getByUuid_C_PrevAndNext(session, answer, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Answer getByUuid_C_PrevAndNext(Session session, Answer answer,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANSWER_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(AnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(answer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Answer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the answer where questionId = &#63; or throws a {@link com.liferay.experts.NoSuchAnswerException} if it could not be found.
	 *
	 * @param questionId the question ID
	 * @return the matching answer
	 * @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByQuestionId(long questionId)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByQuestionId(questionId);

		if (answer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAnswerException(msg.toString());
		}

		return answer;
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByQuestionId(long questionId) throws SystemException {
		return fetchByQuestionId(questionId, true);
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByQuestionId(long questionId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_QUESTIONID,
					finderArgs, this);
		}

		if (result instanceof Answer) {
			Answer answer = (Answer)result;

			if ((questionId != answer.getQuestionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			query.append(AnswerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				List<Answer> list = q.list();

				result = list;

				Answer answer = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
						finderArgs, list);
				}
				else {
					answer = list.get(0);

					cacheResult(answer);

					if ((answer.getQuestionId() != questionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
							finderArgs, answer);
					}
				}

				return answer;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID,
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
				return (Answer)result;
			}
		}
	}

	/**
	 * Returns all the answers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Answer> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<Answer> findByUserId(long userId, int start, int end,
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

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Answer answer : list) {
				if ((userId != answer.getUserId())) {
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

			query.append(_SQL_SELECT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Answer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first answer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws com.liferay.experts.NoSuchAnswerException if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUserId_First(userId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the first answer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Answer> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByUserId_Last(userId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the last answer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<Answer> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Answer[] findByUserId_PrevAndNext(long answerId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByPrimaryKey(answerId);

		Session session = null;

		try {
			session = openSession();

			Answer[] array = new AnswerImpl[3];

			array[0] = getByUserId_PrevAndNext(session, answer, userId,
					orderByComparator, true);

			array[1] = answer;

			array[2] = getByUserId_PrevAndNext(session, answer, userId,
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

	protected Answer getByUserId_PrevAndNext(Session session, Answer answer,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANSWER_WHERE);

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
			query.append(AnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(answer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Answer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Answer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Answer> findAll(int start, int end,
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

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANSWER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWER.concat(AnswerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the answers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Answer answer : findByUuid(uuid)) {
			remove(answer);
		}
	}

	/**
	 * Removes all the answers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Answer answer : findByUuid_C(uuid, companyId)) {
			remove(answer);
		}
	}

	/**
	 * Removes the answer where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @return the answer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Answer removeByQuestionId(long questionId)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByQuestionId(questionId);

		return remove(answer);
	}

	/**
	 * Removes all the answers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (Answer answer : findByUserId(userId)) {
			remove(answer);
		}
	}

	/**
	 * Removes all the answers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Answer answer : findAll()) {
			remove(answer);
		}
	}

	/**
	 * Returns the number of answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANSWER_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of answers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANSWER_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_C_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_C_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_C,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of answers where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANSWER_WHERE);

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
	 * Returns the number of answers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANSWER_WHERE);

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
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANSWER);

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
	 * Initializes the answer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.experts.model.Answer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Answer>> listenersList = new ArrayList<ModelListener<Answer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Answer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnswerImpl.class.getName());
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
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	private static final String _SQL_SELECT_ANSWER = "SELECT answer FROM Answer answer";
	private static final String _SQL_SELECT_ANSWER_WHERE = "SELECT answer FROM Answer answer WHERE ";
	private static final String _SQL_COUNT_ANSWER = "SELECT COUNT(answer) FROM Answer answer";
	private static final String _SQL_COUNT_ANSWER_WHERE = "SELECT COUNT(answer) FROM Answer answer WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "answer.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "answer.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(answer.uuid IS NULL OR answer.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "answer.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "answer.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(answer.uuid IS NULL OR answer.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "answer.companyId = ?";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "answer.questionId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "answer.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "answer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Answer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Answer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnswerPersistenceImpl.class);
	private static Answer _nullAnswer = new AnswerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Answer> toCacheModel() {
				return _nullAnswerCacheModel;
			}
		};

	private static CacheModel<Answer> _nullAnswerCacheModel = new CacheModel<Answer>() {
			public Answer toEntityModel() {
				return _nullAnswer;
			}
		};
}
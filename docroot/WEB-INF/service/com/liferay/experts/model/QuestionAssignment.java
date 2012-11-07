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

package com.liferay.experts.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the QuestionAssignment service. Represents a row in the &quot;Experts_QuestionAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ryan Park
 * @see QuestionAssignmentModel
 * @see com.liferay.experts.model.impl.QuestionAssignmentImpl
 * @see com.liferay.experts.model.impl.QuestionAssignmentModelImpl
 * @generated
 */
public interface QuestionAssignment extends QuestionAssignmentModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.experts.model.impl.QuestionAssignmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.experts.model.Question getQuestion()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}
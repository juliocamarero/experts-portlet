create table Experts_Answer (
	uuid_ VARCHAR(75) null,
	answerId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	questionId LONG,
	content STRING null,
	data_ STRING null
);

create table Experts_Question (
	uuid_ VARCHAR(75) null,
	questionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(140) null,
	content STRING null,
	dueDate DATE null,
	data_ STRING null
);

create table Experts_QuestionAssignment (
	questionAssignmentId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	modifiedDate DATE null,
	questionId LONG,
	locked BOOLEAN
);

create table Experts_TagAssignment (
	tagAssignmentId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	assetTagId LONG,
	assetTagName VARCHAR(75) null,
	locked BOOLEAN
);
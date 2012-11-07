create index IX_2273630F on Experts_Answer (questionId);
create index IX_4D1E3674 on Experts_Answer (userId);
create index IX_69319C3A on Experts_Answer (uuid_);
create index IX_7AAE5FAE on Experts_Answer (uuid_, companyId);

create index IX_85AA6B1C on Experts_Question (userId);
create index IX_39783292 on Experts_Question (uuid_);
create index IX_9E9EE256 on Experts_Question (uuid_, companyId);

create index IX_5D2710E4 on Experts_QuestionAssignment (questionId);
create index IX_458428E2 on Experts_QuestionAssignment (questionId, locked);
create index IX_311416C9 on Experts_QuestionAssignment (userId);
create unique index IX_2E03631E on Experts_QuestionAssignment (userId, questionId);

create index IX_AAA76310 on Experts_TagAssignment (assetTagId);
create unique index IX_F898AB4A on Experts_TagAssignment (assetTagId, userId);
create index IX_524D6451 on Experts_TagAssignment (userId);
create unique index IX_8C85AD4A on Experts_TagAssignment (userId, assetTagId);
package org.lis_entity;

import java.util.ArrayList;
import java.util.List;

public class GithubProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public GithubProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNull() {
            addCriterion("project_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNotNull() {
            addCriterion("project_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressEqualTo(String value) {
            addCriterion("project_address =", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotEqualTo(String value) {
            addCriterion("project_address <>", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThan(String value) {
            addCriterion("project_address >", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_address >=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThan(String value) {
            addCriterion("project_address <", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThanOrEqualTo(String value) {
            addCriterion("project_address <=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLike(String value) {
            addCriterion("project_address like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotLike(String value) {
            addCriterion("project_address not like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIn(List<String> values) {
            addCriterion("project_address in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotIn(List<String> values) {
            addCriterion("project_address not in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressBetween(String value1, String value2) {
            addCriterion("project_address between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotBetween(String value1, String value2) {
            addCriterion("project_address not between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIsNull() {
            addCriterion("project_language is null");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIsNotNull() {
            addCriterion("project_language is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageEqualTo(String value) {
            addCriterion("project_language =", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotEqualTo(String value) {
            addCriterion("project_language <>", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageGreaterThan(String value) {
            addCriterion("project_language >", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("project_language >=", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLessThan(String value) {
            addCriterion("project_language <", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLessThanOrEqualTo(String value) {
            addCriterion("project_language <=", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLike(String value) {
            addCriterion("project_language like", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotLike(String value) {
            addCriterion("project_language not like", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIn(List<String> values) {
            addCriterion("project_language in", values, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotIn(List<String> values) {
            addCriterion("project_language not in", values, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageBetween(String value1, String value2) {
            addCriterion("project_language between", value1, value2, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotBetween(String value1, String value2) {
            addCriterion("project_language not between", value1, value2, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectForkIsNull() {
            addCriterion("project_fork is null");
            return (Criteria) this;
        }

        public Criteria andProjectForkIsNotNull() {
            addCriterion("project_fork is not null");
            return (Criteria) this;
        }

        public Criteria andProjectForkEqualTo(Long value) {
            addCriterion("project_fork =", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkNotEqualTo(Long value) {
            addCriterion("project_fork <>", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkGreaterThan(Long value) {
            addCriterion("project_fork >", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkGreaterThanOrEqualTo(Long value) {
            addCriterion("project_fork >=", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkLessThan(Long value) {
            addCriterion("project_fork <", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkLessThanOrEqualTo(Long value) {
            addCriterion("project_fork <=", value, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkIn(List<Long> values) {
            addCriterion("project_fork in", values, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkNotIn(List<Long> values) {
            addCriterion("project_fork not in", values, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkBetween(Long value1, Long value2) {
            addCriterion("project_fork between", value1, value2, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectForkNotBetween(Long value1, Long value2) {
            addCriterion("project_fork not between", value1, value2, "projectFork");
            return (Criteria) this;
        }

        public Criteria andProjectStarIsNull() {
            addCriterion("project_star is null");
            return (Criteria) this;
        }

        public Criteria andProjectStarIsNotNull() {
            addCriterion("project_star is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStarEqualTo(Long value) {
            addCriterion("project_star =", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarNotEqualTo(Long value) {
            addCriterion("project_star <>", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarGreaterThan(Long value) {
            addCriterion("project_star >", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarGreaterThanOrEqualTo(Long value) {
            addCriterion("project_star >=", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarLessThan(Long value) {
            addCriterion("project_star <", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarLessThanOrEqualTo(Long value) {
            addCriterion("project_star <=", value, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarIn(List<Long> values) {
            addCriterion("project_star in", values, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarNotIn(List<Long> values) {
            addCriterion("project_star not in", values, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarBetween(Long value1, Long value2) {
            addCriterion("project_star between", value1, value2, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectStarNotBetween(Long value1, Long value2) {
            addCriterion("project_star not between", value1, value2, "projectStar");
            return (Criteria) this;
        }

        public Criteria andProjectIssueIsNull() {
            addCriterion("project_issue is null");
            return (Criteria) this;
        }

        public Criteria andProjectIssueIsNotNull() {
            addCriterion("project_issue is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIssueEqualTo(Long value) {
            addCriterion("project_issue =", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueNotEqualTo(Long value) {
            addCriterion("project_issue <>", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueGreaterThan(Long value) {
            addCriterion("project_issue >", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueGreaterThanOrEqualTo(Long value) {
            addCriterion("project_issue >=", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueLessThan(Long value) {
            addCriterion("project_issue <", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueLessThanOrEqualTo(Long value) {
            addCriterion("project_issue <=", value, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueIn(List<Long> values) {
            addCriterion("project_issue in", values, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueNotIn(List<Long> values) {
            addCriterion("project_issue not in", values, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueBetween(Long value1, Long value2) {
            addCriterion("project_issue between", value1, value2, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectIssueNotBetween(Long value1, Long value2) {
            addCriterion("project_issue not between", value1, value2, "projectIssue");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeIsNull() {
            addCriterion("project_readme is null");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeIsNotNull() {
            addCriterion("project_readme is not null");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeEqualTo(String value) {
            addCriterion("project_readme =", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeNotEqualTo(String value) {
            addCriterion("project_readme <>", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeGreaterThan(String value) {
            addCriterion("project_readme >", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeGreaterThanOrEqualTo(String value) {
            addCriterion("project_readme >=", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeLessThan(String value) {
            addCriterion("project_readme <", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeLessThanOrEqualTo(String value) {
            addCriterion("project_readme <=", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeLike(String value) {
            addCriterion("project_readme like", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeNotLike(String value) {
            addCriterion("project_readme not like", value, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeIn(List<String> values) {
            addCriterion("project_readme in", values, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeNotIn(List<String> values) {
            addCriterion("project_readme not in", values, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeBetween(String value1, String value2) {
            addCriterion("project_readme between", value1, value2, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectReadmeNotBetween(String value1, String value2) {
            addCriterion("project_readme not between", value1, value2, "projectReadme");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlIsNull() {
            addCriterion("project_avatarurl is null");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlIsNotNull() {
            addCriterion("project_avatarurl is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlEqualTo(String value) {
            addCriterion("project_avatarurl =", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlNotEqualTo(String value) {
            addCriterion("project_avatarurl <>", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlGreaterThan(String value) {
            addCriterion("project_avatarurl >", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlGreaterThanOrEqualTo(String value) {
            addCriterion("project_avatarurl >=", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlLessThan(String value) {
            addCriterion("project_avatarurl <", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlLessThanOrEqualTo(String value) {
            addCriterion("project_avatarurl <=", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlLike(String value) {
            addCriterion("project_avatarurl like", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlNotLike(String value) {
            addCriterion("project_avatarurl not like", value, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlIn(List<String> values) {
            addCriterion("project_avatarurl in", values, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlNotIn(List<String> values) {
            addCriterion("project_avatarurl not in", values, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlBetween(String value1, String value2) {
            addCriterion("project_avatarurl between", value1, value2, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAvatarurlNotBetween(String value1, String value2) {
            addCriterion("project_avatarurl not between", value1, value2, "projectAvatarurl");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorIsNull() {
            addCriterion("project_author is null");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorIsNotNull() {
            addCriterion("project_author is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorEqualTo(String value) {
            addCriterion("project_author =", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorNotEqualTo(String value) {
            addCriterion("project_author <>", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorGreaterThan(String value) {
            addCriterion("project_author >", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("project_author >=", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorLessThan(String value) {
            addCriterion("project_author <", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorLessThanOrEqualTo(String value) {
            addCriterion("project_author <=", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorLike(String value) {
            addCriterion("project_author like", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorNotLike(String value) {
            addCriterion("project_author not like", value, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorIn(List<String> values) {
            addCriterion("project_author in", values, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorNotIn(List<String> values) {
            addCriterion("project_author not in", values, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorBetween(String value1, String value2) {
            addCriterion("project_author between", value1, value2, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectAuthorNotBetween(String value1, String value2) {
            addCriterion("project_author not between", value1, value2, "projectAuthor");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectDesIsNull() {
            addCriterion("project_des is null");
            return (Criteria) this;
        }

        public Criteria andProjectDesIsNotNull() {
            addCriterion("project_des is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDesEqualTo(String value) {
            addCriterion("project_des =", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotEqualTo(String value) {
            addCriterion("project_des <>", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesGreaterThan(String value) {
            addCriterion("project_des >", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesGreaterThanOrEqualTo(String value) {
            addCriterion("project_des >=", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLessThan(String value) {
            addCriterion("project_des <", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLessThanOrEqualTo(String value) {
            addCriterion("project_des <=", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesLike(String value) {
            addCriterion("project_des like", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotLike(String value) {
            addCriterion("project_des not like", value, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesIn(List<String> values) {
            addCriterion("project_des in", values, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotIn(List<String> values) {
            addCriterion("project_des not in", values, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesBetween(String value1, String value2) {
            addCriterion("project_des between", value1, value2, "projectDes");
            return (Criteria) this;
        }

        public Criteria andProjectDesNotBetween(String value1, String value2) {
            addCriterion("project_des not between", value1, value2, "projectDes");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
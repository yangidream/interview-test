package com.interview.framework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询规则构造器，实现多条件复杂查询的条件拼接
 */
public final class QueryRule implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int ASC_ORDER = 101;
    public static final int DESC_ORDER = 102;
    public static final int GROUP = 103;
    public static final int LIKE = 1;
    public static final int IN = 2;
    public static final int NOTIN = 3;
    public static final int BETWEEN = 4;
    public static final int EQ = 5;
    public static final int NOTEQ = 6;
    public static final int GT = 7;
    public static final int GE = 8;
    public static final int LT = 9;
    public static final int LE = 10;
    public static final int ISNULL = 11;
    public static final int ISNOTNULL = 12;
    public static final int ISEMPTY = 13;
    public static final int ISNOTEMPTY = 14;
    public static final int AND = 201;
    public static final int OR = 202;
    public static final int LIMIT = 301;

    public static final int GROUP_COUNT = 302;
    public static final int GROUP_SUM = 303;

    private List<Rule> ruleList = new ArrayList<Rule>();
    private List<QueryRule> queryRuleList = new ArrayList<QueryRule>();
    private String propertyName;

    private QueryRule() {
    }

    private QueryRule(String propertyName) {
        this.propertyName = propertyName;
    }

    public static QueryRule getInstance() {
        return new QueryRule();
    }

    /**
     * 添加升序规则
     *
     * @param propertyName
     * @return
     */
    public QueryRule addAscOrder(String propertyName) {
        this.ruleList.add(new Rule(ASC_ORDER, propertyName));
        return this;
    }

    /**
     * 添加降序规则
     *
     * @param propertyName
     * @return
     */
    public QueryRule addDescOrder(String propertyName) {
        this.ruleList.add(new Rule(DESC_ORDER, propertyName));
        return this;
    }

    /**
     * 添加分页参数
     *
     * @param
     * @return
     */
    public QueryRule addLimit(Integer pageIndex, Integer pageSize) {
        this.ruleList.add(new Rule(LIMIT, new Limit(pageIndex, pageSize)));
        return this;
    }

    /**
     * 添加分组规则
     *
     * @param propertyNames
     * @return
     */
    public QueryRule addGroupBy(String... propertyNames) {
        this.ruleList.add(new Rule(GROUP, propertyNames));
        return this;
    }

    /**
     * 添加分组求和规则
     *
     * @param propertyName
     * @return
     */
    public QueryRule addSum(String propertyName) {
        this.ruleList.add(new Rule(GROUP_SUM, propertyName));
        return this;
    }

    /**
     * 添加分组计数规则
     *
     * @param propertyName
     * @return
     */
    public QueryRule addCount(String propertyName) {
        this.ruleList.add(new Rule(GROUP_COUNT, propertyName));
        return this;
    }

    public QueryRule andIsNull(String propertyName) {
        this.ruleList.add(new Rule(ISNULL, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsNotNull(String propertyName) {
        this.ruleList.add(new Rule(ISNOTNULL, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsEmpty(String propertyName) {
        this.ruleList.add(new Rule(ISEMPTY, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsNotEmpty(String propertyName) {
        this.ruleList.add(new Rule(ISNOTEMPTY, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andLike(String propertyName, Object value) {
        this.ruleList.add(new Rule(LIKE, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(EQ, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andBetween(String propertyName, Object... values) {
        this.ruleList.add(new Rule(BETWEEN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, List<Object> values) {
        this.ruleList.add(new Rule(IN, propertyName, new Object[]{values}).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, Object... values) {
        this.ruleList.add(new Rule(IN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andNotIn(String propertyName, List<Object> values) {
        this.ruleList.add(new Rule(NOTIN, propertyName, new Object[]{values}).setAndOr(AND));
        return this;
    }

    public QueryRule orNotIn(String propertyName, Object... values) {
        this.ruleList.add(new Rule(NOTIN, propertyName, values).setAndOr(OR));
        return this;
    }


    public QueryRule andNotEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(NOTEQ, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(GT, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(GE, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andLessThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(LT, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andLessEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(LE, propertyName, new Object[]{value}).setAndOr(AND));
        return this;
    }


    public QueryRule orIsNull(String propertyName) {
        this.ruleList.add(new Rule(ISNULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotNull(String propertyName) {
        this.ruleList.add(new Rule(ISNOTNULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsEmpty(String propertyName) {
        this.ruleList.add(new Rule(ISEMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotEmpty(String propertyName) {
        this.ruleList.add(new Rule(ISNOTEMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orLike(String propertyName, Object value) {
        this.ruleList.add(new Rule(LIKE, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(EQ, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orBetween(String propertyName, Object... values) {
        this.ruleList.add(new Rule(BETWEEN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, List<Object> values) {
        this.ruleList.add(new Rule(IN, propertyName, new Object[]{values}).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, Object... values) {
        this.ruleList.add(new Rule(IN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orNotEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(NOTEQ, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(GT, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(GE, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orLessThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(LT, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }

    public QueryRule orLessEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(LE, propertyName, new Object[]{value}).setAndOr(OR));
        return this;
    }


    public List<Rule> getRuleList() {
        return this.ruleList;
    }

    public List<QueryRule> getQueryRuleList() {
        return this.queryRuleList;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    protected class Rule implements Serializable {
        private static final long serialVersionUID = 1L;
        private int type;    //规则的类型
        private String property_name;
        private String[] groupProperties;
        private Object[] values;
        private int andOr = AND;
        private Limit limit;
        private GroupBy groupBy;


        public Rule(int paramInt, String paramString) {
            this.property_name = paramString;
            this.type = paramInt;
        }

        public Rule(int paramInt, String[] groupProperties) {
            this.groupProperties = groupProperties;
            this.type = paramInt;
        }

        public Rule(int paramInt, String paramString,
                    Object[] paramArrayOfObject) {
            this.property_name = paramString;
            this.values = paramArrayOfObject;
            this.type = paramInt;
        }

        public Rule(int type, Limit limit) {
            this.type = type;
            this.limit = limit;
        }

        public Rule(int type, GroupBy groupBy) {
            this.type = type;
            this.groupBy = groupBy;
        }

        public Rule(Limit limit) {
            this.limit = limit;
        }

        public Rule setAndOr(int andOr) {
            this.andOr = andOr;
            return this;
        }

        public int getAndOr() {
            return this.andOr;
        }

        public Object[] getValues() {
            return this.values;
        }

        public int getType() {
            return this.type;
        }

        public String getPropertyName() {
            return this.property_name;
        }

        public Limit getLimit() {
            return limit;
        }

        public String getProperty_name() {
            return property_name;
        }

        public String[] getGroupProperties() {
            return groupProperties;
        }
    }
}

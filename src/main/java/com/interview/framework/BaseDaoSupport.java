package com.interview.framework;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDaoSupport<T extends Serializable, M extends Serializable, PK extends Serializable> implements BaseDAO<T, M, PK> {

    private String tableName = "";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private EntityOperation<T, M> op;

    protected BaseDaoSupport() {
        try {
            Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Class<M> ResultClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            op = new EntityOperation<T, M>(entityClass, ResultClass, this.getPKColumn());
            this.setTableName(op.tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<M> query(QueryRule queryRule) {
        QueryRuleSqlBuilder bulider = new QueryRuleSqlBuilder(queryRule);
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select ");//.append(op.allColumn);
        String gss = bulider.getGroupBySelectSql();
        sqlBuilder.append("".equals(gss) ? op.allColumn : "  " + gss);
        String ws = removeFirstAnd(bulider.getWhereSql());
        sqlBuilder.append(" from ").append(getTableName()).append("".equals(ws) ? ws : (" where " + ws));
        Object[] values = bulider.getValues();
        String groupSql = bulider.getGroupSql();
        sqlBuilder.append((StringUtils.isEmpty(groupSql)) ? " " : (" group by " + groupSql));
        String orderSql = bulider.getOrderSql();
        sqlBuilder.append((StringUtils.isEmpty(orderSql) ? " " : (" order by " + orderSql)));
        String limitSql = bulider.getLimitSql();
        sqlBuilder.append((StringUtils.isEmpty(limitSql)) ? " " : (" limit ") + limitSql);
        return (List<M>) jdbcTemplate.query(sqlBuilder.toString(), this.op.rowMapperM, values);

    }

    private String removeFirstAnd(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return sql;
        }
        return sql.trim().toLowerCase().replaceAll("^\\s*and", "") + " ";
    }

    protected String getTableName() {
        return tableName;
    }

    protected void setTableName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            this.tableName = op.tableName;
        } else {
            this.tableName = tableName;
        }
    }

    protected abstract String getPKColumn();
}

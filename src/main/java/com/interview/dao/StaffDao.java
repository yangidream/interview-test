package com.interview.dao;

import com.interview.entity.StaffDO;
import com.interview.entity.StaffExtendDO;
import com.interview.framework.BaseDaoSupport;
import com.interview.framework.QueryRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="staffDao")
public class StaffDao  extends BaseDaoSupport<StaffDO,StaffExtendDO,Long>{

    @Override
    protected String getPKColumn() {
        return "id";
    }

    public List<StaffExtendDO> selectAll() {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andLike("username","mic");
        queryRule.addLimit(0,4);

        queryRule.addSum("salary");
        queryRule.addCount("username");
        queryRule.addGroupBy("department","username");
        return super.query(queryRule);
    }

}

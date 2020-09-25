package com.interview.dao;

import com.interview.entity.StaffDO;
import com.interview.entity.StaffExtendDO;
import com.interview.framework.BaseDaoSupport;
import com.interview.framework.QueryRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="staffExtendDao")
public class StaffExtendDao extends BaseDaoSupport<StaffDO,StaffExtendDO,Long>{

    @Override
    protected String getPKColumn() {
        return "id";
    }

    public List<StaffExtendDO> selectAllExtend() {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andLike("username","mic");
        queryRule.andEqual("age",22);
        queryRule.addLimit(0,4);

        queryRule.addSum("salary");
        queryRule.addCount("username");
        queryRule.addGroupBy("department","username");
        List<StaffExtendDO> StaffDOList =  (List<StaffExtendDO>)super.query(queryRule);

        return StaffDOList;
    }
}

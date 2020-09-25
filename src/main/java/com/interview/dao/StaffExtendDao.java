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
        // 模糊查询
        queryRule.andLike("username","mic");
        // 精确匹配
        queryRule.andEqual("age",22);
        queryRule.andEqual("salary",1000);

        // 或
        queryRule.orEqual("department","后勤部");

        // 分页
        queryRule.addLimit(0,4);

        // 分组
        queryRule.addSum("salary");
        queryRule.addCount("username");
        queryRule.addGroupBy("department","username");

//        queryRule.addSum("salary");
//        queryRule.addGroupBy("department");

        List<StaffExtendDO> StaffDOList =  (List<StaffExtendDO>)super.query(queryRule);

        return StaffDOList;
    }
}

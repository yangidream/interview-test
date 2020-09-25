package com.interview.framework;

import java.util.List;

/**
 * sql分组组件
 */
public class GroupBy {

    private List<GroupFunction> groupFunctionList; // 需要用分组函数字段集合

    private List<String> propertyNames;  // 分组字段

    public GroupBy() {
    }

    public GroupBy(List<GroupFunction> groupFunctionList, List<String> propertyNames) {
        this.groupFunctionList = groupFunctionList;
        this.propertyNames = propertyNames;
    }

    public List<GroupFunction> getGroupFunctionList() {
        return groupFunctionList;
    }

    public void setGroupFunctionList(List<GroupFunction> groupFunctionList) {
        this.groupFunctionList = groupFunctionList;
    }

    public List<String> getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(List<String> propertyNames) {
        this.propertyNames = propertyNames;
    }
}

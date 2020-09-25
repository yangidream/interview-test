package com.interview.framework;

public class GroupFunction {

    private Integer functionName; // 分组函数类型

    private String propertyName; // 作用于分组函数的字段

    public GroupFunction() {
    }

    public GroupFunction(Integer functionName, String propertyName) {
        this.functionName = functionName;
        this.propertyName = propertyName;
    }

    public Integer getFunctionName() {
        return functionName;
    }

    public void setFunctionName(Integer functionName) {
        this.functionName = functionName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}

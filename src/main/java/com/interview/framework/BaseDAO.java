package com.interview.framework;

import java.util.List;

public interface BaseDAO<T,M,PK> {

    List<M> query(QueryRule rule);


}

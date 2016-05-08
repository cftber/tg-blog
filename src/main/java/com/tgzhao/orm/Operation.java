package com.tgzhao.orm;

import java.sql.Connection;

/**
 * Created by tgzhao on 2016/5/8.
 */
public interface Operation<T> {
    T doInConnection(Connection connection);
}

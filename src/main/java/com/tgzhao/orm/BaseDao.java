package com.tgzhao.orm;


import com.sun.corba.se.pept.transport.ConnectionCache;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by tgzhao on 2016/5/8.
 */
public abstract class BaseDao {
    private static final Logger logger = Logger.getLogger(BaseDao.class);

    protected static <T> T execute(Operation<T> operation) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setReadOnly(true);
            connection.createStatement().execute("SET NAMES 'utf8'");
            return operation.doInConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}

package man.kuke.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: kuke
 * @date: 2020/11/29 - 13:34
 * @description: mybatis 学习
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            /**
             * resource mybatis 资源路径
             * SqlSessionFactoryBuilder加载资源建立sqlSessionFactory
             */
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  sqlSessionFactory创建SqlSession
     *  SqlSession包含数据库查询各种操作
     * @return
     */
    public static SqlSession getSqlSession() {

        return sqlSessionFactory.openSession();
    }






}

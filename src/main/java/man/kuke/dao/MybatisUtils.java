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
    /**
     * 可以类比数据库连接池
     *  SqlSessionFactory 一旦被创建就应该在运行期间一直存在
     *  没有任何理由丢弃或重建
     *
     *  最简单的就是使用单例模式或静态单例模式
     */
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
     *  连接到连接池的一个请求
     *  sqlSession的实例不是线程安全的，因此是不能被共享的
     *  所以它的最佳的作用域是请求或方法作用域
     *  用完之后需要关闭，否则占用资源
     * @return
     */
    public static SqlSession getSqlSession() {

        return sqlSessionFactory.openSession();
    }






}

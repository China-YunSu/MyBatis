package man.kuke.dao;

import man.kuke.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: kuke
 * @date: 2020/11/29 - 13:56
 * @description:
 */
public class UserDaoTest {

    @Test
    public void queryTest() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Person> people = mapper.getPeople();

            for (Person person : people) {
                System.out.println(people);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryTestSingle() {
        SqlSession sqlSession = null;
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Person person = mapper.getPersonById("06181039");
            System.out.println(person);
            sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Person person = new Person("06181040","王欣悦");
        mapper.updatePerson(person);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deletePerson(new Person("113","王五"));
        mapper.deletePerson(new Person("110","王五"));
        mapper.deletePerson(new Person("1122","王五"));


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void select() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Person person = new Person("0","");
        List<Person> personByLike = mapper.getPersonByLike(person);
        System.out.println(personByLike.size());
        for (Person person1 : personByLike) {
            System.out.println(person1);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void querybyMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("ID", "06181040");
        /**
         * getPersonById
         * getPersonByMap
         * id<——>单一方法
         */
        Person person = mapper.getPersonByMap(map);
        System.out.println(person);
        sqlSession.commit();
        sqlSession.close();
    }
}

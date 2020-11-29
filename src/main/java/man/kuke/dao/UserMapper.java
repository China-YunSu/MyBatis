package man.kuke.dao;

import man.kuke.model.Person;

import java.util.List;
import java.util.Map;

/**
 * @author: kuke
 * @date: 2020/11/29 - 13:42
 * @description:
 */
public interface UserMapper {
    //查询所有
    List<Person> getPeople();
    // 根据ID查询
    Person getPersonById(String id);
    //通过map获取
    Person getPersonByMap(Map<String,Object> map);
    //插入一个用户
    void addPerson(Person person);
    //update
    void updatePerson(Person person);
    //delete
    void deletePerson(Person person);
    //模糊查询
    List<Person> getPersonByLike(Person person);
}

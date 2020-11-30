package man.kuke.dao;

import man.kuke.model.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    //limit
    List<Person> getPersonByLimit(Map<String,Object> map);
    //bounds
    List<Person> getPersonByBounds();

    /**
     * 注解
     * //@param()
     * 基本类型的参数或者String类型，需要加上
     * 引用类型不需要加
     * 如果只有一个基本类型的话，可以忽略，建议加上
     * 我们在sql中引用的就是这里@Param（）中设定的属性名
     * #{} ${}
     */
    @Select("select * from person where id = #{id}")
    Person getPersonByAnno(String id);

    @Select("insert into person(id,name) values(#{id},#{name})")
    void addPersonByAnno(@Param("id")String id, @Param("name")String name);

    @Select("delete from person where id=#{id}")
    void deletePersonByAnno(@Param("id")String id);

    @Select("update person set id=#{id},name=#{name} where id=#{id}")
    void updatePersonByAnno(Person person);
}

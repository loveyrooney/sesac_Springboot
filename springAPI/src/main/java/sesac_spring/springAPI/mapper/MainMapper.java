package sesac_spring.springAPI.mapper;

import org.apache.ibatis.annotations.*;
import sesac_spring.springAPI.domain.User;

import java.util.List;

@Mapper
public interface MainMapper {

    List<User> retrieveAll();
    List<User> retrieveOne( String userid );

    @Insert("insert into users(userid, password, nickname) values(#{userid},#{password},#{nickname})")
    void insertUser(User user);

    //보내는 파람이 2개이상이면 파람 어노테이션 쓰거나 변수명을 param1, param2 이런식으로 지정해야됨
    @Select("select * from users where userid = #{userid} and password = #{password} limit 1")
    User getUser(@Param("userid") String userid, @Param("password") String password);
    @Update("update users set password = #{password}, nickname = #{nickname} where userid = #{userid}")
    void updateUser(User user);

    @Delete("delete from users where userid = #{userid}")
    void deleteUser(String userid);
}

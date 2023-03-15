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

    @Update("update table users set password = #{password}, nickname = #{nickname} where userid = #{userid}")
    void updateUser(User user);

    @Delete("delete from users where userid = #{userid}")
    void deleteUser(User user);
}

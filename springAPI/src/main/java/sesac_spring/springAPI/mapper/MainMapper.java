package sesac_spring.springAPI.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sesac_spring.springAPI.domain.User;

import java.util.List;

@Mapper
public interface MainMapper {

    List<User> retrieveAll();
    List<User> retrieveOne( String userid );


    @Insert("insert into users(userid, password, nickname) values(#{userid},#{password},#{nickname})")
    void insertUser(User user);

}

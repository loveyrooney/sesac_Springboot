package sesac.sesac.MyBatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.sesac.MyBatis.domain.User;

import java.util.List;

@Mapper
public interface MainMapper {

    List<User> retrieveAll();

    @Insert("insert into user(name, nickname) values(#{name},#{nickname})")
    void insertUser(User user);

}

//MainMapper 함수에서는 xml 파일에 있는 sql문을 실행한다. xml 파일 내에서 namespace, id로 구분
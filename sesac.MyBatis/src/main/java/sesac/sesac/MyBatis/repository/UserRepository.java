package sesac.sesac.MyBatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.sesac.MyBatis.domain.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //Optional은 null일수도 있는 객체를 감싸는 클래스임. 널체크 함수가 있음.
    Optional<UserEntity> findByName(String name);
    //findByIdName(int id, String name) : select id where name
    //boolean existByName(String name);

}

package sesac.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> deleteById(String id);
    Optional<UserEntity> findById(String id);
}

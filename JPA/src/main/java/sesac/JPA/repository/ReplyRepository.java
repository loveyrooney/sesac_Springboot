package sesac.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.JPA.domain.BoardEntity;

import java.util.Optional;

@Repository
public interface ReplyRepository extends JpaRepository<BoardEntity, Integer> {
    Optional<BoardEntity> findByUserId(String userId);
}

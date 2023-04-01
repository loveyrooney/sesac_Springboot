package sesac.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.ReplyEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
    List<ReplyEntity> findByBoardEntity(BoardEntity boardEntity);
}

package sesac.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.JPA.domain.BoardEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    Long countBy();
    List<BoardEntity> findByBoardTitleContaining(String title);
    List<BoardEntity> findByBoardContentContaining(String content);
    List<BoardEntity> findByUserEntity_IdContaining(String id);

}

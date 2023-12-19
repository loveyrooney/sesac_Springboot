package sesac.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.BoardDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    List<BoardEntity> findByBoardTitleContaining(String title);

    @Query(value="SELECT * FROM boarddb WHERE convert_from(lo_get(cast(board_content as bigint)),'UTF-8') LIKE %:content%",nativeQuery = true)
    List<BoardEntity> selectSQLByBoardContentContaining(@Param("content") String content);

    List<BoardEntity> findByUserEntity_IdContaining(String id);
    List<BoardEntity> findByUserEntity_Id(String id);
}

package sesac.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            BoardDTO b = new BoardDTO();
            b.setUserId(result.get(i).getUserEntity().getId());
            b.setTitle(result.get(i).getTitle());
            b.setDate(result.get(i).getDate());

            boards.add(b);
        }
        return boards;
    }


}

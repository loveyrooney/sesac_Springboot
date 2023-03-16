package sesac.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private BoardRepository boardRepository;

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            BoardDTO b = new BoardDTO();
            b.setId(result.get(i).getId());
            b.setName(result.get(i).getName());
            b.setPw(result.get(i).getPw());
            b.setContent(result.get(i).getContent());

            boards.add(b);
        }
        return boards;
    }

    public void createBoard(BoardEntity boardEntity) {
        System.out.println("b :" +boardEntity.getName()+boardEntity.getId()+boardEntity.getContent());
        boardRepository.save(boardEntity);
    }
}

package sesac.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    UserService userService;

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            BoardDTO b = new BoardDTO();
            b.setBoardId(result.get(i).getBoardId());
            b.setUserId(result.get(i).getUserEntity().getId());
            b.setBoardTitle(result.get(i).getBoardTitle());
            b.setBoardDate(result.get(i).getBoardDate());

            boards.add(b);
        }
        return boards;
    }

    public void createBoard(BoardDTO boardDTO) {
        UserDTO getuser = userService.getUser(boardDTO.getUserId());
        UserEntity writer = new UserEntity();
        writer.setId(getuser.getId());
        writer.setPw(getuser.getPw());

        BoardEntity newBoard = new BoardEntity();
        newBoard.setUserEntity(writer);
        newBoard.setBoardTitle(boardDTO.getBoardTitle());
        newBoard.setBoardContent(boardDTO.getBoardContent());
        newBoard.setBoardDate(boardDTO.getBoardDate());

        boardRepository.save(newBoard);
    }

    public BoardDTO getBoardInfo(int id) {
        Optional<BoardEntity> target = boardRepository.findById(id);
        BoardDTO targetBoard = new BoardDTO();
        targetBoard.setBoardId(target.get().getBoardId());
        targetBoard.setUserId(target.get().getUserEntity().getId());
        targetBoard.setBoardTitle(target.get().getBoardTitle());
        targetBoard.setBoardContent(target.get().getBoardContent());
        targetBoard.setBoardDate(target.get().getBoardDate());

        return targetBoard;
    }

    public Long getCount() {
        Long count = boardRepository.countBy();
        return count;
    }

    public void updateBoard(BoardDTO boardDTO){
        Optional<BoardEntity> target = boardRepository.findById(boardDTO.getBoardId());
        target.get().setBoardTitle(boardDTO.getBoardTitle());
        target.get().setBoardContent(boardDTO.getBoardContent());
        boardRepository.save(target.get());
    }

    public void deleteBoard(int id){
        boardRepository.deleteById(id);
    }


}

package sesac.JPA.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.dto.CreateBoardDTO;
import sesac.JPA.exceptions.BusinessException;
import sesac.JPA.exceptions.ErrorCode;
import sesac.JPA.repository.BoardRepository;
import sesac.JPA.repository.ReplyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;
    private final UserService userService;

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> all = boardRepository.findAll();
        return getFinal(all);
    }

    public List<BoardDTO> getSearchList(String select, String search){
        switch (select){
            case "title" : List<BoardEntity> titles = boardRepository.findByBoardTitleContaining(search);
                return getFinal(titles);
            case "content" : List<BoardEntity> contents = boardRepository.selectSQLByBoardContentContaining(search);
                return getFinal(contents);
            case "writer" : List<BoardEntity> writers = boardRepository.findByUserEntity_IdContaining(search);
                return getFinal(writers);
            default: List<BoardDTO> empty = Collections.emptyList();
                return empty;
        }
    }
    public List<BoardDTO> getFinal(List<BoardEntity> result){
        List<BoardDTO> boards = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            Long count = replyRepository.countByBoardEntity_BoardId(result.get(i).getBoardId());
            BoardDTO b = new BoardDTO();
            b.setBoardId(result.get(i).getBoardId());
            b.setUserId(result.get(i).getUserEntity().getId());
            b.setBoardTitle(result.get(i).getBoardTitle()+" ["+count+"]");
            b.setBoardDate(result.get(i).getBoardDate());

            boards.add(b);
        }
        return boards;
    }

    public void createBoard(CreateBoardDTO boardDTO) {
        if(userService.isUser(boardDTO.getUserId())) {
            UserEntity writer = new UserEntity();
            writer.setId(boardDTO.getUserId());

            BoardEntity newBoard = new BoardEntity();
            newBoard.setUserEntity(writer);
            newBoard.setBoardTitle(boardDTO.getBoardTitle());
            newBoard.setBoardContent(boardDTO.getBoardContent());
            newBoard.setBoardDate(boardDTO.getBoardDate());

            boardRepository.save(newBoard);
        }
    }

    public BoardDTO getBoardInfo(int id) {
        BoardEntity target = boardRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.NOT_EXIST_BOARD));
        BoardDTO targetBoard = new BoardDTO();
        targetBoard.setBoardId(target.getBoardId());
        targetBoard.setUserId(target.getUserEntity().getId());
        targetBoard.setBoardTitle(target.getBoardTitle());
        targetBoard.setBoardContent(target.getBoardContent());
        targetBoard.setBoardDate(target.getBoardDate());
        System.out.println("service"+target.getBoardId()+target.getUserEntity().getId());
        return targetBoard;
    }

    public void updateBoard(BoardDTO boardDTO){
        BoardEntity target = boardRepository.findById(boardDTO.getBoardId()).orElseThrow(()-> new BusinessException(ErrorCode.NOT_EXIST_BOARD));
        target.setBoardTitle(boardDTO.getBoardTitle());
        target.setBoardContent(boardDTO.getBoardContent());
        boardRepository.save(target);
    }

    public void deleteBoard(int id){
        boardRepository.deleteById(id);
    }


}

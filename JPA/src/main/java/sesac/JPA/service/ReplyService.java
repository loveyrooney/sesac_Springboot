package sesac.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.ReplyEntity;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.dto.ReplyDTO;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.repository.BoardRepository;
import sesac.JPA.repository.ReplyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    public List<ReplyDTO> getReplyList(int id){
        List<ReplyEntity> result = replyRepository.findByBoardEntity_BoardId(id);
            List<ReplyDTO> replies = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                ReplyDTO r = new ReplyDTO();
                r.setReplyId(result.get(i).getReplyId());
                r.setUserId(result.get(i).getUserEntity().getId());
                r.setReplyContent(result.get(i).getReplyContent());
                r.setReplyDate(result.get(i).getReplyDate());

                replies.add(r);
            }
            return replies;
    }

    public Long getCount() {
        Long count = replyRepository.countBy();
        return count;
    }
    public ArrayList<Long> getBoardReplyCount() {
        List<BoardEntity> boardList = boardRepository.findAll();
        ArrayList<Long> countList = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            Long count = replyRepository.countByBoardEntity_BoardId(boardList.get(i).getBoardId());
            countList.add(count);
        }
        //System.out.println(countList);
        return countList;
    }
    public void createReply(ReplyDTO replyDTO){
        UserDTO getuser = userService.getUser(replyDTO.getUserId());
        UserEntity writer = new UserEntity();
        writer.setId(getuser.getId());

        BoardDTO getboard = boardService.getBoardInfo(replyDTO.getBoardId());
        BoardEntity board = new BoardEntity();
        board.setBoardId(getboard.getBoardId());

        ReplyEntity newReply = new ReplyEntity();
        newReply.setUserEntity(writer);
        newReply.setBoardEntity(board);
        newReply.setReplyContent(replyDTO.getReplyContent());
        newReply.setReplyDate(replyDTO.getReplyDate());

        replyRepository.save(newReply);
    }

    public ReplyDTO getReplyInfo(int id) {
        Optional<ReplyEntity> target = replyRepository.findById(id);
        ReplyDTO targetReply = new ReplyDTO();
        targetReply.setReplyId(target.get().getReplyId());
        targetReply.setUserId(target.get().getUserEntity().getId());
        targetReply.setBoardId(target.get().getBoardEntity().getBoardId());
        targetReply.setReplyContent(target.get().getReplyContent());
        targetReply.setReplyDate(target.get().getReplyDate());

        return targetReply;
    }

    public void deleteReply(int id){
        replyRepository.deleteById(id);
    }
}
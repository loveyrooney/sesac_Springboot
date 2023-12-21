package sesac.JPA.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sesac.JPA.config.EmailConfig;
import sesac.JPA.dto.MailAuthDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final UserService userService;
    private final EmailConfig emailConfig;

    public Boolean sendMail(String mail) {
        if(userService.isUser(mail)) return false;
        else {
            MailAuthDTO mailAuthDTO = createAuthCode(mail);
            SimpleMailMessage emailForm = mailForm(mailAuthDTO);
            try {
                javaMailSender.send(emailForm);
            } catch (RuntimeException e) {
                  System.out.println(e.getMessage());
//                throw new BusinessLogicException(ExceptionCode.UNABLE_TO_SEND_EMAIL);
            }
            return true;
        }
    }

    private MailAuthDTO createAuthCode(String mail) {
        MailAuthDTO mailAuthDTO = new MailAuthDTO();
        UUID uuid = UUID.randomUUID();
        mailAuthDTO.setTo(mail);
        mailAuthDTO.setAuthCode(uuid.toString());
        //인증코드 보관해 둬야 함
        return mailAuthDTO;
    }

    private SimpleMailMessage mailForm(MailAuthDTO mailAuthDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getId());
        message.setTo(mailAuthDTO.getTo());
        message.setSubject("[javaboard] 이메일 인증 코드 입니다.");
        message.setText("인증코드: " + mailAuthDTO.getAuthCode());
        return message;
    }

    //인증번호 체크 메서드

}

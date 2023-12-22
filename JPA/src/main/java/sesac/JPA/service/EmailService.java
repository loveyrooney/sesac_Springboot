package sesac.JPA.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sesac.JPA.config.EmailConfig;
import sesac.JPA.dto.MailAuthDTO;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final UserService userService;
    private final EmailConfig emailConfig;
    private final PasswordEncoder encoder;
    ConcurrentHashMap<String, String> mailAuthInfo = new ConcurrentHashMap<>();

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
        mailAuthDTO.setTo(mail);
        UUID uuid = UUID.randomUUID();
        mailAuthDTO.setTo(uuid.toString());
        mailAuthInfo.put(mailAuthDTO.getTo(),encoder.encode(mailAuthDTO.getAuthCode()));
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

    public Boolean authCodeCheck(MailAuthDTO mailAuthDTO) {
        if(mailAuthInfo.containsKey(mailAuthDTO.getTo())) {
            if(encoder.matches(mailAuthDTO.getAuthCode(),mailAuthInfo.get(mailAuthDTO.getTo()))) {
                mailAuthInfo.remove(mailAuthDTO.getTo());
            } else System.out.println("authcode don't mached.");
        }
        //else throw new BusinessLogicException(ExceptionCode.UNABLE_TO_SEND_EMAIL);
        return true;
    }


}

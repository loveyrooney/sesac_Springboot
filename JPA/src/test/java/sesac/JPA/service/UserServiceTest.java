package sesac.JPA.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void isUser() {
        final String id = "myId123@gamil.com";
        given(userRepository.existsById(id)).willReturn(true);
        Boolean result = userService.isUser(id);
        assertTrue(result);
    }

    @Test
    void checkUser() {
        final String id = "myId123@gamil.com";
        final UserDTO user = new UserDTO();
        user.setId(id);
        given(userRepository.findById(user.getId())).willReturn(Optional.empty());
        String result1 = userService.checkUser(user);
        assertEquals("notPresent", result1);

        given(userRepository.findById(user.getId())).willReturn(Optional.of(new UserEntity()));
        String result2 = userService.checkUser(user);
        assertEquals("notVerified", result2);
        //System.out.println(result1+result2);

    }

}
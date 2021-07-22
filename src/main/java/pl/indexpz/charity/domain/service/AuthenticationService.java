package pl.indexpz.charity.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.indexpz.charity.domain.model.User;
import pl.indexpz.charity.domain.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public void registerUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void updateUserPassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}

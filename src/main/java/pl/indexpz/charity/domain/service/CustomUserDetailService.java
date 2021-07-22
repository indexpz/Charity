package pl.indexpz.charity.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.indexpz.charity.domain.model.User;
import pl.indexpz.charity.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
                return optionalUser
                        .map(user -> new org.springframework.security.core.userdetails.User(
                                user.getUsername(),
                                user.getPassword(),
                                List.of(new SimpleGrantedAuthority(user.getRole()))
                        ))
                        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }
}

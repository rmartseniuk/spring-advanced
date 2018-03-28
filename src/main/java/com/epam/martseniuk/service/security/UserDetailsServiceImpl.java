package com.epam.martseniuk.service.security;

import com.epam.martseniuk.repository.UserRepository;
import com.epam.martseniuk.util.CertificateUtils;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Roman_Martseniuk
 */
@Setter
@Profile("ssl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private CertificateUtils certificateUtils;
    private HttpServletRequest httpServletRequest;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String serialNumber = certificateUtils.getSerialNumber(httpServletRequest);
        com.epam.martseniuk.entity.User user = userRepository.findUserByUsernameAndSerialNumber(username, serialNumber);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

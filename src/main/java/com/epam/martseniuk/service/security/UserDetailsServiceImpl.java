package com.epam.martseniuk.service.security;

import com.epam.martseniuk.repository.UserRepository;
import com.epam.martseniuk.util.CertificateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Roman_Martseniuk
 */
@Service
@Profile("ssl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateUtils certificateUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String serialNumber = certificateUtils.getSerialNumber();
//        com.epam.martseniuk.entity.User user = userRepository.findUserByUsernameAndSerialNumber(username, serialNumber);
        com.epam.martseniuk.entity.User user = userRepository.findOne(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

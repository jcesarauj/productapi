package com.productapi.service;

import java.util.List;
import java.util.Optional;

import com.productapi.domain.models.core.auth.ApiUser;
import com.productapi.repository.ApiUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private ApiUserRepository _apiUserRepository;

    @Autowired
    public void CustomUserDetailService(ApiUserRepository apiUserRepository) {
        _apiUserRepository = apiUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUser apiUser = Optional.ofNullable(_apiUserRepository.findByUserName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        List<GrantedAuthority> autorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> autorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new org.springframework.security.core.userdetails.User(apiUser.getUserName(), apiUser.getPassword(), apiUser.isAdmin() ? autorityListAdmin : autorityListUser);
    }
}

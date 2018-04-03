package com.pensareluis.Holamundo.impl;

import com.pensareluis.Holamundo.entity.Account;
import com.pensareluis.Holamundo.entity.UserRole;
import com.pensareluis.Holamundo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/27
 */


@Service("userServices")
public class UserService implements UserDetailsService{
    @Autowired
    @Qualifier("userRepository")
      private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> user = userRepository.findFirstByUsername(username);
        if( user.isPresent() ){
            List<GrantedAuthority> authorities = builAuthorities(user.get().getUserRole());
            return buildUser(user.get(), authorities);
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }
    private User buildUser(Account user, List<GrantedAuthority> authorities){
            return new User(user.getUsername(),user.getPassword(),user.isEnable(),true,true,true,authorities);//Aqui hay cosas

    }

    private List<GrantedAuthority> builAuthorities (Set<UserRole> userRoles){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for(UserRole userRole: userRoles){
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }

}

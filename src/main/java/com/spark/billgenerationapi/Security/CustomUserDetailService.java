package com.spark.billgenerationapi.Security;

import com.spark.billgenerationapi.entity.User;
import com.spark.billgenerationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        System.out.println(userId);
        User user=this.userRepository.findByUserId(userId);
        System.out.println(user);
        return new CustomUserDetail(user);
    }
}

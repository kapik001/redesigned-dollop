package com.kapusta.security.user;

import com.kapusta.security.user.dto.UserDetailsDTO;
import com.kapusta.security.user.entity.User;

import java.util.ArrayList;

class UserDetailsConverter {
    static UserDetailsDTO convertUser(User user) {
        if (user == null) {
            return null;
        }
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setLogin(user.getLogin());
        userDetailsDTO.setFirstName(user.getUserPrivateData().getFirstName());
        userDetailsDTO.setLastName(user.getUserPrivateData().getLastName());
        userDetailsDTO.setEmail(user.getUserPrivateData().getEmail());
        userDetailsDTO.setPrivileges(new ArrayList<>());
        if (user.getAuthorities() != null) {
            user.getAuthorities().forEach(a -> userDetailsDTO.getPrivileges().add(a.getAuthority()));
        }
        return userDetailsDTO;
    }
}

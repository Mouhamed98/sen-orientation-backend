package com.senorientation.backend.user;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    public String id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phoneNumber;

    private Date birthday;

    private String token;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
  
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
  
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
  
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
  
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
  
        return true;
    }

    @Override
    public boolean isEnabled() {
  
        return true;
    }

    @Override
    public String getPassword() {
  
        return password;
    }

}

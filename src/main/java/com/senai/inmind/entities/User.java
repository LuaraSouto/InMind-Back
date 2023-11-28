package com.senai.inmind.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.senai.inmind.dtos.UserInputDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {

    public User(UserInputDTO dto) {
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.picture = dto.getPicture();
        this.address = dto.getAddress();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String username;
    @Column(unique = true)
    protected String email;
    @Column(nullable = false)
    protected String password;
    protected FileInfo picture;
    @Enumerated(EnumType.STRING)
    protected Role role;
    @OneToOne(optional = true)
    protected Address address;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == null){
            return null;
        }
        return List.of(new SimpleGrantedAuthority("ROLE_"+this.role.name()));
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

}

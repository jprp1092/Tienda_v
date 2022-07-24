/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author joser
 */
public class Userprincipal implements UserDetails { //userdatils almacena la informacion del ususario sin aun validarla

    private Persona persona;

    public Userprincipal(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>(); //Nos devolvera los roles que posee un usuario

        //Extrae lista de permisos
        //Agregamos cada permiso a la lista de arriba de authorities
        this.persona.getPermissionList().forEach(p -> {                     //la p simboliza cada elemnto, ejemplo admin, user
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        //Extrae lista of roles (Role_name)
        //Agregamos cada rol a la lista de arriba de authorities en la lista se sabe que es un rol porque los roles inician con el prefijo ROLE_ si no deduce que es un permiso
        this.persona.getRoleList().forEach(r -> {
           GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
           authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.persona.getPassword();
    }

    @Override
    public String getUsername() {
        return this.persona.getNombre();
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
        return this.persona.getActive() == 1;
    }
}

package ru.kata.spring_security_bootstrap.service;

import ru.kata.spring_security_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getAllByName(Set<String> roles);
}

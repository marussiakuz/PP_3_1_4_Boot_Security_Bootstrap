package ru.kata.spring_security_bootstrap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring_security_bootstrap.model.Role;
import ru.kata.spring_security_bootstrap.repository.RoleRepository;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllByName(Set<String> roles) {
        return roleRepository.getAllByNames(roles);
    }
}

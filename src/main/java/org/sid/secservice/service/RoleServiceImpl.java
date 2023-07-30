package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.repo.AppRoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private AppRoleRepository approleRepository;


    public RoleServiceImpl(AppRoleRepository approleRepository) {
        this.approleRepository = approleRepository;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return approleRepository.save(appRole);
    }

    @Override
    public List<AppRole> listRoles() {
        return approleRepository.findAll();
    }
}

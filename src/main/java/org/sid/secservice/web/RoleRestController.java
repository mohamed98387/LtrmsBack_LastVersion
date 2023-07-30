package org.sid.secservice.web;


import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.repo.AppRoleRepository;
import org.sid.secservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleRestController {
    private RoleService roleService;
    private AppRoleRepository appRoleRepository;

    public RoleRestController(AppRoleRepository appRoleRepository) {
        this.appRoleRepository = appRoleRepository;
    }

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public RoleRestController(RoleService roleService, AppRoleRepository appRoleRepository) {
        this.roleService = roleService;
        this.appRoleRepository = appRoleRepository;
    }
    @PostMapping(path = "/addrole")
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return roleService.addNewRole(appRole);
    }
    @GetMapping(path = "/roles")
    public List<AppRole> appRoles() {
        return roleService.listRoles();
    }
}

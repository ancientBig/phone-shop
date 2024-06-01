package com.phone.shop.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phone.shop.entity.Role;
import com.phone.shop.repository.RoleRepository;
import com.phone.shop.service.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService{
	@Autowired
    private RoleRepository roleRepository;
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}

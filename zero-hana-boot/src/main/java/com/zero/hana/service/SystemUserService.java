package com.zero.hana.service;

import com.zero.hana.domain.entity.SystemUserEntity;
import com.zero.hana.reponsitory.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> getAllEmployees() {
        return systemUserRepository.findAll();
    }

    public SystemUserEntity saveEmployee(SystemUserEntity systemUserEntity) {
        return systemUserRepository.save(systemUserEntity);
    }

    // other CRUD methods
}

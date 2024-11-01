package com.zero.hana.controller;

import com.zero.hana.domain.entity.SystemUserEntity;
import com.zero.hana.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class HanaController {

    @Autowired
    private SystemUserService systemUserService;

    @GetMapping
    public List<SystemUserEntity> getAllEmployees() {
        return systemUserService.getAllEmployees();
    }

    @PostMapping
    public SystemUserEntity createEmployee(@RequestBody SystemUserEntity systemUserEntity) {
        return systemUserService.saveEmployee(systemUserEntity);
    }

}

package com.innogon.kanbanapi.controller;


import com.innogon.kanbanapi.dao.UserRepository;
import com.innogon.kanbanapi.dao.model.User;
import com.turkraft.springfilter.boot.Filter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/api/users")

@Slf4j
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/search")
    public Page<User> search(@Filter Specification<User> spec, Pageable page) {
        return userRepository.findAll(spec, page);
    }



}
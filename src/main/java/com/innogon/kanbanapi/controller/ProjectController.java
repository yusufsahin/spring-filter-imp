package com.innogon.kanbanapi.controller;


import com.innogon.kanbanapi.dao.ProjectRepository;
import com.innogon.kanbanapi.dao.model.Project;

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
@RequestMapping("/api/projects")

@Slf4j
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor

public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "/search")
    public Page<Project> search(@Filter Specification<Project> spec, Pageable page) {
        return projectRepository.findAll(spec, page);
    }
}
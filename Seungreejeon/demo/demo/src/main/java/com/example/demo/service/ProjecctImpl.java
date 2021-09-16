package com.example.demo.service;


import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjecctImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void addproject(Project project) throws Exception {
        projectRepository.save(project);
    }

    @Override
    public List<Project> fetchProject() throws Exception {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Long boardNo) throws Exception {
        projectRepository.deleteById(boardNo);
    }
}

package com.example.demo.service;


import com.example.demo.entity.Project;

import java.util.List;

public interface ProjectService {

    public void addproject(Project project) throws Exception;

    public List<Project> fetchProject() throws Exception;

    public void deleteProject(Long boardNo) throws Exception;
}

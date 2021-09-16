package com.example.demo.controller.authentication;


import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProjectController {


    @Autowired
    ProjectService projectService;

    @PostMapping("/add-project")
    public ResponseEntity<Project> getProject(@RequestBody Project project) throws Exception {
        log.info("project() : " + project.toString());

        projectService.addproject(project);

        return new ResponseEntity<Project>(HttpStatus.OK);
    }


    @GetMapping("/fetch-project")
    public ResponseEntity<List<Project>> fetchProject() throws Exception {

        log.info("fetch project()");

        List<Project> fetchProject =  projectService.fetchProject();

        return new ResponseEntity<List<Project>>(fetchProject, HttpStatus.OK);
    }


    @DeleteMapping("/delete-project/{boardNo}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long boardNo) throws Exception {

        log.info("board No : " + boardNo);

        projectService.deleteProject(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}

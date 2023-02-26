package com.jira.controller;

import com.jira.entity.IssueRequest;
import com.jira.entity.Response;
import com.jira.service.TaskService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/issue")
    public ResponseEntity<Response> createIssue(@RequestBody IssueRequest request) throws UnirestException, IOException {
        return new ResponseEntity<>(taskService.createIssue(request), HttpStatus.CREATED);
    }

}

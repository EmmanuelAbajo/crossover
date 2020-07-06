package com.company.resourceapi.controllers;

import com.company.resourceapi.entities.Project;
import com.company.resourceapi.services.ProjectService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(ProjectRestController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "Project")
public class ProjectRestController {

	public static final String ENDPOINT = "/api/v2/projects";
	public static final String ENDPOINT_ID = "/{id}";
	public static final String PATH_VARIABLE_ID = "id";

	private static final String API_PARAM_ID = "ID";

	@Autowired
	private ProjectService projectService;

	@ApiOperation("Get a Project")
	@GetMapping(ENDPOINT_ID)
	public Project getProject(
			@ApiParam(name = API_PARAM_ID, required = true)
			@PathVariable(PATH_VARIABLE_ID)
			final long projectId
	) {
		return projectService.getProject(projectId);
	}

	@ApiOperation("Create a Project")
	@PostMapping
	public Project createProject(@Valid @RequestBody Project project) {
		return projectService.createProject(project);
	}
	
}

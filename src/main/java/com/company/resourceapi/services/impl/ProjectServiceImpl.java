package com.company.resourceapi.services.impl;

import java.util.Optional;

import com.company.resourceapi.entities.Project;
import com.company.resourceapi.entities.SdlcSystem;
import com.company.resourceapi.exceptions.NotFoundException;
import com.company.resourceapi.repositories.ProjectRepository;
import com.company.resourceapi.repositories.SdlcSystemRepository;
import com.company.resourceapi.services.ProjectService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final SdlcSystemRepository sdlcSystemRepository;

	public Project getProject(long id) {
		try {
			return projectRepository.findById(id).orElseThrow(() -> new NotFoundException(Project.class, id));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		long id = project.getSdlcSystem().getId();
		SdlcSystem sdlcSystem = sdlcSystemRepository.findById(id).get();
		project.setSdlcSystem(sdlcSystem);
		return projectRepository.save(project);
	}
}

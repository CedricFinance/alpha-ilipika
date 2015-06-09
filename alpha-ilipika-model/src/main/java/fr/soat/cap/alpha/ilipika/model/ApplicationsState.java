package fr.soat.cap.alpha.ilipika.model;

import java.util.List;

public class ApplicationsState {

	private final ApplicationRepository applicationRepository;

	public ApplicationsState(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public List<Application> listApplications() {
		return this.applicationRepository.listApplications();
	}

}

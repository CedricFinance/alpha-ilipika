package fr.soat.cap.alpha.ilipika.rest;

import java.util.Arrays;
import java.util.List;

import fr.soat.cap.alpha.ilipika.model.Application;
import fr.soat.cap.alpha.ilipika.model.ApplicationRepository;

public class FakeApplicationRepository implements ApplicationRepository {

	@Override
	public List<Application> listApplications() {
		final Application applicationA = new Application("Application A");
		final Application applicationB = new Application("Application B");
		final Application applicationC = new Application("Application C");
		final Application applicationD = new Application("Application D");
		final Application applicationE = new Application("Application E");
		applicationA.dependsOn(applicationB);
		applicationA.dependsOn(applicationC);
		applicationA.dependsOn(applicationD);
		applicationB.dependsOn(applicationE);
		applicationE.dependsOn(applicationB);
		return Arrays.asList(applicationA, applicationB, applicationC, applicationD, applicationE);
	}

}

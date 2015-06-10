package fr.soat.cap.alpha.ilipika.rest;

import fr.soat.cap.alpha.ilipika.model.ApplicationRepository;
import fr.soat.cap.alpha.ilipika.model.ApplicationsState;

public class Main {

	public static void main(String[] args) {
		// Dépendances du modèle
		final ApplicationRepository applicationRepository = new FakeApplicationRepository();

		// Domain model
		final ApplicationsState applicationsState = new ApplicationsState(applicationRepository);

		// Adapter
		final RestAdapter adapter = new RestAdapter(applicationsState, System.out);

		// run
		adapter.adapt(args);
	}

}

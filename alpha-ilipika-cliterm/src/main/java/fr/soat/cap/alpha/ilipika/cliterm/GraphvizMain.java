package fr.soat.cap.alpha.ilipika.cliterm;

import fr.soat.cap.alpha.ilipika.model.ApplicationRepository;
import fr.soat.cap.alpha.ilipika.model.ApplicationsState;

public class GraphvizMain {

	public static void main(String[] args) {
		// Dépendances du modèle
		final ApplicationRepository applicationRepository = new FakeApplicationRepository();

		// Domain model
		final ApplicationsState applicationsState = new ApplicationsState(applicationRepository);

		// Adapter
		final GraphvizAdapter adapter = new GraphvizAdapter(applicationsState, System.out);

		// run
		adapter.adapt(args);
	}
}

package fr.soat.cap.alpha.ilipika.cliterm;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import fr.soat.cap.alpha.ilipika.model.Application;
import fr.soat.cap.alpha.ilipika.model.ApplicationsState;

public class CommandLineAdapter {

	private final ApplicationsState applicationsState;
	private final PrintStream out;

	public CommandLineAdapter(ApplicationsState applicationsState,
			PrintStream out) {
		this.applicationsState = applicationsState;
		this.out = out;
	}

	public void adapt(String[] args) {
		for (final Application application : this.applicationsState.listApplications()) {
			this.out.print(application.getName());
			final List<String> dependencies = application.dependencies();
			if (dependencies.isEmpty()) {
				this.out.println(" has no dependencies.");
			} else {
				this.out.println(dependencies.stream().collect(Collectors.joining(" and ", " depends on ", ".")));
			}
			this.out.println("");
		}
	}

}

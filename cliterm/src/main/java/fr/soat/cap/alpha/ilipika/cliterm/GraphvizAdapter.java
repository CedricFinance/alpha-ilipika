package fr.soat.cap.alpha.ilipika.cliterm;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import fr.soat.cap.alpha.ilipika.model.Application;
import fr.soat.cap.alpha.ilipika.model.ApplicationsState;

public class GraphvizAdapter {

	private final ApplicationsState applicationsState;
	private final PrintStream out;

	public GraphvizAdapter(ApplicationsState applicationsState,
			PrintStream out) {
		this.applicationsState = applicationsState;
		this.out = out;
	}

	/*
	 * digraph {
   A -> {B C}
}
	 *
	 */
	public void adapt(String[] args) {
		this.out.println("digraph {");
		for (final Application application : this.applicationsState.listApplications()) {
			this.out.print(quoteString(application.getName()));
			final List<String> dependencies = application.dependencies();
			if (!dependencies.isEmpty()) {
				this.out.print(dependencies.stream().map(this::quoteString).collect(Collectors.joining(" ", "-> {", "}")));
			}
			this.out.println("");
		}
		this.out.println("}");
	}

	private String quoteString(final String str) {
		return "\""+str+"\"";
	}

}

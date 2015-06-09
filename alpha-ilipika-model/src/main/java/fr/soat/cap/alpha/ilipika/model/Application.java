package fr.soat.cap.alpha.ilipika.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
	private final String name;
	private final List<Application> dependencies = new ArrayList<Application>();

	public Application(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public List<String> dependencies() {
		return this.dependencies.stream().map(Application::getName).collect(Collectors.toList());
	}

	public void dependsOn(Application anotherApplication) {
		this.dependencies.add(anotherApplication);
	}
}

package fr.soat.cap.alpha.ilipika.rest;

import static spark.Spark.get;

import java.io.PrintStream;

import spark.Spark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.soat.cap.alpha.ilipika.model.Application;
import fr.soat.cap.alpha.ilipika.model.ApplicationsState;

public class RestAdapter {

	private final ApplicationsState applicationsState;

	public RestAdapter(ApplicationsState applicationsState, PrintStream out) {
		this.applicationsState = applicationsState;
	}

	/*
	[
		{
			name:"Application A",
			dependsOn:["Application B", "Application C"]
		},
		{
			name:"Application B",
			dependsOn:["Application A"]
		}
	]
	 */
	public void adapt(String[] args) {
		Spark.staticFileLocation("/public");

		final GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Application.class, new ApplicationSerializer());
		final Gson gson = builder.create();
		get("list", (req, res) -> {
			res.type("application/json");
			return this.applicationsState.listApplications();
		}, gson::toJson);
	}

}

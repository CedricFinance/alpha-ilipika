package fr.soat.cap.alpha.ilipika.neo4jadapter;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import fr.soat.cap.alpha.ilipika.model.Application;
import fr.soat.cap.alpha.ilipika.model.ApplicationRepository;

public class Neo4jAdapter implements ApplicationRepository {

	@Override
	public List<Application> listApplications() {
		final Client client = ClientBuilder.newClient();
		client.register(HttpAuthenticationFeature.basic("neo4j", "neo4jdev"));
		final WebTarget api = client.target("http://localhost:7474").path("db").path("data");
		final WebTarget target = api.path("node");
		final Response response = target.request(APPLICATION_JSON_TYPE).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		final Response post = api.path("transaction").path("commit").request(APPLICATION_JSON_TYPE).accept(APPLICATION_JSON_TYPE) //
				.post(Entity.entity("{ \"statements\": [ { \"statement\": \"CREATE (n) RETURN id(n)\" } ] }", APPLICATION_JSON_TYPE));
		System.out.println(post.getStatus());
		System.out.println(post.readEntity(String.class));
		return null;
	}

	public static void main(String[] args) {
		new Neo4jAdapter().listApplications();
	}

}

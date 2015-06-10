package fr.soat.cap.alpha.ilipika.rest;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import fr.soat.cap.alpha.ilipika.model.Application;

public class ApplicationSerializer implements JsonSerializer<Application>{

	@Override
	public JsonElement serialize(Application arg0, Type arg1,
			JsonSerializationContext arg2) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.add("name", new JsonPrimitive(arg0.getName()));

		final JsonArray dependencies = new JsonArray();
		for (final String dependency : arg0.dependencies()) {
			dependencies.add(new JsonPrimitive(dependency));
		}

		jsonObject.add("dependencies", dependencies);
		return jsonObject;
	}

}

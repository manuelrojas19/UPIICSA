package mx.ipn.upiicsa.poo.practica05.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import mx.ipn.upiicsa.poo.practica05.model.Figura;

public class Serializer<T> implements JsonSerializer<T>, JsonDeserializer<T> {
	private static final String TYPE = "type";
	private static final Serializer<Figura> serializer = new Serializer<>();

	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObj = json.getAsJsonObject();
		String className = jsonObj.get(TYPE).getAsString();
		try {
			return context.deserialize(json, Class.forName(className));
		} catch (ClassNotFoundException e) {
			throw new JsonParseException(e);
		}
	}

	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		JsonElement jsonEle = context.serialize(src, src.getClass());
		jsonEle.getAsJsonObject().addProperty(TYPE, src.getClass().getCanonicalName());
		return jsonEle;
	}

	public String getFigurasSerializer(List<Figura> figuras) {
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Figura.class, serializer);
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		java.lang.reflect.Type type = new TypeToken<ArrayList<Figura>>() {
		}.getType();
		String json = gson.toJson(figuras, type);
		return json;
	}

	public List<Figura> getFigurasList(String json) {
		List<Figura> figs = null;
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Figura.class, serializer);
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		java.lang.reflect.Type type = new TypeToken<ArrayList<Figura>>() {
		}.getType();
		figs = gson.fromJson(json, type);
		return figs;
	}

}

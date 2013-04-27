package util;

import java.util.List;

import play.data.validation.Error;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ResponseUtil {

	/**
	 * 构造一个返回错误信息的json对象
	 * */
	public static JsonObject responseError(String message){
		JsonObject res = new JsonObject();
		res.addProperty("status", "201"); //状态
		JsonArray ja = new JsonArray();
		ja.add(new JsonPrimitive(message));
		res.add("message", ja);
		return res;
	}
	/**
	 * 构造一个返回错误信息的json对象
	 * */
	public static JsonObject responseError(List<play.data.validation.Error> message){
		JsonObject res = new JsonObject();
		res.addProperty("status", "201");	//状态
		JsonArray ja = new JsonArray();
		for(play.data.validation.Error er : message){
			ja.add(new JsonPrimitive(er.getKey()));
		}
		res.add("message", ja);
		return res;
	}
	/**
	 * 构造成功对象
	 * */
	public static JsonObject responseSuccess(JsonObject data){
		JsonObject res = new JsonObject();
		res.addProperty("status", "200");	//状态
		res.add("data", data);
		return res;
	}
	public static JsonObject responseSuccess(){
		JsonObject res = new JsonObject();
		res.addProperty("status", "200");	//状态
		res.addProperty("data", "");
		return res;
	}
	public static JsonObject responseSuccess(String message){
		JsonObject res = new JsonObject();
		res.addProperty("status", "200");	//状态
		res.addProperty("data", "");
		JsonArray ja = new JsonArray();
		ja.add(new JsonPrimitive(message));
		res.add("message", ja);
		return res;
	}
	public static JsonObject responseSuccess(String message, JsonObject data){
		JsonObject res = new JsonObject();
		res.addProperty("status", "200");	//状态
		res.addProperty("data", "");
		JsonArray ja = new JsonArray();
		ja.add(new JsonPrimitive(message));
		res.add("message", ja);
		res.add("data", data);
		return res;
	}
}

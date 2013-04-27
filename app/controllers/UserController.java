package controllers;

import com.google.gson.JsonObject;

import models.User;
import play.mvc.Controller;
import util.ResponseUtil;

public class UserController extends Controller {
	
	public static void addUser(){
		String account = request.params.get("account");
		String username = request.params.get("username");
		String password = request.params.get("password");
		
		validation.required("帐号不能为空", account);
		validation.required("用户名不能为空", username);

		if (validation.hasErrors()) {
			JsonObject res = ResponseUtil.responseError(validation.errors());
			renderJSON(res);
		}
		
		User user = new User(account, username);
		//注册时用户密码可以为空,若用户密码不为空，则需要对密码进行加密处理
		if(password != null && !password.equals(""))	
			user.setPassword(play.libs.Codec.hexMD5("001"));
    	if(user.create()){
    		renderJSON(ResponseUtil.responseSuccess("用户注册成功"));
    	}else{
    		renderJSON(ResponseUtil.responseError("用户注册失败"));
    	}
	}
}

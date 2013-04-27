package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	User user = new User("001", "CJJ");
    	user.setPassword(play.libs.Codec.hexMD5("001"));
    	user.create();
        render();
    }

}
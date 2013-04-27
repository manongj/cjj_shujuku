import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.test.FunctionalTest;


public class UserTest extends FunctionalTest {
	
	@Test
	public void addTest(){
		Request req = newRequest();
		req.params.put("account", "001");
		req.params.put("username", "cjj");
		req.params.put("password", "001");
		Response res = POST(req, "/user/add");
		String content = getContent(res);
		JsonObject jo = (JsonObject) new JsonParser().parse(content).getAsJsonObject().get("members");
		assertNotNull(jo);
		assertEquals("200", jo.get("status").getAsString());
	}
}

package restAssuredDemo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


public class SocialNetworkingPost
{
@Test
    public void getSpecificSocialNetworkingPost()
    {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/6").
                then().statusCode(200).log().all().
                body("title", is("dolorem eum magni eos aperiam quia")).
                body("body", is("ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"));
    }
    @Test
    public void createASocialNetworkingPost(){
        HashMap<String, String> PostRequestBody = new HashMap<>();
        PostRequestBody.put("userId", "1");
        PostRequestBody.put("title", "My last holiday in Japan");
        PostRequestBody.put("body", "I went holiday with my family . we had a good time. It was in the winter");

        given().contentType(ContentType.JSON).log().all().with().body(PostRequestBody).
                when().post("https://jsonplaceholder.typicode.com/posts").
                then().statusCode(201).log().all().
                body("title", is ("My last holiday in Japan"));
    }
    @Test
    public void getSpecificSocialNetworkingComment()
    {
        given().contentType(ContentType.JSON).log().all().
                when().get(" https://jsonplaceholder.typicode.com/posts/75").
                then().statusCode(200).log().all().
                body("title", is("dignissimos eum dolor ut enim et delectus in")).
                body("userId", is(8));
    }
    @Test
    public void createASocialNetworkingComment(){
        HashMap<String, String> PostRequestBody = new HashMap<>();
        PostRequestBody.put("postId", "1");
        PostRequestBody.put("name", "My first comment");
        PostRequestBody.put("email", "imaan@gmail.com");
        PostRequestBody.put("body", "I like the post make by my best friend");

        given().contentType(ContentType.JSON).log().all().with().body(PostRequestBody).
                when().post("https://jsonplaceholder.typicode.com/comments").
                then().statusCode(201).log().all().
                body("name", is ("My first comment"));
    }
    @Test
    public void getSpecificSocialNetworkingUsers()
    {
        given().contentType(ContentType.JSON).log().all().
                when().get("  https://jsonplaceholder.typicode.com/users/1").
                then().statusCode(200).log().all().
                body("website", is("hildegard.org")).
                body("phone", is("1-770-736-8031 x56442"));
    }
    @Test
    public void createASocialNetworkingUsers() {
        JSONObject PostRequestBody = new JSONObject();
        PostRequestBody.put("name", "Leanne Graham");
        PostRequestBody.put("username", "Bret");
        PostRequestBody.put("email", "Sincere@april.biz");
        Map address = new HashMap<>();;
        address.put("street", "Kulas Light");
        address.put("suite", "Apt. 556");
        address.put("city", "Gwenborough");
        address.put("zipcode", "92998-3874");

        Map<String, String> geo = new HashMap<>();
        geo.put("lat", "-37.3159");
        geo.put("lng", "81.1496");

        address.put("geo", geo);

        PostRequestBody.put("address", address);
        PostRequestBody.put("phone", "1-770-736-8031 x56442");
        PostRequestBody.put("website", "hildegard.org");
        Map company = new HashMap();
        company.put("name", "Romaguera-Cron");
        company.put("catchPhrase", "Multi-layered client-server neural-net");
        company.put("bs", "harness real-time e-markets");
        PostRequestBody.put("company", company);


        given().contentType(ContentType.JSON).log().all().with().body(PostRequestBody).
                when().post("https://jsonplaceholder.typicode.com/users").
                then().statusCode(201).log().all().
                body("address.city", is("Gwenborough"));
    }
}

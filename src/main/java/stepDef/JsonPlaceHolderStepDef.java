package stepDef;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class JsonPlaceHolderStepDef extends BaseSteps
{
    Response getCommentResponse;
    Response postCommentResponse;

    RequestBodyService requestBodyService;

    DocumentContext requestBody;
    @Given("JsonPlaceHolder is up and running")
    public void json_place_holder_is_up_and_running()
    {
        setHeadersWithContentType();
        setEndpointPath(ServiceURL);
        Response getServiceresponse = getCall();
        assertThat(getServiceresponse.statusCode(), equalTo(200));
    }
    @When("Get request is send to get a specific comment with {string}")
    public void get_request_is_send_to_get_a_specific_comment_with(String id)
    {
        setHeadersWithContentType();
        setEndpointPath(CommentsURL + id);
        getCommentResponse = getCall();
    }
    @Then("Specific comment details with {string}, {string}, {string} is returned with status code of {int}")
    public void specific_comment_details_with_is_returned_with_status_code_of(String id, String name, String email, Integer sCode)
    {
        assertThat(getCommentResponse.statusCode(), equalTo(sCode));
        assertThat(getCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(getCommentResponse.body().jsonPath().get("email"), equalTo(email));
        assertThat(getCommentResponse.body().jsonPath().get("id"), equalTo(Integer.parseInt(id)));
    }


    //second Scenario
    @When("I create a new comment with {string}, {string}, {string}, and {string}")
    public void i_create_a_new_comment_with_and(String postId, String name, String email, String body)
    {
        setHeadersWithContentType();
        setEndpointPath(CommentsURL);
        requestBodyService = new RequestBodyService();
        requestBody = loadJsonTemplate(MakeACommentPayload);
        requestBodyService.setRequestForComment(requestBody, postId, name, email, body);
        postCommentResponse = getPostCall();
    }
    @Then("Specific comment details with {string}, {string}, {string} and {string} is returned with status code of {int}")
    public void specific_comment_details_with_and_is_returned_with_status_code_of(String postId, String name, String email, String body, Integer statusCode)
    {
        assertThat(postCommentResponse.statusCode(), equalTo(statusCode));
        assertThat(postCommentResponse.body().jsonPath().get("postId"), equalTo(postId));
        assertThat(postCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(postCommentResponse.body().jsonPath().get("email"), equalTo(email));
    }


}

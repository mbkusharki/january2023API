package utilities;

import com.jayway.jsonpath.DocumentContext;
import stepDef.BaseSteps;

public class RequestBodyService extends BaseSteps
{
    public void setRequestForComment(DocumentContext requestBody, String postId, String name, String email, String body)
    {
        requestBody.set("postId", postId);
        requestBody.set("name", name);
        requestBody.set("email", email);
        requestBody.set("body", body);
    }
}

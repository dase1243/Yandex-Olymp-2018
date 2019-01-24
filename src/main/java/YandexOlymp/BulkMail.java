package YandexOlymp;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class BulkMail {
    public static void main(String[] args) throws Exception {
        WebClient webClient = new WebClient();
        HtmlPage page1 = webClient.getPage("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&flowName=GlifWebSignIn&flowEntry=SignUp");
        HtmlForm form = page1.getFormByName("myform");

    }
}

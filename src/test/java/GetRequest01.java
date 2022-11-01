import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest01 {

    @Test
    public void test01() {

        String url="https://restful-booker.herokuapp.com/booking";

        Response response=given().when().get(url);
        // given().when().get(url); end pointe gondermek icin request olusturmus olduk.
        // Response response -> api tarafindan bana donen response (cevap)

        //Response response=given().auth().basic("user","password").when().get(url);
        //basic aut ile request gondermek icin

        //response.prettyPrint(); //response'taki body'i yazdirir

        //response.prettyPeek();  // response'taki herseyi yazdirir.

        //response.peek();

        //response.print();
        // [{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747},...]

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) JUnit Assert leri ile API testi yapabiliriz.
        assertEquals("Status Kod Hatalı",200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.statusLine());
        assertEquals("application/json; charset=utf-8", response.contentType());

        // 2) assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}

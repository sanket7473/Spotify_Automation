import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class Spotify_s{
    String token = "BQCMfTMdt0vsRpOdMeUg7Qoa24NrNhXNLANWetgUZmUTDNtyJCHU0ZZy2cB2FwPyt0apEKnKQKo6kC2Kc-Y6-5dZ7L6yB5O2elzOrHiRTD3B5h_-RpD6I2r_-GpufitVgeaD1irarWPDWA8XYn6vhEfZ9B_9GZAaUIxAA0anCXJ3MqVP5PFL3lc2Jc6ooe8-XRp1AgbPLliTbdQCHVj4HVxfgPM8CdrCq1_XZzreEmeC8vJqx2bGwfYGPkOipm8epf-ko8t3KA";
    String type = "artists";
    @Test
    public void getUserPlaylist() {
        Response res = given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer" + token)
                .when()
                .get("https://api.spotify.com/v1/users/nr3vm9usfmicwi3usug5vkqva/playlists?user_id=nr3vm9usfmicwi3usug5vkqva&limit=10&offset=5");


    }
 @Test
 public void CreatePlayList()
    {
      Response res=given()
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + token )
              .body("{\n" +
                      "    \"name\": \"New Playlist\",\n" +
                      "    \"description\": \"New playlist description\",\n" +
                      "    \"public\": false\n" +
                      "}"
              )
              .when()
              .post("https://api.spotify.com/v1/users/nr3vm9usfmicwi3usug5vkqva/playlists");
      res.prettyPrint();
      Assert.assertEquals(res.statusCode(),201);
    }

    @Test
    public void GetUserprofile()
    {
        Response res=given().
                header("Authorization","Bearer " + token ).
                when().
                get(" https://api.spotify.com/v1/users/nr3vm9usfmicwi3usug5vkqva");
        Assert.assertEquals(res.statusCode(),200);
    }
    @Test
    public void get_Current_Users_Profile()
    {
        Response res=given().header("Authorization", "Bearer " + token).when().get("https://api.spotify.com/v1/me");
        Assert.assertEquals(res.statusCode(),200);
        res.prettyPrint();
    }

//    @Test
//    public void get_Users_top_Item()
//    {
//        Response res=given()
//                .header("Authorization", "Bearer" + token )
//                .when()
//                .get("https://api.spotify.com/v1/me/top/{type} "+ type);
//        Assert.assertEquals(res.statusCode(),200);
//        res.prettyPrint();
//    }
}

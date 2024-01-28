import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class Spotify_s{
    String token = "BQCG3NZOo5HGHracr4e7GpKDzAyWLIfoQGm5Y1ADQzWY5UyMm3S1Gn-h04juRcPCOhx8NHTp0QtM21AcKCYlZ1iGhWTgfv8t-367vS2-6nRDWcCjKqYzXXYLxEPtEjZ-mY-6VzLBSVPl3Wy1Vlrx6-A9ll1vohDvtFtP_GcXKWgm4hBcGwHxz_WF4QzgI8hGTo_3eSMhqzKTOk9mu2pDkJIM6tNKCACRVSYkT-G2on9kMVRshhREFCl95SSuEHZRgQM8hy3EVw";
    String type = "artists";

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
        Response res=given().header("Authorization", "Bearer " + token).when().get("\n" +
                "https://api.spotify.com/v1/me");
        Assert.assertEquals(res.statusCode(),200);
        res.prettyPrint();
    }


    @Test
    public void followPlayList()
    {
        Response res=given()
                .header("Authorization", "Bearer " + token ).header("Content-Type", "application/json").
                body(
                        "{\n" +
                                "    \"public\": false\n" +
                                "}")
                .when()
                .put("\n" +
                        "https://api.spotify.com/v1/playlists/4Xf8eiasJ1p8dLHCv7j15Y" +
                        "/followers");
        Assert.assertEquals(res.statusCode(),200);
    }

    @Test
    public void followArtistOrUser() {
        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .put("https://api.spotify.com/v1/me/following?type=artist&ids=4HQeSXwG2BVH0KvxHE5oCf");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(), 204);
    }
}

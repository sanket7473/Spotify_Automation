import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;
public class playlist {
    String token = "BQCG3NZOo5HGHracr4e7GpKDzAyWLIfoQGm5Y1ADQzWY5UyMm3S1Gn-h04juRcPCOhx8NHTp0QtM21AcKCYlZ1iGhWTgfv8t-367vS2-6nRDWcCjKqYzXXYLxEPtEjZ-mY-6VzLBSVPl3Wy1Vlrx6-A9ll1vohDvtFtP_GcXKWgm4hBcGwHxz_WF4QzgI8hGTo_3eSMhqzKTOk9mu2pDkJIM6tNKCACRVSYkT-G2on9kMVRshhREFCl95SSuEHZRgQM8hy3EVw";
    String type = "artists";
    String imagePath = "C:\\Users\\Sanket\\Desktop\\DogImage.jpg";
    // Create a File object from the image file path
    File imageFile = new File(imagePath);

    //Create playlist
    @Test
    public void createPlaylist() {
        Response res = given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token).
                body("{\n" +
                        "    \"name\": \"New Playlist\",\n" +
                        "    \"description\": \"New playlist description\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/nr3vm9usfmicwi3usug5vkqva/playlists");
        Assert.assertEquals(res.statusCode(),201);
        res.prettyPrint();
    }

    //Get Playlist
    @Test
    public void getPlaylist()
    {
        Response res=given().header("Authorization" ,"Bearer " + token).when().get("https://api.spotify.com/v1/playlists/7gKBk8VfsS8D7VCF6dgEOG");
        Assert.assertEquals(res.statusCode(),200);
    }
    //GetFeaturedPlaylist
    @Test
    public void getFeaturedPlaylist()
    {
        Response res=given().header("Authorization", "Bearer " + token).when().get("\n" +
                "https://api.spotify.com/v1/browse/featured-playlists");
        Assert.assertEquals(res.statusCode(),200);
    }

   //GetCategoryPlayList
    @Test
    public void getCategoryPlayList()
    {
        Response res=given().header("Authorization", "Bearer " + token).when().get("https://api.spotify.com/v1/browse/categories/dinner/playlists");
        Assert.assertEquals(res.statusCode(),200);
    }

   //getPlayListCoverImage
    @Test
    public void getPlayListCoverImage()
    {
        Response res=given().header("Authorization","Bearer " + token ).when().get("https://api.spotify.com/v1/playlists/7eLUwsZ0aLFWfsCQs6ULkC/images?playlist_id=3cEYpjA9oz9GiPac4AsH4n");


    }
    @Test
    public void addItemToPlaylist()
    {
        Response res=given().
                header("Authorization" ,"Bearer " + token).
        header("'Content-Type","application/json").
                body("{\n" +
                        "    \"uris\": [\n" +
                        "\"spotify:track:1418IuVKQPTYqt7QNJ9RXN\"\n" +
                        "    ],\n" +
                        "    \"position\":0\n" +
                        "}").post("https://api.spotify.com/v1/playlists/4HNfsSmwJHZBFL6HkSHIOW/tracks");
                 Assert.assertEquals(res.statusCode(),201);
    }

}

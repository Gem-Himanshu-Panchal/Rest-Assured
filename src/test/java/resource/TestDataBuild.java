package resource;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(){
        RestAssured.baseURI = "https;//rahulshettyacademy.com";
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress("1234, XYZ colony, ABC");
        p.setLanguage("Hinglish");
        p.setPhoneNumber("88728289342");
        p.setWebsite("www.google.com");
        List<String> li = new ArrayList<>();
        li.add("Sneaker park");
        li.add("HEHE");
        li.add("QA");

        p.setName("Himu1808");
        p.setType(li);
        Location loc = new Location();
        loc.setLat(-38.3834234);
        loc.setLng(33.4273563);
        p.setLocation(loc);
        return p;
    }
}

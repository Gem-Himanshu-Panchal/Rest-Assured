package resource;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(String name, String language, String address){
        RestAssured.baseURI = "https;//rahulshettyacademy.com";
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhoneNumber("88728289342");
        p.setWebsite("www.google.com");
        List<String> li = new ArrayList<>();
        li.add("Sneaker park");
        li.add("HEHE");
        li.add("QA");

        p.setName(name);
        p.setType(li);
        Location loc = new Location();
        loc.setLat(-38.3834234);
        loc.setLng(33.4273563);
        p.setLocation(loc);
        return p;
    }
}

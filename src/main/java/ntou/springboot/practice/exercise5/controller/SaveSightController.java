package ntou.springboot.practice.exercise5.controller;

import ntou.springboot.practice.exercise5.entity.Sight;
import ntou.springboot.practice.exercise5.service.SightService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class SaveSightController {
    private SightService sightService;
    private List<String> sightList = asList("中山區", "信義區", "仁愛區", "中正區", "安樂區", "七堵區", "暖暖區");

    public SaveSightController(SightService sightService) throws IOException {
        this.sightService = sightService;
        saveAttraction();
    }
    public void saveAttraction() throws IOException {
        for (int i = 0; i < sightList.size(); i++) {
            int index = 0;
            Sight[] sights = new Sight[100];

            String link = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
            Document document = Jsoup.connect(link).get();
            Elements boxElements = document.select("h4:contains(" + sightList.get(i) + ")");

            for (Element boxElement : boxElements) {
                Element ulElement = boxElement.nextElementSibling();

                Elements liElements = ulElement.select("li");

                for (Element liElement : liElements) {
                    String SightName = liElement.select("a").text();
                    String href = liElement.select("a").attr("href");

                    String zone = boxElement.text();

                    Document document1 = Jsoup.connect(new URL(new URL(link), href).toString()).get();
                    Element strongElement = document1.select("strong").first();
                    Element gpicElement = document1.select("div.gpic").first();
                    Element descriptionElement = document1.select("div.text").first();
                    Element addressElement = document1.select("div.address").first();

                    String category = strongElement.text();
                    String photoURL = "";

                    if (gpicElement != null) {
                        photoURL = gpicElement.select("img").attr("data-src");
                    }

                    else {
                        photoURL = "";
                    }

                    String description = descriptionElement.text();
                    String address = addressElement.select("span").text();

                    sights[index] = new Sight(SightName, zone, category, photoURL, description, address);
                    index++;

                    sightService.insertSight(new Sight(SightName, zone, category, photoURL, description, address));

                    System.out.println();
                }
            }
        }

    }
}

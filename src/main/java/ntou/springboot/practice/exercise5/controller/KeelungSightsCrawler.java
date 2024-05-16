package ntou.springboot.practice.exercise5.controller;

import ntou.springboot.practice.exercise5.entity.Sight;
import ntou.springboot.practice.exercise5.service.SightService;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class KeelungSightsCrawler extends Sight {

    private final SightService sightService;

    @Autowired
    public KeelungSightsCrawler(SightService sightService) {
        super();
        this.sightService = sightService;
    }
    public KeelungSightsCrawler(String sightName, String zone, String category, String photoURL, String description, String address, SightService sightService) {
        super(sightName, zone, category, photoURL, description, address);
        this.sightService = sightService;
    }


    @GetMapping("/SightAPI")
    public ResponseEntity<List<Sight>> getItems(@RequestParam(value = "zone", defaultValue = "") String pointName) throws IOException {
        List<Sight> sights = sightService.findByZone(pointName);
        return ResponseEntity.ok().body(sights);
    }

    @Override
    public String toString() {
        return String.format("SightName: %s%nZone: %s%nCategory: %s%nPhotoURL:%n%s%nDescription: %s%nAddress: %s%n%n", getSightName(), getZone(), getCategory(), getPhotoURL(), getDescription(), getAddress());
    }
}
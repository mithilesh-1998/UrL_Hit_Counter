package com.Geekster.URLHitCounter.Controller;

import com.Geekster.URLHitCounter.Service.UrlHitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlHitController {

    private final UrlHitService urlHitService;

    public UrlHitController(UrlHitService urlHitService) {
        this.urlHitService = urlHitService;
    }
    @GetMapping("count")
    public int getHitCount(){
        return urlHitService.incrementHitCount();
    }
    @GetMapping("username/{username}/count")
    public String getUserHitCount(@PathVariable String username) {
        Integer usercount = urlHitService.getUserHitCounter(username);

        return "Username" + ":"+username+" " +  "HitCount"+ ":" + usercount+" " ;
    }
}

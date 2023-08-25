package com.search.SearchApp.Config;

import org.springframework.stereotype.Component;

@Component
public class BingSearchConfig {

    public String getImageSearchConfig(){
        return "https://bing-image-search1.p.rapidapi.com";
    }

}

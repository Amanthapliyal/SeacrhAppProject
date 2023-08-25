package com.search.SearchApp.Adapter;
import com.search.SearchApp.Adapter.Response.ImageResponse;
import com.search.SearchApp.Config.BingSearchConfig;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class ImageSearchResultAdapter {

    BingSearchConfig bingSearchConfig;
    RestTemplate restTemplate;

    final static String IMAGE_SEARCH_PATH = "%s/images/search?q=%s";

    public ImageResponse imageSearchResult(String string){
        String uri = String.format(IMAGE_SEARCH_PATH, bingSearchConfig.getImageSearchConfig(),string);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Key","fddcfb5e08msh6eb2fa83a15fd8dp1fc008jsn1066abed18d1");
        httpHeaders.add("X-RapidAPI-Host","bing-image-search1.p.rapidapi.com");
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

        return  restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<ImageResponse>() {}).getBody();

    }
}

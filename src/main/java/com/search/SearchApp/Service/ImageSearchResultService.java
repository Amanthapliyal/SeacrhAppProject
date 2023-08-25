package com.search.SearchApp.Service;

import com.search.SearchApp.Adapter.ImageSearchResultAdapter;
import com.search.SearchApp.Adapter.Response.ImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ImageSearchResultService {

    ImageSearchResultAdapter imageSearchResultAdapter;
    RedisService redisService;

    public ImageResponse getImageSearchResult(String query) throws IOException {
        if(!redisService.isValuePresent(query)) {
            var result = imageSearchResultAdapter.imageSearchResult(query);
            redisService.setValue(query, result);
            System.out.println("from client");
            return (ImageResponse)result;
        }
        else{
            System.out.println("from redis");
            return (ImageResponse) redisService.getValue(query);
        }
    }
}

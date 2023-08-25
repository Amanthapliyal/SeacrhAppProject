package com.search.SearchApp.Controller;

import com.search.SearchApp.Adapter.Response.ImageResponse;
import com.search.SearchApp.Service.ImageSearchResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/query")
@AllArgsConstructor
public class ImageController {

    ImageSearchResultService imageSearchResultService;

    @GetMapping("/{search}")
    public ImageResponse getImageSearchResult(@PathVariable("search") String search) throws IOException {
        return imageSearchResultService.getImageSearchResult(search);
    }

}

package com.search.SearchApp.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {

    String webSearchUrl;
    String name;
    String thumbnailUrl;
    String datePublished;
    boolean isFamilyFriendly;
    String contentUrl;

}

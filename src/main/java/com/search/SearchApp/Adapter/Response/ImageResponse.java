package com.search.SearchApp.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageResponse {

    String _type;
    Instrumentation instrumentation;
    String readLink;
    String webSearchUrl;
    QueryContext queryContext;
    List<Value> value;


}

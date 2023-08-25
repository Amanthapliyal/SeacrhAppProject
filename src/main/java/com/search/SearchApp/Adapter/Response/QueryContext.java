package com.search.SearchApp.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryContext {

    String originalQuery;
    String alterationDisplayQuery;
    String alterationOverrideQuery;
    String alterationMethod;
    String alterationType;

}

package com.schmidt.comfview.utils;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;

public class Search {

    /**
     * Search channel based on the channel name.
     * @param search youtube api search item made previously
     * @param name channel name to search
     * @return an ArrayList containing the 25 first search results and all the data
     */
    public ArrayList<SearchResult> searchChannel(YouTube.Search.List search, String name) throws IOException {
        ArrayList<SearchResult> results;

        search.setMaxResults((long) 25);
        search.setQ(name);
        search.setType("channel");
        SearchListResponse response = search.execute();

        results = (ArrayList<SearchResult>) response.getItems();

        return results;
    }
}

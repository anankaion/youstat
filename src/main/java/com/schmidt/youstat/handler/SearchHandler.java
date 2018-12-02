package com.schmidt.youstat.handler;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;

public class SearchHandler {

    /**
     * SearchHandler Items based on the name and the type given.
     * @param search youtube api search item made previously
     * @param name channel name to search
     * @param type type of item to be searched
     * @return an ArrayList containing the 25 first search results and all the data
     */
    public ArrayList<SearchResult> search(YouTube.Search.List search, String name, char type) throws IOException {
        SearchListResponse response;

        search.setMaxResults((long) 25);
        search.setQ(name);

        switch (type) {
            case 'c':
                search.setType("channel");
                break;

            case 'v':
                search.setType("video");
                break;

            case 'p':
                search.setType("playlist");
                break;

            default:
                throw new IllegalArgumentException();
        }

        response = search.execute();

        return (ArrayList<SearchResult>) response.getItems();
    }
}

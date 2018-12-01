package com.schmidt.comfview.utils;

import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;

import java.util.ArrayList;

public class Print {

    /**
     * Prints all found channels in an eyepleasing manner.
     * @param channels ArrayList which contains search results based on a previous search
     */
    public void printChannels(ArrayList<SearchResult> channels){
        for (SearchResult result : channels){
            SearchResultSnippet snippet = result.getSnippet();

            System.out.println("ID:\t" + snippet.getChannelId());
            System.out.println("Name:\t" + snippet.getChannelTitle());
            System.out.println("Description:\t" + snippet.getDescription());
            System.out.println();
        }
    }
}

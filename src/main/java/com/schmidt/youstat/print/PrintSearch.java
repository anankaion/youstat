package com.schmidt.youstat.print;

import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;

import java.util.ArrayList;

public class PrintSearch {

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

    /**
     * Prints all found videos in an eyepleasing manner.
     * @param videos ArrayList which contains search results based on a previous search
     */
    public void printVideos(ArrayList<SearchResult> videos) {
        for (SearchResult result : videos){
            SearchResultSnippet snippet = result.getSnippet();

            System.out.println("Name:\t" + snippet.getTitle());
            System.out.println("Creator:\t" + snippet.getChannelTitle());
            System.out.println("Published:\t" + snippet.getPublishedAt());
            System.out.println();
        }
    }

    /**
     * Prints all found playlists in an eyepleasing manner.
     * @param playlists ArrayList which contains search results based on a previous search
     */
    public void printPlaylists(ArrayList<SearchResult> playlists) {
        for (SearchResult result : playlists){
            SearchResultSnippet snippet = result.getSnippet();

            System.out.println("Name:\t" + snippet.getTitle());
            System.out.println("Creator:\t" + snippet.getChannelTitle());
            System.out.println();
        }
    }
}

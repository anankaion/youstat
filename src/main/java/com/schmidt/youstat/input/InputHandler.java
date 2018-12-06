package com.schmidt.youstat.input;

import com.google.api.services.youtube.YouTube;
import com.schmidt.youstat.handler.ListHandler;
import com.schmidt.youstat.print.PrintList;
import com.schmidt.youstat.print.PrintSearch;
import com.schmidt.youstat.handler.SearchHandler;

import java.io.IOException;

import static com.schmidt.youstat.YouStat.youtube;

public class InputHandler {

    private SearchHandler searchHandler;
    private ListHandler listHandler;

    private PrintSearch printSearch;
    private PrintList printList;

    public InputHandler() {
        searchHandler = new SearchHandler();
        listHandler = new ListHandler();

        printSearch = new PrintSearch();
        printList = new PrintList();
    }

    /**
     * Performs the search depending on the arguments given.
     * @param input arguments from main
     * @throws IOException
     */
    public void handleSearch(String[] input) throws IOException {
        YouTube.Search.List search = youtube.search().list("snippet");

        switch (input[1]){
            case "channel":
                printSearch.printChannels(searchHandler.search(search, input[2], 'c'));
                break;

            case "video":
                printSearch.printVideos(searchHandler.search(search, input[2], 'v'));
                break;

            case "playlist":
                printSearch.printPlaylists(searchHandler.search(search, input[2], 'p'));
                break;

            default:
                throw new IllegalArgumentException();
        }
    }

    public void handleList(String[] input) throws IOException {
        YouTube.Channels.List channels;
        YouTube.Videos.List videos;

        switch (input[1]){
            case "channel":
                channels = youtube.channels().list(
                        "contentOwnerDetails,statistics,topicDetails"
                );
                printList.printChannel(listHandler.listChannel(channels, input[2]));
                break;

            case "video":
                videos = youtube.videos().list(
                        "snippet,contentDetails,statistics"
                );

                break;

            case "playlist":
                break;

            default:
                throw new IllegalArgumentException();
        }
    }
}

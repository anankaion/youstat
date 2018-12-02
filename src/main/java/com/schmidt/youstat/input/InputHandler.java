package com.schmidt.youstat.input;

import com.google.api.services.youtube.YouTube;
import com.schmidt.youstat.handler.PrintHandler;
import com.schmidt.youstat.handler.SearchHandler;

import java.io.IOException;

import static com.schmidt.youstat.YouStat.youtube;

public class InputHandler {

    private SearchHandler searchHandler;
    private PrintHandler printHandler;

    public InputHandler() {
        searchHandler = new SearchHandler();
        printHandler = new PrintHandler();
    }

    /**
     * Performs the search depending on the arguments given.
     * @param args arguments from main
     * @throws IOException
     */
    public void handleSearch(String[] args) throws IOException {
        YouTube.Search.List search = youtube.search().list("snippet");

        switch (args[1]){
            case "channel":
                printHandler.printChannels(searchHandler.search(search, args[2], 'c'));
                break;

            case "video":
                printHandler.printVideos(searchHandler.search(search, args[2], 'v'));
                break;

            case "playlist":
                printHandler.printPlaylists(searchHandler.search(search, args[2], 'p'));
                break;

            default:
                throw new IllegalArgumentException();
        }
    }
}

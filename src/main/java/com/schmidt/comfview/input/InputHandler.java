package com.schmidt.comfview.input;

import com.google.api.services.youtube.YouTube;
import com.schmidt.comfview.handler.PrintHandler;
import com.schmidt.comfview.handler.SearchHandler;

import java.io.IOException;

import static com.schmidt.comfview.ComfView.youtube;

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
                printHandler.printVideos(searchHandler.search(search, args[2], 'p'));
                break;

            default:
                throw new IllegalArgumentException();
        }
    }
}

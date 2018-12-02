package com.schmidt.youstat.handler;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;

import java.io.IOException;
import java.util.ArrayList;

public class ListHandler {

    /**
     * Returns a list containing all channels given a specific username.
     * @param channel youtube api channel made previously
     * @param name name of the channel
     * @return the first channel matching the criteria
     * @throws IOException
     */
    public Channel listChannel(YouTube.Channels.List channel, String name) throws IOException {
        ChannelListResponse response;

        channel.setForUsername(name);

        response = channel.execute();

        return response.getItems().get(0);
    }
}

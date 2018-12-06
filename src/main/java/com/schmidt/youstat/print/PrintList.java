package com.schmidt.youstat.print;

import com.google.api.services.youtube.model.*;


public class PrintList{

    /**
     * Print infos about one channel in an eyepleasing manner.
     * @param channel channel i want info about
     */
    public void printChannel(Channel channel) {
        int i = 0;

        ChannelContentOwnerDetails contentOwnerDetails = channel.getContentOwnerDetails();
        ChannelStatistics statistics = channel.getStatistics();
        ChannelTopicDetails topicDetails = channel.getTopicDetails();

        System.out.println("Name:\t" + contentOwnerDetails.getContentOwner());
        System.out.println("Subscribers:\t" + statistics.getSubscriberCount());
        System.out.println("Views:\t" + statistics.getViewCount());
        System.out.println("Videos:\t" + statistics.getVideoCount());
        System.out.println();

        for (String s : topicDetails.getTopicCategories()){
            System.out.println("Category " + i + ":\t" + s);
            i++;
        }
    }

    /**
     * Print infos about one video in an eyepleasing manner.
     * @param video video i want info about
     */
    public void printVideo(Video video) {
        VideoSnippet snippet = video.getSnippet();
        VideoContentDetails contentDetails = video.getContentDetails();

        System.out.println("Name:\t" + snippet.getTitle());
        System.out.println("Creator:\t" + snippet.getChannelId());
        System.out.println("Description:\t" + snippet.getDescription());
        System.out.println("Duration:\t" + contentDetails.getDuration());
        System.out.println("Dimension:\t" + contentDetails.getDimension());
    }
}

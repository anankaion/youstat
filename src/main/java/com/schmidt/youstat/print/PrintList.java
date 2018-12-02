package com.schmidt.youstat.print;

import com.google.api.services.youtube.model.*;


public class PrintList{

    public void printChannels(Channel channel) {
        int i = 0;

        ChannelContentOwnerDetails contentOwnerDetails = channel.getContentOwnerDetails();
        ChannelStatistics statistics = channel.getStatistics();
        ChannelAuditDetails auditDetails = channel.getAuditDetails();
        ChannelTopicDetails topicDetails = channel.getTopicDetails();

        System.out.println("Name:\t" + contentOwnerDetails.getContentOwner());
        System.out.println("Subscribers:\t" + statistics.getSubscriberCount());
        System.out.println("Views:\t" + statistics.getViewCount());
        System.out.println("Videos:\t" + statistics.getVideoCount());
        System.out.println();
        System.out.println("Overall Standing:\t" + auditDetails.getOverallGoodStanding());
        System.out.println("Community Guidelines Standing:\t" + auditDetails.getCommunityGuidelinesGoodStanding());
        System.out.println("Copyright Strike Standing:\t" + auditDetails.getCopyrightStrikesGoodStanding());
        System.out.println();

        for (String s : topicDetails.getTopicCategories()){
            System.out.println("Category " + i + ":\t" + s);
            i++;
        }
    }

}

/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2018/5/14
 */


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "OFN54pE9cQ3K1AEGcFR86wnsP";
    private final static String CONSUMER_KEY_SECRET = "WwTFOStDPiHciRsoHRg93934IPtasSdgAig7OmBGylsH1IiWuR";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("uji coba");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "zp90GA4wgPtevL6a5I3VTZKkosUknNqFxEWtt9tRGlJHF";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1108968853-T9Szj9dezf5A8UF30XvnOWNWk50ttis6GDHBAMQ";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
package util;

import com.uncr.studioapp.domain.channel.ChannelVO;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Log4j2
public class YoutubeDataAPI {
    private static final String URL = "https://www.googleapis.com/youtube/v3";
    static final String API_KEY = "AIzaSyBZ9eEWICOQKk7uXxz6tcT2l3CimLfEJAQ";

    public void setChannelInfo(ChannelVO channelVO) throws ParseException, NullPointerException {
        String result= this.youtubeAPICall("/channels", "snippet", 1, channelVO.getChannelID());

        JSONParser jsonParser = new JSONParser();
        JSONObject youtube = (JSONObject) jsonParser.parse(result);
        JSONArray itemArray = (JSONArray) youtube.get("items");

        JSONObject tempObject = (JSONObject) itemArray.get(0);
        JSONObject snippet = (JSONObject) tempObject.get("snippet");

        JSONObject thumbnails = (JSONObject) snippet.get("thumbnails");
        JSONObject defaultThumbnail = (JSONObject) thumbnails.get("default");

        channelVO.setChannelTitle((String) snippet.get("title"));
        channelVO.setChannelThumbnail((String) defaultThumbnail.get("url"));
        channelVO.setChannelRegion((String) snippet.get("country"));
    }

    private String youtubeAPICall(String baseUrl, String part, int maxResults, String  id) throws NullPointerException {
        WebClient client = WebClient
                .builder()
                .baseUrl(URL + baseUrl)
                .build();

        Mono<String> response = client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("key", API_KEY)
                        .queryParam("part", part)
                        .queryParam("maxResults", maxResults)
                        .queryParam("id", id)
                        .build()
                )
                .exchangeToMono(res -> {
                    if (res.statusCode().is2xxSuccessful())
                        return res.bodyToMono(String.class);
                    else {
                        return res.bodyToMono(String.class).flatMap(body -> {
                            log.error("Fail to get Channel Infos");
                            return Mono.error(WebClientResponseException.create(res.statusCode().value(), body, null, null, null));
                        });
                    }
                });
        String results = response.block();

        return results;
    }
}

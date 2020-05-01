import org.jsoup.*;
import org.jsoup.nodes.*;

import java.io.IOException;

public class NaverTest {
    public static void main(String[] args) {
        String url = "https://datalab.naver.com/keyword/realtimeList.naver?entertainment=2&groupingLevel=0&marketing=2&news=2&sports=2";
        Document document = null;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(document.select("li.ranking_item span.item_title").toString());
        String[] rankList = document.select("li.ranking_item span.item_title").toString().split("<span class=\"item_title\">");
        int rank = -1;
        for (int i = 1; i < rankList.length; i++) {
            System.out.println(i + ". " + rankList[i].replace("\n", "").replace("</span>", ""));
        }
    }
}

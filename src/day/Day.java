package day;

import java.util.HashMap;
import java.util.Map;

public class Day {
    private Map<String, String> urls = new HashMap<>();

    public Day() {

    }

    public Day(Map<String, String> urls) {
        this.urls = urls;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public void put(String url, String html) {
        this.urls.put(url, html);
    }

    public void putAll(Map<String, String> urls) {
        this.urls.putAll(urls);
    }
}

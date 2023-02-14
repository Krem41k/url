package day;

import java.util.HashMap;
import java.util.Map;

public class Day {
    private Map<String, String> urls = new HashMap<>();

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public void putUrl(String url, String html) {
        this.urls.put(url, html);
    }

    public void putAllUrl(Map<String, String> urls) {
        this.urls.putAll(urls);
    }
}

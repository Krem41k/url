package day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day {
    private Map<String, String> urls = new HashMap<>();

    public Set<String> deletedPages(Day firstDay, Day secondDay) {
        if (firstDay == null || secondDay == null)
            return null;
        Set<String> firstDayUrls = firstDay.getUrls().keySet();
        Map<String, String> secondDayUrls = secondDay.getUrls();
        Set<String> deletedUrls = new HashSet<>();
        for (String s : firstDayUrls) {
            if (!secondDayUrls.containsKey(s))
                deletedUrls.add(s);
        }
        return deletedUrls;
    }

    public Set<String> createdPages(Day firstDay, Day secondDay) {
        if (firstDay == null || secondDay == null)
            return null;
        Set<String> secondDayUrls = secondDay.getUrls().keySet();
        Map<String, String> firstDayUrls = firstDay.getUrls();
        Set<String> createdUrls = new HashSet<>();
        for (String s : secondDayUrls) {
            if (!firstDayUrls.containsKey(s))
                createdUrls.add(s);
        }
        return createdUrls;
    }

    public Set<String>  changedPages(Day firstDay, Day secondDay){
        if (firstDay == null || secondDay == null)
            return null;
        Map<String, String>  secondDayUrls = secondDay.getUrls();
        Map<String, String> firstDayUrls = firstDay.getUrls();
        Set<String> changedUrls = new HashSet<>();

        for (String s : secondDayUrls.keySet()) {
            if (firstDayUrls.containsKey(s)) {
                if (!secondDayUrls.get(s).equals(firstDayUrls.get(s)))
                    changedUrls.add(s);
            }
        }
        return changedUrls;
    }

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

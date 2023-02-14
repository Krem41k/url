package page;

import day.Day;
import exception.MyException;
import utils.Validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PageWork {
    public static Set<String> deletedPages(Day firstDay, Day secondDay) throws MyException {
        if (!Validation.isValidDay(firstDay, secondDay))
            throw new MyException("Переменные дня имеют Null-ссылку");

        Map<String, String> firstDayUrls = firstDay.getUrls();
        Map<String, String> secondDayUrls = secondDay.getUrls();
        Set<String> deletedUrls = new HashSet<>();

        if (secondDayUrls.isEmpty() || firstDayUrls.isEmpty())
            throw new MyException("Отсутсвуют Urls или Pages");

        for (String s : firstDayUrls.keySet()) {
            if (!secondDayUrls.containsKey(s))
                deletedUrls.add(s);
        }
        return deletedUrls;
    }

    public static Set<String> createdPages(Day firstDay, Day secondDay) throws MyException {
        if (!Validation.isValidDay(firstDay, secondDay))
            throw new MyException("Переменные дня имеют Null-ссылку");

        Map<String, String> secondDayUrls = secondDay.getUrls();
        Map<String, String> firstDayUrls = firstDay.getUrls();
        Set<String> createdUrls = new HashSet<>();
        if (secondDayUrls.isEmpty() || firstDayUrls.isEmpty())
            throw new MyException("Отсутсвуют Urls или Pages");

        for (String s : secondDayUrls.keySet()) {
            if (!firstDayUrls.containsKey(s))
                createdUrls.add(s);
        }
        return createdUrls;
    }

    public static Set<String> changedPages(Day firstDay, Day secondDay) throws MyException {
        if (!Validation.isValidDay(firstDay, secondDay))
            throw new MyException("Переменные дня имеют Null-ссылку");

        Map<String, String> secondDayUrls = secondDay.getUrls();
        Map<String, String> firstDayUrls = firstDay.getUrls();
        Set<String> changedUrls = new HashSet<>();

        if (secondDayUrls.isEmpty() || firstDayUrls.isEmpty())
            throw new MyException("Отсутсвуют Urls или Pages");

        for (String s : secondDayUrls.keySet()) {
            if (firstDayUrls.containsKey(s)) {
                if (!secondDayUrls.get(s).equals(firstDayUrls.get(s)))
                    changedUrls.add(s);
            }
        }
        return changedUrls;
    }
}

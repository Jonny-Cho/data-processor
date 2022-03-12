package com.study.dataprocessor.util;

import java.io.IOException;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UrlConnector {

    public String getHtml(final String url) {
        try {
            return Jsoup.connect(url).get().html();
        } catch (IOException e) {
            throw new IllegalArgumentException("접근할 수 없는 url입니다.");
        }
    }

}

package com.beanstalk.core.transit;

import com.beanstalk.core.bigtable.entities.Identifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult implements Comparable<SearchResult> {

    private Double score;

    private String title;

    private String subTitle;

    private Identifier identifier;

    private String image;

    private String type;

    @Override
    public int compareTo(SearchResult o) {

        if (score == null || o.score == null) {
            return 0;
        }

        return o.score.compareTo(score);
    }
}

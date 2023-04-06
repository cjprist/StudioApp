package com.uncr.studioapp.domain.feed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyLikeDB {
    private Long boardID;
    private boolean myLike=false;
}

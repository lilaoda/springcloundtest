package com.lhy.mybatis1.vo;

import lombok.Data;

@Data
public class Tab {
    private String title;
    private String tabUrl;
    private String contentUrl;
    private boolean isH5;
    //1,装备扫描，2，签收，
    private int type;

    public Tab() {
    }

    public Tab(String title, String contentUrl, boolean isH5) {
        this.title = title;
        this.contentUrl = contentUrl;
        this.isH5 = isH5;
    }
}

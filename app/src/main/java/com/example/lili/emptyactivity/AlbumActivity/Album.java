package com.example.lili.emptyactivity.AlbumActivity;

import java.net.URL;

/**
 * Created by lili on 07/11/2017.
 */

public class Album {
    private String url;
    private String title;
    private String thumbnailUrl;

    public Album(String url, java.lang.String string) {
        this.url = url;
        this.title = string;
    }

    public String getUrl() {
        return url;
    }

    public String getTitre() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setTitre(String titre) {
        this.title = titre;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "url=" + url +
                ", titre='" + title + '\'' +
                '}';
    }
}

package com.saveapis.inventoryplugin.models;

public class GithubCommitGetDto {
    public String sha;
    public String url;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

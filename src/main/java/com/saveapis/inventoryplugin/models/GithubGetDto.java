package com.saveapis.inventoryplugin.models;

public class GithubGetDto {
    private String name;
    private String zipball_url;
    private String tarball_url;
    private GithubCommitGetDto commit;
    private String node_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipball_url() {
        return zipball_url;
    }

    public void setZipball_url(String zipball_url) {
        this.zipball_url = zipball_url;
    }

    public String getTarball_url() {
        return tarball_url;
    }

    public void setTarball_url(String tarball_url) {
        this.tarball_url = tarball_url;
    }

    public GithubCommitGetDto getCommit() {
        return commit;
    }

    public void setCommit(GithubCommitGetDto commit) {
        this.commit = commit;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}

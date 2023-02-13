package com.mb.dataiku.application.config;


public class DnAConfiguration {

    public static final String PREFIX = "github";
    public static final String DNA_URL = "https://dev.dna.app.corpintra.net";

    private String organization;
    private String repo;
    private String username;
    private String token;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
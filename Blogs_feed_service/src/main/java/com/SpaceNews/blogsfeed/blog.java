package com.SpaceNews.blogsfeed;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class blog {
    private int id;
    private String title;
    private String url;
    
    @JsonProperty("image_url")
    private String imageUrl;
    
    @JsonProperty("news_site")
    private String newsSite;
    
    private String summary;
    
    @JsonProperty("published_at")
    private String publishedAt;
    
    @JsonProperty("updated_at")
    private String updatedAt;
    
    private boolean featured;
    
    private List<Launch> launches;
    private List<Event> events;

    // Getters and setters

    public static class Launch {
        @JsonProperty("launch_id")
        private String launchId;
        
        private String provider;

        // Getters and setters

        public String getLaunchId() {
            return launchId;
        }

        public void setLaunchId(String launchId) {
            this.launchId = launchId;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }    
    }

    public static class Event {
        // Define fields according to the expected structure of events
        

        // Getters and setters
    }

    // Getters and setters for Blog fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Launch> getLaunches() {
        return launches;
    }

    public void setLaunches(List<Launch> launches) {
        this.launches = launches;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

package com.abn.gitlab.assignment.api.payload;


import com.fasterxml.jackson.annotation.JsonProperty;

/*Json builder for issues object (POJO class)
*
* */
public class Issues {
    @JsonProperty("project_id")
    private int projectId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("iid")
    private int iid;

    @JsonProperty("title")
    private String title;

    @JsonProperty("state")
    private String state;

    private Issues(int projectId, int id, String createdAt, int iid, String title, String state) {
        this.projectId = projectId;
        this.id = id;
        this.createdAt = createdAt;
        this.iid = iid;
        this.title = title;
        this.state = state;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getIid() {
        return iid;
    }

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public static class Builder{
        private int projectId, iid, id;
        private String createdAt,title,state;


        public Builder setProjectId(int projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setIid(int iid) {
            this.iid = iid;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Issues build() {
            return new Issues(projectId, id, createdAt, iid, title, state);
        }
    }
}
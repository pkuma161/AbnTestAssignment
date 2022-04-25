package com.abn.gitlab.assignment.api;

import com.abn.gitlab.assignment.api.payload.Issues;
import com.abn.gitlab.assignment.api.api.IssuesApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiTest {

    /*
    * method to test whether listIssues is working
    *
    * */
    @Test
    public void testGetIssuesReturns200() {
        Response response = IssuesApi.getIssues();

        assertThat(response.getStatusCode() == 200).isTrue();
    }

   @Test
    public void testPartialUpdateIssueWithTitleChange() {
        Issues payload = new Issues.Builder()
                .setId(106988699)
                .setIid(3)
                .setTitle("Test Case Updated10")
                .setProjectId(35550309)
                .setCreatedAt("2022-04-21T18:33:20.513Z")
                .setState("opened")
                .build();

        Response response = IssuesApi.updateIssue(payload,3);

        assertThat(response.getStatusCode() == 200).isTrue();
    }

   @Test
    public void testCreateIssueReturns201() {

       Issues payload = new Issues.Builder()
               .setId(0)
               .setIid(12)
               .setTitle("Test Case Created12")
               .setProjectId(35550309)
               .setCreatedAt("2022-04-22T18:33:20.513Z")
               .setState("opened")
               .build();

        Response response = IssuesApi.createIssue(payload);

        assertThat(response.getStatusCode() == 201).isTrue();
    }

    @Test
    public void testDeleteReturns204() {


        Response response = IssuesApi.deleteIssue(12);

        assertThat(response.getStatusCode() == 204).isTrue();
    }
}


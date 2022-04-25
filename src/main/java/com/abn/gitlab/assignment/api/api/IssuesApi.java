package com.abn.gitlab.assignment.api.api;

import com.abn.gitlab.assignment.api.payload.Issues;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class IssuesApi extends BaseApi {
    protected static final String ISSUES_ENDPOINT = BASE_ENDPOINT + "issues";
    protected static final String ISSUES_ENDPOINT_WITH_PROJECT = BASE_ENDPOINT + "projects/35550309/issues/";
    protected static final String TOKEN = "glpat-PuWYrxXXegNzxrsYoFyR";

/*
* Method to get the issues list
* */
    public static Response getIssues() {
        return given()
                .header("Authorization" , "Bearer "+TOKEN)
                .get(ISSUES_ENDPOINT);

    }
/*
* Method to create an issue
* */
    public static Response createIssue(Issues payload) {
        return given()
                .header("Authorization" , "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(ISSUES_ENDPOINT_WITH_PROJECT);
    }
    /*
     * Method to update the issue using payload and issue id
     * */
    public static Response updateIssue(Issues payload, int iid) {
        return given()
                .header("Authorization" , "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put( ISSUES_ENDPOINT_WITH_PROJECT+Integer.toString(iid));
    }
    /*
     * Method to delete the issue using issue id
     * */
    public static Response deleteIssue(int iid) {
        return given()
                .header("Authorization" , "Bearer "+TOKEN)
                .delete(ISSUES_ENDPOINT_WITH_PROJECT + Integer.toString(iid));
    }
}

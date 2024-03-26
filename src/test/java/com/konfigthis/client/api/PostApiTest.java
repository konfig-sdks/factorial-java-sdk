/*
 * Factorial API
 * Open Api Specifications available at [https://github.com/factorialco/oas](https://github.com/factorialco/oasLooking)  Guides and support available at [https://help.factorialhr.com/integrations](https://help.factorialhr.com/integrations)  # Authentication  The public API provides two methods of authentication, ApiKeys and OAuth2. The following sections provide information regarding each one and their intent.  ## OAuth2  > OAuth2 is used to identify individual users, not applications or platforms.  OAuth2 is available for authenticating to the public API and making requests via third parties **on behalf of a user**. All actions are authored on behalf of the user that creates the token. This means the intent is to be used mainly to do submit actions the actual user is performing on an alternative interface.  To generate a token you will require opening an authorization dialog that returns a code, this code can then be exchanged for a token.  ### Configuration  In order to create an OAuth application, you must be an admin, head over to your [personal repository of OAuth applications](https://api.factorialhr.com/oauth/applications), click on `New application` and follow the creation process.  The Factorial API enforces the same permissions at the user level than the Factorial web application. This means that Factorial API users will only be able to perform the same actions they are allowed to do in the Factorial platform.  Next step will be to generate the Authorization Code you will need in order to generate an OAuth2 Token.  ### OAuth2 Code Generation  Should be generated via browser by opening the following url. The user should be already logged in to Factorial beforehand.  `https://api.factorialhr.com/oauth/authorize?client_id=&redirect_uri=&response_type=code&scope=`  YOUR_CLIENT_ID: OAuth2 Application Id REDIRECT_URI: OAuth2 Redirect URL  #### State Parameter  An optional query parameter called `state` can be added to the code generation url. Any string can be used and will be sent on the callback url.  > Authorization protocols provide a `state` parameter that allows you to restore the previous state of your application. The `state` parameter preserves some state objects set by the client in the Authorization request and makes it available to the client in the response.  ### OAuth2 Token Generation  Once you have the authorization code, you can request their access token to Factorial.  `curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&code=&grant_type=authorization_code&redirect_uri='`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret AUTHORIZATION_CODE: OAuth2 CODE REDIRECT_URI: OAuth2 Redirect URL  > You can generate only one OAuth2 token per Code, that means that if you want to generate a new token for a Code that already have one you should refresh your token.  Every time a new token is generated a refresh token is generated as well, so that you can use it on the OAuth2 Refresh Token, and an expire date is also provided.  ### OAuth2 Refresh Token  You can generate a new token under the same Code with a new expire date (you can do it as many times as you need). A refresh token is also returned here so that you can use it on the OAuth2 Refresh Token again.  `curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&refresh_token=&grant_type=refresh_token'`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret REFRESH_TOKEN: OAuth2 Refresh Token  ### OAuth2 Revoke Token  You can revoke an access/refresh token if you do not want it to be active anylonger. This can happen in cases where you have refreshed your token and would like to revoke the previous token if you haven't used the new token yet, as using the new token automatically revokes the previous one.  `curl -X POST 'https://api.factorialhr.com/oauth/revoke' -d 'client_id=&client_secret=&token='`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret TOKEN: OAuth2 Access/Refresh Token (whichever you wish to revoke)  ### OAuth2 Token Usage  The generated token is the credential for performing authenticated requests to Factorial. This token should be included in the Authorization header prefixed with the word Bearer and a separating space. As an example, if your token is `12345` then the header content should be `Bearer 12345`.  ### Maintaining a persistent connection  To maintain a persistent connection, you should not let the token expire. You can avoid this by simply refreshing your token before the expiration date. This will give you another token with a new expiration date, before that token expires you should refresh it again, and so on... If you want to do this automatically, you should provide something in your code that will help you perform the update every time the token expires. Otherwise, you would have to do the update manually and make sure you refresh your token before the expiration date to maintain the connection.  ## ApiKeys  > API keys are used to identify systems, not the individual users that access.  ApiKeys have **TOTAL ACCESS** to everything and never expire. Its the creators responsibility to generate them and store them securely.  ### Generation  In the `Core>Keys` section of this documentation you can access the apis for managing this resource.  ### Usage  ApiKeys are a single string of symbols that must be added as a custom header on the request. The header name must be `x-api-key` and the key must be the value without any prefixes.  ### Disclaimer  ApiKey management require full admin permissions as the resource itself allows for full admin access to the entire platform on behalf of the company and not of a user, therefore any operations are not linked to any user in particular.  # Development  ## SDKs  Coming soon  ## Sandbox  A sandbox/demo environment is available for testing integrations via public API calls. Developers can request provisioning with full access to a demo company where to test code before actually interacting with a production environment.  Contact your account manager or account executive to request this environment and get OAuth2 credentials for generating tokens.  Note: the domain for sandbox is different than that from production. Sandbox base domain is `http://api.demo.factorialhr.com`  ## Postman  Click the \"Run in Postman\" button to open the full list of endpoints on your Postman workspace as a Postman Collection. Inside the collection lookout for the Collection's Variables, configure your variables accordingly.  ### Delegating Token Generation To Postman  Coming soon  # Changelog  Coming soon  # How to...  ## Custom Fields  Custom fields are useful when you want to add some fields that are not the default ones, to every employee of the company.  For that, you have to create via Factorial App the base custom field in order to have all the employees with it. That option is available in customization, inside the company menu  Once you have that, via API, you can [Create a value for a custom field](https://apidoc.factorialhr.com/#72f3f786-e37d-4e80-ada2-0beedd03b171) to each employee. You should know the custom field id in order to make that, you can check it by [getting a collection of custom fields](https://apidoc.factorialhr.com/#f98dae5a-a8d0-474e-a181-7e9603409b42)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.AtsJobPosting;
import java.io.File;
import com.konfigthis.client.model.Post;
import com.konfigthis.client.model.PostAtsJobPostingRequest;
import com.konfigthis.client.model.PostCreateNewPostRequest;
import com.konfigthis.client.model.PostJobPostingUpdateRequest;
import com.konfigthis.client.model.PostUpdateExistingPostRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PostApi
 */
@Disabled
public class PostApiTest {

    private static PostApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new PostApi(apiClient);
    }

    /**
     * Create a Job Posting
     *
     * This endpoint allows you create and store Ats Job Postings in Factorial.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void atsJobPostingTest() throws ApiException {
        String title = null;
        String status = null;
        String description = null;
        String contractType = null;
        Boolean remote = null;
        String scheduleType = null;
        Integer teamId = null;
        Integer locationId = null;
        String salaryFormat = null;
        Integer salaryFromAmountInCents = null;
        Integer salaryToAmountInCents = null;
        String cvRequirement = null;
        String coverLetterRequirement = null;
        String phoneRequirement = null;
        String photoRequirement = null;
        AtsJobPosting response = api.atsJobPosting(title, status)
                .description(description)
                .contractType(contractType)
                .remote(remote)
                .scheduleType(scheduleType)
                .teamId(teamId)
                .locationId(locationId)
                .salaryFormat(salaryFormat)
                .salaryFromAmountInCents(salaryFromAmountInCents)
                .salaryToAmountInCents(salaryToAmountInCents)
                .cvRequirement(cvRequirement)
                .coverLetterRequirement(coverLetterRequirement)
                .phoneRequirement(phoneRequirement)
                .photoRequirement(photoRequirement)
                .execute();
        // TODO: test validations
    }

    /**
     * Create a Post
     *
     * Create a Post
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createNewPostTest() throws ApiException {
        String title = null;
        String description = null;
        Integer postsGroupId = null;
        String type = null;
        String publishedAt = null;
        String starsAt = null;
        String endsAt = null;
        String location = null;
        Integer targetId = null;
        Boolean sendNotifications = null;
        File image = null;
        Boolean allowCommentsAndReactions = null;
        File attachments = null;
        List<Post> response = api.createNewPost(title, description, postsGroupId, type, publishedAt)
                .starsAt(starsAt)
                .endsAt(endsAt)
                .location(location)
                .targetId(targetId)
                .sendNotifications(sendNotifications)
                .image(image)
                .allowCommentsAndReactions(allowCommentsAndReactions)
                .attachments(attachments)
                .execute();
        // TODO: test validations
    }

    /**
     * Duplicate a Job Posting
     *
     * Make a duplicate of a job posting. The only parameter required for this operation is the id of the posting you wish to duplicate. One thing to note about this operation is that the id of the resulting posting will be different from the original, the title will have Copy appended to it, so if your origin title was Don&#39;t buy a the title of the duplicate will be Don&#39;t buy a Copy in addition to this, the status of the duplicate will default to draft. All this being said, kindly inspect the duplicate and ensure you get it into your desired state.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void duplicateJobPostingTest() throws ApiException {
        String id = null;
        AtsJobPosting response = api.duplicateJobPosting(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Get all job postings
     *
     * This endpoint allows fetching all available Ats Job Postings, scoped to the user credentials and company of that user.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllPostingsTest() throws ApiException {
        String status = null;
        Integer teamId = null;
        String locationId = null;
        Integer legalEntityId = null;
        List<AtsJobPosting> response = api.getAllPostings()
                .status(status)
                .teamId(teamId)
                .locationId(locationId)
                .legalEntityId(legalEntityId)
                .execute();
        // TODO: test validations
    }

    /**
     * Get Post
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getByIdTest() throws ApiException {
        String id = null;
        Post response = api.getById(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Update a Job Posting
     *
     * Update a Job Posting
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void jobPostingUpdateTest() throws ApiException {
        String id = null;
        String title = null;
        String description = null;
        String contractType = null;
        Boolean remote = null;
        String status = null;
        String scheduleType = null;
        Integer teamId = null;
        Integer locationId = null;
        String salaryFormat = null;
        Integer salaryFromAmountInCents = null;
        Integer salaryToAmountInCents = null;
        String cvRequirement = null;
        String coverLetterRequirement = null;
        String phoneRequirement = null;
        String photoRequirement = null;
        AtsJobPosting response = api.jobPostingUpdate(id)
                .title(title)
                .description(description)
                .contractType(contractType)
                .remote(remote)
                .status(status)
                .scheduleType(scheduleType)
                .teamId(teamId)
                .locationId(locationId)
                .salaryFormat(salaryFormat)
                .salaryFromAmountInCents(salaryFromAmountInCents)
                .salaryToAmountInCents(salaryToAmountInCents)
                .cvRequirement(cvRequirement)
                .coverLetterRequirement(coverLetterRequirement)
                .phoneRequirement(phoneRequirement)
                .photoRequirement(photoRequirement)
                .execute();
        // TODO: test validations
    }

    /**
     * Get Posts
     *
     * This endpoint allows you to fetch a collection of posts.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listPostsTest() throws ApiException {
        List<Post> response = api.listPosts()
                .execute();
        // TODO: test validations
    }

    /**
     * Delete a Job Posting
     *
     * Deletes an existing job posting
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void removeJobPostingTest() throws ApiException {
        String id = null;
        AtsJobPosting response = api.removeJobPosting(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Delete Post
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void removePostTest() throws ApiException {
        String id = null;
        Post response = api.removePost(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Create a Post
     *
     * Create a Post
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateExistingPostTest() throws ApiException {
        Integer id = null;
        String id = null;
        String title = null;
        String description = null;
        String starsAt = null;
        String location = null;
        Boolean sendNotifications = null;
        Boolean deleteCoverImage = null;
        File image = null;
        Boolean allowCommentsAndReactions = null;
        File attachments = null;
        List<Integer> deletedAttachments = null;
        List<Post> response = api.updateExistingPost(id, id)
                .title(title)
                .description(description)
                .starsAt(starsAt)
                .location(location)
                .sendNotifications(sendNotifications)
                .deleteCoverImage(deleteCoverImage)
                .image(image)
                .allowCommentsAndReactions(allowCommentsAndReactions)
                .attachments(attachments)
                .deletedAttachments(deletedAttachments)
                .execute();
        // TODO: test validations
    }

}

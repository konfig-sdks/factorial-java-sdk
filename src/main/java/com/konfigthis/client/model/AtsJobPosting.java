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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.konfigthis.client.model.AtsQuestion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * AtsJobPosting
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class AtsJobPosting {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_CREATION_DATE = "creation_date";
  @SerializedName(SERIALIZED_NAME_CREATION_DATE)
  private String creationDate;

  public static final String SERIALIZED_NAME_REMOTE = "remote";
  @SerializedName(SERIALIZED_NAME_REMOTE)
  private Boolean remote;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_SCHEDULE_TYPE = "schedule_type";
  @SerializedName(SERIALIZED_NAME_SCHEDULE_TYPE)
  private String scheduleType;

  public static final String SERIALIZED_NAME_TEAM_ID = "team_id";
  @SerializedName(SERIALIZED_NAME_TEAM_ID)
  private Integer teamId;

  public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
  @SerializedName(SERIALIZED_NAME_LOCATION_ID)
  private Integer locationId;

  public static final String SERIALIZED_NAME_LEGAL_ENTITY_ID = "legal_entity_id";
  @SerializedName(SERIALIZED_NAME_LEGAL_ENTITY_ID)
  private Integer legalEntityId;

  public static final String SERIALIZED_NAME_ATS_COMPANY_ID = "ats_company_id";
  @SerializedName(SERIALIZED_NAME_ATS_COMPANY_ID)
  private Integer atsCompanyId;

  public static final String SERIALIZED_NAME_SALARY_FORMAT = "salary_format";
  @SerializedName(SERIALIZED_NAME_SALARY_FORMAT)
  private String salaryFormat;

  public static final String SERIALIZED_NAME_SALARY_FROM_AMOUNT_IN_CENTS = "salary_from_amount_in_cents";
  @SerializedName(SERIALIZED_NAME_SALARY_FROM_AMOUNT_IN_CENTS)
  private Integer salaryFromAmountInCents;

  public static final String SERIALIZED_NAME_SALARY_TO_AMOUNT_IN_CENTS = "salary_to_amount_in_cents";
  @SerializedName(SERIALIZED_NAME_SALARY_TO_AMOUNT_IN_CENTS)
  private Integer salaryToAmountInCents;

  public static final String SERIALIZED_NAME_CV_REQUIREMENT = "cv_requirement";
  @SerializedName(SERIALIZED_NAME_CV_REQUIREMENT)
  private String cvRequirement;

  public static final String SERIALIZED_NAME_COVER_LETTER_REQUIREMENT = "cover_letter_requirement";
  @SerializedName(SERIALIZED_NAME_COVER_LETTER_REQUIREMENT)
  private String coverLetterRequirement;

  public static final String SERIALIZED_NAME_PHONE_REQUIREMENT = "phone_requirement";
  @SerializedName(SERIALIZED_NAME_PHONE_REQUIREMENT)
  private String phoneRequirement;

  public static final String SERIALIZED_NAME_PHOTO_REQUIREMENT = "photo_requirement";
  @SerializedName(SERIALIZED_NAME_PHOTO_REQUIREMENT)
  private String photoRequirement;

  public static final String SERIALIZED_NAME_QUESTIONS = "questions";
  @SerializedName(SERIALIZED_NAME_QUESTIONS)
  private List<AtsQuestion> questions = null;

  public AtsJobPosting() {
  }

  public AtsJobPosting title(String title) {
    
    
    
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "A wonderful job ", value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    
    
    
    this.title = title;
  }


  public AtsJobPosting description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "The most wonderful job in the whoooole world", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public AtsJobPosting id(Integer id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    
    
    
    this.id = id;
  }


  public AtsJobPosting creationDate(String creationDate) {
    
    
    
    
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-24T18:39:03.515Z", value = "")

  public String getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(String creationDate) {
    
    
    
    this.creationDate = creationDate;
  }


  public AtsJobPosting remote(Boolean remote) {
    
    
    
    
    this.remote = remote;
    return this;
  }

   /**
   * Get remote
   * @return remote
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getRemote() {
    return remote;
  }


  public void setRemote(Boolean remote) {
    
    
    
    this.remote = remote;
  }


  public AtsJobPosting status(String status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "published", value = "")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    
    
    
    this.status = status;
  }


  public AtsJobPosting scheduleType(String scheduleType) {
    
    
    
    
    this.scheduleType = scheduleType;
    return this;
  }

   /**
   * Get scheduleType
   * @return scheduleType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "full_time", value = "")

  public String getScheduleType() {
    return scheduleType;
  }


  public void setScheduleType(String scheduleType) {
    
    
    
    this.scheduleType = scheduleType;
  }


  public AtsJobPosting teamId(Integer teamId) {
    
    
    
    
    this.teamId = teamId;
    return this;
  }

   /**
   * Get teamId
   * @return teamId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getTeamId() {
    return teamId;
  }


  public void setTeamId(Integer teamId) {
    
    
    
    this.teamId = teamId;
  }


  public AtsJobPosting locationId(Integer locationId) {
    
    
    
    
    this.locationId = locationId;
    return this;
  }

   /**
   * Get locationId
   * @return locationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getLocationId() {
    return locationId;
  }


  public void setLocationId(Integer locationId) {
    
    
    
    this.locationId = locationId;
  }


  public AtsJobPosting legalEntityId(Integer legalEntityId) {
    
    
    
    
    this.legalEntityId = legalEntityId;
    return this;
  }

   /**
   * Get legalEntityId
   * @return legalEntityId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getLegalEntityId() {
    return legalEntityId;
  }


  public void setLegalEntityId(Integer legalEntityId) {
    
    
    
    this.legalEntityId = legalEntityId;
  }


  public AtsJobPosting atsCompanyId(Integer atsCompanyId) {
    
    
    
    
    this.atsCompanyId = atsCompanyId;
    return this;
  }

   /**
   * Get atsCompanyId
   * @return atsCompanyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getAtsCompanyId() {
    return atsCompanyId;
  }


  public void setAtsCompanyId(Integer atsCompanyId) {
    
    
    
    this.atsCompanyId = atsCompanyId;
  }


  public AtsJobPosting salaryFormat(String salaryFormat) {
    
    
    
    
    this.salaryFormat = salaryFormat;
    return this;
  }

   /**
   * Get salaryFormat
   * @return salaryFormat
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "fixed_amount", value = "")

  public String getSalaryFormat() {
    return salaryFormat;
  }


  public void setSalaryFormat(String salaryFormat) {
    
    
    
    this.salaryFormat = salaryFormat;
  }


  public AtsJobPosting salaryFromAmountInCents(Integer salaryFromAmountInCents) {
    
    
    
    
    this.salaryFromAmountInCents = salaryFromAmountInCents;
    return this;
  }

   /**
   * Get salaryFromAmountInCents
   * @return salaryFromAmountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "600000", value = "")

  public Integer getSalaryFromAmountInCents() {
    return salaryFromAmountInCents;
  }


  public void setSalaryFromAmountInCents(Integer salaryFromAmountInCents) {
    
    
    
    this.salaryFromAmountInCents = salaryFromAmountInCents;
  }


  public AtsJobPosting salaryToAmountInCents(Integer salaryToAmountInCents) {
    
    
    
    
    this.salaryToAmountInCents = salaryToAmountInCents;
    return this;
  }

   /**
   * Get salaryToAmountInCents
   * @return salaryToAmountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "600000", value = "")

  public Integer getSalaryToAmountInCents() {
    return salaryToAmountInCents;
  }


  public void setSalaryToAmountInCents(Integer salaryToAmountInCents) {
    
    
    
    this.salaryToAmountInCents = salaryToAmountInCents;
  }


  public AtsJobPosting cvRequirement(String cvRequirement) {
    
    
    
    
    this.cvRequirement = cvRequirement;
    return this;
  }

   /**
   * Get cvRequirement
   * @return cvRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mandatory", value = "")

  public String getCvRequirement() {
    return cvRequirement;
  }


  public void setCvRequirement(String cvRequirement) {
    
    
    
    this.cvRequirement = cvRequirement;
  }


  public AtsJobPosting coverLetterRequirement(String coverLetterRequirement) {
    
    
    
    
    this.coverLetterRequirement = coverLetterRequirement;
    return this;
  }

   /**
   * Get coverLetterRequirement
   * @return coverLetterRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mandatory", value = "")

  public String getCoverLetterRequirement() {
    return coverLetterRequirement;
  }


  public void setCoverLetterRequirement(String coverLetterRequirement) {
    
    
    
    this.coverLetterRequirement = coverLetterRequirement;
  }


  public AtsJobPosting phoneRequirement(String phoneRequirement) {
    
    
    
    
    this.phoneRequirement = phoneRequirement;
    return this;
  }

   /**
   * Get phoneRequirement
   * @return phoneRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mandatory", value = "")

  public String getPhoneRequirement() {
    return phoneRequirement;
  }


  public void setPhoneRequirement(String phoneRequirement) {
    
    
    
    this.phoneRequirement = phoneRequirement;
  }


  public AtsJobPosting photoRequirement(String photoRequirement) {
    
    
    
    
    this.photoRequirement = photoRequirement;
    return this;
  }

   /**
   * Get photoRequirement
   * @return photoRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mandatory", value = "")

  public String getPhotoRequirement() {
    return photoRequirement;
  }


  public void setPhotoRequirement(String photoRequirement) {
    
    
    
    this.photoRequirement = photoRequirement;
  }


  public AtsJobPosting questions(List<AtsQuestion> questions) {
    
    
    
    
    this.questions = questions;
    return this;
  }

  public AtsJobPosting addQuestionsItem(AtsQuestion questionsItem) {
    if (this.questions == null) {
      this.questions = new ArrayList<>();
    }
    this.questions.add(questionsItem);
    return this;
  }

   /**
   * Get questions
   * @return questions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[{\"id\":1,\"label\":\"Why do you want to work with us?\",\"position\":0,\"mandatory\":true,\"question_type\":\"long_text\",\"ats_job_posting_id\":1,\"created_at\":\"2022-06-24T18:39:03.515Z\",\"updated_at\":\"2022-06-24T18:39:03.515Z\"},{\"id\":2,\"label\":\"Linkedin profile url\",\"position\":1,\"mandatory\":true,\"question_type\":\"text\",\"ats_job_posting_id\":1,\"created_at\":\"2022-06-24T18:39:03.515Z\",\"updated_at\":\"2022-06-24T18:39:03.515Z\"},{\"id\":3,\"label\":\"Are you willing yo relocate?\",\"position\":0,\"mandatory\":true,\"question_type\":\"single_choice\",\"options\":[true,false],\"ats_job_posting_id\":1,\"created_at\":\"2022-06-24T18:39:03.515Z\",\"updated_at\":\"2022-06-24T18:39:03.515Z\"},{\"id\":4,\"label\":\"Which office do you prefer?\",\"position\":0,\"mandatory\":false,\"question_type\":\"multiple_choice\",\"options\":[\"Barcelona\",\"Madrid\",\"Amsterdam\"],\"ats_job_posting_id\":1,\"created_at\":\"2022-06-24T18:39:03.515Z\",\"updated_at\":\"2022-06-24T18:39:03.515Z\"},{\"id\":5,\"label\":\"Attach your language certificate\",\"position\":0,\"mandatory\":false,\"question_type\":\"file\",\"ats_job_posting_id\":1,\"created_at\":\"2022-06-24T18:39:03.515Z\",\"updated_at\":\"2022-06-24T18:39:03.515Z\"}]", value = "")

  public List<AtsQuestion> getQuestions() {
    return questions;
  }


  public void setQuestions(List<AtsQuestion> questions) {
    
    
    
    this.questions = questions;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the AtsJobPosting instance itself
   */
  public AtsJobPosting putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AtsJobPosting atsJobPosting = (AtsJobPosting) o;
    return Objects.equals(this.title, atsJobPosting.title) &&
        Objects.equals(this.description, atsJobPosting.description) &&
        Objects.equals(this.id, atsJobPosting.id) &&
        Objects.equals(this.creationDate, atsJobPosting.creationDate) &&
        Objects.equals(this.remote, atsJobPosting.remote) &&
        Objects.equals(this.status, atsJobPosting.status) &&
        Objects.equals(this.scheduleType, atsJobPosting.scheduleType) &&
        Objects.equals(this.teamId, atsJobPosting.teamId) &&
        Objects.equals(this.locationId, atsJobPosting.locationId) &&
        Objects.equals(this.legalEntityId, atsJobPosting.legalEntityId) &&
        Objects.equals(this.atsCompanyId, atsJobPosting.atsCompanyId) &&
        Objects.equals(this.salaryFormat, atsJobPosting.salaryFormat) &&
        Objects.equals(this.salaryFromAmountInCents, atsJobPosting.salaryFromAmountInCents) &&
        Objects.equals(this.salaryToAmountInCents, atsJobPosting.salaryToAmountInCents) &&
        Objects.equals(this.cvRequirement, atsJobPosting.cvRequirement) &&
        Objects.equals(this.coverLetterRequirement, atsJobPosting.coverLetterRequirement) &&
        Objects.equals(this.phoneRequirement, atsJobPosting.phoneRequirement) &&
        Objects.equals(this.photoRequirement, atsJobPosting.photoRequirement) &&
        Objects.equals(this.questions, atsJobPosting.questions)&&
        Objects.equals(this.additionalProperties, atsJobPosting.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, id, creationDate, remote, status, scheduleType, teamId, locationId, legalEntityId, atsCompanyId, salaryFormat, salaryFromAmountInCents, salaryToAmountInCents, cvRequirement, coverLetterRequirement, phoneRequirement, photoRequirement, questions, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AtsJobPosting {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    remote: ").append(toIndentedString(remote)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    scheduleType: ").append(toIndentedString(scheduleType)).append("\n");
    sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    legalEntityId: ").append(toIndentedString(legalEntityId)).append("\n");
    sb.append("    atsCompanyId: ").append(toIndentedString(atsCompanyId)).append("\n");
    sb.append("    salaryFormat: ").append(toIndentedString(salaryFormat)).append("\n");
    sb.append("    salaryFromAmountInCents: ").append(toIndentedString(salaryFromAmountInCents)).append("\n");
    sb.append("    salaryToAmountInCents: ").append(toIndentedString(salaryToAmountInCents)).append("\n");
    sb.append("    cvRequirement: ").append(toIndentedString(cvRequirement)).append("\n");
    sb.append("    coverLetterRequirement: ").append(toIndentedString(coverLetterRequirement)).append("\n");
    sb.append("    phoneRequirement: ").append(toIndentedString(phoneRequirement)).append("\n");
    sb.append("    photoRequirement: ").append(toIndentedString(photoRequirement)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("title");
    openapiFields.add("description");
    openapiFields.add("id");
    openapiFields.add("creation_date");
    openapiFields.add("remote");
    openapiFields.add("status");
    openapiFields.add("schedule_type");
    openapiFields.add("team_id");
    openapiFields.add("location_id");
    openapiFields.add("legal_entity_id");
    openapiFields.add("ats_company_id");
    openapiFields.add("salary_format");
    openapiFields.add("salary_from_amount_in_cents");
    openapiFields.add("salary_to_amount_in_cents");
    openapiFields.add("cv_requirement");
    openapiFields.add("cover_letter_requirement");
    openapiFields.add("phone_requirement");
    openapiFields.add("photo_requirement");
    openapiFields.add("questions");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to AtsJobPosting
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!AtsJobPosting.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AtsJobPosting is not found in the empty JSON string", AtsJobPosting.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("creation_date") != null && !jsonObj.get("creation_date").isJsonNull()) && !jsonObj.get("creation_date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creation_date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creation_date").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("schedule_type") != null && !jsonObj.get("schedule_type").isJsonNull()) && !jsonObj.get("schedule_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `schedule_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("schedule_type").toString()));
      }
      if ((jsonObj.get("salary_format") != null && !jsonObj.get("salary_format").isJsonNull()) && !jsonObj.get("salary_format").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `salary_format` to be a primitive type in the JSON string but got `%s`", jsonObj.get("salary_format").toString()));
      }
      if ((jsonObj.get("cv_requirement") != null && !jsonObj.get("cv_requirement").isJsonNull()) && !jsonObj.get("cv_requirement").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cv_requirement` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cv_requirement").toString()));
      }
      if ((jsonObj.get("cover_letter_requirement") != null && !jsonObj.get("cover_letter_requirement").isJsonNull()) && !jsonObj.get("cover_letter_requirement").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cover_letter_requirement` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cover_letter_requirement").toString()));
      }
      if ((jsonObj.get("phone_requirement") != null && !jsonObj.get("phone_requirement").isJsonNull()) && !jsonObj.get("phone_requirement").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone_requirement` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phone_requirement").toString()));
      }
      if ((jsonObj.get("photo_requirement") != null && !jsonObj.get("photo_requirement").isJsonNull()) && !jsonObj.get("photo_requirement").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `photo_requirement` to be a primitive type in the JSON string but got `%s`", jsonObj.get("photo_requirement").toString()));
      }
      if (jsonObj.get("questions") != null && !jsonObj.get("questions").isJsonNull()) {
        JsonArray jsonArrayquestions = jsonObj.getAsJsonArray("questions");
        if (jsonArrayquestions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("questions").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `questions` to be an array in the JSON string but got `%s`", jsonObj.get("questions").toString()));
          }

          // validate the optional field `questions` (array)
          for (int i = 0; i < jsonArrayquestions.size(); i++) {
            AtsQuestion.validateJsonObject(jsonArrayquestions.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AtsJobPosting.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AtsJobPosting' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AtsJobPosting> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AtsJobPosting.class));

       return (TypeAdapter<T>) new TypeAdapter<AtsJobPosting>() {
           @Override
           public void write(JsonWriter out, AtsJobPosting value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public AtsJobPosting read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             AtsJobPosting instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of AtsJobPosting given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of AtsJobPosting
  * @throws IOException if the JSON string is invalid with respect to AtsJobPosting
  */
  public static AtsJobPosting fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AtsJobPosting.class);
  }

 /**
  * Convert an instance of AtsJobPosting to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


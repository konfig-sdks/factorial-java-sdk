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
import com.konfigthis.client.model.AtsAnswer;
import com.konfigthis.client.model.AtsApplicationCv;
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
 * AtsApplication
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class AtsApplication {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_ATS_CANDIDATE_ID = "ats_candidate_id";
  @SerializedName(SERIALIZED_NAME_ATS_CANDIDATE_ID)
  private Integer atsCandidateId;

  public static final String SERIALIZED_NAME_ATS_JOB_POSTING_ID = "ats_job_posting_id";
  @SerializedName(SERIALIZED_NAME_ATS_JOB_POSTING_ID)
  private Integer atsJobPostingId;

  public static final String SERIALIZED_NAME_ATS_APPLICATION_PHASE_ID = "ats_application_phase_id";
  @SerializedName(SERIALIZED_NAME_ATS_APPLICATION_PHASE_ID)
  private Integer atsApplicationPhaseId;

  public static final String SERIALIZED_NAME_ATS_APPLICATION_PHASE_NAME = "ats_application_phase_name";
  @SerializedName(SERIALIZED_NAME_ATS_APPLICATION_PHASE_NAME)
  private String atsApplicationPhaseName;

  public static final String SERIALIZED_NAME_ATS_APPLICATION_PHASE_TYPE = "ats_application_phase_type";
  @SerializedName(SERIALIZED_NAME_ATS_APPLICATION_PHASE_TYPE)
  private String atsApplicationPhaseType;

  public static final String SERIALIZED_NAME_ATS_JOB_POSTING_TITLE = "ats_job_posting_title";
  @SerializedName(SERIALIZED_NAME_ATS_JOB_POSTING_TITLE)
  private String atsJobPostingTitle;

  public static final String SERIALIZED_NAME_CONVERSATION_ID = "conversation_id";
  @SerializedName(SERIALIZED_NAME_CONVERSATION_ID)
  private Integer conversationId;

  public static final String SERIALIZED_NAME_COVER_LETTER = "cover_letter";
  @SerializedName(SERIALIZED_NAME_COVER_LETTER)
  private String coverLetter;

  public static final String SERIALIZED_NAME_CV = "cv";
  @SerializedName(SERIALIZED_NAME_CV)
  private AtsApplicationCv cv;

  public static final String SERIALIZED_NAME_PHOTO = "photo";
  @SerializedName(SERIALIZED_NAME_PHOTO)
  private String photo;

  public static final String SERIALIZED_NAME_DISQUALIFIED_REASON = "disqualified_reason";
  @SerializedName(SERIALIZED_NAME_DISQUALIFIED_REASON)
  private String disqualifiedReason;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_FULL_NAME = "full_name";
  @SerializedName(SERIALIZED_NAME_FULL_NAME)
  private String fullName;

  public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_MEDIUM = "medium";
  @SerializedName(SERIALIZED_NAME_MEDIUM)
  private String medium;

  public static final String SERIALIZED_NAME_PERSONAL_URL = "personal_url";
  @SerializedName(SERIALIZED_NAME_PERSONAL_URL)
  private String personalUrl;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;

  public static final String SERIALIZED_NAME_QUALIFIED = "qualified";
  @SerializedName(SERIALIZED_NAME_QUALIFIED)
  private Boolean qualified;

  public static final String SERIALIZED_NAME_RATING_AVERAGE = "rating_average";
  @SerializedName(SERIALIZED_NAME_RATING_AVERAGE)
  private Integer ratingAverage;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private String source;

  public static final String SERIALIZED_NAME_TALENT_POOL = "talent_pool";
  @SerializedName(SERIALIZED_NAME_TALENT_POOL)
  private Boolean talentPool;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_ANSWERS = "answers";
  @SerializedName(SERIALIZED_NAME_ANSWERS)
  private List<AtsAnswer> answers = null;

  public AtsApplication() {
  }

  public AtsApplication id(Integer id) {
    
    
    
    
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


  public AtsApplication atsCandidateId(Integer atsCandidateId) {
    
    
    
    
    this.atsCandidateId = atsCandidateId;
    return this;
  }

   /**
   * Get atsCandidateId
   * @return atsCandidateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getAtsCandidateId() {
    return atsCandidateId;
  }


  public void setAtsCandidateId(Integer atsCandidateId) {
    
    
    
    this.atsCandidateId = atsCandidateId;
  }


  public AtsApplication atsJobPostingId(Integer atsJobPostingId) {
    
    
    
    
    this.atsJobPostingId = atsJobPostingId;
    return this;
  }

   /**
   * Get atsJobPostingId
   * @return atsJobPostingId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getAtsJobPostingId() {
    return atsJobPostingId;
  }


  public void setAtsJobPostingId(Integer atsJobPostingId) {
    
    
    
    this.atsJobPostingId = atsJobPostingId;
  }


  public AtsApplication atsApplicationPhaseId(Integer atsApplicationPhaseId) {
    
    
    
    
    this.atsApplicationPhaseId = atsApplicationPhaseId;
    return this;
  }

   /**
   * Get atsApplicationPhaseId
   * @return atsApplicationPhaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getAtsApplicationPhaseId() {
    return atsApplicationPhaseId;
  }


  public void setAtsApplicationPhaseId(Integer atsApplicationPhaseId) {
    
    
    
    this.atsApplicationPhaseId = atsApplicationPhaseId;
  }


  public AtsApplication atsApplicationPhaseName(String atsApplicationPhaseName) {
    
    
    
    
    this.atsApplicationPhaseName = atsApplicationPhaseName;
    return this;
  }

   /**
   * Get atsApplicationPhaseName
   * @return atsApplicationPhaseName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Hired", value = "")

  public String getAtsApplicationPhaseName() {
    return atsApplicationPhaseName;
  }


  public void setAtsApplicationPhaseName(String atsApplicationPhaseName) {
    
    
    
    this.atsApplicationPhaseName = atsApplicationPhaseName;
  }


  public AtsApplication atsApplicationPhaseType(String atsApplicationPhaseType) {
    
    
    
    
    this.atsApplicationPhaseType = atsApplicationPhaseType;
    return this;
  }

   /**
   * Get atsApplicationPhaseType
   * @return atsApplicationPhaseType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "hired", value = "")

  public String getAtsApplicationPhaseType() {
    return atsApplicationPhaseType;
  }


  public void setAtsApplicationPhaseType(String atsApplicationPhaseType) {
    
    
    
    this.atsApplicationPhaseType = atsApplicationPhaseType;
  }


  public AtsApplication atsJobPostingTitle(String atsJobPostingTitle) {
    
    
    
    
    this.atsJobPostingTitle = atsJobPostingTitle;
    return this;
  }

   /**
   * Get atsJobPostingTitle
   * @return atsJobPostingTitle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Software Engineer", value = "")

  public String getAtsJobPostingTitle() {
    return atsJobPostingTitle;
  }


  public void setAtsJobPostingTitle(String atsJobPostingTitle) {
    
    
    
    this.atsJobPostingTitle = atsJobPostingTitle;
  }


  public AtsApplication conversationId(Integer conversationId) {
    
    
    
    
    this.conversationId = conversationId;
    return this;
  }

   /**
   * Get conversationId
   * @return conversationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getConversationId() {
    return conversationId;
  }


  public void setConversationId(Integer conversationId) {
    
    
    
    this.conversationId = conversationId;
  }


  public AtsApplication coverLetter(String coverLetter) {
    
    
    
    
    this.coverLetter = coverLetter;
    return this;
  }

   /**
   * Get coverLetter
   * @return coverLetter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "This is a cover letter", value = "")

  public String getCoverLetter() {
    return coverLetter;
  }


  public void setCoverLetter(String coverLetter) {
    
    
    
    this.coverLetter = coverLetter;
  }


  public AtsApplication cv(AtsApplicationCv cv) {
    
    
    
    
    this.cv = cv;
    return this;
  }

   /**
   * Get cv
   * @return cv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AtsApplicationCv getCv() {
    return cv;
  }


  public void setCv(AtsApplicationCv cv) {
    
    
    
    this.cv = cv;
  }


  public AtsApplication photo(String photo) {
    
    
    
    
    this.photo = photo;
    return this;
  }

   /**
   * Get photo
   * @return photo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "photo.jpeg", value = "")

  public String getPhoto() {
    return photo;
  }


  public void setPhoto(String photo) {
    
    
    
    this.photo = photo;
  }


  public AtsApplication disqualifiedReason(String disqualifiedReason) {
    
    
    
    
    this.disqualifiedReason = disqualifiedReason;
    return this;
  }

   /**
   * Get disqualifiedReason
   * @return disqualifiedReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "not_a_fit", value = "")

  public String getDisqualifiedReason() {
    return disqualifiedReason;
  }


  public void setDisqualifiedReason(String disqualifiedReason) {
    
    
    
    this.disqualifiedReason = disqualifiedReason;
  }


  public AtsApplication email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "bob.stone@factorial.co", value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public AtsApplication firstName(String firstName) {
    
    
    
    
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Bob", value = "")

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    
    
    
    this.firstName = firstName;
  }


  public AtsApplication fullName(String fullName) {
    
    
    
    
    this.fullName = fullName;
    return this;
  }

   /**
   * Get fullName
   * @return fullName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Bob Stone", value = "")

  public String getFullName() {
    return fullName;
  }


  public void setFullName(String fullName) {
    
    
    
    this.fullName = fullName;
  }


  public AtsApplication lastName(String lastName) {
    
    
    
    
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Stone", value = "")

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    
    
    
    this.lastName = lastName;
  }


  public AtsApplication medium(String medium) {
    
    
    
    
    this.medium = medium;
    return this;
  }

   /**
   * Get medium
   * @return medium
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "organic", value = "")

  public String getMedium() {
    return medium;
  }


  public void setMedium(String medium) {
    
    
    
    this.medium = medium;
  }


  public AtsApplication personalUrl(String personalUrl) {
    
    
    
    
    this.personalUrl = personalUrl;
    return this;
  }

   /**
   * Get personalUrl
   * @return personalUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "www.linkedin.com/awesome", value = "")

  public String getPersonalUrl() {
    return personalUrl;
  }


  public void setPersonalUrl(String personalUrl) {
    
    
    
    this.personalUrl = personalUrl;
  }


  public AtsApplication phone(String phone) {
    
    
    
    
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "666666666", value = "")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    
    
    
    this.phone = phone;
  }


  public AtsApplication qualified(Boolean qualified) {
    
    
    
    
    this.qualified = qualified;
    return this;
  }

   /**
   * Get qualified
   * @return qualified
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getQualified() {
    return qualified;
  }


  public void setQualified(Boolean qualified) {
    
    
    
    this.qualified = qualified;
  }


  public AtsApplication ratingAverage(Integer ratingAverage) {
    
    
    
    
    this.ratingAverage = ratingAverage;
    return this;
  }

   /**
   * Get ratingAverage
   * @return ratingAverage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getRatingAverage() {
    return ratingAverage;
  }


  public void setRatingAverage(Integer ratingAverage) {
    
    
    
    this.ratingAverage = ratingAverage;
  }


  public AtsApplication source(String source) {
    
    
    
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "manually_added", value = "")

  public String getSource() {
    return source;
  }


  public void setSource(String source) {
    
    
    
    this.source = source;
  }


  public AtsApplication talentPool(Boolean talentPool) {
    
    
    
    
    this.talentPool = talentPool;
    return this;
  }

   /**
   * Get talentPool
   * @return talentPool
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getTalentPool() {
    return talentPool;
  }


  public void setTalentPool(Boolean talentPool) {
    
    
    
    this.talentPool = talentPool;
  }


  public AtsApplication createdAt(String createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-24T18:39:03.515Z", value = "")

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public AtsApplication answers(List<AtsAnswer> answers) {
    
    
    
    
    this.answers = answers;
    return this;
  }

  public AtsApplication addAnswersItem(AtsAnswer answersItem) {
    if (this.answers == null) {
      this.answers = new ArrayList<>();
    }
    this.answers.add(answersItem);
    return this;
  }

   /**
   * Get answers
   * @return answers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<AtsAnswer> getAnswers() {
    return answers;
  }


  public void setAnswers(List<AtsAnswer> answers) {
    
    
    
    this.answers = answers;
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
   * @return the AtsApplication instance itself
   */
  public AtsApplication putAdditionalProperty(String key, Object value) {
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
    AtsApplication atsApplication = (AtsApplication) o;
    return Objects.equals(this.id, atsApplication.id) &&
        Objects.equals(this.atsCandidateId, atsApplication.atsCandidateId) &&
        Objects.equals(this.atsJobPostingId, atsApplication.atsJobPostingId) &&
        Objects.equals(this.atsApplicationPhaseId, atsApplication.atsApplicationPhaseId) &&
        Objects.equals(this.atsApplicationPhaseName, atsApplication.atsApplicationPhaseName) &&
        Objects.equals(this.atsApplicationPhaseType, atsApplication.atsApplicationPhaseType) &&
        Objects.equals(this.atsJobPostingTitle, atsApplication.atsJobPostingTitle) &&
        Objects.equals(this.conversationId, atsApplication.conversationId) &&
        Objects.equals(this.coverLetter, atsApplication.coverLetter) &&
        Objects.equals(this.cv, atsApplication.cv) &&
        Objects.equals(this.photo, atsApplication.photo) &&
        Objects.equals(this.disqualifiedReason, atsApplication.disqualifiedReason) &&
        Objects.equals(this.email, atsApplication.email) &&
        Objects.equals(this.firstName, atsApplication.firstName) &&
        Objects.equals(this.fullName, atsApplication.fullName) &&
        Objects.equals(this.lastName, atsApplication.lastName) &&
        Objects.equals(this.medium, atsApplication.medium) &&
        Objects.equals(this.personalUrl, atsApplication.personalUrl) &&
        Objects.equals(this.phone, atsApplication.phone) &&
        Objects.equals(this.qualified, atsApplication.qualified) &&
        Objects.equals(this.ratingAverage, atsApplication.ratingAverage) &&
        Objects.equals(this.source, atsApplication.source) &&
        Objects.equals(this.talentPool, atsApplication.talentPool) &&
        Objects.equals(this.createdAt, atsApplication.createdAt) &&
        Objects.equals(this.answers, atsApplication.answers)&&
        Objects.equals(this.additionalProperties, atsApplication.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, atsCandidateId, atsJobPostingId, atsApplicationPhaseId, atsApplicationPhaseName, atsApplicationPhaseType, atsJobPostingTitle, conversationId, coverLetter, cv, photo, disqualifiedReason, email, firstName, fullName, lastName, medium, personalUrl, phone, qualified, ratingAverage, source, talentPool, createdAt, answers, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AtsApplication {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    atsCandidateId: ").append(toIndentedString(atsCandidateId)).append("\n");
    sb.append("    atsJobPostingId: ").append(toIndentedString(atsJobPostingId)).append("\n");
    sb.append("    atsApplicationPhaseId: ").append(toIndentedString(atsApplicationPhaseId)).append("\n");
    sb.append("    atsApplicationPhaseName: ").append(toIndentedString(atsApplicationPhaseName)).append("\n");
    sb.append("    atsApplicationPhaseType: ").append(toIndentedString(atsApplicationPhaseType)).append("\n");
    sb.append("    atsJobPostingTitle: ").append(toIndentedString(atsJobPostingTitle)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    coverLetter: ").append(toIndentedString(coverLetter)).append("\n");
    sb.append("    cv: ").append(toIndentedString(cv)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    disqualifiedReason: ").append(toIndentedString(disqualifiedReason)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    medium: ").append(toIndentedString(medium)).append("\n");
    sb.append("    personalUrl: ").append(toIndentedString(personalUrl)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    qualified: ").append(toIndentedString(qualified)).append("\n");
    sb.append("    ratingAverage: ").append(toIndentedString(ratingAverage)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    talentPool: ").append(toIndentedString(talentPool)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("ats_candidate_id");
    openapiFields.add("ats_job_posting_id");
    openapiFields.add("ats_application_phase_id");
    openapiFields.add("ats_application_phase_name");
    openapiFields.add("ats_application_phase_type");
    openapiFields.add("ats_job_posting_title");
    openapiFields.add("conversation_id");
    openapiFields.add("cover_letter");
    openapiFields.add("cv");
    openapiFields.add("photo");
    openapiFields.add("disqualified_reason");
    openapiFields.add("email");
    openapiFields.add("first_name");
    openapiFields.add("full_name");
    openapiFields.add("last_name");
    openapiFields.add("medium");
    openapiFields.add("personal_url");
    openapiFields.add("phone");
    openapiFields.add("qualified");
    openapiFields.add("rating_average");
    openapiFields.add("source");
    openapiFields.add("talent_pool");
    openapiFields.add("created_at");
    openapiFields.add("answers");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to AtsApplication
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!AtsApplication.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AtsApplication is not found in the empty JSON string", AtsApplication.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("ats_application_phase_name") != null && !jsonObj.get("ats_application_phase_name").isJsonNull()) && !jsonObj.get("ats_application_phase_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ats_application_phase_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ats_application_phase_name").toString()));
      }
      if ((jsonObj.get("ats_application_phase_type") != null && !jsonObj.get("ats_application_phase_type").isJsonNull()) && !jsonObj.get("ats_application_phase_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ats_application_phase_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ats_application_phase_type").toString()));
      }
      if ((jsonObj.get("ats_job_posting_title") != null && !jsonObj.get("ats_job_posting_title").isJsonNull()) && !jsonObj.get("ats_job_posting_title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ats_job_posting_title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ats_job_posting_title").toString()));
      }
      if ((jsonObj.get("cover_letter") != null && !jsonObj.get("cover_letter").isJsonNull()) && !jsonObj.get("cover_letter").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cover_letter` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cover_letter").toString()));
      }
      // validate the optional field `cv`
      if (jsonObj.get("cv") != null && !jsonObj.get("cv").isJsonNull()) {
        AtsApplicationCv.validateJsonObject(jsonObj.getAsJsonObject("cv"));
      }
      if ((jsonObj.get("photo") != null && !jsonObj.get("photo").isJsonNull()) && !jsonObj.get("photo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `photo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("photo").toString()));
      }
      if ((jsonObj.get("disqualified_reason") != null && !jsonObj.get("disqualified_reason").isJsonNull()) && !jsonObj.get("disqualified_reason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `disqualified_reason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("disqualified_reason").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("first_name") != null && !jsonObj.get("first_name").isJsonNull()) && !jsonObj.get("first_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `first_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("first_name").toString()));
      }
      if ((jsonObj.get("full_name") != null && !jsonObj.get("full_name").isJsonNull()) && !jsonObj.get("full_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `full_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("full_name").toString()));
      }
      if ((jsonObj.get("last_name") != null && !jsonObj.get("last_name").isJsonNull()) && !jsonObj.get("last_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `last_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("last_name").toString()));
      }
      if ((jsonObj.get("medium") != null && !jsonObj.get("medium").isJsonNull()) && !jsonObj.get("medium").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `medium` to be a primitive type in the JSON string but got `%s`", jsonObj.get("medium").toString()));
      }
      if ((jsonObj.get("personal_url") != null && !jsonObj.get("personal_url").isJsonNull()) && !jsonObj.get("personal_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `personal_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("personal_url").toString()));
      }
      if ((jsonObj.get("phone") != null && !jsonObj.get("phone").isJsonNull()) && !jsonObj.get("phone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phone").toString()));
      }
      if ((jsonObj.get("source") != null && !jsonObj.get("source").isJsonNull()) && !jsonObj.get("source").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `source` to be a primitive type in the JSON string but got `%s`", jsonObj.get("source").toString()));
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if (jsonObj.get("answers") != null && !jsonObj.get("answers").isJsonNull()) {
        JsonArray jsonArrayanswers = jsonObj.getAsJsonArray("answers");
        if (jsonArrayanswers != null) {
          // ensure the json data is an array
          if (!jsonObj.get("answers").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `answers` to be an array in the JSON string but got `%s`", jsonObj.get("answers").toString()));
          }

          // validate the optional field `answers` (array)
          for (int i = 0; i < jsonArrayanswers.size(); i++) {
            AtsAnswer.validateJsonObject(jsonArrayanswers.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AtsApplication.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AtsApplication' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AtsApplication> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AtsApplication.class));

       return (TypeAdapter<T>) new TypeAdapter<AtsApplication>() {
           @Override
           public void write(JsonWriter out, AtsApplication value) throws IOException {
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
           public AtsApplication read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             AtsApplication instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of AtsApplication given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of AtsApplication
  * @throws IOException if the JSON string is invalid with respect to AtsApplication
  */
  public static AtsApplication fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AtsApplication.class);
  }

 /**
  * Convert an instance of AtsApplication to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


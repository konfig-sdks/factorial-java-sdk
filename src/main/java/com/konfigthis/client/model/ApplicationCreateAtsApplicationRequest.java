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
import com.konfigthis.client.model.ApplicationCreateAtsApplicationRequestAnswersInner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.File;
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
 * ApplicationCreateAtsApplicationRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ApplicationCreateAtsApplicationRequest {
  public static final String SERIALIZED_NAME_ATS_JOB_POSTING_ID = "ats_job_posting_id";
  @SerializedName(SERIALIZED_NAME_ATS_JOB_POSTING_ID)
  private Integer atsJobPostingId;

  /**
   * Gets or Sets source
   */
  @JsonAdapter(SourceEnum.Adapter.class)
 public enum SourceEnum {
    INDEED("indeed"),
    
    LINKEDIN("linkedin"),
    
    JOBTARGET("JobTarget"),
    
    MANUALLY_ADDED("manually_added"),
    
    ORGANIC("organic"),
    
    JOBPOSTING("jobposting"),
    
    JOIN("JOIN");

    private String value;

    SourceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SourceEnum fromValue(String value) {
      for (SourceEnum b : SourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SourceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SourceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SourceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SourceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private SourceEnum source;

  public static final String SERIALIZED_NAME_MEDIUM = "medium";
  @SerializedName(SERIALIZED_NAME_MEDIUM)
  private String medium;

  public static final String SERIALIZED_NAME_ATS_CANDIDATE_ID = "ats_candidate_id";
  @SerializedName(SERIALIZED_NAME_ATS_CANDIDATE_ID)
  private Integer atsCandidateId;

  public static final String SERIALIZED_NAME_COVER_LETTER = "cover_letter";
  @SerializedName(SERIALIZED_NAME_COVER_LETTER)
  private String coverLetter;

  public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_CV = "cv";
  @SerializedName(SERIALIZED_NAME_CV)
  private File cv;

  public static final String SERIALIZED_NAME_PHOTO = "photo";
  @SerializedName(SERIALIZED_NAME_PHOTO)
  private File photo;

  public static final String SERIALIZED_NAME_ANSWERS = "answers";
  @SerializedName(SERIALIZED_NAME_ANSWERS)
  private List<ApplicationCreateAtsApplicationRequestAnswersInner> answers = null;

  public ApplicationCreateAtsApplicationRequest() {
  }

  public ApplicationCreateAtsApplicationRequest atsJobPostingId(Integer atsJobPostingId) {
    
    
    
    
    this.atsJobPostingId = atsJobPostingId;
    return this;
  }

   /**
   * Get atsJobPostingId
   * @return atsJobPostingId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "1", required = true, value = "")

  public Integer getAtsJobPostingId() {
    return atsJobPostingId;
  }


  public void setAtsJobPostingId(Integer atsJobPostingId) {
    
    
    
    this.atsJobPostingId = atsJobPostingId;
  }


  public ApplicationCreateAtsApplicationRequest source(SourceEnum source) {
    
    
    
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "INDEED", required = true, value = "")

  public SourceEnum getSource() {
    return source;
  }


  public void setSource(SourceEnum source) {
    
    
    
    this.source = source;
  }


  public ApplicationCreateAtsApplicationRequest medium(String medium) {
    
    
    
    
    this.medium = medium;
    return this;
  }

   /**
   * Get medium
   * @return medium
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "LinkedIn", value = "")

  public String getMedium() {
    return medium;
  }


  public void setMedium(String medium) {
    
    
    
    this.medium = medium;
  }


  public ApplicationCreateAtsApplicationRequest atsCandidateId(Integer atsCandidateId) {
    
    
    
    
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


  public ApplicationCreateAtsApplicationRequest coverLetter(String coverLetter) {
    
    
    
    
    this.coverLetter = coverLetter;
    return this;
  }

   /**
   * Get coverLetter
   * @return coverLetter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "", value = "")

  public String getCoverLetter() {
    return coverLetter;
  }


  public void setCoverLetter(String coverLetter) {
    
    
    
    this.coverLetter = coverLetter;
  }


  public ApplicationCreateAtsApplicationRequest firstName(String firstName) {
    
    
    
    
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


  public ApplicationCreateAtsApplicationRequest lastName(String lastName) {
    
    
    
    
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


  public ApplicationCreateAtsApplicationRequest phone(String phone) {
    
    
    
    
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1134124214", value = "")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    
    
    
    this.phone = phone;
  }


  public ApplicationCreateAtsApplicationRequest email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "bob_stone@factorial.co", value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public ApplicationCreateAtsApplicationRequest cv(File cv) {
    
    
    
    
    this.cv = cv;
    return this;
  }

   /**
   * Get cv
   * @return cv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[B@3c82a07", value = "")

  public File getCv() {
    return cv;
  }


  public void setCv(File cv) {
    
    
    
    this.cv = cv;
  }


  public ApplicationCreateAtsApplicationRequest photo(File photo) {
    
    
    
    
    this.photo = photo;
    return this;
  }

   /**
   * Get photo
   * @return photo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[B@6134877f", value = "")

  public File getPhoto() {
    return photo;
  }


  public void setPhoto(File photo) {
    
    
    
    this.photo = photo;
  }


  public ApplicationCreateAtsApplicationRequest answers(List<ApplicationCreateAtsApplicationRequestAnswersInner> answers) {
    
    
    
    
    this.answers = answers;
    return this;
  }

  public ApplicationCreateAtsApplicationRequest addAnswersItem(ApplicationCreateAtsApplicationRequestAnswersInner answersItem) {
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
  @ApiModelProperty(example = "[{\"ats_question_id\":10,\"value\":true},{\"ats_question_id\":11,\"value\":[\"Barcelona\",\"Madrid\"]},{\"ats_question_id\":12,\"value\":\"cv.pdf\"}]", value = "")

  public List<ApplicationCreateAtsApplicationRequestAnswersInner> getAnswers() {
    return answers;
  }


  public void setAnswers(List<ApplicationCreateAtsApplicationRequestAnswersInner> answers) {
    
    
    
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
   * @return the ApplicationCreateAtsApplicationRequest instance itself
   */
  public ApplicationCreateAtsApplicationRequest putAdditionalProperty(String key, Object value) {
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
    ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = (ApplicationCreateAtsApplicationRequest) o;
    return Objects.equals(this.atsJobPostingId, applicationCreateAtsApplicationRequest.atsJobPostingId) &&
        Objects.equals(this.source, applicationCreateAtsApplicationRequest.source) &&
        Objects.equals(this.medium, applicationCreateAtsApplicationRequest.medium) &&
        Objects.equals(this.atsCandidateId, applicationCreateAtsApplicationRequest.atsCandidateId) &&
        Objects.equals(this.coverLetter, applicationCreateAtsApplicationRequest.coverLetter) &&
        Objects.equals(this.firstName, applicationCreateAtsApplicationRequest.firstName) &&
        Objects.equals(this.lastName, applicationCreateAtsApplicationRequest.lastName) &&
        Objects.equals(this.phone, applicationCreateAtsApplicationRequest.phone) &&
        Objects.equals(this.email, applicationCreateAtsApplicationRequest.email) &&
        Objects.equals(this.cv, applicationCreateAtsApplicationRequest.cv) &&
        Objects.equals(this.photo, applicationCreateAtsApplicationRequest.photo) &&
        Objects.equals(this.answers, applicationCreateAtsApplicationRequest.answers)&&
        Objects.equals(this.additionalProperties, applicationCreateAtsApplicationRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationCreateAtsApplicationRequest {\n");
    sb.append("    atsJobPostingId: ").append(toIndentedString(atsJobPostingId)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    medium: ").append(toIndentedString(medium)).append("\n");
    sb.append("    atsCandidateId: ").append(toIndentedString(atsCandidateId)).append("\n");
    sb.append("    coverLetter: ").append(toIndentedString(coverLetter)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    cv: ").append(toIndentedString(cv)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
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
    openapiFields.add("ats_job_posting_id");
    openapiFields.add("source");
    openapiFields.add("medium");
    openapiFields.add("ats_candidate_id");
    openapiFields.add("cover_letter");
    openapiFields.add("first_name");
    openapiFields.add("last_name");
    openapiFields.add("phone");
    openapiFields.add("email");
    openapiFields.add("cv");
    openapiFields.add("photo");
    openapiFields.add("answers");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("ats_job_posting_id");
    openapiRequiredFields.add("source");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ApplicationCreateAtsApplicationRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ApplicationCreateAtsApplicationRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApplicationCreateAtsApplicationRequest is not found in the empty JSON string", ApplicationCreateAtsApplicationRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ApplicationCreateAtsApplicationRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("source").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `source` to be a primitive type in the JSON string but got `%s`", jsonObj.get("source").toString()));
      }
      if ((jsonObj.get("medium") != null && !jsonObj.get("medium").isJsonNull()) && !jsonObj.get("medium").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `medium` to be a primitive type in the JSON string but got `%s`", jsonObj.get("medium").toString()));
      }
      if ((jsonObj.get("cover_letter") != null && !jsonObj.get("cover_letter").isJsonNull()) && !jsonObj.get("cover_letter").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cover_letter` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cover_letter").toString()));
      }
      if ((jsonObj.get("first_name") != null && !jsonObj.get("first_name").isJsonNull()) && !jsonObj.get("first_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `first_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("first_name").toString()));
      }
      if ((jsonObj.get("last_name") != null && !jsonObj.get("last_name").isJsonNull()) && !jsonObj.get("last_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `last_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("last_name").toString()));
      }
      if ((jsonObj.get("phone") != null && !jsonObj.get("phone").isJsonNull()) && !jsonObj.get("phone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phone").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
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
            ApplicationCreateAtsApplicationRequestAnswersInner.validateJsonObject(jsonArrayanswers.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApplicationCreateAtsApplicationRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApplicationCreateAtsApplicationRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApplicationCreateAtsApplicationRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApplicationCreateAtsApplicationRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ApplicationCreateAtsApplicationRequest>() {
           @Override
           public void write(JsonWriter out, ApplicationCreateAtsApplicationRequest value) throws IOException {
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
           public ApplicationCreateAtsApplicationRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ApplicationCreateAtsApplicationRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ApplicationCreateAtsApplicationRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ApplicationCreateAtsApplicationRequest
  * @throws IOException if the JSON string is invalid with respect to ApplicationCreateAtsApplicationRequest
  */
  public static ApplicationCreateAtsApplicationRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApplicationCreateAtsApplicationRequest.class);
  }

 /**
  * Convert an instance of ApplicationCreateAtsApplicationRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


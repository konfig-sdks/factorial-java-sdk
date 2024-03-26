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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.File;
import java.io.IOException;

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
 * ApplicationUpdateDataRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ApplicationUpdateDataRequest {
  public static final String SERIALIZED_NAME_ATS_APPLICATION_PHASE_ID = "ats_application_phase_id";
  @SerializedName(SERIALIZED_NAME_ATS_APPLICATION_PHASE_ID)
  private Integer atsApplicationPhaseId;

  public static final String SERIALIZED_NAME_QUALIFIED = "qualified";
  @SerializedName(SERIALIZED_NAME_QUALIFIED)
  private Boolean qualified;

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

  public static final String SERIALIZED_NAME_PERSONAL_URL = "personal_url";
  @SerializedName(SERIALIZED_NAME_PERSONAL_URL)
  private String personalUrl;

  /**
   * Gets or Sets disqualifiedReason
   */
  @JsonAdapter(DisqualifiedReasonEnum.Adapter.class)
 public enum DisqualifiedReasonEnum {
    NOT_A_FIT("not_a_fit"),
    
    SELF_DISQUALIFIED("self_disqualified"),
    
    SALARY("salary"),
    
    OTHER_REASON("other_reason"),
    
    UNDERQUALIFIED("underqualified"),
    
    OFFER_NOT_ACCEPTED("offer_not_accepted"),
    
    OTHER_OFFER("other_offer"),
    
    NO_RESPONSE("no_response");

    private String value;

    DisqualifiedReasonEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DisqualifiedReasonEnum fromValue(String value) {
      for (DisqualifiedReasonEnum b : DisqualifiedReasonEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DisqualifiedReasonEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DisqualifiedReasonEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DisqualifiedReasonEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DisqualifiedReasonEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DISQUALIFIED_REASON = "disqualified_reason";
  @SerializedName(SERIALIZED_NAME_DISQUALIFIED_REASON)
  private DisqualifiedReasonEnum disqualifiedReason;

  public static final String SERIALIZED_NAME_CV = "cv";
  @SerializedName(SERIALIZED_NAME_CV)
  private File cv;

  public static final String SERIALIZED_NAME_PHOTO = "photo";
  @SerializedName(SERIALIZED_NAME_PHOTO)
  private File photo;

  public ApplicationUpdateDataRequest() {
  }

  public ApplicationUpdateDataRequest atsApplicationPhaseId(Integer atsApplicationPhaseId) {
    
    
    
    
    this.atsApplicationPhaseId = atsApplicationPhaseId;
    return this;
  }

   /**
   * Get atsApplicationPhaseId
   * @return atsApplicationPhaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getAtsApplicationPhaseId() {
    return atsApplicationPhaseId;
  }


  public void setAtsApplicationPhaseId(Integer atsApplicationPhaseId) {
    
    
    
    this.atsApplicationPhaseId = atsApplicationPhaseId;
  }


  public ApplicationUpdateDataRequest qualified(Boolean qualified) {
    
    
    
    
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


  public ApplicationUpdateDataRequest firstName(String firstName) {
    
    
    
    
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


  public ApplicationUpdateDataRequest lastName(String lastName) {
    
    
    
    
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


  public ApplicationUpdateDataRequest phone(String phone) {
    
    
    
    
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


  public ApplicationUpdateDataRequest email(String email) {
    
    
    
    
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


  public ApplicationUpdateDataRequest personalUrl(String personalUrl) {
    
    
    
    
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


  public ApplicationUpdateDataRequest disqualifiedReason(DisqualifiedReasonEnum disqualifiedReason) {
    
    
    
    
    this.disqualifiedReason = disqualifiedReason;
    return this;
  }

   /**
   * Get disqualifiedReason
   * @return disqualifiedReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "NOT_A_FIT", value = "")

  public DisqualifiedReasonEnum getDisqualifiedReason() {
    return disqualifiedReason;
  }


  public void setDisqualifiedReason(DisqualifiedReasonEnum disqualifiedReason) {
    
    
    
    this.disqualifiedReason = disqualifiedReason;
  }


  public ApplicationUpdateDataRequest cv(File cv) {
    
    
    
    
    this.cv = cv;
    return this;
  }

   /**
   * Get cv
   * @return cv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[B@4bf334c9", value = "")

  public File getCv() {
    return cv;
  }


  public void setCv(File cv) {
    
    
    
    this.cv = cv;
  }


  public ApplicationUpdateDataRequest photo(File photo) {
    
    
    
    
    this.photo = photo;
    return this;
  }

   /**
   * Get photo
   * @return photo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[B@2690cd5f", value = "")

  public File getPhoto() {
    return photo;
  }


  public void setPhoto(File photo) {
    
    
    
    this.photo = photo;
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
   * @return the ApplicationUpdateDataRequest instance itself
   */
  public ApplicationUpdateDataRequest putAdditionalProperty(String key, Object value) {
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
    ApplicationUpdateDataRequest applicationUpdateDataRequest = (ApplicationUpdateDataRequest) o;
    return Objects.equals(this.atsApplicationPhaseId, applicationUpdateDataRequest.atsApplicationPhaseId) &&
        Objects.equals(this.qualified, applicationUpdateDataRequest.qualified) &&
        Objects.equals(this.firstName, applicationUpdateDataRequest.firstName) &&
        Objects.equals(this.lastName, applicationUpdateDataRequest.lastName) &&
        Objects.equals(this.phone, applicationUpdateDataRequest.phone) &&
        Objects.equals(this.email, applicationUpdateDataRequest.email) &&
        Objects.equals(this.personalUrl, applicationUpdateDataRequest.personalUrl) &&
        Objects.equals(this.disqualifiedReason, applicationUpdateDataRequest.disqualifiedReason) &&
        Objects.equals(this.cv, applicationUpdateDataRequest.cv) &&
        Objects.equals(this.photo, applicationUpdateDataRequest.photo)&&
        Objects.equals(this.additionalProperties, applicationUpdateDataRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atsApplicationPhaseId, qualified, firstName, lastName, phone, email, personalUrl, disqualifiedReason, cv, photo, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationUpdateDataRequest {\n");
    sb.append("    atsApplicationPhaseId: ").append(toIndentedString(atsApplicationPhaseId)).append("\n");
    sb.append("    qualified: ").append(toIndentedString(qualified)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    personalUrl: ").append(toIndentedString(personalUrl)).append("\n");
    sb.append("    disqualifiedReason: ").append(toIndentedString(disqualifiedReason)).append("\n");
    sb.append("    cv: ").append(toIndentedString(cv)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
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
    openapiFields.add("ats_application_phase_id");
    openapiFields.add("qualified");
    openapiFields.add("first_name");
    openapiFields.add("last_name");
    openapiFields.add("phone");
    openapiFields.add("email");
    openapiFields.add("personal_url");
    openapiFields.add("disqualified_reason");
    openapiFields.add("cv");
    openapiFields.add("photo");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ApplicationUpdateDataRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ApplicationUpdateDataRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApplicationUpdateDataRequest is not found in the empty JSON string", ApplicationUpdateDataRequest.openapiRequiredFields.toString()));
        }
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
      if ((jsonObj.get("personal_url") != null && !jsonObj.get("personal_url").isJsonNull()) && !jsonObj.get("personal_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `personal_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("personal_url").toString()));
      }
      if ((jsonObj.get("disqualified_reason") != null && !jsonObj.get("disqualified_reason").isJsonNull()) && !jsonObj.get("disqualified_reason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `disqualified_reason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("disqualified_reason").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApplicationUpdateDataRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApplicationUpdateDataRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApplicationUpdateDataRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApplicationUpdateDataRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ApplicationUpdateDataRequest>() {
           @Override
           public void write(JsonWriter out, ApplicationUpdateDataRequest value) throws IOException {
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
           public ApplicationUpdateDataRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ApplicationUpdateDataRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ApplicationUpdateDataRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ApplicationUpdateDataRequest
  * @throws IOException if the JSON string is invalid with respect to ApplicationUpdateDataRequest
  */
  public static ApplicationUpdateDataRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApplicationUpdateDataRequest.class);
  }

 /**
  * Convert an instance of ApplicationUpdateDataRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


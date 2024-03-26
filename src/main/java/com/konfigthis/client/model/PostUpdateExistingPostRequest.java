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
 * PostUpdateExistingPostRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PostUpdateExistingPostRequest {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_STARS_AT = "stars_at";
  @SerializedName(SERIALIZED_NAME_STARS_AT)
  private String starsAt;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  private String location;

  public static final String SERIALIZED_NAME_SEND_NOTIFICATIONS = "send_notifications";
  @SerializedName(SERIALIZED_NAME_SEND_NOTIFICATIONS)
  private Boolean sendNotifications;

  public static final String SERIALIZED_NAME_DELETE_COVER_IMAGE = "delete_cover_image";
  @SerializedName(SERIALIZED_NAME_DELETE_COVER_IMAGE)
  private Boolean deleteCoverImage;

  public static final String SERIALIZED_NAME_IMAGE = "image";
  @SerializedName(SERIALIZED_NAME_IMAGE)
  private File image;

  public static final String SERIALIZED_NAME_ALLOW_COMMENTS_AND_REACTIONS = "allow_comments_and_reactions";
  @SerializedName(SERIALIZED_NAME_ALLOW_COMMENTS_AND_REACTIONS)
  private Boolean allowCommentsAndReactions;

  public static final String SERIALIZED_NAME_ATTACHMENTS = "attachments";
  @SerializedName(SERIALIZED_NAME_ATTACHMENTS)
  private File attachments;

  public static final String SERIALIZED_NAME_DELETED_ATTACHMENTS = "deleted_attachments";
  @SerializedName(SERIALIZED_NAME_DELETED_ATTACHMENTS)
  private List<Integer> deletedAttachments = null;

  public PostUpdateExistingPostRequest() {
  }

  public PostUpdateExistingPostRequest title(String title) {
    
    
    
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "New Post", value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    
    
    
    this.title = title;
  }


  public PostUpdateExistingPostRequest description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "description", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public PostUpdateExistingPostRequest id(Integer id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "1", required = true, value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    
    
    
    this.id = id;
  }


  public PostUpdateExistingPostRequest starsAt(String starsAt) {
    
    
    
    
    this.starsAt = starsAt;
    return this;
  }

   /**
   * Get starsAt
   * @return starsAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-09-08T00:00:00.000Z", value = "")

  public String getStarsAt() {
    return starsAt;
  }


  public void setStarsAt(String starsAt) {
    
    
    
    this.starsAt = starsAt;
  }


  public PostUpdateExistingPostRequest location(String location) {
    
    
    
    
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Green park", value = "")

  public String getLocation() {
    return location;
  }


  public void setLocation(String location) {
    
    
    
    this.location = location;
  }


  public PostUpdateExistingPostRequest sendNotifications(Boolean sendNotifications) {
    
    
    
    
    this.sendNotifications = sendNotifications;
    return this;
  }

   /**
   * Get sendNotifications
   * @return sendNotifications
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getSendNotifications() {
    return sendNotifications;
  }


  public void setSendNotifications(Boolean sendNotifications) {
    
    
    
    this.sendNotifications = sendNotifications;
  }


  public PostUpdateExistingPostRequest deleteCoverImage(Boolean deleteCoverImage) {
    
    
    
    
    this.deleteCoverImage = deleteCoverImage;
    return this;
  }

   /**
   * Get deleteCoverImage
   * @return deleteCoverImage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getDeleteCoverImage() {
    return deleteCoverImage;
  }


  public void setDeleteCoverImage(Boolean deleteCoverImage) {
    
    
    
    this.deleteCoverImage = deleteCoverImage;
  }


  public PostUpdateExistingPostRequest image(File image) {
    
    
    
    
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public File getImage() {
    return image;
  }


  public void setImage(File image) {
    
    
    
    this.image = image;
  }


  public PostUpdateExistingPostRequest allowCommentsAndReactions(Boolean allowCommentsAndReactions) {
    
    
    
    
    this.allowCommentsAndReactions = allowCommentsAndReactions;
    return this;
  }

   /**
   * Get allowCommentsAndReactions
   * @return allowCommentsAndReactions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getAllowCommentsAndReactions() {
    return allowCommentsAndReactions;
  }


  public void setAllowCommentsAndReactions(Boolean allowCommentsAndReactions) {
    
    
    
    this.allowCommentsAndReactions = allowCommentsAndReactions;
  }


  public PostUpdateExistingPostRequest attachments(File attachments) {
    
    
    
    
    this.attachments = attachments;
    return this;
  }

   /**
   * Get attachments
   * @return attachments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public File getAttachments() {
    return attachments;
  }


  public void setAttachments(File attachments) {
    
    
    
    this.attachments = attachments;
  }


  public PostUpdateExistingPostRequest deletedAttachments(List<Integer> deletedAttachments) {
    
    
    
    
    this.deletedAttachments = deletedAttachments;
    return this;
  }

  public PostUpdateExistingPostRequest addDeletedAttachmentsItem(Integer deletedAttachmentsItem) {
    if (this.deletedAttachments == null) {
      this.deletedAttachments = new ArrayList<>();
    }
    this.deletedAttachments.add(deletedAttachmentsItem);
    return this;
  }

   /**
   * Get deletedAttachments
   * @return deletedAttachments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Integer> getDeletedAttachments() {
    return deletedAttachments;
  }


  public void setDeletedAttachments(List<Integer> deletedAttachments) {
    
    
    
    this.deletedAttachments = deletedAttachments;
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
   * @return the PostUpdateExistingPostRequest instance itself
   */
  public PostUpdateExistingPostRequest putAdditionalProperty(String key, Object value) {
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
    PostUpdateExistingPostRequest postUpdateExistingPostRequest = (PostUpdateExistingPostRequest) o;
    return Objects.equals(this.title, postUpdateExistingPostRequest.title) &&
        Objects.equals(this.description, postUpdateExistingPostRequest.description) &&
        Objects.equals(this.id, postUpdateExistingPostRequest.id) &&
        Objects.equals(this.starsAt, postUpdateExistingPostRequest.starsAt) &&
        Objects.equals(this.location, postUpdateExistingPostRequest.location) &&
        Objects.equals(this.sendNotifications, postUpdateExistingPostRequest.sendNotifications) &&
        Objects.equals(this.deleteCoverImage, postUpdateExistingPostRequest.deleteCoverImage) &&
        Objects.equals(this.image, postUpdateExistingPostRequest.image) &&
        Objects.equals(this.allowCommentsAndReactions, postUpdateExistingPostRequest.allowCommentsAndReactions) &&
        Objects.equals(this.attachments, postUpdateExistingPostRequest.attachments) &&
        Objects.equals(this.deletedAttachments, postUpdateExistingPostRequest.deletedAttachments)&&
        Objects.equals(this.additionalProperties, postUpdateExistingPostRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, id, starsAt, location, sendNotifications, deleteCoverImage, image, allowCommentsAndReactions, attachments, deletedAttachments, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostUpdateExistingPostRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    starsAt: ").append(toIndentedString(starsAt)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    sendNotifications: ").append(toIndentedString(sendNotifications)).append("\n");
    sb.append("    deleteCoverImage: ").append(toIndentedString(deleteCoverImage)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    allowCommentsAndReactions: ").append(toIndentedString(allowCommentsAndReactions)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    deletedAttachments: ").append(toIndentedString(deletedAttachments)).append("\n");
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
    openapiFields.add("stars_at");
    openapiFields.add("location");
    openapiFields.add("send_notifications");
    openapiFields.add("delete_cover_image");
    openapiFields.add("image");
    openapiFields.add("allow_comments_and_reactions");
    openapiFields.add("attachments");
    openapiFields.add("deleted_attachments");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PostUpdateExistingPostRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PostUpdateExistingPostRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PostUpdateExistingPostRequest is not found in the empty JSON string", PostUpdateExistingPostRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PostUpdateExistingPostRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("stars_at") != null && !jsonObj.get("stars_at").isJsonNull()) && !jsonObj.get("stars_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `stars_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("stars_at").toString()));
      }
      if ((jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) && !jsonObj.get("location").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `location` to be a primitive type in the JSON string but got `%s`", jsonObj.get("location").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("deleted_attachments") != null && !jsonObj.get("deleted_attachments").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `deleted_attachments` to be an array in the JSON string but got `%s`", jsonObj.get("deleted_attachments").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PostUpdateExistingPostRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PostUpdateExistingPostRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PostUpdateExistingPostRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PostUpdateExistingPostRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<PostUpdateExistingPostRequest>() {
           @Override
           public void write(JsonWriter out, PostUpdateExistingPostRequest value) throws IOException {
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
           public PostUpdateExistingPostRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PostUpdateExistingPostRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PostUpdateExistingPostRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PostUpdateExistingPostRequest
  * @throws IOException if the JSON string is invalid with respect to PostUpdateExistingPostRequest
  */
  public static PostUpdateExistingPostRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PostUpdateExistingPostRequest.class);
  }

 /**
  * Convert an instance of PostUpdateExistingPostRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


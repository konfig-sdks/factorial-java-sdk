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
 * Post
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class Post {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
 public enum TypeEnum {
    EVENT("event"),
    
    ANNOUNCEMENT("announcement"),
    
    FIRST_DAY("first_day"),
    
    BIRTHDAY("birthday"),
    
    WORKIVERSARY("workiversary");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_ALLOW_COMMENTS_AND_REACTIONS = "allow_comments_and_reactions";
  @SerializedName(SERIALIZED_NAME_ALLOW_COMMENTS_AND_REACTIONS)
  private Boolean allowCommentsAndReactions;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  private String location;

  public static final String SERIALIZED_NAME_PUBLISHED_AT = "published_at";
  @SerializedName(SERIALIZED_NAME_PUBLISHED_AT)
  private String publishedAt;

  public static final String SERIALIZED_NAME_STARTS_AT = "starts_at";
  @SerializedName(SERIALIZED_NAME_STARTS_AT)
  private String startsAt;

  public static final String SERIALIZED_NAME_ENDS_AT = "ends_at";
  @SerializedName(SERIALIZED_NAME_ENDS_AT)
  private String endsAt;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public static final String SERIALIZED_NAME_VISITS_COUNT = "visits_count";
  @SerializedName(SERIALIZED_NAME_VISITS_COUNT)
  private Integer visitsCount;

  public static final String SERIALIZED_NAME_COMMENTS_COUNT = "comments_count";
  @SerializedName(SERIALIZED_NAME_COMMENTS_COUNT)
  private Integer commentsCount;

  public static final String SERIALIZED_NAME_REACTIONS_COUNT = "reactions_count";
  @SerializedName(SERIALIZED_NAME_REACTIONS_COUNT)
  private Integer reactionsCount;

  public static final String SERIALIZED_NAME_COVER_IMAGE_URL = "cover_image_url";
  @SerializedName(SERIALIZED_NAME_COVER_IMAGE_URL)
  private String coverImageUrl;

  public static final String SERIALIZED_NAME_AUTHOR_ID = "author_id";
  @SerializedName(SERIALIZED_NAME_AUTHOR_ID)
  private Integer authorId;

  public static final String SERIALIZED_NAME_POSTS_GROUP_ID = "posts_group_id";
  @SerializedName(SERIALIZED_NAME_POSTS_GROUP_ID)
  private Integer postsGroupId;

  public static final String SERIALIZED_NAME_TARGET_ID = "target_id";
  @SerializedName(SERIALIZED_NAME_TARGET_ID)
  private Integer targetId;

  public Post() {
  }

  public Post title(String title) {
    
    
    
    
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


  public Post description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "This is available until sunday", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public Post id(Integer id) {
    
    
    
    
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


  public Post type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FIRST_DAY", value = "")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
  }


  public Post allowCommentsAndReactions(Boolean allowCommentsAndReactions) {
    
    
    
    
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


  public Post location(String location) {
    
    
    
    
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


  public Post publishedAt(String publishedAt) {
    
    
    
    
    this.publishedAt = publishedAt;
    return this;
  }

   /**
   * Get publishedAt
   * @return publishedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-09-08T00:00:00.000Z", value = "")

  public String getPublishedAt() {
    return publishedAt;
  }


  public void setPublishedAt(String publishedAt) {
    
    
    
    this.publishedAt = publishedAt;
  }


  public Post startsAt(String startsAt) {
    
    
    
    
    this.startsAt = startsAt;
    return this;
  }

   /**
   * Get startsAt
   * @return startsAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-010-08T00:00:00.000Z", value = "")

  public String getStartsAt() {
    return startsAt;
  }


  public void setStartsAt(String startsAt) {
    
    
    
    this.startsAt = startsAt;
  }


  public Post endsAt(String endsAt) {
    
    
    
    
    this.endsAt = endsAt;
    return this;
  }

   /**
   * Get endsAt
   * @return endsAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-10-09T00:00:00.000Z", value = "")

  public String getEndsAt() {
    return endsAt;
  }


  public void setEndsAt(String endsAt) {
    
    
    
    this.endsAt = endsAt;
  }


  public Post createdAt(String createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-09-08T15:41:54.000Z", value = "")

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public Post updatedAt(String updatedAt) {
    
    
    
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-09-08T15:41:54.000Z", value = "")

  public String getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(String updatedAt) {
    
    
    
    this.updatedAt = updatedAt;
  }


  public Post visitsCount(Integer visitsCount) {
    
    
    
    
    this.visitsCount = visitsCount;
    return this;
  }

   /**
   * Get visitsCount
   * @return visitsCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "")

  public Integer getVisitsCount() {
    return visitsCount;
  }


  public void setVisitsCount(Integer visitsCount) {
    
    
    
    this.visitsCount = visitsCount;
  }


  public Post commentsCount(Integer commentsCount) {
    
    
    
    
    this.commentsCount = commentsCount;
    return this;
  }

   /**
   * Get commentsCount
   * @return commentsCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "")

  public Integer getCommentsCount() {
    return commentsCount;
  }


  public void setCommentsCount(Integer commentsCount) {
    
    
    
    this.commentsCount = commentsCount;
  }


  public Post reactionsCount(Integer reactionsCount) {
    
    
    
    
    this.reactionsCount = reactionsCount;
    return this;
  }

   /**
   * Get reactionsCount
   * @return reactionsCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "")

  public Integer getReactionsCount() {
    return reactionsCount;
  }


  public void setReactionsCount(Integer reactionsCount) {
    
    
    
    this.reactionsCount = reactionsCount;
  }


  public Post coverImageUrl(String coverImageUrl) {
    
    
    
    
    this.coverImageUrl = coverImageUrl;
    return this;
  }

   /**
   * Get coverImageUrl
   * @return coverImageUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "test-cover-image-jpg.com", value = "")

  public String getCoverImageUrl() {
    return coverImageUrl;
  }


  public void setCoverImageUrl(String coverImageUrl) {
    
    
    
    this.coverImageUrl = coverImageUrl;
  }


  public Post authorId(Integer authorId) {
    
    
    
    
    this.authorId = authorId;
    return this;
  }

   /**
   * Get authorId
   * @return authorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getAuthorId() {
    return authorId;
  }


  public void setAuthorId(Integer authorId) {
    
    
    
    this.authorId = authorId;
  }


  public Post postsGroupId(Integer postsGroupId) {
    
    
    
    
    this.postsGroupId = postsGroupId;
    return this;
  }

   /**
   * Get postsGroupId
   * @return postsGroupId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getPostsGroupId() {
    return postsGroupId;
  }


  public void setPostsGroupId(Integer postsGroupId) {
    
    
    
    this.postsGroupId = postsGroupId;
  }


  public Post targetId(Integer targetId) {
    
    
    
    
    this.targetId = targetId;
    return this;
  }

   /**
   * Get targetId
   * @return targetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getTargetId() {
    return targetId;
  }


  public void setTargetId(Integer targetId) {
    
    
    
    this.targetId = targetId;
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
   * @return the Post instance itself
   */
  public Post putAdditionalProperty(String key, Object value) {
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
    Post post = (Post) o;
    return Objects.equals(this.title, post.title) &&
        Objects.equals(this.description, post.description) &&
        Objects.equals(this.id, post.id) &&
        Objects.equals(this.type, post.type) &&
        Objects.equals(this.allowCommentsAndReactions, post.allowCommentsAndReactions) &&
        Objects.equals(this.location, post.location) &&
        Objects.equals(this.publishedAt, post.publishedAt) &&
        Objects.equals(this.startsAt, post.startsAt) &&
        Objects.equals(this.endsAt, post.endsAt) &&
        Objects.equals(this.createdAt, post.createdAt) &&
        Objects.equals(this.updatedAt, post.updatedAt) &&
        Objects.equals(this.visitsCount, post.visitsCount) &&
        Objects.equals(this.commentsCount, post.commentsCount) &&
        Objects.equals(this.reactionsCount, post.reactionsCount) &&
        Objects.equals(this.coverImageUrl, post.coverImageUrl) &&
        Objects.equals(this.authorId, post.authorId) &&
        Objects.equals(this.postsGroupId, post.postsGroupId) &&
        Objects.equals(this.targetId, post.targetId)&&
        Objects.equals(this.additionalProperties, post.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, id, type, allowCommentsAndReactions, location, publishedAt, startsAt, endsAt, createdAt, updatedAt, visitsCount, commentsCount, reactionsCount, coverImageUrl, authorId, postsGroupId, targetId, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Post {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    allowCommentsAndReactions: ").append(toIndentedString(allowCommentsAndReactions)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    publishedAt: ").append(toIndentedString(publishedAt)).append("\n");
    sb.append("    startsAt: ").append(toIndentedString(startsAt)).append("\n");
    sb.append("    endsAt: ").append(toIndentedString(endsAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    visitsCount: ").append(toIndentedString(visitsCount)).append("\n");
    sb.append("    commentsCount: ").append(toIndentedString(commentsCount)).append("\n");
    sb.append("    reactionsCount: ").append(toIndentedString(reactionsCount)).append("\n");
    sb.append("    coverImageUrl: ").append(toIndentedString(coverImageUrl)).append("\n");
    sb.append("    authorId: ").append(toIndentedString(authorId)).append("\n");
    sb.append("    postsGroupId: ").append(toIndentedString(postsGroupId)).append("\n");
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
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
    openapiFields.add("type");
    openapiFields.add("allow_comments_and_reactions");
    openapiFields.add("location");
    openapiFields.add("published_at");
    openapiFields.add("starts_at");
    openapiFields.add("ends_at");
    openapiFields.add("created_at");
    openapiFields.add("updated_at");
    openapiFields.add("visits_count");
    openapiFields.add("comments_count");
    openapiFields.add("reactions_count");
    openapiFields.add("cover_image_url");
    openapiFields.add("author_id");
    openapiFields.add("posts_group_id");
    openapiFields.add("target_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Post
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Post.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Post is not found in the empty JSON string", Post.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) && !jsonObj.get("location").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `location` to be a primitive type in the JSON string but got `%s`", jsonObj.get("location").toString()));
      }
      if ((jsonObj.get("published_at") != null && !jsonObj.get("published_at").isJsonNull()) && !jsonObj.get("published_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `published_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("published_at").toString()));
      }
      if ((jsonObj.get("starts_at") != null && !jsonObj.get("starts_at").isJsonNull()) && !jsonObj.get("starts_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `starts_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("starts_at").toString()));
      }
      if ((jsonObj.get("ends_at") != null && !jsonObj.get("ends_at").isJsonNull()) && !jsonObj.get("ends_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ends_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ends_at").toString()));
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if ((jsonObj.get("updated_at") != null && !jsonObj.get("updated_at").isJsonNull()) && !jsonObj.get("updated_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated_at").toString()));
      }
      if ((jsonObj.get("cover_image_url") != null && !jsonObj.get("cover_image_url").isJsonNull()) && !jsonObj.get("cover_image_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cover_image_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cover_image_url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Post.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Post' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Post> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Post.class));

       return (TypeAdapter<T>) new TypeAdapter<Post>() {
           @Override
           public void write(JsonWriter out, Post value) throws IOException {
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
           public Post read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             Post instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of Post given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Post
  * @throws IOException if the JSON string is invalid with respect to Post
  */
  public static Post fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Post.class);
  }

 /**
  * Convert an instance of Post to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


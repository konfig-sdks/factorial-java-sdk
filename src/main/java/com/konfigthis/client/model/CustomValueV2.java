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
 * CustomValueV2
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CustomValueV2 {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public static final String SERIALIZED_NAME_FIELD_ID = "field_id";
  @SerializedName(SERIALIZED_NAME_FIELD_ID)
  private Integer fieldId;

  public static final String SERIALIZED_NAME_SLUG_ID = "slug_id";
  @SerializedName(SERIALIZED_NAME_SLUG_ID)
  private Integer slugId;

  public static final String SERIALIZED_NAME_SLUG_NAME = "slug_name";
  @SerializedName(SERIALIZED_NAME_SLUG_NAME)
  private String slugName;

  public static final String SERIALIZED_NAME_REQUIRED = "required";
  @SerializedName(SERIALIZED_NAME_REQUIRED)
  private Boolean required;

  public static final String SERIALIZED_NAME_INSTANCE_ID = "instance_id";
  @SerializedName(SERIALIZED_NAME_INSTANCE_ID)
  private Integer instanceId;

  public CustomValueV2() {
  }

  public CustomValueV2 id(Integer id) {
    
    
    
    
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


  public CustomValueV2 label(String label) {
    
    
    
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Shirt Size", value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    
    
    
    this.label = label;
  }


  public CustomValueV2 value(String value) {
    
    
    
    
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "S", value = "")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    
    
    
    this.value = value;
  }


  public CustomValueV2 fieldId(Integer fieldId) {
    
    
    
    
    this.fieldId = fieldId;
    return this;
  }

   /**
   * Get fieldId
   * @return fieldId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getFieldId() {
    return fieldId;
  }


  public void setFieldId(Integer fieldId) {
    
    
    
    this.fieldId = fieldId;
  }


  public CustomValueV2 slugId(Integer slugId) {
    
    
    
    
    this.slugId = slugId;
    return this;
  }

   /**
   * Get slugId
   * @return slugId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getSlugId() {
    return slugId;
  }


  public void setSlugId(Integer slugId) {
    
    
    
    this.slugId = slugId;
  }


  public CustomValueV2 slugName(String slugName) {
    
    
    
    
    this.slugName = slugName;
    return this;
  }

   /**
   * Get slugName
   * @return slugName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "employees questions", value = "")

  public String getSlugName() {
    return slugName;
  }


  public void setSlugName(String slugName) {
    
    
    
    this.slugName = slugName;
  }


  public CustomValueV2 required(Boolean required) {
    
    
    
    
    this.required = required;
    return this;
  }

   /**
   * Get required
   * @return required
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getRequired() {
    return required;
  }


  public void setRequired(Boolean required) {
    
    
    
    this.required = required;
  }


  public CustomValueV2 instanceId(Integer instanceId) {
    
    
    
    
    this.instanceId = instanceId;
    return this;
  }

   /**
   * Get instanceId
   * @return instanceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getInstanceId() {
    return instanceId;
  }


  public void setInstanceId(Integer instanceId) {
    
    
    
    this.instanceId = instanceId;
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
   * @return the CustomValueV2 instance itself
   */
  public CustomValueV2 putAdditionalProperty(String key, Object value) {
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
    CustomValueV2 customValueV2 = (CustomValueV2) o;
    return Objects.equals(this.id, customValueV2.id) &&
        Objects.equals(this.label, customValueV2.label) &&
        Objects.equals(this.value, customValueV2.value) &&
        Objects.equals(this.fieldId, customValueV2.fieldId) &&
        Objects.equals(this.slugId, customValueV2.slugId) &&
        Objects.equals(this.slugName, customValueV2.slugName) &&
        Objects.equals(this.required, customValueV2.required) &&
        Objects.equals(this.instanceId, customValueV2.instanceId)&&
        Objects.equals(this.additionalProperties, customValueV2.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, label, value, fieldId, slugId, slugName, required, instanceId, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomValueV2 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    fieldId: ").append(toIndentedString(fieldId)).append("\n");
    sb.append("    slugId: ").append(toIndentedString(slugId)).append("\n");
    sb.append("    slugName: ").append(toIndentedString(slugName)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
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
    openapiFields.add("label");
    openapiFields.add("value");
    openapiFields.add("field_id");
    openapiFields.add("slug_id");
    openapiFields.add("slug_name");
    openapiFields.add("required");
    openapiFields.add("instance_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CustomValueV2
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CustomValueV2.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomValueV2 is not found in the empty JSON string", CustomValueV2.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("label") != null && !jsonObj.get("label").isJsonNull()) && !jsonObj.get("label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("label").toString()));
      }
      if ((jsonObj.get("value") != null && !jsonObj.get("value").isJsonNull()) && !jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
      if ((jsonObj.get("slug_name") != null && !jsonObj.get("slug_name").isJsonNull()) && !jsonObj.get("slug_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `slug_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("slug_name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomValueV2.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomValueV2' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomValueV2> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomValueV2.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomValueV2>() {
           @Override
           public void write(JsonWriter out, CustomValueV2 value) throws IOException {
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
           public CustomValueV2 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CustomValueV2 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CustomValueV2 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CustomValueV2
  * @throws IOException if the JSON string is invalid with respect to CustomValueV2
  */
  public static CustomValueV2 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomValueV2.class);
  }

 /**
  * Convert an instance of CustomValueV2 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


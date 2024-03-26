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
 * PostJobPostingUpdateRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PostJobPostingUpdateRequest {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  /**
   * Gets or Sets contractType
   */
  @JsonAdapter(ContractTypeEnum.Adapter.class)
 public enum ContractTypeEnum {
    INDEFINITE("indefinite"),
    
    TEMPORARY("temporary"),
    
    FIXED_DISCONTINUED("fixed_discontinued"),
    
    INTERN("intern"),
    
    TRAINING("training");

    private String value;

    ContractTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ContractTypeEnum fromValue(String value) {
      for (ContractTypeEnum b : ContractTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ContractTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ContractTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ContractTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ContractTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CONTRACT_TYPE = "contract_type";
  @SerializedName(SERIALIZED_NAME_CONTRACT_TYPE)
  private ContractTypeEnum contractType;

  public static final String SERIALIZED_NAME_REMOTE = "remote";
  @SerializedName(SERIALIZED_NAME_REMOTE)
  private Boolean remote;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    DRAFT("draft"),
    
    PUBLISHED("published"),
    
    UNLISTED("unlisted"),
    
    ARCHIVED("archived"),
    
    CANCELLED("cancelled");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  /**
   * Gets or Sets scheduleType
   */
  @JsonAdapter(ScheduleTypeEnum.Adapter.class)
 public enum ScheduleTypeEnum {
    FULL_TIME("full_time"),
    
    PART_TIME("part_time");

    private String value;

    ScheduleTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ScheduleTypeEnum fromValue(String value) {
      for (ScheduleTypeEnum b : ScheduleTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ScheduleTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ScheduleTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ScheduleTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ScheduleTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SCHEDULE_TYPE = "schedule_type";
  @SerializedName(SERIALIZED_NAME_SCHEDULE_TYPE)
  private ScheduleTypeEnum scheduleType;

  public static final String SERIALIZED_NAME_TEAM_ID = "team_id";
  @SerializedName(SERIALIZED_NAME_TEAM_ID)
  private Integer teamId;

  public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
  @SerializedName(SERIALIZED_NAME_LOCATION_ID)
  private Integer locationId;

  /**
   * Gets or Sets salaryFormat
   */
  @JsonAdapter(SalaryFormatEnum.Adapter.class)
 public enum SalaryFormatEnum {
    RANGE("range"),
    
    FIXED_AMOUNT("fixed_amount");

    private String value;

    SalaryFormatEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SalaryFormatEnum fromValue(String value) {
      for (SalaryFormatEnum b : SalaryFormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SalaryFormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SalaryFormatEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SalaryFormatEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SalaryFormatEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SALARY_FORMAT = "salary_format";
  @SerializedName(SERIALIZED_NAME_SALARY_FORMAT)
  private SalaryFormatEnum salaryFormat;

  public static final String SERIALIZED_NAME_SALARY_FROM_AMOUNT_IN_CENTS = "salary_from_amount_in_cents";
  @SerializedName(SERIALIZED_NAME_SALARY_FROM_AMOUNT_IN_CENTS)
  private Integer salaryFromAmountInCents;

  public static final String SERIALIZED_NAME_SALARY_TO_AMOUNT_IN_CENTS = "salary_to_amount_in_cents";
  @SerializedName(SERIALIZED_NAME_SALARY_TO_AMOUNT_IN_CENTS)
  private Integer salaryToAmountInCents;

  /**
   * Gets or Sets cvRequirement
   */
  @JsonAdapter(CvRequirementEnum.Adapter.class)
 public enum CvRequirementEnum {
    MANDATORY("mandatory"),
    
    OPTIONAL("optional"),
    
    DO_NOT_ASK("do_not_ask");

    private String value;

    CvRequirementEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CvRequirementEnum fromValue(String value) {
      for (CvRequirementEnum b : CvRequirementEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CvRequirementEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CvRequirementEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CvRequirementEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CvRequirementEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CV_REQUIREMENT = "cv_requirement";
  @SerializedName(SERIALIZED_NAME_CV_REQUIREMENT)
  private CvRequirementEnum cvRequirement;

  /**
   * Gets or Sets coverLetterRequirement
   */
  @JsonAdapter(CoverLetterRequirementEnum.Adapter.class)
 public enum CoverLetterRequirementEnum {
    MANDATORY("mandatory"),
    
    OPTIONAL("optional"),
    
    DO_NOT_ASK("do_not_ask");

    private String value;

    CoverLetterRequirementEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CoverLetterRequirementEnum fromValue(String value) {
      for (CoverLetterRequirementEnum b : CoverLetterRequirementEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CoverLetterRequirementEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CoverLetterRequirementEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CoverLetterRequirementEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CoverLetterRequirementEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COVER_LETTER_REQUIREMENT = "cover_letter_requirement";
  @SerializedName(SERIALIZED_NAME_COVER_LETTER_REQUIREMENT)
  private CoverLetterRequirementEnum coverLetterRequirement;

  /**
   * Gets or Sets phoneRequirement
   */
  @JsonAdapter(PhoneRequirementEnum.Adapter.class)
 public enum PhoneRequirementEnum {
    MANDATORY("mandatory"),
    
    OPTIONAL("optional"),
    
    DO_NOT_ASK("do_not_ask");

    private String value;

    PhoneRequirementEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PhoneRequirementEnum fromValue(String value) {
      for (PhoneRequirementEnum b : PhoneRequirementEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PhoneRequirementEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PhoneRequirementEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PhoneRequirementEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PhoneRequirementEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PHONE_REQUIREMENT = "phone_requirement";
  @SerializedName(SERIALIZED_NAME_PHONE_REQUIREMENT)
  private PhoneRequirementEnum phoneRequirement;

  /**
   * Gets or Sets photoRequirement
   */
  @JsonAdapter(PhotoRequirementEnum.Adapter.class)
 public enum PhotoRequirementEnum {
    MANDATORY("mandatory"),
    
    OPTIONAL("optional"),
    
    DO_NOT_ASK("do_not_ask");

    private String value;

    PhotoRequirementEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PhotoRequirementEnum fromValue(String value) {
      for (PhotoRequirementEnum b : PhotoRequirementEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PhotoRequirementEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PhotoRequirementEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PhotoRequirementEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PhotoRequirementEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PHOTO_REQUIREMENT = "photo_requirement";
  @SerializedName(SERIALIZED_NAME_PHOTO_REQUIREMENT)
  private PhotoRequirementEnum photoRequirement;

  public PostJobPostingUpdateRequest() {
  }

  public PostJobPostingUpdateRequest title(String title) {
    
    
    
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Developer", value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    
    
    
    this.title = title;
  }


  public PostJobPostingUpdateRequest description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Full Stack Developer", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public PostJobPostingUpdateRequest contractType(ContractTypeEnum contractType) {
    
    
    
    
    this.contractType = contractType;
    return this;
  }

   /**
   * Get contractType
   * @return contractType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "TEMPORARY", value = "")

  public ContractTypeEnum getContractType() {
    return contractType;
  }


  public void setContractType(ContractTypeEnum contractType) {
    
    
    
    this.contractType = contractType;
  }


  public PostJobPostingUpdateRequest remote(Boolean remote) {
    
    
    
    
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


  public PostJobPostingUpdateRequest status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "DRAFT", value = "")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public PostJobPostingUpdateRequest scheduleType(ScheduleTypeEnum scheduleType) {
    
    
    
    
    this.scheduleType = scheduleType;
    return this;
  }

   /**
   * Get scheduleType
   * @return scheduleType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FULL_TIME", value = "")

  public ScheduleTypeEnum getScheduleType() {
    return scheduleType;
  }


  public void setScheduleType(ScheduleTypeEnum scheduleType) {
    
    
    
    this.scheduleType = scheduleType;
  }


  public PostJobPostingUpdateRequest teamId(Integer teamId) {
    
    
    
    
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


  public PostJobPostingUpdateRequest locationId(Integer locationId) {
    
    
    
    
    this.locationId = locationId;
    return this;
  }

   /**
   * Get locationId
   * @return locationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getLocationId() {
    return locationId;
  }


  public void setLocationId(Integer locationId) {
    
    
    
    this.locationId = locationId;
  }


  public PostJobPostingUpdateRequest salaryFormat(SalaryFormatEnum salaryFormat) {
    
    
    
    
    this.salaryFormat = salaryFormat;
    return this;
  }

   /**
   * Get salaryFormat
   * @return salaryFormat
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "RANGE", value = "")

  public SalaryFormatEnum getSalaryFormat() {
    return salaryFormat;
  }


  public void setSalaryFormat(SalaryFormatEnum salaryFormat) {
    
    
    
    this.salaryFormat = salaryFormat;
  }


  public PostJobPostingUpdateRequest salaryFromAmountInCents(Integer salaryFromAmountInCents) {
    
    
    
    
    this.salaryFromAmountInCents = salaryFromAmountInCents;
    return this;
  }

   /**
   * Get salaryFromAmountInCents
   * @return salaryFromAmountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "50000", value = "")

  public Integer getSalaryFromAmountInCents() {
    return salaryFromAmountInCents;
  }


  public void setSalaryFromAmountInCents(Integer salaryFromAmountInCents) {
    
    
    
    this.salaryFromAmountInCents = salaryFromAmountInCents;
  }


  public PostJobPostingUpdateRequest salaryToAmountInCents(Integer salaryToAmountInCents) {
    
    
    
    
    this.salaryToAmountInCents = salaryToAmountInCents;
    return this;
  }

   /**
   * Get salaryToAmountInCents
   * @return salaryToAmountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "60000", value = "")

  public Integer getSalaryToAmountInCents() {
    return salaryToAmountInCents;
  }


  public void setSalaryToAmountInCents(Integer salaryToAmountInCents) {
    
    
    
    this.salaryToAmountInCents = salaryToAmountInCents;
  }


  public PostJobPostingUpdateRequest cvRequirement(CvRequirementEnum cvRequirement) {
    
    
    
    
    this.cvRequirement = cvRequirement;
    return this;
  }

   /**
   * Get cvRequirement
   * @return cvRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MANDATORY", value = "")

  public CvRequirementEnum getCvRequirement() {
    return cvRequirement;
  }


  public void setCvRequirement(CvRequirementEnum cvRequirement) {
    
    
    
    this.cvRequirement = cvRequirement;
  }


  public PostJobPostingUpdateRequest coverLetterRequirement(CoverLetterRequirementEnum coverLetterRequirement) {
    
    
    
    
    this.coverLetterRequirement = coverLetterRequirement;
    return this;
  }

   /**
   * Get coverLetterRequirement
   * @return coverLetterRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MANDATORY", value = "")

  public CoverLetterRequirementEnum getCoverLetterRequirement() {
    return coverLetterRequirement;
  }


  public void setCoverLetterRequirement(CoverLetterRequirementEnum coverLetterRequirement) {
    
    
    
    this.coverLetterRequirement = coverLetterRequirement;
  }


  public PostJobPostingUpdateRequest phoneRequirement(PhoneRequirementEnum phoneRequirement) {
    
    
    
    
    this.phoneRequirement = phoneRequirement;
    return this;
  }

   /**
   * Get phoneRequirement
   * @return phoneRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MANDATORY", value = "")

  public PhoneRequirementEnum getPhoneRequirement() {
    return phoneRequirement;
  }


  public void setPhoneRequirement(PhoneRequirementEnum phoneRequirement) {
    
    
    
    this.phoneRequirement = phoneRequirement;
  }


  public PostJobPostingUpdateRequest photoRequirement(PhotoRequirementEnum photoRequirement) {
    
    
    
    
    this.photoRequirement = photoRequirement;
    return this;
  }

   /**
   * Get photoRequirement
   * @return photoRequirement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MANDATORY", value = "")

  public PhotoRequirementEnum getPhotoRequirement() {
    return photoRequirement;
  }


  public void setPhotoRequirement(PhotoRequirementEnum photoRequirement) {
    
    
    
    this.photoRequirement = photoRequirement;
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
   * @return the PostJobPostingUpdateRequest instance itself
   */
  public PostJobPostingUpdateRequest putAdditionalProperty(String key, Object value) {
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
    PostJobPostingUpdateRequest postJobPostingUpdateRequest = (PostJobPostingUpdateRequest) o;
    return Objects.equals(this.title, postJobPostingUpdateRequest.title) &&
        Objects.equals(this.description, postJobPostingUpdateRequest.description) &&
        Objects.equals(this.contractType, postJobPostingUpdateRequest.contractType) &&
        Objects.equals(this.remote, postJobPostingUpdateRequest.remote) &&
        Objects.equals(this.status, postJobPostingUpdateRequest.status) &&
        Objects.equals(this.scheduleType, postJobPostingUpdateRequest.scheduleType) &&
        Objects.equals(this.teamId, postJobPostingUpdateRequest.teamId) &&
        Objects.equals(this.locationId, postJobPostingUpdateRequest.locationId) &&
        Objects.equals(this.salaryFormat, postJobPostingUpdateRequest.salaryFormat) &&
        Objects.equals(this.salaryFromAmountInCents, postJobPostingUpdateRequest.salaryFromAmountInCents) &&
        Objects.equals(this.salaryToAmountInCents, postJobPostingUpdateRequest.salaryToAmountInCents) &&
        Objects.equals(this.cvRequirement, postJobPostingUpdateRequest.cvRequirement) &&
        Objects.equals(this.coverLetterRequirement, postJobPostingUpdateRequest.coverLetterRequirement) &&
        Objects.equals(this.phoneRequirement, postJobPostingUpdateRequest.phoneRequirement) &&
        Objects.equals(this.photoRequirement, postJobPostingUpdateRequest.photoRequirement)&&
        Objects.equals(this.additionalProperties, postJobPostingUpdateRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, contractType, remote, status, scheduleType, teamId, locationId, salaryFormat, salaryFromAmountInCents, salaryToAmountInCents, cvRequirement, coverLetterRequirement, phoneRequirement, photoRequirement, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostJobPostingUpdateRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
    sb.append("    remote: ").append(toIndentedString(remote)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    scheduleType: ").append(toIndentedString(scheduleType)).append("\n");
    sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    salaryFormat: ").append(toIndentedString(salaryFormat)).append("\n");
    sb.append("    salaryFromAmountInCents: ").append(toIndentedString(salaryFromAmountInCents)).append("\n");
    sb.append("    salaryToAmountInCents: ").append(toIndentedString(salaryToAmountInCents)).append("\n");
    sb.append("    cvRequirement: ").append(toIndentedString(cvRequirement)).append("\n");
    sb.append("    coverLetterRequirement: ").append(toIndentedString(coverLetterRequirement)).append("\n");
    sb.append("    phoneRequirement: ").append(toIndentedString(phoneRequirement)).append("\n");
    sb.append("    photoRequirement: ").append(toIndentedString(photoRequirement)).append("\n");
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
    openapiFields.add("contract_type");
    openapiFields.add("remote");
    openapiFields.add("status");
    openapiFields.add("schedule_type");
    openapiFields.add("team_id");
    openapiFields.add("location_id");
    openapiFields.add("salary_format");
    openapiFields.add("salary_from_amount_in_cents");
    openapiFields.add("salary_to_amount_in_cents");
    openapiFields.add("cv_requirement");
    openapiFields.add("cover_letter_requirement");
    openapiFields.add("phone_requirement");
    openapiFields.add("photo_requirement");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PostJobPostingUpdateRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PostJobPostingUpdateRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PostJobPostingUpdateRequest is not found in the empty JSON string", PostJobPostingUpdateRequest.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("contract_type") != null && !jsonObj.get("contract_type").isJsonNull()) && !jsonObj.get("contract_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contract_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contract_type").toString()));
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
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PostJobPostingUpdateRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PostJobPostingUpdateRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PostJobPostingUpdateRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PostJobPostingUpdateRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<PostJobPostingUpdateRequest>() {
           @Override
           public void write(JsonWriter out, PostJobPostingUpdateRequest value) throws IOException {
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
           public PostJobPostingUpdateRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PostJobPostingUpdateRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PostJobPostingUpdateRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PostJobPostingUpdateRequest
  * @throws IOException if the JSON string is invalid with respect to PostJobPostingUpdateRequest
  */
  public static PostJobPostingUpdateRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PostJobPostingUpdateRequest.class);
  }

 /**
  * Convert an instance of PostJobPostingUpdateRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


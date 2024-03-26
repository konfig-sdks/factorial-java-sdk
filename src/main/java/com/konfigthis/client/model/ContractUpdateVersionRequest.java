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
import org.openapitools.jackson.nullable.JsonNullable;

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
 * ContractUpdateVersionRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ContractUpdateVersionRequest {
  public static final String SERIALIZED_NAME_EFFECTIVE_ON = "effective_on";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_ON)
  private String effectiveOn;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_STARTS_ON = "starts_on";
  @SerializedName(SERIALIZED_NAME_STARTS_ON)
  private String startsOn;

  public static final String SERIALIZED_NAME_ENDS_ON = "ends_on";
  @SerializedName(SERIALIZED_NAME_ENDS_ON)
  private String endsOn;

  /**
   * Gets or Sets workingHoursFrequency
   */
  @JsonAdapter(WorkingHoursFrequencyEnum.Adapter.class)
 public enum WorkingHoursFrequencyEnum {
    WEEK("week"),
    
    DAY("day"),
    
    MONTH("month"),
    
    YEAR("year");

    private String value;

    WorkingHoursFrequencyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static WorkingHoursFrequencyEnum fromValue(String value) {
      for (WorkingHoursFrequencyEnum b : WorkingHoursFrequencyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<WorkingHoursFrequencyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final WorkingHoursFrequencyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public WorkingHoursFrequencyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return WorkingHoursFrequencyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_WORKING_HOURS_FREQUENCY = "working_hours_frequency";
  @SerializedName(SERIALIZED_NAME_WORKING_HOURS_FREQUENCY)
  private WorkingHoursFrequencyEnum workingHoursFrequency;

  public static final String SERIALIZED_NAME_WORKING_WEEK_DAYS = "working_week_days";
  @SerializedName(SERIALIZED_NAME_WORKING_WEEK_DAYS)
  private String workingWeekDays;

  public static final String SERIALIZED_NAME_WORKING_HOURS = "working_hours";
  @SerializedName(SERIALIZED_NAME_WORKING_HOURS)
  private Integer workingHours;

  /**
   * Gets or Sets salaryFrequency
   */
  @JsonAdapter(SalaryFrequencyEnum.Adapter.class)
 public enum SalaryFrequencyEnum {
    YEARLY("yearly"),
    
    MONTHLY("monthly"),
    
    WEEKLY("weekly"),
    
    HOURLY("hourly"),
    
    DAILY("daily");

    private String value;

    SalaryFrequencyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SalaryFrequencyEnum fromValue(String value) {
      for (SalaryFrequencyEnum b : SalaryFrequencyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SalaryFrequencyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SalaryFrequencyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SalaryFrequencyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SalaryFrequencyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SALARY_FREQUENCY = "salary_frequency";
  @SerializedName(SERIALIZED_NAME_SALARY_FREQUENCY)
  private SalaryFrequencyEnum salaryFrequency;

  public static final String SERIALIZED_NAME_SALARY_AMOUNT = "salary_amount";
  @SerializedName(SERIALIZED_NAME_SALARY_AMOUNT)
  private Integer salaryAmount;

  public static final String SERIALIZED_NAME_JOB_TITLE = "job_title";
  @SerializedName(SERIALIZED_NAME_JOB_TITLE)
  private String jobTitle;

  public static final String SERIALIZED_NAME_ES_COTIZATION_GROUP = "es_cotization_group";
  @SerializedName(SERIALIZED_NAME_ES_COTIZATION_GROUP)
  private Integer esCotizationGroup;

  public static final String SERIALIZED_NAME_ES_PROFESSIONAL_CATEGORY_ID = "es_professional_category_id";
  @SerializedName(SERIALIZED_NAME_ES_PROFESSIONAL_CATEGORY_ID)
  private Integer esProfessionalCategoryId;

  public static final String SERIALIZED_NAME_ES_EDUCATION_LEVEL_ID = "es_education_level_id";
  @SerializedName(SERIALIZED_NAME_ES_EDUCATION_LEVEL_ID)
  private Integer esEducationLevelId;

  public static final String SERIALIZED_NAME_ES_CONTRACT_TYPE_ID = "es_contract_type_id";
  @SerializedName(SERIALIZED_NAME_ES_CONTRACT_TYPE_ID)
  private Integer esContractTypeId;

  public ContractUpdateVersionRequest() {
  }

  public ContractUpdateVersionRequest effectiveOn(String effectiveOn) {
    
    
    
    
    this.effectiveOn = effectiveOn;
    return this;
  }

   /**
   * Get effectiveOn
   * @return effectiveOn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2022-04-22", required = true, value = "")

  public String getEffectiveOn() {
    return effectiveOn;
  }


  public void setEffectiveOn(String effectiveOn) {
    
    
    
    this.effectiveOn = effectiveOn;
  }


  public ContractUpdateVersionRequest employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public ContractUpdateVersionRequest startsOn(String startsOn) {
    
    
    
    
    this.startsOn = startsOn;
    return this;
  }

   /**
   * Get startsOn
   * @return startsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2021-04-22", value = "")

  public String getStartsOn() {
    return startsOn;
  }


  public void setStartsOn(String startsOn) {
    
    
    
    this.startsOn = startsOn;
  }


  public ContractUpdateVersionRequest endsOn(String endsOn) {
    
    
    
    
    this.endsOn = endsOn;
    return this;
  }

   /**
   * Get endsOn
   * @return endsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2023-04-22", value = "")

  public String getEndsOn() {
    return endsOn;
  }


  public void setEndsOn(String endsOn) {
    
    
    
    this.endsOn = endsOn;
  }


  public ContractUpdateVersionRequest workingHoursFrequency(WorkingHoursFrequencyEnum workingHoursFrequency) {
    
    
    
    
    this.workingHoursFrequency = workingHoursFrequency;
    return this;
  }

   /**
   * Get workingHoursFrequency
   * @return workingHoursFrequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "WEEK", value = "")

  public WorkingHoursFrequencyEnum getWorkingHoursFrequency() {
    return workingHoursFrequency;
  }


  public void setWorkingHoursFrequency(WorkingHoursFrequencyEnum workingHoursFrequency) {
    
    
    
    this.workingHoursFrequency = workingHoursFrequency;
  }


  public ContractUpdateVersionRequest workingWeekDays(String workingWeekDays) {
    
    
    
    
    this.workingWeekDays = workingWeekDays;
    return this;
  }

   /**
   * Get workingWeekDays
   * @return workingWeekDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "friday,tuesday,saturday", value = "")

  public String getWorkingWeekDays() {
    return workingWeekDays;
  }


  public void setWorkingWeekDays(String workingWeekDays) {
    
    
    
    this.workingWeekDays = workingWeekDays;
  }


  public ContractUpdateVersionRequest workingHours(Integer workingHours) {
    
    
    
    
    this.workingHours = workingHours;
    return this;
  }

   /**
   * Get workingHours
   * @return workingHours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "800", value = "")

  public Integer getWorkingHours() {
    return workingHours;
  }


  public void setWorkingHours(Integer workingHours) {
    
    
    
    this.workingHours = workingHours;
  }


  public ContractUpdateVersionRequest salaryFrequency(SalaryFrequencyEnum salaryFrequency) {
    
    
    
    
    this.salaryFrequency = salaryFrequency;
    return this;
  }

   /**
   * Get salaryFrequency
   * @return salaryFrequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "YEARLY", value = "")

  public SalaryFrequencyEnum getSalaryFrequency() {
    return salaryFrequency;
  }


  public void setSalaryFrequency(SalaryFrequencyEnum salaryFrequency) {
    
    
    
    this.salaryFrequency = salaryFrequency;
  }


  public ContractUpdateVersionRequest salaryAmount(Integer salaryAmount) {
    
    
    
    
    this.salaryAmount = salaryAmount;
    return this;
  }

   /**
   * Get salaryAmount
   * @return salaryAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5000000", value = "")

  public Integer getSalaryAmount() {
    return salaryAmount;
  }


  public void setSalaryAmount(Integer salaryAmount) {
    
    
    
    this.salaryAmount = salaryAmount;
  }


  public ContractUpdateVersionRequest jobTitle(String jobTitle) {
    
    
    
    
    this.jobTitle = jobTitle;
    return this;
  }

   /**
   * Get jobTitle
   * @return jobTitle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Jr Software Developer", value = "")

  public String getJobTitle() {
    return jobTitle;
  }


  public void setJobTitle(String jobTitle) {
    
    
    
    this.jobTitle = jobTitle;
  }


  public ContractUpdateVersionRequest esCotizationGroup(Integer esCotizationGroup) {
    
    
    
    
    this.esCotizationGroup = esCotizationGroup;
    return this;
  }

   /**
   * the cotization group id for Spain contracts
   * @return esCotizationGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "the cotization group id for Spain contracts")

  public Integer getEsCotizationGroup() {
    return esCotizationGroup;
  }


  public void setEsCotizationGroup(Integer esCotizationGroup) {
    
    
    
    this.esCotizationGroup = esCotizationGroup;
  }


  public ContractUpdateVersionRequest esProfessionalCategoryId(Integer esProfessionalCategoryId) {
    
    
    
    
    this.esProfessionalCategoryId = esProfessionalCategoryId;
    return this;
  }

   /**
   * the professional category id for Spain contracts
   * @return esProfessionalCategoryId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "the professional category id for Spain contracts")

  public Integer getEsProfessionalCategoryId() {
    return esProfessionalCategoryId;
  }


  public void setEsProfessionalCategoryId(Integer esProfessionalCategoryId) {
    
    
    
    this.esProfessionalCategoryId = esProfessionalCategoryId;
  }


  public ContractUpdateVersionRequest esEducationLevelId(Integer esEducationLevelId) {
    
    
    
    
    this.esEducationLevelId = esEducationLevelId;
    return this;
  }

   /**
   * the education level id for Spain contracts
   * @return esEducationLevelId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "4", value = "the education level id for Spain contracts")

  public Integer getEsEducationLevelId() {
    return esEducationLevelId;
  }


  public void setEsEducationLevelId(Integer esEducationLevelId) {
    
    
    
    this.esEducationLevelId = esEducationLevelId;
  }


  public ContractUpdateVersionRequest esContractTypeId(Integer esContractTypeId) {
    
    
    
    
    this.esContractTypeId = esContractTypeId;
    return this;
  }

   /**
   * the contract type id for Spain contracts
   * @return esContractTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "the contract type id for Spain contracts")

  public Integer getEsContractTypeId() {
    return esContractTypeId;
  }


  public void setEsContractTypeId(Integer esContractTypeId) {
    
    
    
    this.esContractTypeId = esContractTypeId;
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
   * @return the ContractUpdateVersionRequest instance itself
   */
  public ContractUpdateVersionRequest putAdditionalProperty(String key, Object value) {
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
    ContractUpdateVersionRequest contractUpdateVersionRequest = (ContractUpdateVersionRequest) o;
    return Objects.equals(this.effectiveOn, contractUpdateVersionRequest.effectiveOn) &&
        Objects.equals(this.employeeId, contractUpdateVersionRequest.employeeId) &&
        Objects.equals(this.startsOn, contractUpdateVersionRequest.startsOn) &&
        Objects.equals(this.endsOn, contractUpdateVersionRequest.endsOn) &&
        Objects.equals(this.workingHoursFrequency, contractUpdateVersionRequest.workingHoursFrequency) &&
        Objects.equals(this.workingWeekDays, contractUpdateVersionRequest.workingWeekDays) &&
        Objects.equals(this.workingHours, contractUpdateVersionRequest.workingHours) &&
        Objects.equals(this.salaryFrequency, contractUpdateVersionRequest.salaryFrequency) &&
        Objects.equals(this.salaryAmount, contractUpdateVersionRequest.salaryAmount) &&
        Objects.equals(this.jobTitle, contractUpdateVersionRequest.jobTitle) &&
        Objects.equals(this.esCotizationGroup, contractUpdateVersionRequest.esCotizationGroup) &&
        Objects.equals(this.esProfessionalCategoryId, contractUpdateVersionRequest.esProfessionalCategoryId) &&
        Objects.equals(this.esEducationLevelId, contractUpdateVersionRequest.esEducationLevelId) &&
        Objects.equals(this.esContractTypeId, contractUpdateVersionRequest.esContractTypeId)&&
        Objects.equals(this.additionalProperties, contractUpdateVersionRequest.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(effectiveOn, employeeId, startsOn, endsOn, workingHoursFrequency, workingWeekDays, workingHours, salaryFrequency, salaryAmount, jobTitle, esCotizationGroup, esProfessionalCategoryId, esEducationLevelId, esContractTypeId, additionalProperties);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContractUpdateVersionRequest {\n");
    sb.append("    effectiveOn: ").append(toIndentedString(effectiveOn)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    startsOn: ").append(toIndentedString(startsOn)).append("\n");
    sb.append("    endsOn: ").append(toIndentedString(endsOn)).append("\n");
    sb.append("    workingHoursFrequency: ").append(toIndentedString(workingHoursFrequency)).append("\n");
    sb.append("    workingWeekDays: ").append(toIndentedString(workingWeekDays)).append("\n");
    sb.append("    workingHours: ").append(toIndentedString(workingHours)).append("\n");
    sb.append("    salaryFrequency: ").append(toIndentedString(salaryFrequency)).append("\n");
    sb.append("    salaryAmount: ").append(toIndentedString(salaryAmount)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    esCotizationGroup: ").append(toIndentedString(esCotizationGroup)).append("\n");
    sb.append("    esProfessionalCategoryId: ").append(toIndentedString(esProfessionalCategoryId)).append("\n");
    sb.append("    esEducationLevelId: ").append(toIndentedString(esEducationLevelId)).append("\n");
    sb.append("    esContractTypeId: ").append(toIndentedString(esContractTypeId)).append("\n");
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
    openapiFields.add("effective_on");
    openapiFields.add("employee_id");
    openapiFields.add("starts_on");
    openapiFields.add("ends_on");
    openapiFields.add("working_hours_frequency");
    openapiFields.add("working_week_days");
    openapiFields.add("working_hours");
    openapiFields.add("salary_frequency");
    openapiFields.add("salary_amount");
    openapiFields.add("job_title");
    openapiFields.add("es_cotization_group");
    openapiFields.add("es_professional_category_id");
    openapiFields.add("es_education_level_id");
    openapiFields.add("es_contract_type_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("effective_on");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ContractUpdateVersionRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ContractUpdateVersionRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ContractUpdateVersionRequest is not found in the empty JSON string", ContractUpdateVersionRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ContractUpdateVersionRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("effective_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `effective_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("effective_on").toString()));
      }
      if ((jsonObj.get("starts_on") != null && !jsonObj.get("starts_on").isJsonNull()) && !jsonObj.get("starts_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `starts_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("starts_on").toString()));
      }
      if ((jsonObj.get("ends_on") != null && !jsonObj.get("ends_on").isJsonNull()) && !jsonObj.get("ends_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ends_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ends_on").toString()));
      }
      if ((jsonObj.get("working_hours_frequency") != null && !jsonObj.get("working_hours_frequency").isJsonNull()) && !jsonObj.get("working_hours_frequency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `working_hours_frequency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("working_hours_frequency").toString()));
      }
      if ((jsonObj.get("working_week_days") != null && !jsonObj.get("working_week_days").isJsonNull()) && !jsonObj.get("working_week_days").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `working_week_days` to be a primitive type in the JSON string but got `%s`", jsonObj.get("working_week_days").toString()));
      }
      if ((jsonObj.get("salary_frequency") != null && !jsonObj.get("salary_frequency").isJsonNull()) && !jsonObj.get("salary_frequency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `salary_frequency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("salary_frequency").toString()));
      }
      if ((jsonObj.get("job_title") != null && !jsonObj.get("job_title").isJsonNull()) && !jsonObj.get("job_title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `job_title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("job_title").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ContractUpdateVersionRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ContractUpdateVersionRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ContractUpdateVersionRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ContractUpdateVersionRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ContractUpdateVersionRequest>() {
           @Override
           public void write(JsonWriter out, ContractUpdateVersionRequest value) throws IOException {
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
           public ContractUpdateVersionRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ContractUpdateVersionRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ContractUpdateVersionRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ContractUpdateVersionRequest
  * @throws IOException if the JSON string is invalid with respect to ContractUpdateVersionRequest
  */
  public static ContractUpdateVersionRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ContractUpdateVersionRequest.class);
  }

 /**
  * Convert an instance of ContractUpdateVersionRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


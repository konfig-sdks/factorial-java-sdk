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
 * ContractVersion
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ContractVersion {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;

  public static final String SERIALIZED_NAME_JOB_TITLE = "job_title";
  @SerializedName(SERIALIZED_NAME_JOB_TITLE)
  private String jobTitle;

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;

  public static final String SERIALIZED_NAME_LEVEL = "level";
  @SerializedName(SERIALIZED_NAME_LEVEL)
  private String level;

  public static final String SERIALIZED_NAME_EFFECTIVE_ON = "effective_on";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_ON)
  private String effectiveOn;

  public static final String SERIALIZED_NAME_STARTS_ON = "starts_on";
  @SerializedName(SERIALIZED_NAME_STARTS_ON)
  private String startsOn;

  public static final String SERIALIZED_NAME_ENDS_ON = "ends_on";
  @SerializedName(SERIALIZED_NAME_ENDS_ON)
  private String endsOn;

  public static final String SERIALIZED_NAME_HAS_PAYROLL = "has_payroll";
  @SerializedName(SERIALIZED_NAME_HAS_PAYROLL)
  private Boolean hasPayroll;

  public static final String SERIALIZED_NAME_SALARY_AMOUNT = "salary_amount";
  @SerializedName(SERIALIZED_NAME_SALARY_AMOUNT)
  private Integer salaryAmount;

  public static final String SERIALIZED_NAME_SALARY_FREQUENCY = "salary_frequency";
  @SerializedName(SERIALIZED_NAME_SALARY_FREQUENCY)
  private String salaryFrequency;

  public static final String SERIALIZED_NAME_WORKING_WEEK_DAYS = "working_week_days";
  @SerializedName(SERIALIZED_NAME_WORKING_WEEK_DAYS)
  private String workingWeekDays;

  public static final String SERIALIZED_NAME_WORKING_HOURS = "working_hours";
  @SerializedName(SERIALIZED_NAME_WORKING_HOURS)
  private Integer workingHours;

  public static final String SERIALIZED_NAME_WORKING_HOURS_FREQUENCY = "working_hours_frequency";
  @SerializedName(SERIALIZED_NAME_WORKING_HOURS_FREQUENCY)
  private String workingHoursFrequency;

  public static final String SERIALIZED_NAME_ES_HAS_TELEWORKING_CONTRACT = "es_has_teleworking_contract";
  @SerializedName(SERIALIZED_NAME_ES_HAS_TELEWORKING_CONTRACT)
  private Boolean esHasTeleworkingContract;

  public static final String SERIALIZED_NAME_ES_COTIZATION_GROUP = "es_cotization_group";
  @SerializedName(SERIALIZED_NAME_ES_COTIZATION_GROUP)
  private Integer esCotizationGroup;

  public static final String SERIALIZED_NAME_ES_CONTRACT_OBSERVATIONS = "es_contract_observations";
  @SerializedName(SERIALIZED_NAME_ES_CONTRACT_OBSERVATIONS)
  private String esContractObservations;

  public static final String SERIALIZED_NAME_ES_JOB_DESCRIPTION = "es_job_description";
  @SerializedName(SERIALIZED_NAME_ES_JOB_DESCRIPTION)
  private String esJobDescription;

  public static final String SERIALIZED_NAME_ES_TRIAL_PERIOD_ENDS_ON = "es_trial_period_ends_on";
  @SerializedName(SERIALIZED_NAME_ES_TRIAL_PERIOD_ENDS_ON)
  private String esTrialPeriodEndsOn;

  public static final String SERIALIZED_NAME_ES_CONTRACT_TYPE_ID = "es_contract_type_id";
  @SerializedName(SERIALIZED_NAME_ES_CONTRACT_TYPE_ID)
  private Integer esContractTypeId;

  public static final String SERIALIZED_NAME_ES_WORKING_DAY_TYPE_ID = "es_working_day_type_id";
  @SerializedName(SERIALIZED_NAME_ES_WORKING_DAY_TYPE_ID)
  private Integer esWorkingDayTypeId;

  public static final String SERIALIZED_NAME_ES_EDUCATION_LEVEL_ID = "es_education_level_id";
  @SerializedName(SERIALIZED_NAME_ES_EDUCATION_LEVEL_ID)
  private Integer esEducationLevelId;

  public static final String SERIALIZED_NAME_ES_PROFESSIONAL_CATEGORY_ID = "es_professional_category_id";
  @SerializedName(SERIALIZED_NAME_ES_PROFESSIONAL_CATEGORY_ID)
  private Integer esProfessionalCategoryId;

  public static final String SERIALIZED_NAME_FR_EMPLOYEE_TYPE = "fr_employee_type";
  @SerializedName(SERIALIZED_NAME_FR_EMPLOYEE_TYPE)
  private String frEmployeeType;

  public static final String SERIALIZED_NAME_FR_FORFAIT_JOURS = "fr_forfait_jours";
  @SerializedName(SERIALIZED_NAME_FR_FORFAIT_JOURS)
  private Boolean frForfaitJours;

  public static final String SERIALIZED_NAME_FR_JOURS_PAR_AN = "fr_jours_par_an";
  @SerializedName(SERIALIZED_NAME_FR_JOURS_PAR_AN)
  private Integer frJoursParAn;

  public static final String SERIALIZED_NAME_FR_COEFFICIENT = "fr_coefficient";
  @SerializedName(SERIALIZED_NAME_FR_COEFFICIENT)
  private Integer frCoefficient;

  public static final String SERIALIZED_NAME_FR_CONTRACT_TYPE_ID = "fr_contract_type_id";
  @SerializedName(SERIALIZED_NAME_FR_CONTRACT_TYPE_ID)
  private Integer frContractTypeId;

  public static final String SERIALIZED_NAME_FR_LEVEL_ID = "fr_level_id";
  @SerializedName(SERIALIZED_NAME_FR_LEVEL_ID)
  private Integer frLevelId;

  public static final String SERIALIZED_NAME_FR_STEP_ID = "fr_step_id";
  @SerializedName(SERIALIZED_NAME_FR_STEP_ID)
  private Integer frStepId;

  public static final String SERIALIZED_NAME_FR_MUTUAL_ID = "fr_mutual_id";
  @SerializedName(SERIALIZED_NAME_FR_MUTUAL_ID)
  private Integer frMutualId;

  public static final String SERIALIZED_NAME_FR_PROFESSIONAL_CATEGORY_ID = "fr_professional_category_id";
  @SerializedName(SERIALIZED_NAME_FR_PROFESSIONAL_CATEGORY_ID)
  private Integer frProfessionalCategoryId;

  public static final String SERIALIZED_NAME_FR_WORK_TYPE_ID = "fr_work_type_id";
  @SerializedName(SERIALIZED_NAME_FR_WORK_TYPE_ID)
  private Integer frWorkTypeId;

  public static final String SERIALIZED_NAME_COMPENSATION_IDS = "compensation_ids";
  @SerializedName(SERIALIZED_NAME_COMPENSATION_IDS)
  private List<Integer> compensationIds = null;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public ContractVersion() {
  }

  public ContractVersion id(Integer id) {
    
    
    
    
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


  public ContractVersion employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public ContractVersion country(String country) {
    
    
    
    
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "es", value = "")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    
    
    
    this.country = country;
  }


  public ContractVersion jobTitle(String jobTitle) {
    
    
    
    
    this.jobTitle = jobTitle;
    return this;
  }

   /**
   * Get jobTitle
   * @return jobTitle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Software Engineer", value = "")

  public String getJobTitle() {
    return jobTitle;
  }


  public void setJobTitle(String jobTitle) {
    
    
    
    this.jobTitle = jobTitle;
  }


  public ContractVersion role(String role) {
    
    
    
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Backend Engineer", value = "")

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    
    
    
    this.role = role;
  }


  public ContractVersion level(String level) {
    
    
    
    
    this.level = level;
    return this;
  }

   /**
   * Get level
   * @return level
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Junior", value = "")

  public String getLevel() {
    return level;
  }


  public void setLevel(String level) {
    
    
    
    this.level = level;
  }


  public ContractVersion effectiveOn(String effectiveOn) {
    
    
    
    
    this.effectiveOn = effectiveOn;
    return this;
  }

   /**
   * Get effectiveOn
   * @return effectiveOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-02-13", value = "")

  public String getEffectiveOn() {
    return effectiveOn;
  }


  public void setEffectiveOn(String effectiveOn) {
    
    
    
    this.effectiveOn = effectiveOn;
  }


  public ContractVersion startsOn(String startsOn) {
    
    
    
    
    this.startsOn = startsOn;
    return this;
  }

   /**
   * Get startsOn
   * @return startsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-02-19", value = "")

  public String getStartsOn() {
    return startsOn;
  }


  public void setStartsOn(String startsOn) {
    
    
    
    this.startsOn = startsOn;
  }


  public ContractVersion endsOn(String endsOn) {
    
    
    
    
    this.endsOn = endsOn;
    return this;
  }

   /**
   * Get endsOn
   * @return endsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2023-02-19", value = "")

  public String getEndsOn() {
    return endsOn;
  }


  public void setEndsOn(String endsOn) {
    
    
    
    this.endsOn = endsOn;
  }


  public ContractVersion hasPayroll(Boolean hasPayroll) {
    
    
    
    
    this.hasPayroll = hasPayroll;
    return this;
  }

   /**
   * Get hasPayroll
   * @return hasPayroll
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getHasPayroll() {
    return hasPayroll;
  }


  public void setHasPayroll(Boolean hasPayroll) {
    
    
    
    this.hasPayroll = hasPayroll;
  }


  public ContractVersion salaryAmount(Integer salaryAmount) {
    
    
    
    
    this.salaryAmount = salaryAmount;
    return this;
  }

   /**
   * Get salaryAmount
   * @return salaryAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "45000", value = "")

  public Integer getSalaryAmount() {
    return salaryAmount;
  }


  public void setSalaryAmount(Integer salaryAmount) {
    
    
    
    this.salaryAmount = salaryAmount;
  }


  public ContractVersion salaryFrequency(String salaryFrequency) {
    
    
    
    
    this.salaryFrequency = salaryFrequency;
    return this;
  }

   /**
   * Get salaryFrequency
   * @return salaryFrequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "monthly", value = "")

  public String getSalaryFrequency() {
    return salaryFrequency;
  }


  public void setSalaryFrequency(String salaryFrequency) {
    
    
    
    this.salaryFrequency = salaryFrequency;
  }


  public ContractVersion workingWeekDays(String workingWeekDays) {
    
    
    
    
    this.workingWeekDays = workingWeekDays;
    return this;
  }

   /**
   * Get workingWeekDays
   * @return workingWeekDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWorkingWeekDays() {
    return workingWeekDays;
  }


  public void setWorkingWeekDays(String workingWeekDays) {
    
    
    
    this.workingWeekDays = workingWeekDays;
  }


  public ContractVersion workingHours(Integer workingHours) {
    
    
    
    
    this.workingHours = workingHours;
    return this;
  }

   /**
   * Get workingHours
   * @return workingHours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "8", value = "")

  public Integer getWorkingHours() {
    return workingHours;
  }


  public void setWorkingHours(Integer workingHours) {
    
    
    
    this.workingHours = workingHours;
  }


  public ContractVersion workingHoursFrequency(String workingHoursFrequency) {
    
    
    
    
    this.workingHoursFrequency = workingHoursFrequency;
    return this;
  }

   /**
   * Get workingHoursFrequency
   * @return workingHoursFrequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWorkingHoursFrequency() {
    return workingHoursFrequency;
  }


  public void setWorkingHoursFrequency(String workingHoursFrequency) {
    
    
    
    this.workingHoursFrequency = workingHoursFrequency;
  }


  public ContractVersion esHasTeleworkingContract(Boolean esHasTeleworkingContract) {
    
    
    
    
    this.esHasTeleworkingContract = esHasTeleworkingContract;
    return this;
  }

   /**
   * Get esHasTeleworkingContract
   * @return esHasTeleworkingContract
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getEsHasTeleworkingContract() {
    return esHasTeleworkingContract;
  }


  public void setEsHasTeleworkingContract(Boolean esHasTeleworkingContract) {
    
    
    
    this.esHasTeleworkingContract = esHasTeleworkingContract;
  }


  public ContractVersion esCotizationGroup(Integer esCotizationGroup) {
    
    
    
    
    this.esCotizationGroup = esCotizationGroup;
    return this;
  }

   /**
   * Get esCotizationGroup
   * @return esCotizationGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getEsCotizationGroup() {
    return esCotizationGroup;
  }


  public void setEsCotizationGroup(Integer esCotizationGroup) {
    
    
    
    this.esCotizationGroup = esCotizationGroup;
  }


  public ContractVersion esContractObservations(String esContractObservations) {
    
    
    
    
    this.esContractObservations = esContractObservations;
    return this;
  }

   /**
   * Get esContractObservations
   * @return esContractObservations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "8", value = "")

  public String getEsContractObservations() {
    return esContractObservations;
  }


  public void setEsContractObservations(String esContractObservations) {
    
    
    
    this.esContractObservations = esContractObservations;
  }


  public ContractVersion esJobDescription(String esJobDescription) {
    
    
    
    
    this.esJobDescription = esJobDescription;
    return this;
  }

   /**
   * Get esJobDescription
   * @return esJobDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Junior software engineer", value = "")

  public String getEsJobDescription() {
    return esJobDescription;
  }


  public void setEsJobDescription(String esJobDescription) {
    
    
    
    this.esJobDescription = esJobDescription;
  }


  public ContractVersion esTrialPeriodEndsOn(String esTrialPeriodEndsOn) {
    
    
    
    
    this.esTrialPeriodEndsOn = esTrialPeriodEndsOn;
    return this;
  }

   /**
   * Get esTrialPeriodEndsOn
   * @return esTrialPeriodEndsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEsTrialPeriodEndsOn() {
    return esTrialPeriodEndsOn;
  }


  public void setEsTrialPeriodEndsOn(String esTrialPeriodEndsOn) {
    
    
    
    this.esTrialPeriodEndsOn = esTrialPeriodEndsOn;
  }


  public ContractVersion esContractTypeId(Integer esContractTypeId) {
    
    
    
    
    this.esContractTypeId = esContractTypeId;
    return this;
  }

   /**
   * Get esContractTypeId
   * @return esContractTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getEsContractTypeId() {
    return esContractTypeId;
  }


  public void setEsContractTypeId(Integer esContractTypeId) {
    
    
    
    this.esContractTypeId = esContractTypeId;
  }


  public ContractVersion esWorkingDayTypeId(Integer esWorkingDayTypeId) {
    
    
    
    
    this.esWorkingDayTypeId = esWorkingDayTypeId;
    return this;
  }

   /**
   * Get esWorkingDayTypeId
   * @return esWorkingDayTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "8", value = "")

  public Integer getEsWorkingDayTypeId() {
    return esWorkingDayTypeId;
  }


  public void setEsWorkingDayTypeId(Integer esWorkingDayTypeId) {
    
    
    
    this.esWorkingDayTypeId = esWorkingDayTypeId;
  }


  public ContractVersion esEducationLevelId(Integer esEducationLevelId) {
    
    
    
    
    this.esEducationLevelId = esEducationLevelId;
    return this;
  }

   /**
   * Get esEducationLevelId
   * @return esEducationLevelId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getEsEducationLevelId() {
    return esEducationLevelId;
  }


  public void setEsEducationLevelId(Integer esEducationLevelId) {
    
    
    
    this.esEducationLevelId = esEducationLevelId;
  }


  public ContractVersion esProfessionalCategoryId(Integer esProfessionalCategoryId) {
    
    
    
    
    this.esProfessionalCategoryId = esProfessionalCategoryId;
    return this;
  }

   /**
   * Get esProfessionalCategoryId
   * @return esProfessionalCategoryId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "15", value = "")

  public Integer getEsProfessionalCategoryId() {
    return esProfessionalCategoryId;
  }


  public void setEsProfessionalCategoryId(Integer esProfessionalCategoryId) {
    
    
    
    this.esProfessionalCategoryId = esProfessionalCategoryId;
  }


  public ContractVersion frEmployeeType(String frEmployeeType) {
    
    
    
    
    this.frEmployeeType = frEmployeeType;
    return this;
  }

   /**
   * Get frEmployeeType
   * @return frEmployeeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getFrEmployeeType() {
    return frEmployeeType;
  }


  public void setFrEmployeeType(String frEmployeeType) {
    
    
    
    this.frEmployeeType = frEmployeeType;
  }


  public ContractVersion frForfaitJours(Boolean frForfaitJours) {
    
    
    
    
    this.frForfaitJours = frForfaitJours;
    return this;
  }

   /**
   * Get frForfaitJours
   * @return frForfaitJours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getFrForfaitJours() {
    return frForfaitJours;
  }


  public void setFrForfaitJours(Boolean frForfaitJours) {
    
    
    
    this.frForfaitJours = frForfaitJours;
  }


  public ContractVersion frJoursParAn(Integer frJoursParAn) {
    
    
    
    
    this.frJoursParAn = frJoursParAn;
    return this;
  }

   /**
   * Get frJoursParAn
   * @return frJoursParAn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrJoursParAn() {
    return frJoursParAn;
  }


  public void setFrJoursParAn(Integer frJoursParAn) {
    
    
    
    this.frJoursParAn = frJoursParAn;
  }


  public ContractVersion frCoefficient(Integer frCoefficient) {
    
    
    
    
    this.frCoefficient = frCoefficient;
    return this;
  }

   /**
   * Get frCoefficient
   * @return frCoefficient
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrCoefficient() {
    return frCoefficient;
  }


  public void setFrCoefficient(Integer frCoefficient) {
    
    
    
    this.frCoefficient = frCoefficient;
  }


  public ContractVersion frContractTypeId(Integer frContractTypeId) {
    
    
    
    
    this.frContractTypeId = frContractTypeId;
    return this;
  }

   /**
   * Get frContractTypeId
   * @return frContractTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrContractTypeId() {
    return frContractTypeId;
  }


  public void setFrContractTypeId(Integer frContractTypeId) {
    
    
    
    this.frContractTypeId = frContractTypeId;
  }


  public ContractVersion frLevelId(Integer frLevelId) {
    
    
    
    
    this.frLevelId = frLevelId;
    return this;
  }

   /**
   * Get frLevelId
   * @return frLevelId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrLevelId() {
    return frLevelId;
  }


  public void setFrLevelId(Integer frLevelId) {
    
    
    
    this.frLevelId = frLevelId;
  }


  public ContractVersion frStepId(Integer frStepId) {
    
    
    
    
    this.frStepId = frStepId;
    return this;
  }

   /**
   * Get frStepId
   * @return frStepId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrStepId() {
    return frStepId;
  }


  public void setFrStepId(Integer frStepId) {
    
    
    
    this.frStepId = frStepId;
  }


  public ContractVersion frMutualId(Integer frMutualId) {
    
    
    
    
    this.frMutualId = frMutualId;
    return this;
  }

   /**
   * Get frMutualId
   * @return frMutualId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrMutualId() {
    return frMutualId;
  }


  public void setFrMutualId(Integer frMutualId) {
    
    
    
    this.frMutualId = frMutualId;
  }


  public ContractVersion frProfessionalCategoryId(Integer frProfessionalCategoryId) {
    
    
    
    
    this.frProfessionalCategoryId = frProfessionalCategoryId;
    return this;
  }

   /**
   * Get frProfessionalCategoryId
   * @return frProfessionalCategoryId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrProfessionalCategoryId() {
    return frProfessionalCategoryId;
  }


  public void setFrProfessionalCategoryId(Integer frProfessionalCategoryId) {
    
    
    
    this.frProfessionalCategoryId = frProfessionalCategoryId;
  }


  public ContractVersion frWorkTypeId(Integer frWorkTypeId) {
    
    
    
    
    this.frWorkTypeId = frWorkTypeId;
    return this;
  }

   /**
   * Get frWorkTypeId
   * @return frWorkTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrWorkTypeId() {
    return frWorkTypeId;
  }


  public void setFrWorkTypeId(Integer frWorkTypeId) {
    
    
    
    this.frWorkTypeId = frWorkTypeId;
  }


  public ContractVersion compensationIds(List<Integer> compensationIds) {
    
    
    
    
    this.compensationIds = compensationIds;
    return this;
  }

  public ContractVersion addCompensationIdsItem(Integer compensationIdsItem) {
    if (this.compensationIds == null) {
      this.compensationIds = new ArrayList<>();
    }
    this.compensationIds.add(compensationIdsItem);
    return this;
  }

   /**
   * Get compensationIds
   * @return compensationIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Integer> getCompensationIds() {
    return compensationIds;
  }


  public void setCompensationIds(List<Integer> compensationIds) {
    
    
    
    this.compensationIds = compensationIds;
  }


  public ContractVersion createdAt(String createdAt) {
    
    
    
    
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


  public ContractVersion updatedAt(String updatedAt) {
    
    
    
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-24T18:39:03.515Z", value = "")

  public String getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(String updatedAt) {
    
    
    
    this.updatedAt = updatedAt;
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
   * @return the ContractVersion instance itself
   */
  public ContractVersion putAdditionalProperty(String key, Object value) {
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
    ContractVersion contractVersion = (ContractVersion) o;
    return Objects.equals(this.id, contractVersion.id) &&
        Objects.equals(this.employeeId, contractVersion.employeeId) &&
        Objects.equals(this.country, contractVersion.country) &&
        Objects.equals(this.jobTitle, contractVersion.jobTitle) &&
        Objects.equals(this.role, contractVersion.role) &&
        Objects.equals(this.level, contractVersion.level) &&
        Objects.equals(this.effectiveOn, contractVersion.effectiveOn) &&
        Objects.equals(this.startsOn, contractVersion.startsOn) &&
        Objects.equals(this.endsOn, contractVersion.endsOn) &&
        Objects.equals(this.hasPayroll, contractVersion.hasPayroll) &&
        Objects.equals(this.salaryAmount, contractVersion.salaryAmount) &&
        Objects.equals(this.salaryFrequency, contractVersion.salaryFrequency) &&
        Objects.equals(this.workingWeekDays, contractVersion.workingWeekDays) &&
        Objects.equals(this.workingHours, contractVersion.workingHours) &&
        Objects.equals(this.workingHoursFrequency, contractVersion.workingHoursFrequency) &&
        Objects.equals(this.esHasTeleworkingContract, contractVersion.esHasTeleworkingContract) &&
        Objects.equals(this.esCotizationGroup, contractVersion.esCotizationGroup) &&
        Objects.equals(this.esContractObservations, contractVersion.esContractObservations) &&
        Objects.equals(this.esJobDescription, contractVersion.esJobDescription) &&
        Objects.equals(this.esTrialPeriodEndsOn, contractVersion.esTrialPeriodEndsOn) &&
        Objects.equals(this.esContractTypeId, contractVersion.esContractTypeId) &&
        Objects.equals(this.esWorkingDayTypeId, contractVersion.esWorkingDayTypeId) &&
        Objects.equals(this.esEducationLevelId, contractVersion.esEducationLevelId) &&
        Objects.equals(this.esProfessionalCategoryId, contractVersion.esProfessionalCategoryId) &&
        Objects.equals(this.frEmployeeType, contractVersion.frEmployeeType) &&
        Objects.equals(this.frForfaitJours, contractVersion.frForfaitJours) &&
        Objects.equals(this.frJoursParAn, contractVersion.frJoursParAn) &&
        Objects.equals(this.frCoefficient, contractVersion.frCoefficient) &&
        Objects.equals(this.frContractTypeId, contractVersion.frContractTypeId) &&
        Objects.equals(this.frLevelId, contractVersion.frLevelId) &&
        Objects.equals(this.frStepId, contractVersion.frStepId) &&
        Objects.equals(this.frMutualId, contractVersion.frMutualId) &&
        Objects.equals(this.frProfessionalCategoryId, contractVersion.frProfessionalCategoryId) &&
        Objects.equals(this.frWorkTypeId, contractVersion.frWorkTypeId) &&
        Objects.equals(this.compensationIds, contractVersion.compensationIds) &&
        Objects.equals(this.createdAt, contractVersion.createdAt) &&
        Objects.equals(this.updatedAt, contractVersion.updatedAt)&&
        Objects.equals(this.additionalProperties, contractVersion.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, employeeId, country, jobTitle, role, level, effectiveOn, startsOn, endsOn, hasPayroll, salaryAmount, salaryFrequency, workingWeekDays, workingHours, workingHoursFrequency, esHasTeleworkingContract, esCotizationGroup, esContractObservations, esJobDescription, esTrialPeriodEndsOn, esContractTypeId, esWorkingDayTypeId, esEducationLevelId, esProfessionalCategoryId, frEmployeeType, frForfaitJours, frJoursParAn, frCoefficient, frContractTypeId, frLevelId, frStepId, frMutualId, frProfessionalCategoryId, frWorkTypeId, compensationIds, createdAt, updatedAt, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContractVersion {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    effectiveOn: ").append(toIndentedString(effectiveOn)).append("\n");
    sb.append("    startsOn: ").append(toIndentedString(startsOn)).append("\n");
    sb.append("    endsOn: ").append(toIndentedString(endsOn)).append("\n");
    sb.append("    hasPayroll: ").append(toIndentedString(hasPayroll)).append("\n");
    sb.append("    salaryAmount: ").append(toIndentedString(salaryAmount)).append("\n");
    sb.append("    salaryFrequency: ").append(toIndentedString(salaryFrequency)).append("\n");
    sb.append("    workingWeekDays: ").append(toIndentedString(workingWeekDays)).append("\n");
    sb.append("    workingHours: ").append(toIndentedString(workingHours)).append("\n");
    sb.append("    workingHoursFrequency: ").append(toIndentedString(workingHoursFrequency)).append("\n");
    sb.append("    esHasTeleworkingContract: ").append(toIndentedString(esHasTeleworkingContract)).append("\n");
    sb.append("    esCotizationGroup: ").append(toIndentedString(esCotizationGroup)).append("\n");
    sb.append("    esContractObservations: ").append(toIndentedString(esContractObservations)).append("\n");
    sb.append("    esJobDescription: ").append(toIndentedString(esJobDescription)).append("\n");
    sb.append("    esTrialPeriodEndsOn: ").append(toIndentedString(esTrialPeriodEndsOn)).append("\n");
    sb.append("    esContractTypeId: ").append(toIndentedString(esContractTypeId)).append("\n");
    sb.append("    esWorkingDayTypeId: ").append(toIndentedString(esWorkingDayTypeId)).append("\n");
    sb.append("    esEducationLevelId: ").append(toIndentedString(esEducationLevelId)).append("\n");
    sb.append("    esProfessionalCategoryId: ").append(toIndentedString(esProfessionalCategoryId)).append("\n");
    sb.append("    frEmployeeType: ").append(toIndentedString(frEmployeeType)).append("\n");
    sb.append("    frForfaitJours: ").append(toIndentedString(frForfaitJours)).append("\n");
    sb.append("    frJoursParAn: ").append(toIndentedString(frJoursParAn)).append("\n");
    sb.append("    frCoefficient: ").append(toIndentedString(frCoefficient)).append("\n");
    sb.append("    frContractTypeId: ").append(toIndentedString(frContractTypeId)).append("\n");
    sb.append("    frLevelId: ").append(toIndentedString(frLevelId)).append("\n");
    sb.append("    frStepId: ").append(toIndentedString(frStepId)).append("\n");
    sb.append("    frMutualId: ").append(toIndentedString(frMutualId)).append("\n");
    sb.append("    frProfessionalCategoryId: ").append(toIndentedString(frProfessionalCategoryId)).append("\n");
    sb.append("    frWorkTypeId: ").append(toIndentedString(frWorkTypeId)).append("\n");
    sb.append("    compensationIds: ").append(toIndentedString(compensationIds)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
    openapiFields.add("employee_id");
    openapiFields.add("country");
    openapiFields.add("job_title");
    openapiFields.add("role");
    openapiFields.add("level");
    openapiFields.add("effective_on");
    openapiFields.add("starts_on");
    openapiFields.add("ends_on");
    openapiFields.add("has_payroll");
    openapiFields.add("salary_amount");
    openapiFields.add("salary_frequency");
    openapiFields.add("working_week_days");
    openapiFields.add("working_hours");
    openapiFields.add("working_hours_frequency");
    openapiFields.add("es_has_teleworking_contract");
    openapiFields.add("es_cotization_group");
    openapiFields.add("es_contract_observations");
    openapiFields.add("es_job_description");
    openapiFields.add("es_trial_period_ends_on");
    openapiFields.add("es_contract_type_id");
    openapiFields.add("es_working_day_type_id");
    openapiFields.add("es_education_level_id");
    openapiFields.add("es_professional_category_id");
    openapiFields.add("fr_employee_type");
    openapiFields.add("fr_forfait_jours");
    openapiFields.add("fr_jours_par_an");
    openapiFields.add("fr_coefficient");
    openapiFields.add("fr_contract_type_id");
    openapiFields.add("fr_level_id");
    openapiFields.add("fr_step_id");
    openapiFields.add("fr_mutual_id");
    openapiFields.add("fr_professional_category_id");
    openapiFields.add("fr_work_type_id");
    openapiFields.add("compensation_ids");
    openapiFields.add("created_at");
    openapiFields.add("updated_at");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ContractVersion
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ContractVersion.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ContractVersion is not found in the empty JSON string", ContractVersion.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("country") != null && !jsonObj.get("country").isJsonNull()) && !jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
      if ((jsonObj.get("job_title") != null && !jsonObj.get("job_title").isJsonNull()) && !jsonObj.get("job_title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `job_title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("job_title").toString()));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
      if ((jsonObj.get("level") != null && !jsonObj.get("level").isJsonNull()) && !jsonObj.get("level").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `level` to be a primitive type in the JSON string but got `%s`", jsonObj.get("level").toString()));
      }
      if ((jsonObj.get("effective_on") != null && !jsonObj.get("effective_on").isJsonNull()) && !jsonObj.get("effective_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `effective_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("effective_on").toString()));
      }
      if ((jsonObj.get("starts_on") != null && !jsonObj.get("starts_on").isJsonNull()) && !jsonObj.get("starts_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `starts_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("starts_on").toString()));
      }
      if ((jsonObj.get("ends_on") != null && !jsonObj.get("ends_on").isJsonNull()) && !jsonObj.get("ends_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ends_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ends_on").toString()));
      }
      if ((jsonObj.get("salary_frequency") != null && !jsonObj.get("salary_frequency").isJsonNull()) && !jsonObj.get("salary_frequency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `salary_frequency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("salary_frequency").toString()));
      }
      if ((jsonObj.get("working_week_days") != null && !jsonObj.get("working_week_days").isJsonNull()) && !jsonObj.get("working_week_days").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `working_week_days` to be a primitive type in the JSON string but got `%s`", jsonObj.get("working_week_days").toString()));
      }
      if ((jsonObj.get("working_hours_frequency") != null && !jsonObj.get("working_hours_frequency").isJsonNull()) && !jsonObj.get("working_hours_frequency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `working_hours_frequency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("working_hours_frequency").toString()));
      }
      if ((jsonObj.get("es_contract_observations") != null && !jsonObj.get("es_contract_observations").isJsonNull()) && !jsonObj.get("es_contract_observations").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `es_contract_observations` to be a primitive type in the JSON string but got `%s`", jsonObj.get("es_contract_observations").toString()));
      }
      if ((jsonObj.get("es_job_description") != null && !jsonObj.get("es_job_description").isJsonNull()) && !jsonObj.get("es_job_description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `es_job_description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("es_job_description").toString()));
      }
      if ((jsonObj.get("es_trial_period_ends_on") != null && !jsonObj.get("es_trial_period_ends_on").isJsonNull()) && !jsonObj.get("es_trial_period_ends_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `es_trial_period_ends_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("es_trial_period_ends_on").toString()));
      }
      if ((jsonObj.get("fr_employee_type") != null && !jsonObj.get("fr_employee_type").isJsonNull()) && !jsonObj.get("fr_employee_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fr_employee_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fr_employee_type").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("compensation_ids") != null && !jsonObj.get("compensation_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `compensation_ids` to be an array in the JSON string but got `%s`", jsonObj.get("compensation_ids").toString()));
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if ((jsonObj.get("updated_at") != null && !jsonObj.get("updated_at").isJsonNull()) && !jsonObj.get("updated_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated_at").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ContractVersion.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ContractVersion' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ContractVersion> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ContractVersion.class));

       return (TypeAdapter<T>) new TypeAdapter<ContractVersion>() {
           @Override
           public void write(JsonWriter out, ContractVersion value) throws IOException {
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
           public ContractVersion read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ContractVersion instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ContractVersion given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ContractVersion
  * @throws IOException if the JSON string is invalid with respect to ContractVersion
  */
  public static ContractVersion fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ContractVersion.class);
  }

 /**
  * Convert an instance of ContractVersion to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


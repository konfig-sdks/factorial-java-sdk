

# PostJobPostingUpdateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**title** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**contractType** | [**ContractTypeEnum**](#ContractTypeEnum) |  |  [optional] |
|**remote** | **Boolean** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**scheduleType** | [**ScheduleTypeEnum**](#ScheduleTypeEnum) |  |  [optional] |
|**teamId** | **Integer** |  |  [optional] |
|**locationId** | **Integer** |  |  [optional] |
|**salaryFormat** | [**SalaryFormatEnum**](#SalaryFormatEnum) |  |  [optional] |
|**salaryFromAmountInCents** | **Integer** |  |  [optional] |
|**salaryToAmountInCents** | **Integer** |  |  [optional] |
|**cvRequirement** | [**CvRequirementEnum**](#CvRequirementEnum) |  |  [optional] |
|**coverLetterRequirement** | [**CoverLetterRequirementEnum**](#CoverLetterRequirementEnum) |  |  [optional] |
|**phoneRequirement** | [**PhoneRequirementEnum**](#PhoneRequirementEnum) |  |  [optional] |
|**photoRequirement** | [**PhotoRequirementEnum**](#PhotoRequirementEnum) |  |  [optional] |



## Enum: ContractTypeEnum

| Name | Value |
|---- | -----|
| INDEFINITE | &quot;indefinite&quot; |
| TEMPORARY | &quot;temporary&quot; |
| FIXED_DISCONTINUED | &quot;fixed_discontinued&quot; |
| INTERN | &quot;intern&quot; |
| TRAINING | &quot;training&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;draft&quot; |
| PUBLISHED | &quot;published&quot; |
| UNLISTED | &quot;unlisted&quot; |
| ARCHIVED | &quot;archived&quot; |
| CANCELLED | &quot;cancelled&quot; |



## Enum: ScheduleTypeEnum

| Name | Value |
|---- | -----|
| FULL_TIME | &quot;full_time&quot; |
| PART_TIME | &quot;part_time&quot; |



## Enum: SalaryFormatEnum

| Name | Value |
|---- | -----|
| RANGE | &quot;range&quot; |
| FIXED_AMOUNT | &quot;fixed_amount&quot; |



## Enum: CvRequirementEnum

| Name | Value |
|---- | -----|
| MANDATORY | &quot;mandatory&quot; |
| OPTIONAL | &quot;optional&quot; |
| DO_NOT_ASK | &quot;do_not_ask&quot; |



## Enum: CoverLetterRequirementEnum

| Name | Value |
|---- | -----|
| MANDATORY | &quot;mandatory&quot; |
| OPTIONAL | &quot;optional&quot; |
| DO_NOT_ASK | &quot;do_not_ask&quot; |



## Enum: PhoneRequirementEnum

| Name | Value |
|---- | -----|
| MANDATORY | &quot;mandatory&quot; |
| OPTIONAL | &quot;optional&quot; |
| DO_NOT_ASK | &quot;do_not_ask&quot; |



## Enum: PhotoRequirementEnum

| Name | Value |
|---- | -----|
| MANDATORY | &quot;mandatory&quot; |
| OPTIONAL | &quot;optional&quot; |
| DO_NOT_ASK | &quot;do_not_ask&quot; |




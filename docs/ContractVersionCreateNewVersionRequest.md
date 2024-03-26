

# ContractVersionCreateNewVersionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**effectiveOn** | **String** |  |  [optional] |
|**employeeId** | **Integer** |  |  [optional] |
|**startsOn** | **String** |  |  [optional] |
|**endsOn** | **String** |  |  [optional] |
|**workingHoursFrequency** | [**WorkingHoursFrequencyEnum**](#WorkingHoursFrequencyEnum) |  |  [optional] |
|**workingWeekDays** | **String** |  |  [optional] |
|**workingHours** | **Integer** |  |  [optional] |
|**salaryFrequency** | [**SalaryFrequencyEnum**](#SalaryFrequencyEnum) |  |  [optional] |
|**salaryAmount** | **Integer** |  |  [optional] |
|**jobTitle** | **String** |  |  [optional] |



## Enum: WorkingHoursFrequencyEnum

| Name | Value |
|---- | -----|
| WEEK | &quot;week&quot; |
| DAY | &quot;day&quot; |
| MONTH | &quot;month&quot; |
| YEAR | &quot;year&quot; |



## Enum: SalaryFrequencyEnum

| Name | Value |
|---- | -----|
| YEARLY | &quot;yearly&quot; |
| MONTHLY | &quot;monthly&quot; |
| WEEKLY | &quot;weekly&quot; |
| HOURLY | &quot;hourly&quot; |
| DAILY | &quot;daily&quot; |




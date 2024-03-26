

# ApplicationCreateAtsApplicationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**atsJobPostingId** | **Integer** |  |  |
|**source** | [**SourceEnum**](#SourceEnum) |  |  |
|**medium** | **String** |  |  [optional] |
|**atsCandidateId** | **Integer** |  |  [optional] |
|**coverLetter** | **String** |  |  [optional] |
|**firstName** | **String** |  |  [optional] |
|**lastName** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**cv** | **File** |  |  [optional] |
|**photo** | **File** |  |  [optional] |
|**answers** | [**List&lt;ApplicationCreateAtsApplicationRequestAnswersInner&gt;**](ApplicationCreateAtsApplicationRequestAnswersInner.md) |  |  [optional] |



## Enum: SourceEnum

| Name | Value |
|---- | -----|
| INDEED | &quot;indeed&quot; |
| LINKEDIN | &quot;linkedin&quot; |
| JOBTARGET | &quot;JobTarget&quot; |
| MANUALLY_ADDED | &quot;manually_added&quot; |
| ORGANIC | &quot;organic&quot; |
| JOBPOSTING | &quot;jobposting&quot; |
| JOIN | &quot;JOIN&quot; |




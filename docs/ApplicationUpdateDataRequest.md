

# ApplicationUpdateDataRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**atsApplicationPhaseId** | **Integer** |  |  [optional] |
|**qualified** | **Boolean** |  |  [optional] |
|**firstName** | **String** |  |  [optional] |
|**lastName** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**personalUrl** | **String** |  |  [optional] |
|**disqualifiedReason** | [**DisqualifiedReasonEnum**](#DisqualifiedReasonEnum) |  |  [optional] |
|**cv** | **File** |  |  [optional] |
|**photo** | **File** |  |  [optional] |



## Enum: DisqualifiedReasonEnum

| Name | Value |
|---- | -----|
| NOT_A_FIT | &quot;not_a_fit&quot; |
| SELF_DISQUALIFIED | &quot;self_disqualified&quot; |
| SALARY | &quot;salary&quot; |
| OTHER_REASON | &quot;other_reason&quot; |
| UNDERQUALIFIED | &quot;underqualified&quot; |
| OFFER_NOT_ACCEPTED | &quot;offer_not_accepted&quot; |
| OTHER_OFFER | &quot;other_offer&quot; |
| NO_RESPONSE | &quot;no_response&quot; |






# PostCreateNewPostRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**title** | **String** |  |  |
|**description** | **String** |  |  |
|**postsGroupId** | **Integer** |  |  |
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**publishedAt** | **String** |  |  |
|**starsAt** | **String** |  |  [optional] |
|**endsAt** | **String** |  |  [optional] |
|**location** | **String** |  |  [optional] |
|**targetId** | **Integer** |  |  [optional] |
|**sendNotifications** | **Boolean** |  |  [optional] |
|**image** | **File** |  |  [optional] |
|**allowCommentsAndReactions** | **Boolean** |  |  [optional] |
|**attachments** | **File** |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EVENT | &quot;event&quot; |
| ANNOUNCEMENT | &quot;announcement&quot; |
| FIRST_DAY | &quot;first_day&quot; |
| BIRTHDAY | &quot;birthday&quot; |
| WORKIVERSARY | &quot;workiversary&quot; |




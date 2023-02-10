Feature: JsonPlaceHolder
  @JPlace
  Scenario Outline: Get Specific Comment
    Given JsonPlaceHolder is up and running
    When Get request is send to get a specific comment with "<id>"
    Then Specific comment details with "<id>", "<name>", "<email>" is returned with status code of 200
    Examples:
      | id | name                        |email                       |
      | 1  | id labore ex et quam laborum|Eliseo@gardner.biz          |

  @JPlace
  Scenario Outline: Create Comment
    Given JsonPlaceHolder is up and running
    When I create a new comment with "<postId>", "<name>", "<email>", and "<body>"
    Then Specific comment details with "<postId>", "<name>", "<email>" and "<body>" is returned with status code of 201
    Examples:
      | postId | name            |email                       |body            |
      | 1      |Lateef Abdulsalam|abdulsalam1220@gardner.biz  |I like this post|


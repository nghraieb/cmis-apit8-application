Feature: Circuit Switch
  Scenario: create circuit switch request and get result
	Given I create a request
	When I get the created request
	Then I Should have a request 
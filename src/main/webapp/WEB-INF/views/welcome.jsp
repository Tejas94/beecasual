<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<script src="resources/js/angular.min.js" ></script>
<script src="resources/js/ui-bootstrap.js" ></script>
   <link rel="stylesheet" href="resources/css/bootstrap-combined.css" media="screen">
   <script>
		angular.module('myApp', ['ui.bootstrap']);

		 var myApp=angular.module('myApp').controller('TypeaheadCtrl', function($scope) {

			  var _selected;

			  $scope.selected = undefined;
			  $scope.states = [${categoryList}];
			});</script>
   <style type="text/css">
    .typeahead-demo .custom-popup-wrapper {
    position: absolute;
    top: 100%;
    left: 0;
    z-index: 1000;
    display: none;
    background-color: #f9f9f9;
  }

  .typeahead-demo .custom-popup-wrapper > .message {
    padding: 10px 20px;
    border-bottom: 1px solid #ddd;
    color: #868686;
  }

  .typeahead-demo .custom-popup-wrapper > .dropdown-menu {
    position: static;
    float: none;
    display: block;
    min-width: 160px;
    background-color: transparent;
    border: none;
    border-radius: 0;
    box-shadow: none;
  }
   </style>
	 
</head>
<body>
<div ng-app="myApp">
    <div class='container-fluid typeahead-demo' ng-controller="TypeaheadCtrl">

    <h4>Static arrays</h4>
    <pre>Model: {{selected | json}}</pre>
    <input type="text" ng-model="selected" uib-typeahead="state for state in states | filter:$viewValue | limitTo:8" class="form-control">
</div>
</body>
</html>
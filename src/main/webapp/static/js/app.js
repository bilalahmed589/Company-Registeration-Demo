'use strict';

var App = angular.module('customerApp',[]);

App.directive('owner-directive', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attr, mCtrl) {
        	console.log("Here and there");
            function myValidation(value) {
                console.log("Here");
            	if (value.indexOf("e") > -1) {
                    mCtrl.$setValidity('charE', true);
                } else {
                    mCtrl.$setValidity('charE', false);
                }
                return value;
            }
            mCtrl.$parsers.push(myValidation);
        }
    };
});



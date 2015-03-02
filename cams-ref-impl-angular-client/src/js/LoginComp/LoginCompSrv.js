'use strict';

//
// Service factory for the view main
//
angular.module("mainApp").factory("LoginCompSrv", ["$http", function ($http) {

	  /**
	   * Converts an object to x-www-form-urlencoded serialization.
	   * @param {Object} obj
	   * @return {String}
	   */ 
	  var param = function(obj) {
	    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;
	      
	    for(name in obj) {
	      value = obj[name];
	        
	      if(value instanceof Array) {
	        for(i=0; i<value.length; ++i) {
	          subValue = value[i];
	          fullSubName = name + '[' + i + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value instanceof Object) {
	        for(subName in value) {
	          subValue = value[subName];
	          fullSubName = name + '[' + subName + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value !== undefined && value !== null)
	        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	    }
	      
	    return query.length ? query.substr(0, query.length - 1) : query;
	  };

    var LoginCompSrv = {};
		
	// Calling service operation 	
	LoginCompSrv.LoadLogin = function () {
		return $http.get("/user");
	};
		
	// Calling service operation LoginUser
	LoginCompSrv.LoginUser = function (loginSession) {
		var credentials = {username: loginSession.signon, password: loginSession.password};
		return $http.post('login', param(credentials), {
			headers: {
				"content-type" : "application/x-www-form-urlencoded;charset=utf-8"
			}
		});
	};
		
	// Calling service operation LogoutUser
	LoginCompSrv.LogoutUser = function () {
		return $http.post('logout', {});
	};

    return LoginCompSrv;
}]);

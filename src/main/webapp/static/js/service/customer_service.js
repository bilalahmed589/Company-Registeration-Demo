'use strict';

App.factory('CustomerService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllUsers: function() {
					return $http.get('/customer/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createUser: function(user){
					return $http.post('/customer/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		   createBeneficalOwner: function(id){
				return $http.post('/customer/'+ id + "/beneficialOwner/")
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while creating user');
									return $q.reject(errResponse);
								}
						);
	    },
		    
		    updateUser: function(user, id){
					return $http.put('/customer/'+id, user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
			
			
			loadCustomer: function(id){
				return $http.get('/customer/'+id )
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while updating user');
									return $q.reject(errResponse);
								}
						);
		}
		
	};

}]);

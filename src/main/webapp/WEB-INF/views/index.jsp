<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Company Registration</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="customerApp" class="ng-cloak">
      <div class="generic-container" ng-controller="CustomerController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Company Registration</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.customer.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input ng-show="!isDetail" type="text" ng-model="ctrl.customer.username" name="uname" class="username form-control input-sm" placeholder="Enter your name" required />
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.username"></span>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address</label>
                              <div class="col-md-7">
                                  <input ng-show="!isDetail" name="address" type="text" ng-model="ctrl.customer.address" class="form-control input-sm" placeholder="Enter your Address." required/>
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.address"></span>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                  	<span ng-show="myForm.address.$error.required">This is a required field</span>
                                  </div>	
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">City</label>
                              <div class="col-md-7">
                                  <input ng-show="!isDetail" name="city" type="text" ng-model="ctrl.customer.city" class="form-control input-sm" placeholder="Enter your City." required/>
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.city"></span>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                  	<span ng-show="myForm.city.$error.required">This is a required field</span>
                                  </div>	
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Country</label>
                              <div class="col-md-7">
                                  <!-- <input ng-show="!isDetail" type="text" ng-model="ctrl.customer.country" class="form-control input-sm" placeholder="Enter your Country."/>-->
                                    <select name="country" ng-show="!isDetail" ng-model="ctrl.customer.country" class="form-control input-sm" required>
    									<option value="">-- Select a Country --</option>
    									<option ng-repeat="country in countries" value="{{country.name}}">{{country.name}}</option>
  									</select>
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.country"></span>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                  	<span ng-show="myForm.country.$error.required">This is a required field</span>
                                  </div>	
                              </div>
                          </div>
                      </div>                      

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Email</label>
                              <div class="col-md-7">
                                  <input ng-show="!isDetail" type="email" ng-model="ctrl.customer.email" name="email" class="email form-control input-sm" placeholder="Enter your Email"/>
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.email"></span>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Phone</label>
                              <div class="col-md-7">
                                  <input ng-show="!isDetail" type="input" ng-model="ctrl.customer.phone" name="phonce" class="email form-control input-sm" placeholder="Enter your Phone"/>
                                  <span ng-show="isDetail" ng-bind="ctrl.customer.phone"></span>
                              </div>
                          </div>
                      </div>

                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Beneficial Owner</label>
                             <div class="col-md-7">
                              	<fieldset  data-ng-repeat="owner in ctrl.customer.owners">
                              		<span>
                              			<input name="owner" ng-show="!isDetail" type="text" ng-model="owner.ownerName" class="" placeholder="Enter companyOwner." required owner-directive="" />
                              			<button ng-show="!isDetail && !$first" class="remove" ng-click="removeOwner()">-</button>
                              		</span>
                              		<span ng-show="isDetail" ng-bind="owner.ownerName"></span>
                              	</fieldset>
                              	<div class="has-error" ng-show="myForm.$dirty">
                              		<span ng-show="myForm.owner.$error.required">This is a required field</span>
                              	</div>	
            						<!-- <input type="text" class="form-control" name="option[]" />-->
        					</div>
        					<div class="col-md-3" ng-show="!isDetail">
            					<button type="button" ng-click="addNewOwner()" class="btn btn-default addButton"><i class="fa fa-plus"></i></button>
        					</div>
                              <!-- <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.beneficialOwner" class="form-control input-sm" placeholder="Enter companyOwner."/>
                                  	<button type="submit" class="btn btn-primary">
  										<i class="btn btn-primary btn-sm glyphicon glyphicon-plus"></i> Add Another
									</button>
                              </div>-->
                          </div>
                      </div>
                       <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit" ng-show="!isDetail"  value="{{!ctrl.customer.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-show="!isDetail" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                              <button type="button" ng-show="isDetail" ng-click="ctrl.reset()" class="btn btn-warning btn-sm">Add New Company</button>
                          </div>
                      </div>
                      
                      
                  </form>
                 
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Companies </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Address</th>
                           	  <th>City</th>                              
                              <th>Email</th>
                              <th width="25%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.customers">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.username"></span></td>
                              <td><span ng-bind="u.address"></span></td>
                              <td><span ng-bind="u.city"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>
                              <button type="button" ng-click="ctrl.detail(u.id)" class="btn btn-info custom-width">Details</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/customer_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
  </body>
</html>
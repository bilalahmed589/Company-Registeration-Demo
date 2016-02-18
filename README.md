# Company-Registeration-Demo
1. This app provides a simple REST service for adding,updating and deletion of a company.
2. REST service in built on Spring MVC.
2. This app also contain the angularjs client for REST services.

Company
-------

Create Company                    POST /company

This creates a new company.

Sample Request:
{
   "id": null,
   "username": "Ahmed",
   "address": "Address",
   "city": "Karachi",
   "country": "Pakistan",
   "email": "bilalahmed589@yahoo.com",
   "phone": "03222900604",
   "owners": [
      {
         "ownerName": "Bilal"
      }
   ]
}

Responses:
Status 400 Returned if the input is invalid (e.g. missing required fields, invalid field values, and so forth).
Status 201 - application/jsonReturns a json of the created company.

Update Company                    Update /company
This updates an existing company
Sample Request:
{
   "id": 1,
   "username": "Ahmed",
   "address": "Address",
   "city": "Karachi",
   "country": "Pakistan",
   "email": "bilalahmed589@yahoo.com",
   "phone": "03222900604",
   "owners": [
      {
         "ownerName": "Bilal"
      }
   ]
}

Responses:
Status 400 Returned if the input is invalid (e.g. missing required fields, invalid field values, and so forth).
Status 201 - application/jsonReturns a json of the created company

Get All Companies                 Get /company
Get a company                     GET /company{id}
Add company owners                POST /company/{id}/beneficialOwner

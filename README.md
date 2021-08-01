# omniriocatalog

Start The Project with Maven
 Build The projct from: 	
 catalog>mvn clean install
 
RUN This JAR: from target Folder: java -jar catalogService.jar


1. POST: http://localhost:8080/addatribute

Accept:application/json
Content-Type:application/json

a. Request Body:
{
	
	"attributename":"color",
	"attributevalue":"BLACK"
}



Response:
{
    "id": 1,
    "attributename": "color",
    "attributevalue": "BLACK"
}

b. Request Body: 

{
	
	"attributename":"Size",
	"attributevalue":"34"
}

Response:{
    "id": 2,
    "attributename": "Size",
    "attributevalue": "34"
}

=====================

Validation 
{
	
	"attributename":"color",
	"attributevalue":""// blank Value
}
Response: 
{
    "message": "attributevalue: attributevalue may not be empty",
    "status": 400
}

2. Add Catagoty:
Post: http://localhost:8080/addcatalog

Accept:application/json
Content-Type:application/json

Request Body : 

{
    "catName": "BlackShirt",
    "attribute": [
        {
            "id": 1,
            "attributename": "color",
            "attributevalue": "BLACK"
        },
        {
            "id": 2,
            "attributename": "Size",
            "attributevalue": "34"
        }
    ]
}

Response:
{
    "catId": 1,
    "catName": "BlackShirt",
    "attribute": [
        {
            "id": 1,
            "attributename": "color",
            "attributevalue": "BLACK"
        },
        {
            "id": 2,
            "attributename": "Size",
            "attributevalue": "34"
        }
    ]
}

Validation:
{
    "catName": "",// Empty catagory
    "attribute": [
        {
            "id": 1,
            "attributename": "color",
            "attributevalue": "BLACK"
        },
        {
            "id": 3,
            "attributename": "Size",
            "attributevalue": "34"
        }
    ]
}
Response:
{
    "message": "catName: must not be empty",
    "status": 400
}


===================
3. Search Catagoty:
GET: http://localhost:8080/getcatagory/1

Response: {
    "catId": 1,
    "catName": "BlackShirt",
    "attribute": [
        {
            "id": 1,
            "attributename": "color",
            "attributevalue": "BLACK"
        },
        {
            "id": 3,
            "attributename": "Size",
            "attributevalue": "34"
        }
    ]
}


Validation:
http://localhost:8080/getcatagory/2   // No catagory availbale as 2

response:
{
    "message": "Error In catalog search",
    "status": 404
}


===============
4. Add product:

http://localhost:8080/product/create
Accept:application/json
Content-Type:application/json

Request:
{
    "productName": "BlackShirt34Size",
    "categoty": {
        "catId": 1,
        "catName": "BlackShirt",
        "attribute": [
            {
                "id": 1,
                "attributename": "color",
                "attributevalue": "BLACK"
            },
            {
                "id": 2,
                "attributename": "Size",
                "attributevalue": "34"
            }
        ]
    }
}


Response:

{
    "productid": "ppid_00002",
    "productName": "BlackShirt34Size",
    "categoty": {
        "catId": 1,
        "catName": "BlackShirt",
        "attribute": [
            {
                "id": 1,
                "attributename": "color",
                "attributevalue": "BLACK"
            },
            {
                "id": 2,
                "attributename": "Size",
                "attributevalue": "34"
            }
        ]
    }
}

Validation:

{
    "productName": "",//Empty Product name
    "categoty": {
        "catId": 1,
        "catName": "BlackShirt",
        "attribute": [
            {
                "id": 1,
                "attributename": "color",
                "attributevalue": "BLACK"
            },
            {
                "id": 2,
                "attributename": "Size",
                "attributevalue": "34"
            }
        ]
    }
}

:
{
    "message": "productName: must not be empty",
    "status": 400
}

===

Product Search:
GET: http://localhost:8080/getproduct/ppid_00002

Response:
{
    "productid": "ppid_00002",
    "productName": "BlackShirt34Size",
    "categoty": {
        "catId": 1,
        "catName": "BlackShirt",
        "attribute": [
            {
                "id": 1,
                "attributename": "color",
                "attributevalue": "BLACK"
            },
            {
                "id": 2,
                "attributename": "Size",
                "attributevalue": "34"
            }
        ]
    }
}

validation:
http://localhost:8080/getproduct/00001 /// No product 

{
    "message": "Error In product search",
    "status": 404
}



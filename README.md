# Angular 2 Todo App

This is a simple Todo application that uses Angular 2 as front end, Spring boot service as Middleware and MongoDb as Backend DB

## Getting Started

This application has two main folders 

1. Todo Angular 2 APP
2. Todo Spring boot service

### Prerequisites

For this application to run below are the pre requisite

1. NodeJs
2. STS

### Installing steps

##### Installing and Running Angular 2 app

Navingate main folder where you see both service and app folders

Execute below commands:

```
 cd angular-todo-app
 ```

Install node modules

```
 npm install
```

Run the application

```
 npm start
```

If you have angular cli  installed then you can do `ng serve` as well

Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

##### Starting the service

Now your app is up and running, its time to start the service. To start the service you need STS.

###### Import the project

=>

```
 Right click project explorer -> import -> Existing maven project
```

###### Build the artifact

=>

```
 Right click on project -> Run as -> maven clean
```
```
 Right click on project -> Run as -> maven install
```

###### Running the project

=> 

```
 Right click on project -> Run as -> Spring boot app
```


## Running the unit test cases or Angular 2 app 

To run the angular 2 test cases 

```
 npm test
```
or

Run `ng test` to execute the unit tests via Karma.

## Authors

**Shaik Fareed** : Full stack Java developer at GE
**Email id** : shaikfareed46@gmail.com


## Help

###### Please let me know if you have problems executing the app. 



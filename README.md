<div align="center">
        <h1> SPRING BOOT/ REST/ H2</h1>
</div>

## **1. Introduction**  

This project is an application/service in Spring Boot, with which REST queries are made to an in-memory database of type H2.

<a name="resources"></a>

## **2. Resources**

<a name="download"></a>

### **2.1 Download the project**

To download the project you have 2 ways:

- The first one is the simplest but the questionable one. - Go to the [project's repository](https://github.com/EnriqueRuizA/SpringBootH2Service) in Github. In the upper left part of the container where the project is located, it is shown a green button (code). If you click on it, a tab will appear. In the lower, part click on 'download zip' and a zip of the project will be downloaded.
- The second is the best option because we can play with the git infrastructure directly.
  - For this we need to have git installed on the computer.
  - Create a parent folder.
  - Go into the folder and check that it is empty.
  - Clone the repository with the use of the following command:

        git clone git@github.com:EnriqueRuizA/SpringBootH2Service.git

<a name="serve"></a>

### **2.2 Serve the project**

In order to be able to launch the project once downloaded :

* We need to install the dependencies of the components and packages

        mvn clean install
        
* Launch the project

* To see the contents of the table:

        http://localhost:8080/listaPrecios
        
![](https://raw.githubusercontent.com/EnriqueRuizA/SpringBootH2Service/main/img/listaPrecios.jpg "listaPrecios")

 or
 
        http://localhost:8080/h2
     
![](https://raw.githubusercontent.com/EnriqueRuizA/SpringBootH2Service/main/img/h2.jpg "h2")

        
* To see the result of the query in both the browser and Postman:

        http://localhost:8080/preciosFiltrados/2020-06-14%2000:00:00/35455/1

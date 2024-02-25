# RestAssured  
### Intro:  
- **Overview**: API testing, OAuth2.0 [Google/Spotify Live Examples] & Design Production Level Framework  
- This README is used for tutorial 

### Install and Config:  
1. Clone repository:  [https://github.com/doducduy20127477/RestAssured.git]  
2. Build and run project

### Table of Contents:
1. Getting Started  
   ```Test.java```
2. Logging  
   ```AutomateGet.java```:
   - Extract Response
   - Hamcrest assertions
   - Request Response logging
3. Handling Headers  
   ```AutomateHeaders.java```:
   - Multiple Headers
   - Extract Response Headers
4. Request Specification  
   ```RequestSpecificationExample.java```:
   - BDD to non-BDD
   - Request Specification Builder
   - Query Request Specification
5. Response Specification  
   ```ResponseSpecificationExample.java```: The same with   Request Specification
6. Automate POST, PUT and DELETE  
   ```AutomatePost.java```
   ```AutomatePut.java```
   ```AutomateDelete.java```
7. Send Request Payload Multiple Ways  
   **```DEPENDENCY: jackson-databind```**  
   ```AutomatePost.java```: Send as a file  
   ```RequestPayloadAsJsonArray.java```: Send JSON Array as a List **(charset UTF-8)**
8. Send Complex JSON as Request Payload ```RequestPayloadComplexJson.java```
9. Handling Request Parameters & Multipart Form Data  
   ```RequestParameters.java```
   - Single/Multiple Query Parameters
   - Path Parameter
   - Multipart Form Data
   - Form URL Encoding
10. File Upload and Download  
    ```UploadFile.java```
    ```UploadFile.java```
11. JSON Schema Validation  
    **```DEPENDENCY: json-schema-validator```**  
    ```JsonSchemaValidation.java```: delete dynamic variable in ```EchoGet.json``` **(id, example)**
12. Filters  
    ```Filters.java```: Log Request/Response Specification to file
13. Serialization and Deserialization: use **```jackson.databind.ObjectMapper```**
    ```JsonAPI_JSONObject.java``` ```JsonAPI_JSONArray.java```:   
    - Familiar with Jackson library explicitly
    - Jackson Object/Array Node      

    ```SimplePojoTest.java```: Serialize and Deserialize  
    ```WorkspacePojoTest.java```: Parameterize Tests using **```@DataProvider```**

### Technical and Tools:
1. Tech stack and tools:
* Rest Assured
* TestNG  
* Java  
* Allure Reports  
* Hamcrest  
* Jackson API  
* Lombok  
### Summary:  
### Reference:  



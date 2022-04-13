# Supplementary Specification

## Functionality

*Specifies the features that are not related to the use cases, namely: Audit, Reporting and Security.*

**<u> Security: </u>**
  
- **The interactions made by users (i.e. Administrator, Coordinator, Nurses, Receptionists, SNS Users) will proceed by an authentication using a password interface.** 

## Usability

*Evaluates the user interface. It has several subcategories, among them: error prevention; interface aesthetics and design; help and documentation; consistency and standards.*

**<u> Error Prevention: </u>**

- **The errors will be treated with exceptions, informing and alerting the user to input the correct information.**

**<u> Interface Aesthetics and Design: </u>**

- **Visually, the application will be very appealing to the eye, easy to understand and use.**
- **It will be divided in departments for each kind of user.**

**<u> Help and Documentation: </u>**

- **All classes are going to be documented correctly in order to everyone who has access to the code understand and manage it in the correct way.**
- **From the user point of view, it should be intuitive and simple to use.**

**<u> Consistency and Standards: </u>**

- **The program will be well-designed.**


## Reliability

*Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures.*

**<u> Frequency and Severity of Failure: </u>**

- **The application will be as complete as possible in order to prevent eventual failures, especially big ones which can crash the system.**

**<u> Possibility of Recovery: </u>**

- **The application will have multiple windows in order to be possible to exit in case of failure and get back to the menu.**
- **These windows will help to maintain the well-function of the application, making sure the found problem won´t interfere with other parts of the app.**

**<u> Possibility of Prediction: </u>**

- **Exceptions will be used to prevent possible mistakes.**

**<u> Accuracy: </u>**

- **The application will be as accurate in its calculations as possible.**

**<u> Average Time Between Failures :</u>**

- **This time will be the smallest possible.**


## Performance

*Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability.*

- **The code should be implemented thinking about the performance of the program, namely the requirements above referenced.**
- **The system should have responses in small time ranges. It should not consume a lot of memory.**
- **The application is supposed to start in a very short amount of time.**

## Supportability

*The supportability requirements gathers several characteristics, such as: testability, adaptability, maintainability, compatibility, configurability, installability, scalability and more.*

**<u> Testability: </u>**

- **Expects to use Test Driven Development in order to test the features and performance of the important classes.**

- **Unit tests are recommended.**

**<u> Adaptability: </u>**

- **It´s expected for the application to be easy to adapt to any hardware.**

**<u> Maintainability: </u>**

- **The application should be easy to do regular maintenance. For that is important that the code is well commented.**

**<u> Compatibility: </u>**

- **It should be compatible with many software.**

**<u> Configurability: </u>**

- **The system should be prepared to send SMS notifications.**

**<u> Instability: </u>**

- **The application will be easy to install.**

**<u> Scalability: </u>**

- **The application should not have problems in to change in to any size or scale.**

## +

### Design Constraints

*Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc.*

- **Adopt good design pratices and coding standards using GRASP patterns.**

- **The system should be prepared to send notifications to SNS Users.**
 

### Implementation Constraints

*Specifies or constraints the code or construction of a system such such as: mandatory standards/patterns, implementation languages, database integrity, resource limits, operating system.*

- **Implement the core software in Java**

- **Must follow a Test Driven Development approach.**

- **Intellij IDEA Educational Edition 2021.2.3 will be used to code.**
 

### Interface Constraints

*Specifies or constraints the features inherent to the interaction of the system being developed with other external systems.*

- **Implement using JavaFx.**

### Physical Constraints

*Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight.*

- **Should be used by a computer with an IDE that reads Java code.**
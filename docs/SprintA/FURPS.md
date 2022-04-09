# Supplementary specification

## Functionality

*Specifies the features that are not related to the use cases, namely: Audit, Reporting and Security.*

**Security:**
  
- **The interactions made by users (i.e. Administrator, Nurses, SNS Users, Receptionists) will proceed by an authentication using a password generator interface.** 

## Usability

*Evaluates the user interface. It has several subcategories, among them: error prevention; interface aesthetics and design; help and documentation; consistency and standards.*

**Error Prevention**

- **The errors will be treated with exceptions, informing and alerting the user to input the correct information.**

**Interface Aesthetics and Design**

- **Visually, the application will be very appealing to the eye, easy to understand and use.**
- **It will be divided in departments for each kind of user.**

**Help and Documentation**

- **All the classes are going to be documented correctly in order to everyone who has access to the code understand and manage it in the correct way.**

**Consistency and Standards**

- **All the GRASP Patterns should be used to ensure that the program is well designed.**


## Reliability
*Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures.*

**Frequency and Severity of Failure**

- **The application will be as complete as possible in order to prevent eventual failures.**

**Possibility of Recovery**

- **The application will have multiple "windows" in order to be possible to exit in case of failure and get back to the menu.**

**Possibility of Prediction**

- **Exceptions will be used to prevent possible mistakes.**

**Accuracy**

- **The application will be as accurate as possible.**

**Average Time Between Failures**

- **This time will be the smallest possible.**


## Performance

*Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability.*

- **The code should be implemented thinking about the performance of the program, namely the requirements above referenced.**
- **The system should have responses in small time ranges. It should not consume a lot of memory.**

## Supportability
*The supportability requirements gathers several characteristics, such as: testability, adaptability, maintainability, compatibility, configurability, installability, scalability and more.*

**Testability:**
- **Expects to use Test Driven Development in order to test the features and performance of the important classes.**
- **[...] unit tests are recommended [...]**

**Adaptability**
- **It´s expected th**

**Maintainability**
- **The application should be easy to do regular maintenance. For that is important that the code is well commented.**

**Compatibility**
- **It should be compatible with as many softwares as possible.**

**Configurability:**

- **The system should be prepared to send SMS notifications.**

**Instability**
- **The application will be easy to install.**

**Scalability**
- **The application should not have problems in to change in to any size or scale.**

## +

### Design Constraints

- **Adopt good design pratices and coding standards using GRASP patterns.**

- **The system should be prepared to send notifications to SNS Users.**
 

### Implementation Constraints

- **Implement the core software in Java**

- **Must follow a Test Driven Development approach.**
 

### Interface Constraints

- **Implement using JavaFx.**

### Physical Constraints

- **Should be used by a computer with an IDE that reads Java code.**
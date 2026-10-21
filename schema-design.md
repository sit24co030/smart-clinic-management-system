\# Smart Clinic Management System — Database Schema Design



\## 1. Overview



The Smart Clinic Management System uses MySQL to store patient, doctor, appointment, and prescription information. The Spring Boot application uses Java entity classes to represent the database records.



\## 2. Patient Table



| Column | Description |

|---|---|

| id | Primary key identifying the patient |

| name | Patient's name |

| email | Patient's email address |

| phone | Patient's phone number |



\## 3. Doctor Table



| Column | Description |

|---|---|

| id | Primary key identifying the doctor |

| name | Doctor's name |

| specialty | Doctor's medical specialty |

| email | Doctor's email address |

| availableTimes | Doctor's available time information |



\## 4. Appointment Table



| Column | Description |

|---|---|

| id | Primary key identifying the appointment |

| appointmentTime | Date and time of the appointment |

| status | Appointment status, such as BOOKED, CANCELLED, or COMPLETED |

| patient reference | Association with the patient |

| doctor reference | Association with the doctor |



\## 5. Prescription Table



| Column | Description |

|---|---|

| id | Primary key identifying the prescription |

| medication | Prescribed medication |

| dosage | Prescribed dosage |

| prescribedDate | Date the prescription was issued |

| instructions | Instructions associated with the prescription |

| patient reference | Association with the patient |

| doctor reference | Association with the doctor |



\## 6. Relationships



\- One patient can have multiple appointments.

\- One doctor can have multiple appointments.

\- A prescription is associated with a patient and a doctor.

\- Appointments and prescriptions reference the related patient and doctor records.



\## 7. Implementation Note



This document describes the logical database design. Actual SQL column types, constraints, table names, and foreign-key definitions should be confirmed against the entity mappings and the MySQL database.




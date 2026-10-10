# Reminder Service

One or two sentences: what it does and why you built it.

## Features
- (list what the API can do, in your words)

## Tech Stack
Java, Spring Boot, Spring Data JPA / Hibernate, MySQL, JavaMail, Spring Scheduling, Swagger/OpenAPI

## How It Works
Short explanation of the flow: client -> controller -> service -> repository -> MySQL,
and how the scheduler finds due reminders and sends the email.

## Setup
1. Create the database: `CREATE DATABASE reminder_db;`
2. Set these environment variables:
    - `MAIL_USERNAME` - your Gmail address
    - `MAIL_PASSWORD` - a Gmail App Password (not your normal password)
    - `DB_PASSWORD` - your MySQL password
3. Run `ReminderServiceApplication`.
4. Open Swagger: http://localhost:8080/swagger-ui/index.html

## API Endpoints
| Method | URL | Description |
|---|---|---|
| POST | /api/reminders | Create a reminder |
| GET | /api/reminders | List all reminders |
| GET | /api/reminders/{id} | Get one reminder |
| PUT | /api/reminders/{id} | Update a reminder |
| PATCH | /api/reminders/{id}/cancel | Cancel a reminder |
| DELETE | /api/reminders/{id} | Delete a reminder |

## Example Request
<img width="1277" height="805" alt="image" src="https://github.com/user-attachments/assets/3017b68d-5b0e-4fae-b18f-72ea6d3335ec" />


## Known Limitations
- (be honest, e.g. status SENT means the mail server accepted it, not that it was delivered)

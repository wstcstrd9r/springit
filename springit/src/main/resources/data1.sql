
yeah insert into link( id, created_by, created_date, last_modified_date,last_modified_by,title, url)
values(1,'Kiran', NOW(), NOW(), NOW(), 'Getting Started with Spring Boot 2', 'https://therealdanvega.com/spring-boot-2');

insert into comment
(id, created_by, created_date, last_modified_by, last_modified_date, body, link_id)
Values
(1, 'Kiran', NOW(), NOW(), NOW(), 'What an awesome idea for a course', 1)
CREATE TABLE book
(
    id        serial PRIMARY KEY,
    ISBN      varchar(255) NOT NULL,
    title     varchar(255),
    author    varchar(255) NOT NULL,
    publisher varchar(255) NOT NULL,
    genre     varchar(255) NOT NULL,
    page      integer,
    progress  integer,
    completed boolean      NOT NULL,
    rating    integer,
    addedby   varchar(255)
);

insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-6381-5268-2', 'Pilots Of Dusk', 'Shamas Driscoll', 'Oculus', 'Fantasy', 300, 0, FALSE, null);
insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-8949-4717-6', 'Heir Of The End', 'Samara Ellis', 'Weilly', 'Adventure', 450, 0, FALSE, null);
insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-6490-3442-2', 'Scourge Of History', 'Kelise Ferguson', 'Papyrus', 'Horror', 630, 0, FALSE, null);
insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-6266-0581-4', 'Technology Of The Oceans', 'Enzo Mcdermott', 'Pyramid', 'Science', 210, 0, FALSE, null);
insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-5844-8747-9', 'Bored By Time Travel', 'Elana Shah', 'Prosper', 'Science', 540, 0, FALSE, null);
insert into book (ISBN, TITLE, AUTHOR, PUBLISHER, GENRE, PAGE, PROGRESS, COMPLETED, RATING)
values ('0-3515-0094-4', 'Amusing Art', 'Hayden Cannon', 'Minor', 'Art', 180, 0, FALSE, null);

SELECT *
FROM book;
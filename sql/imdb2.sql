drop database if exists imdb2;
create database if not exists imdb2;
use imdb2;
-- create tables that contain reference data
create table if not exists imdb2.role (
    name varchar(255) not null,
    primary key (name)
);
create table if not exists imdb2.genre (
    name varchar(255) not null,
    primary key (name)
);
create table if not exists imdb2.content_rating (
	code varchar(255) not null,
    name varchar(255) not null,
    primary key (code)
);
-- create tables that contains entity data
create table if not exists imdb2.page (
	id int not null auto_increment,
    title varchar(255) not null,
    description varchar(255),
    image varchar(255),
    primary key (id)
);
create table if not exists imdb2.person (
    name varchar(255) not null,
    dob date,
    birth_place varchar(255),
    page_id int not null,
    foreign key (page_id) references imdb2.page(id),
    primary key (page_id)
);
create table if not exists imdb2.video (
    title varchar(255) not null,
    release_date date,
    rating float,
    content_rating_code varchar(255),
    page_id int not null,
    foreign key (page_id) references imdb2.page(id),
    foreign key (content_rating_code)  references imdb2.content_rating(code),
    primary key (page_id)
);
-- create tables that contain entity relationship info
create table if not exists imdb2.page_url (
	page_id int not null,
    url varchar(255) not null,
    foreign key (page_id)  references imdb2.page(id),
    primary key (url)
);
create table if not exists imdb2.person_role_video (
	person_id int not null,
    role_name varchar(255) not null,
    video_id int not null,
    foreign key (person_id) references imdb2.person(page_id),
    foreign key (role_name) references imdb2.role(name),
    foreign key (video_id) references imdb2.video(page_id),
    primary key (person_id, role_name, video_id)
);
create table if not exists imdb2.video_genre (
	video_id int not null,
    genre_name varchar(255) not null,
    foreign key (genre_name) references imdb2.genre(name),
    foreign key (video_id) references imdb2.video(page_id),
    primary key (video_id, genre_name)
);
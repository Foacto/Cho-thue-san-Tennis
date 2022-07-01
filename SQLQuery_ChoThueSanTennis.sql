create database ChoThue_SanTennis
go
use ChoThue_SanTennis

create table tblTennisCenter (
	Id int primary key not null,
	name nvarchar(50) not null,
	address nvarchar(255) not null,
	star int not null,
	des nvarchar(255) null)

create table tblService (
	IdService int IDENTITY(1, 1) primary key not null,
	name nvarchar(50) not null,
	type nvarchar(50) not null,
	price float(10) not null,
	unity nvarchar(10) not null,
	note nvarchar(255) null)

create table tblClient (
	IdClient int IDENTITY(1, 1) primary key not null,
	name nvarchar(50) not null,
	address nvarchar(255) not null,
	mail nvarchar(50) not null,
	tel nvarchar(20) not null,
	note nvarchar(255) null)

create table tblUser (
	IdUser int IDENTITY(1, 1) primary key not null,
	name nvarchar(50) not null,
	username nvarchar(25) not null,
	password nvarchar(25) not null,
	role nvarchar(50) not null)

create table tblTennisCourt (
	IdCourt nvarchar(10) primary key not null,
	name nvarchar(50) not null,
	type nvarchar(50) not null,
	price float(10) not null,
	des nvarchar(255) null,
	tblTennisCenterId int not null,
	foreign key (tblTennisCenterId) references tblTennisCenter(Id))

create table tblBookingTicket (
	IdBookingTicket int IDENTITY(1, 1) primary key not null,
	bookingDate date not null,
	totalLeft float(10) not null,
	note nvarchar(255) null,
	deposit float(1) not null,
	tblClientId int not null,
	tblUserId int not null,
	foreign key (tblClientID) references tblClient(IdClient),
	foreign key (tblUserId) references tblUser(IdUser))

create table tblBill (
	IdBill int IDENTITY(1, 1) primary key not null,
	paymentDate date not null,
	paymentMethod nvarchar(50) not null,
	amount float(10) not null,
	note nvarchar(255) null,
	tblUserId int not null,
	tblBookingTicketId int not null,
	foreign key (tblUserId) references tblUser(IdUser),
	foreign key (tblBookingTicketId) references tblBookingTicket(IdBookingTicket))

create table tblBookedCourt (
	IdBookedCourt int IDENTITY(1, 1) primary key not null,
	startDate date not null,
	endDate date not null,
	price float(10) not null,
	saleoff float(10) not null,
	note nvarchar(255) null,
	tblTennisCourtId nvarchar(10) not null,
	tblBookingTicketId int not null,
	foreign key (tblTennisCourtId) references tblTennisCourt(IdCourt),
	foreign key (tblBookingTicketId) references tblBookingTicket(IdBookingTicket))

create table tblUseSession (
	IdUseSession int IDENTITY(1, 1) primary key not null,
	checkin datetime not null,
	checkout datetime not null,
	note nvarchar(255) null,
	tblBookedCourtId int not null,
	foreign key (tblBookedCourtId) references tblBookedCourt(IdBookedCourt))

create table tblUsedService (
	IdUsedService int IDENTITY(1, 1) primary key not null,
	amount int not null,
	price float(10) not null,
	saleoff float(10) not null,
	note nvarchar(255) null,
	tblServiceId int not null,
	tblUseSessionId int not null,
	foreign key (tblServiceId) references tblService(IdService),
	foreign key (tblUseSessionId) references tblUseSession(IdUseSession))

drop table tblUseSession
drop table tblClient
drop table tblBill
drop table tblBookedCourt
drop table tblBookingTicket
drop table tblService
drop table tblTennisCenter
drop table tblTennisCourt
drop table tblUsedService
drop table tblUser

drop database if exists turisticka_agencija;
create database if not exists turisticka_agencija;

use turisticka_agencija;



/*==============================================================*/
/* Table: AGENCIJA                                              */
/*==============================================================*/
create table if not exists AGENCIJA
(
   SIFRA_AGENCIJE       varchar(10) not null,
   VLASNIK_ID           int not null,
   NAZIV                varchar(50) not null,
   ADRESA               varchar(50),
   primary key (SIFRA_AGENCIJE)
);

/*==============================================================*/
/* Table: ARANZMAN                                              */
/*==============================================================*/
create table if not exists ARANZMAN
(
   ARANZMAN_ID          int(10) not null auto_increment,
   SIFRA_AGENCIJE       varchar(10) not null,
   ARA_ARANZMAN_ID      int,
   PREVOZNO_SREDSTVO_ID int not null,
   ODREDISTE            varchar(50) not null,
   MESTO_POLASKA        varchar(50) not null,
   primary key (ARANZMAN_ID)
);

/*==============================================================*/
/* Table: KORISNIK                                              */
/*==============================================================*/
create table if not exists KORISNIK
(
   KORISNIK_ID          int(10) not null auto_increment,
   TERMIN_ID            int not null,
   IME                  varchar(20) not null,
   PREZIME              varchar(20) not null,
   ADRESA               varchar(50),
   BROJ_PASOSA          int,
   primary key (KORISNIK_ID)
);

/*==============================================================*/
/* Table: PREVOZNO_SREDSTVO                                     */
/*==============================================================*/
create table if not exists PREVOZNO_SREDSTVO
(
   PREVOZNO_SREDSTVO_ID int(10) not null auto_increment,
   TIP                  varchar(30) not null,
   BROJ_MESTA           int not null,
   primary key (PREVOZNO_SREDSTVO_ID)
);

/*==============================================================*/
/* Table: TERMIN                                                */
/*==============================================================*/
create table if not exists TERMIN
(
   TERMIN_ID            int(10) not null auto_increment,
   ARANZMAN_ID          int not null,
   DATUM_POLASKA        date not null,
   DATUM_ODLASKA        date not null,
   BROJ_SLOBODNIH_MESTA int not null,
   primary key (TERMIN_ID)
);

/*==============================================================*/
/* Table: VLASNIK                                               */
/*==============================================================*/
create table if not exists VLASNIK
(
   VLASNIK_ID           int(10) not null auto_increment,
   JMBG                 varchar(13) not null,
   IME                  varchar(20) not null,
   PREZIME              varchar(20) not null,
   ADRESA               varchar(50),
   primary key (VLASNIK_ID),
   unique(jmbg)
);

/*==============================================================*/
/* Table: VODIC                                                 */
/*==============================================================*/
create table if not exists VODIC
(
   VODIC_ID             int(10) not null auto_increment,
   ARANZMAN_ID          int not null,
   IME                  varchar(20) not null,
   PREZIME              varchar(20) not null,
   STAROST              int,
   GODINE_RADA          int,
   primary key (VODIC_ID)
);

alter table AGENCIJA add constraint FK_VODJENJE foreign key (VLASNIK_ID)
      references VLASNIK (VLASNIK_ID) on delete restrict on update restrict;

alter table ARANZMAN add constraint FK_OBAVLJANJE foreign key (SIFRA_AGENCIJE)
      references AGENCIJA (SIFRA_AGENCIJE) on delete restrict on update restrict;

alter table ARANZMAN add constraint FK_PREVOZI foreign key (PREVOZNO_SREDSTVO_ID)
      references PREVOZNO_SREDSTVO (PREVOZNO_SREDSTVO_ID) on delete restrict on update restrict;

alter table ARANZMAN add constraint FK_ZAMENSKO_PUTOVANJE foreign key (ARA_ARANZMAN_ID)
      references ARANZMAN (ARANZMAN_ID) on delete restrict on update restrict;

alter table KORISNIK add constraint FK_BIRA foreign key (TERMIN_ID)
      references TERMIN (TERMIN_ID) on delete restrict on update restrict;

alter table TERMIN add constraint FK_ORGANIZOVANJE foreign key (ARANZMAN_ID)
      references ARANZMAN (ARANZMAN_ID) on delete restrict on update restrict;

alter table VODIC add constraint FK_RELATIONSHIP_5 foreign key (ARANZMAN_ID)
      references ARANZMAN (ARANZMAN_ID) on delete restrict on update restrict;


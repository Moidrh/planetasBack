create table `Planeta`
(
	`planeta_id` integer not null AUTO_INCREMENT,
	`name` varchar(255) not null,
	`contador` integer,
	`rotacion` integer,
	`diametro` integer,
	`clima` varchar(255),
	`terreno` varchar(255),
	
	primary key (planeta_id)
) ;

create table `Persona`
(
	`id` integer not null,
	`name` varchar(255) not null,
	`planeta_id` integer not null,
	`edad` integer not null,
	`estatura` integer,
	`peso` integer,
	`sexo` varchar(1),
	`contador` integer,
	`fecha_nacimiento` timestamp,
	primary key (`id`),
  	CONSTRAINT `planeta_persona` FOREIGN KEY (`planeta_id`) REFERENCES `Planeta` (`planeta_id`)
);
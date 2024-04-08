use simulacro

create table tienda(
	id_tienda int auto_increment primary key,
    nombre varchar (255) not null,
    ubicacion varchar (255) not null
);

create table cliente(
	id_cliente int auto_increment primary key,
    nombre varchar (255) not null,
    apellido varchar (255) not null,
    email varchar (255) not null
);

create table producto(
	id_producto int (11) auto_increment primary key,
    nombre varchar (255) not null,
    precio decimal (10,2) not null,
    id_tienda int,
    foreign key (id_tienda) references tienda(id_tienda) 
    on update cascade
    on delete cascade
);

create table compra(
	id_compra int (11)auto_increment primary key,
    id_cliente int (11),
    id_producto int (11),
    fecha_compra date not null,
    cantidad int (11) not null,
    foreign key (id_cliente) references cliente(id_cliente)
	on update cascade
    on delete cascade,
    foreign key (id_producto) references producto(id_producto)
	on update cascade
    on delete cascade
);

SET FOREIGN_KEY_CHECKS=0;


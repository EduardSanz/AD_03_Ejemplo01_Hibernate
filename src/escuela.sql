create table cursos (
                        id int primary key auto_increment,
                        nombre varchar(100) not null ,
                        descripcion varchar(1000) not null ,
                        grupo char not null
);

create table equipos (
                         id int auto_increment primary key ,
                         marca varchar(100) not null ,
                         modelo varchar(1000) not null
);

create table alumnos (
                         id int primary key auto_increment,
                         nombre varchar(100) not null ,
                         apellidos varchar(255) not null ,
                         dni varchar(10) not null ,
                         id_curso int ,
                         id_equipo int,
                         foreign key (id_curso) references cursos(id),
                         foreign key (id_equipo) references equipos(id)
);
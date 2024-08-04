create table adm (
    idadm serial not null,
    nomeadm varchar(50),
    emailadm varchar(50),
    senhaadm varchar(50),
    datanascimentoadm char(10),

    constraint pk_adm primary key (idadm)
);


create table categoria (
    idcategoria serial not null,
    nomecategoria varchar(50),

    constraint pk_categoria primary key(idcategoria)
);

create table usuario (
    idusuario serial not null,
    nomeusuario varchar(50),
    emailusuario varchar(50),
    senhausuario varchar(50),
    datanascimentousuario char(10),
    apelidousuario varchar(50),

    constraint pk_usuario primary key(idusuario)
);

create table comunidade (
    idcomunidade serial not null,
    nomecomunidade varchar(50),
    descricaocomunidade varchar(300),

    idcategoria integer, 
    moderador1 integer,

    moderador2 integer,
    moderador3 integer,

    constraint pk_comunidade primary key(idcomunidade),

    constraint fk_comunidade_categoria foreign key(idcategoria) references categoria(idcategoria),
    constraint fk_comunidade_usuario foreign key(moderador1) references usuario(idusuario)
    
);

create table participante (
    idparticipante serial not null,
    idcomunidade integer not null,
    idusuario integer not null,

    constraint pk_participante primary key(idparticipante),

    constraint fk_participante_comunidade foreign key(idcomunidade) references comunidade(idcomunidade),
    constraint fk_participante_usuario foreign key(idusuario) references usuario(idusuario)
);

create table publicacao (
    idpublicado serial not null,
    idcomunidade integer not null,
    idusuario integer not null,
    conteudopublicacao varchar(500),

    constraint pk_publicacao primary key(idpublicacao),
    constraint fk_publicacao_comunidade foreign key(idcomunidade) references comunidade(idcomunidade),
    constraint fk_publicacao_usuario foreign key(idusuario) references usuario(idusuario)
      
);
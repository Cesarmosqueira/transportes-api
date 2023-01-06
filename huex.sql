create table provider(
    id bigint not null primary key,
    ruc varchar(12) not null,
    business_name varchar(30) not null,
    contact_name varchar(30) not null,
    email varchar(64),
    phone_number varchar(16),
    address varchar(64),
    admission_date timestamp not null,
    bank_account varchar(30),
    observation varchar(200)
);

create table truck_fleet(
    id bigint not null primary key,
    id_provider bigint not null,
    tract_plate varchar(6) not null,
    van_plate varchar(6),
    brand varchar(10),
    volume double precision,
    fabrication_date timestamp,
    ton_number double precision,
    axes bigint,
    model varchar(30),
    high_wide_long varchar(30),
    fleet_type varchar(30)
);

ALTER TABLE truck_fleet
    ADD CONSTRAINT fk_truck_fleet_provider FOREIGN KEY (id_provider) REFERENCES provider(id);

create table maintenance_oil(
    id bigint not null primary key,
    id_truck_fleet bigint not null,
    change_type varchar(30),
    place varchar(30),
    date_change timestamp, 
    km_last bigint,
    km_current bigint,
    km_next bigint,
    status bigint,
    date_current timestamp,
    differences bigint
);

ALTER TABLE maintenance_oil
    ADD CONSTRAINT fk_maintenance_oil_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);

create sequence maintenance_oil_id_seq;

alter sequence maintenance_oil_id_seq owner to ygadkmkttxwmqx;

alter sequence maintenance_oil_id_seq owned by documents_units.id;

ALTER TABLE maintenance_oil ALTER COLUMN id SET DEFAULT nextval('maintenance_oil_id_seq');


	
create table documents_units (
    id bigint not null primary key,
    id_truck_fleet bigint not null,
    fire_extinguisher_expiration timestamp,  
    first_aid_kit_expiration timestamp, 
    technical_review_expiration timestamp,
	name_photo_technical_review varchar(100),
    photo_technical_review bytea,
    soat_expiration timestamp,
	name_photo_soat varchar(100),
    photo_soat bytea,
    mtc_expiration timestamp,
	name_photo_mtc varchar(100),
    photo_mtc bytea,
    policy bytea,
    expiration_policy timestamp,
	name_photo_policy varchar(100),
    photo_policy bytea
);


ALTER TABLE documents_units
    ADD CONSTRAINT fk_documents_units_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);
	
create sequence documents_units_id_seq;

alter sequence documents_units_id_seq owner to ygadkmkttxwmqx;

alter sequence documents_units_id_seq owned by documents_units.id;

ALTER TABLE documents_units ALTER COLUMN id SET DEFAULT nextval('documents_units_id_seq');
	
create table check_list(
    id bigint not null primary key,
    id_truck_fleet bigint not null,
	date timestamp,
	name_photo varchar(100),
	photo bytea
);

ALTER TABLE check_list
    ADD CONSTRAINT fk_check_list_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);
	
create table fuel(
    id bigint not null primary key,
    name varchar(40),
    date timestamp not null,
    gallon double precision not null,
    unit_price double precision  not null,
    total_price double precision not null,
    gallon_balance double precision null
);

create sequence fuel_id_seq;

alter sequence fuel_id_seq owner to postgres;

alter sequence fuel_id_seq owned by fuel.id;

ALTER TABLE fuel ALTER COLUMN id SET DEFAULT nextval('fuel_id_seq');

create table kardex_fuel(
    id bigint not null primary key,
    id_truck_fleet bigint not null,
	id_fuel_supply bigint not null,
	date timestamp not null,
	amount_fuel bigint not null,
	mileage bigint, 
	duty_manager varchar(40)
);

create sequence kardex_fuel_id_seq;

alter sequence kardex_fuel_id_seq owner to postgres;

alter sequence kardex_fuel_id_seq owned by kardex_fuel.id;

ALTER TABLE kardex_fuel ALTER COLUMN id SET DEFAULT nextval('kardex_fuel_id_seq');

ALTER TABLE kardex_fuel
    ADD CONSTRAINT fk_kardex_fuel_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);

ALTER TABLE kardex_fuel
    ADD CONSTRAINT fk_kardex_fuel_fuel FOREIGN KEY (id_fuel) REFERENCES fuel(id);
	
create table maintenance_tire(
    id bigint not null primary key,
    id_truck_fleet bigint not null,
    date_review timestamp,
	date_renewal  timestamp,
    status_tire varchar(30)
);

ALTER TABLE maintenance_tire
    ADD CONSTRAINT fk_maintenance_tire_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);

create sequence maintenance_tire_id_seq;

alter sequence maintenance_tire_id_seq owner to ygadkmkttxwmqx;

alter sequence maintenance_tire_id_seq owned by documents_units.id;

ALTER TABLE maintenance_tire ALTER COLUMN id SET DEFAULT nextval('maintenance_tire_id_seq');


create table tracking_services(
    id bigint not null primary key,
    date_service timestamp not null,
    id_truck_fleet bigint not null,
	volume  bigint,
	requested_volume  bigint,
	bill varchar(30) not null,
	destination_detail varchar(30) not null,
	zone varchar(20),
	number_points  bigint,
	service_type varchar(30),
	additional_cost varchar(20),
	observations varchar(30),
	guide_number varchar(20),
	date_precharge timestamp, 
	preload_status varchar(20),
	scheduled_appointment timestamp, 
	id_rates bigint not null,
	id_driver bigint not null,
	id_copilot bigint,
	id_stevedore bigint,
	date_time_completion timestamp,
	weight_load bigint,
	money_delivered money,
	detail_money varchar(250),
	operation varchar(50),
	condition varchar(50),
	monitoring varchar(50),
	photo_insurance bigint
);

ALTER TABLE tracking_services
    ADD CONSTRAINT fk_tracking_services_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);
	
ALTER TABLE tracking_services
    ADD CONSTRAINT fk_tracking_services_rates FOREIGN KEY (id_rates) REFERENCES rates(id);

ALTER TABLE tracking_services
    ADD CONSTRAINT fk_tracking_services_employee_driver FOREIGN KEY (id_driver) REFERENCES employee(id);

ALTER TABLE tracking_services
    ADD CONSTRAINT fk_tracking_services_employee_copilot FOREIGN KEY (id_copilot) REFERENCES employee(id);

ALTER TABLE tracking_services
    ADD CONSTRAINT fk_tracking_services_employee_stevedore FOREIGN KEY (id_stevedore) REFERENCES employee(id);

create table users(
	id bigint not null primary key,
	user_name char(15) not null UNIQUE,
	id_employee bigint not null,
	password text not null,
	role bigint not null,
	active boolean not null
);

ALTER TABLE users
    ADD CONSTRAINT fk_users_employee FOREIGN KEY (id_employee) REFERENCES employee(id);
	
create table menu(
     id bigint not null primary key,
     id_parent bigint not null,
     id_child bigint not null,
     menu_label varchar(70) not null,
     menu_link varchar(300) not null,
     menu_status char(1) not null,
     menu_icon varchar(100) not null,
     menu_update boolean not null,
     menu_delete boolean not null,
     menu_create boolean not null,
     UNIQUE (id_parent, id_child)
);
	

create table user_menu(
	id bigint not null primary key,
	id_user bigint not null,
	id_parent bigint not null,
	id_child bigint not null,
	UNIQUE (id_user, id_parent, id_child)
);

ALTER TABLE user_menu
    ADD CONSTRAINT fk_user_menu_users FOREIGN KEY (id_user) REFERENCES users(id);	
	
	

********Data************************************************

insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (1, 1, 0, 'Administración', '', 'A', 'mdi-tune-vertical', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (2, 1, 1, 'Usuarios', '', 'A', '', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (3, 2, 0, 'Trabajadores', '', 'A', 'mdi-account-hard-hat', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (4, 2, 1, 'Trabajadores', '/employees/employee', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (5, 2, 2, 'Implementos', '/employees/implement', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (6, 2, 3, 'Entrega Implementos', '/employees/employee-implement', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (7, 2, 4, 'Asistencia trabajador', '/employees/employee-attendance', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (8, 2, 5, 'Descuento trabajador', '/employees/employee-discount', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (9, 3, 0, 'Vehículos', '', 'A', 'mdi-truck', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (10, 3, 1, 'Flota de camiones', '/vehicles/truck-fleet', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (11, 3, 2, 'Mantenimiento Aceite', '/vehicles/maintenance-oil', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (12, 3, 3, 'Mantenimiento LLantas', '/vehicles/maintenance-tire', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (13, 4, 0, 'Clientes', '', 'A', 'mdi-account-group', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (14, 4, 1, 'Rutas clientes', '/customers/route', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (15, 4, 2, 'Tarifas clientes', '/customers/rate', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (16, 4, 3, 'Clientes', '/customers/customer', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (17, 4, 4, 'Choferes Aptos', '/customers/customer-employees', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (18, 5, 0, 'Servicios', '', 'A', 'mdi-highway', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (19, 5, 1, 'Tipo gasto', '/services/expenseType', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (20, 5, 2, 'Incidente servicio', '/services/serviceIncidents', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (21, 5, 3, 'Liquidacion servicio', '/services/settlementSummary', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (22, 6, 0, 'Proveedores', '', 'A', 'mdi-dolly', false, false, false);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (23, 6, 1, 'Proveedor', '/providers/providers', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (24, 6, 2, 'Proveedor estivador', '/providers/province-estivators', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (25, 6, 3, 'Proveedor llanta', '/providers/tire-replacement', 'A', '', true, true, true);
insert into menu (id, id_parent, id_child, menu_label, menu_link, menu_status, menu_icon, menu_update, menu_delete, menu_create) 
values (26, 6, 4, 'Proveedor combustible', '/providers/fuel-supply', 'A', '', true, true, true);

************************************************************
insert into user_menu (id, id_parent, id_child, id_user) values (1, 1, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (2, 1, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (3, 2, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (4, 2, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (5, 2, 2, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (6, 2, 3, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (7, 2, 4, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (8, 2, 5, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (9, 3, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (10, 3, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (11, 3, 2, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (12, 3, 3, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (13, 4, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (14, 4, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (15, 4, 2, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (16, 4, 3, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (17, 4, 4, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (18, 5, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (19, 5, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (20, 5, 2, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (21, 5, 3, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (22, 6, 0, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (23, 6, 1, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (24, 6, 2, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (25, 6, 3, 1);
insert into user_menu (id, id_parent, id_child, id_user) values (26, 6, 4, 1);



Optional<User> findByUserName(String name);
	
$2a$10$gIzVbaRU1nEIny/tZbUfaOBlt1g4kmWLbN7BegNwYfsbGjEgr8lM6

insert into employee (id, academic_qualification, address, bank_account, birth_date, cease_date, childrens, contract_type, criminal_records, current_state, dni, dni_expiration_date, document_type, email, full_name, join_date, kin_full_name, kin_phone_number, kinhood, license_category, license_expiration_date, marital_status, pension_system, phone_number, photo_url, place_of_birth, role, salary) values (1, '1', '1', '1', '2022-12-22 02:15:18.000000', '2022-12-22 02:15:25.000000', 1, '1', '1', '1', '1', '2022-12-22 02:15:41.000000', '1', '1', '1', '2022-12-22 02:15:48.000000', '1', '1', '1', '1', '2022-12-22 02:15:56.000000', '1', '1', '1', '1', '1', '1', 1);


insert into users (id,active, id_employee, user_name, password, role)
values (1,true,1,'jgala','$2a$10$gIzVbaRU1nEIny/tZbUfaOBlt1g4kmWLbN7BegNwYfsbGjEgr8lM6',1);



 ResponseTokenDto responseTokenDto = new ResponseTokenDto();
        responseTokenDto.setAccessToken(token);
        responseTokenDto.setExpiryDuration(JwtTokenProvider.getExpiryDuration());

        ObjectMapper objectMapper= new ObjectMapper();
        String responseTokenDtoJson = objectMapper.writeValueAsString(responseTokenDto);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseTokenDtoJson);
		

proponer


List<KardexFuel> findAll();

    KardexFuel findById(int id);

    KardexFuel save(KardexFuel kardexFuel);

    List<KardexFuel> findByIdTruckFleet(Long id);
}
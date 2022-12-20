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
	
create table kardex_fuel(
    id bigint not null primary key,
    id_truck_fleet bigint not null,
	date timestamp not null,
	amount_fuel bigint not null,
	mileage bigint,
	duty_manager varchar(40),
);

ALTER TABLE kardex_fuel
    ADD CONSTRAINT fk_kardex_fuel_truck_fleet FOREIGN KEY (id_truck_fleet) REFERENCES truck_fleet(id);
	
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
	
//Valets
INSERT INTO valet(id,first_name,last_name,initials,cars_in,cars_out) Values(101,'Maximilien','Mingasson','MM',2,3)
INSERT INTO valet(id,first_name,last_name,initials,cars_in,cars_out) Values(102,'Kittie','Twyford','KT',5,2)
INSERT INTO valet(id,first_name,last_name,initials,cars_in,cars_out) Values(103,'Benedetta','Jann','BJ',3,3)
INSERT INTO valet(id,first_name,last_name,initials,cars_in,cars_out) Values(104,'Roda','Dendle','RD',2,5)
INSERT INTO valet(id,first_name,last_name,initials,cars_in,cars_out) Values(105,'Janos','Winthrop','JW',3,2)

//Locations
INSERT INTO location(id, name, address) Values(1,'Marriott Grand','905 Olive St')
INSERT INTO location(id, name, address) Values(2,'Magnolia Garage','505 N 7th St #200')
INSERT INTO location(id, name, address) Values(3,'Hyatt','409 N 9th St')

//Owners
INSERT INTO owner(id,first_name,last_name,phone_number) Values(101,'Billie','Wimbridge','(413) 8075958')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(102,'Emmi','Northill','(351) 7948867')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(103,'Mariam','Reitenbach','(575) 7622585')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(104,'Sonny','Melson','(557) 4535732')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(105,'Matthiew','Trattles','(968) 3816323')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(106,'Gav','Cantua','(343) 6807418')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(107,'Ilse','Catmull','(413) 1912443')
INSERT INTO owner(id,first_name,last_name,phone_number) Values(108,'Rurik','Ainge','(579) 7850168')

//Vehicles
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(101,parseDateTime('2018-01-02', 'yyyy-MM-dd'),8,'Pontiac','Sunbird','Maroon','90-000-2718',105,119, parseDateTime('2019-10-15', 'yyyy-MM-dd'), 106,3)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(102,parseDateTime('2018-10-17', 'yyyy-MM-dd'),13,'BMW','X5','Crimson','41-150-1861', 101,28, parseDateTime('2019-11-06', 'yyyy-MM-dd'), 102,1)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(103,parseDateTime('2018-05-27', 'yyyy-MM-dd'),14,'Mercedes-Benz','400SEL','Red','04-101-7263', 105,63, parseDateTime('2019-12-10', 'yyyy-MM-dd'), 102,2)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(104,parseDateTime('2018-10-08', 'yyyy-MM-dd'),6,'Chrysler','Crossfire Roadster','Turquoise', '04-327-0573', 102,150, parseDateTime('2019-12-28', 'yyyy-MM-dd'), 103,1)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(105,parseDateTime('2018-09-15', 'yyyy-MM-dd'),1,'Porsche','911','Mauv','18-398-3543', 101,82, parseDateTime('2019-05-18', 'yyyy-MM-dd'), 107,3)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(106,parseDateTime('2018-11-02', 'yyyy-MM-dd'),2,'Volkswagen','Eos','Yellow','30-951-9039', 103,117, parseDateTime('2019-08-15', 'yyyy-MM-dd'), 108,1)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(107,parseDateTime('2018-01-15', 'yyyy-MM-dd'),15,'Mercury','Grand Marquis','Aquamarine','91-852-8718',102,75, parseDateTime('2019-07-17', 'yyyy-MM-dd'), 103,2)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(108,parseDateTime('2018-10-27', 'yyyy-MM-dd'),9,'Mercedes-Benz','CLS-Class','Green','68-898-4393', 101,113, parseDateTime('2019-05-06', 'yyyy-MM-dd'), 105,2)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(109,parseDateTime('2018-10-01', 'yyyy-MM-dd'),7,'Ford','F150','Violet','68-327-5002',105 ,88, parseDateTime('2019-12-01','yyyy-MM-dd'), 104,3)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(110,parseDateTime('2018-11-15', 'yyyy-MM-dd'),12,'Hyundai','Elantra','Maroon','86-354-8003', 101,35, parseDateTime('2019-07-09', 'yyyy-MM-dd'), 107,1)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(111,parseDateTime('2018-10-23', 'yyyy-MM-dd'),5,'Ford','Escort','Blue','27-154-2198', 102,131, parseDateTime('2019-12-05', 'yyyy-MM-dd'), 102,3)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(112,parseDateTime('2018-01-17', 'yyyy-MM-dd'),11,'Volkswagen','Jetta','Violet','69-498-6793', 101,115, parseDateTime('2019-09-09', 'yyyy-MM-dd'), 108,1)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(113,parseDateTime('2018-10-02', 'yyyy-MM-dd'),3,'Subaru','Outback','Pink','46-590-2788', 101,103, parseDateTime('2019-09-27', 'yyyy-MM-dd'), 103,2)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(114,parseDateTime('2018-05-15', 'yyyy-MM-dd'),10,'Subaru','Outback','Fuscia','69-137-5373', 104,64, parseDateTime('2019-08-12', 'yyyy-MM-dd'), 107,2)
INSERT INTO vehicle(id,arrival_date,ticket_number ,make,model,color,license_plate,valet_id,parked_location,departure_date,owner_id,location_id) VALUES(115,parseDateTime('2018-09-17', 'yyyy-MM-dd'),4,'Mazda','Mazda6','Aquamarine','63-483-9205', 103,120, parseDateTime('2019-04-02', 'yyyy-MM-dd'), 106,3)

drop table if exists prices;
drop table if exists brand;

create table brand (brand_id int);
create table prices (brand_id int, start_date datetime2, end_date datetime2, prices_list int, product_id int, priority int, price float, currency varchar2(20), foreign key (brand_id) references Brand(brand_id));

insert into brand (brand_id) values (1);

insert into prices (brand_id, start_date, end_date, prices_list, product_id, priority, price, currency) values (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
insert into prices (brand_id, start_date, end_date, prices_list, product_id, priority, price, currency) values (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
insert into prices (brand_id, start_date, end_date, prices_list, product_id, priority, price, currency) values (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 31.50, 'EUR');
insert into prices (brand_id, start_date, end_date, prices_list, product_id, priority, price, currency) values (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');


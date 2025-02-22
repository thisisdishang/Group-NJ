-- INSERT QUERY
INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES 
(1, 'Europe'), 
(2, 'Americas'), 
(3, 'Asia'), 
(4, 'Middle East and Africa'), 
(5, 'Australia');

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES 
('AR', 'Argentina', 2), 
('AU', 'Australia', 5), 
('BE', 'Belgium', 1), 
('BR', 'Brazil', 2),
('CA', 'Canada', 2),
('CH', 'Switzerland', 1);

INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) VALUES 
(1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'IT'), 
(1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT'), 
(1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo', 'JP'), 
(1300, '9450 Kamiya-cho', '6823', 'Hiroshima', 'Chugoku', 'JP'), 
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'), 
(1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');

INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES 
(10, 'Administration', 200, 1700), 
(20, 'Marketing', 201, 1800), 
(30, 'Purchasing', 114, 1700), 
(40, 'Human Resources', 203, 2400), 
(50, 'Shipping', 121, 1500), 
(60, 'IT', 103, 1400);

INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES 
('AD_PRES', 'President', 20000, 40000), 
('AD_VP', 'Administration Vice President', 15000, 30000), 
('AD_ASST', 'Administration Assistant', 3000, 6000), 
('FI_MGR', 'Finance Manager', 8200, 16000), 
('FI_ACCOUNT', 'Accountant', 4200, 9000);

INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) VALUES 
(100, 'Steven', 'King', 'kingsteve@gmail.com', '515.123.4567', '2003-06-17', 'AD_PRES', 24000, NULL, NULL, 90), 
(101, 'Neena', 'Kochhar', 'neenakochhar@gmail.com', '515.123.4568', '2005-09-21', 'AD_VP', 17000, NULL, 100, 90), 
(102, 'Lex', 'De Haan', 'lexdehaan@gmail.com', '515.123.4569', '2001-01-13', 'AD_VP', 17000, NULL, 100, 90), 
(103, 'Alexander', 'Hunold', 'alexander@gmail.com', '590.423.4567', '2006-01-03', 'IT_PROG', 9000, NULL, 102, 60), 
(104, 'Bruce', 'Ernst', 'bruce@gmail.com', '590.423.4568', '2007-05-21', 'IT_PROG', 6000, NULL, 103, 60), 
(105, 'David', 'Austin', 'david@gmail.com', '590.423.4569', '2005-06-25', 'IT_PROG', 4800, NULL, 103, 60);

INSERT INTO JOB_HISTORY (EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID) VALUES 
(102, '2001-01-13', '2006-07-24', 'IT_PROG', 60), 
(101, '2001-09-21', '2005-09-21', 'AC_ACCOUNT', 110), 
(101, '2006-09-21', '2007-10-27', 'AC_MGR', 110), 
(201, '2004-02-17', '2007-12-19', 'MK_REP', 20), 
(114, '2006-03-24', '2007-12-31', 'ST_CLERK', 50), 
(122, '2007-01-01', '2007-12-31', 'ST_CLERK', 50), 
(200, '2008-01-01', '2008-12-31', 'AD_ASST', 90);

-- DISPLAY NUMBER OF EMPLOYEES JOINED AFTER 15H OF THE MONTH
SELECT COUNT(*) AS Num_Employees_Joined_After_15th FROM EMPLOYEES WHERE DAY(HIRE_DATE) > 15;

-- Display the country ID and number of cities we have in the country.
SELECT COUNTRY_ID, COUNT(DISTINCT CITY) AS Num_Cities FROM LOCATIONS GROUP BY COUNTRY_ID;

-- Display average salary of employees in each department who have a commission percentage.
SELECT DEPARTMENT_ID, AVG(SALARY) AS Avg_Salary FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL GROUP BY DEPARTMENT_ID;

-- Display job ID, number of employees, sum of salary, and difference between highest and lowest salary of the employees of the job.
SELECT JOB_ID, COUNT(*) AS Num_Employees, SUM(SALARY) AS Total_Salary, MAX(SALARY) - MIN(SALARY) AS Salary_Difference
FROM EMPLOYEES GROUP BY JOB_ID;

-- Display job ID for jobs with an average salary of more than 10000.
SELECT JOB_ID FROM EMPLOYEES GROUP BY JOB_ID HAVING AVG(SALARY) > 10000;

-- Display years in which more than 10 employees joined.
SELECT YEAR(HIRE_DATE) AS Year, COUNT(*) AS Num_Employees FROM EMPLOYEES GROUP BY YEAR(HIRE_DATE) HAVING COUNT(*) > 10;

-- Display departments in which more than five employees have a commission percentage.
SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL GROUP BY DEPARTMENT_ID HAVING COUNT(*) > 5;

-- Display employee ID for employees who did more than one job in the past.
SELECT EMPLOYEE_ID FROM JOB_HISTORY GROUP BY EMPLOYEE_ID HAVING COUNT(DISTINCT JOB_ID) > 1;

-- Display job ID of jobs that were done by more than 3 employees for more than 100 days.
SELECT JOB_ID FROM JOB_HISTORY WHERE DATEDIFF(END_DATE, START_DATE) > 100 GROUP BY JOB_ID HAVING COUNT(EMPLOYEE_ID) > 3;

-- Display department ID, year, and Number of employees joined.
SELECT DEPARTMENT_ID, YEAR(HIRE_DATE) AS Year, COUNT(*) AS Num_Employees FROM EMPLOYEES GROUP BY DEPARTMENT_ID, YEAR(HIRE_DATE);

-- Display departments where any manager is managing more than 5 employees.
SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID IS NOT NULL GROUP BY DEPARTMENT_ID, MANAGER_ID HAVING COUNT(*) > 5;

-- Display department name, manager name, and city.
SELECT D.DEPARTMENT_NAME, CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS Manager_Name, L.CITY FROM DEPARTMENTS D
JOIN EMPLOYEES E ON D.MANAGER_ID = E.EMPLOYEE_ID JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID;

-- Display country name, city, and department name.
SELECT C.COUNTRY_NAME, L.CITY, D.DEPARTMENT_NAME FROM DEPARTMENTS D JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
JOIN COUNTRIES C ON L.COUNTRY_ID = C.COUNTRY_ID;

-- Display job title, department name, employee last name, and starting date for all jobs from 2000 to 2005.
SELECT J.JOB_TITLE, D.DEPARTMENT_NAME, E.LAST_NAME, JH.START_DATE FROM JOB_HISTORY JH JOIN JOBS J ON JH.JOB_ID = J.JOB_ID
JOIN DEPARTMENTS D ON JH.DEPARTMENT_ID = D.DEPARTMENT_ID JOIN EMPLOYEES E ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID WHERE YEAR(JH.START_DATE)
BETWEEN 2000 AND 2005;

-- Display job title and average salary of employees.
SELECT J.JOB_TITLE, AVG(E.SALARY) AS Avg_Salary FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID = J.JOB_ID GROUP BY J.JOB_TITLE;

-- Display details of jobs that were done by any employee who is currently drawing more than 15000 of salary.
SELECT JH.* FROM JOB_HISTORY JH JOIN EMPLOYEES E ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID WHERE E.SALARY > 15000;

-- Display department name, manager name, and salary of the manager for all managers whose experience is more than 5 years.
SELECT D.DEPARTMENT_NAME, CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS Manager_Name, E.SALARY FROM DEPARTMENTS D
JOIN EMPLOYEES E ON D.MANAGER_ID = E.EMPLOYEE_ID WHERE DATEDIFF(CURDATE(), E.HIRE_DATE) / 365 > 5;

-- Display employee name, job title for the jobs employee did in the past where the job was done less than six months.
SELECT CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS Employee_Name, J.JOB_TITLE FROM JOB_HISTORY JH JOIN EMPLOYEES E ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID
JOIN JOBS J ON JH.JOB_ID = J.JOB_ID WHERE DATEDIFF(JH.END_DATE, JH.START_DATE) < 180;

-- Display department name, average salary, and number of employees with commission within the department.
SELECT D.DEPARTMENT_NAME, AVG(E.SALARY) AS Avg_Salary, COUNT(E.EMPLOYEE_ID) AS Num_Commission_Employees FROM EMPLOYEES E
JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID WHERE E.COMMISSION_PCT IS NOT NULL GROUP BY D.DEPARTMENT_NAME;

-- Display the month in which more than 5 employees joined in any department located in Sydney.
SELECT MONTH(E.HIRE_DATE) AS Joining_Month, COUNT(*) AS Num_Employees FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID WHERE L.CITY = 'Sydney' GROUP BY MONTH(E.HIRE_DATE) HAVING COUNT(*) > 5;

-- Display details of departments in which the maximum salary is more than 10,000.
SELECT D.* FROM DEPARTMENTS D JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID GROUP BY D.DEPARTMENT_ID HAVING MAX(E.SALARY) > 10000;

-- Display jobs into which employees joined in the current year.
SELECT DISTINCT J.JOB_ID, J.JOB_TITLE FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID = J.JOB_ID WHERE YEAR(E.HIRE_DATE) = YEAR(CURDATE());

-- Display employees who did not do any job in the past.
SELECT E.* FROM EMPLOYEES E LEFT JOIN JOB_HISTORY JH ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID WHERE JH.EMPLOYEE_ID IS NULL;

-- Display job title and average salary for employees who did a job in the past.
SELECT J.JOB_TITLE, AVG(E.SALARY) AS Avg_Salary FROM JOB_HISTORY JH JOIN EMPLOYEES E ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID JOIN JOBS J ON JH.JOB_ID = J.JOB_ID
GROUP BY J.JOB_TITLE;

-- Display country name, city, and number of departments where the department has more than 5 employees.
SELECT C.COUNTRY_NAME, L.CITY, COUNT(D.DEPARTMENT_ID) AS Num_Departments FROM DEPARTMENTS D
JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
JOIN COUNTRIES C ON L.COUNTRY_ID = C.COUNTRY_ID
JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY C.COUNTRY_NAME, L.CITY, D.DEPARTMENT_ID
HAVING COUNT(E.EMPLOYEE_ID) > 5;

-- Display details of managers who manage more than 5 employees.
SELECT E.* FROM EMPLOYEES E
WHERE E.EMPLOYEE_ID IN (
    SELECT MANAGER_ID
    FROM EMPLOYEES
    WHERE MANAGER_ID IS NOT NULL
    GROUP BY MANAGER_ID
    HAVING COUNT(*) > 5
);

-- Display the departments into which no employee joined in the last two years.
SELECT D.* FROM DEPARTMENTS D LEFT JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID GROUP BY D.DEPARTMENT_ID
HAVING MAX(E.HIRE_DATE) < DATE_SUB(CURDATE(), INTERVAL 2 YEAR) OR MAX(E.HIRE_DATE) IS NULL;

-- Display details of departments in which the max salary is greater than 10,000 for employees who did a job in the past.
SELECT D.* FROM DEPARTMENTS D
JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
JOIN JOB_HISTORY JH ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID
GROUP BY D.DEPARTMENT_ID
HAVING MAX(E.SALARY) > 10000;

-- Display the third highest salary of all employees.
SELECT DISTINCT SALARY FROM EMPLOYEES ORDER BY SALARY DESC LIMIT 1 OFFSET 2;

-- OR
SELECT MAX(SALARY) AS Third_Highest_Salary FROM EMPLOYEES WHERE SALARY < (SELECT MAX(SALARY) FROM EMPLOYEES WHERE SALARY < (SELECT MAX(SALARY) FROM EMPLOYEES));
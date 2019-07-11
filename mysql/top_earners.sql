SET @max_earnings=(SELECT MAX(SALARY * MONTHS) FROM EMPLOYEE);
    
SELECT
    @max_earnings, COUNT(*) 
FROM 
    EMPLOYEE 
WHERE 
    (SALARY * MONTHS) = @max_earnings;

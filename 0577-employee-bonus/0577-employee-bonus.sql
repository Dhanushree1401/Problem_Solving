SELECT Employee.name, Bonus.bonus 
FROM Employee 
LEFT JOIN Bonus ON Employee.empID = Bonus.empID
WHERE Bonus.bonus < 1000 OR Bonus.bonus IS NULL;
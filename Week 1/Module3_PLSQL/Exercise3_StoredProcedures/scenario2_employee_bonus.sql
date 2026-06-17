CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department      IN VARCHAR2,
    p_BonusPercentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (p_BonusPercentage / 100))
    WHERE Department = p_Department;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Applied ' || p_BonusPercentage || '% bonus to department: ' || p_Department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Failed to update employee bonuses: ' || SQLERRM);
END;
/
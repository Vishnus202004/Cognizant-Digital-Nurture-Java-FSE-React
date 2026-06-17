CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Customers
    SET Balance = Balance * 1.01;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all accounts successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Failed to process monthly interest: ' || SQLERRM);
END;
/
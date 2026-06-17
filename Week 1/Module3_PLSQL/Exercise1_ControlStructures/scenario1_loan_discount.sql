
BEGIN

    FOR r_customer IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate 
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    ) LOOP
       
        SET InterestRate = InterestRate - 1
        WHERE LoanID = r_customer.LoanID;
        
        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || r_customer.LoanID || ' for Customer ID: ' || r_customer.CustomerID);
    END LOOP;


    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing senior loan discounts: ' || SQLERRM);
END;
/
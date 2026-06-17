-- Scenario 3: Query and print system alerts for loans maturing within the next 30 days
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== UPCOMING LOAN DUE REMINDERS (NEXT 30 DAYS) ===');
    
    FOR r_loan IN (
        SELECT l.LoanID, c.Name, l.DueDate, (l.DueDate - TRUNC(SYSDATE)) AS DaysRemaining
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Hello ' || r_loan.Name || ', your Loan (ID: ' || r_loan.LoanID || ') is due on ' || TO_CHAR(r_loan.DueDate, 'YYYY-MM-DD') || '. Days remaining: ' || r_loan.DaysRemaining);
    END LOOP;
END;
/
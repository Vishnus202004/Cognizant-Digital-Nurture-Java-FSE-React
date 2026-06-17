CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN NUMBER,
    p_DestAccountID   IN NUMBER,
    p_Amount          IN NUMBER
) IS
    v_SourceBalance NUMBER;
    e_InsufficientFunds EXCEPTION;
BEGIN
    IF p_Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Amount must be greater than zero.');
    END IF;

    SELECT Balance INTO v_SourceBalance 
    FROM Customers 
    WHERE CustomerID = p_SourceAccountID 
    FOR UPDATE;

    IF v_SourceBalance < p_Amount THEN
        RAISE e_InsufficientFunds;
    END IF;

    UPDATE Customers 
    SET Balance = Balance - p_Amount 
    WHERE CustomerID = p_SourceAccountID;

    UPDATE Customers 
    SET Balance = Balance + p_Amount 
    WHERE CustomerID = p_DestAccountID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_Amount || ' from Account ' || p_SourceAccountID || ' to ' || p_DestAccountID);

EXCEPTION
    WHEN e_InsufficientFunds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Insufficient funds in account ' || p_SourceAccountID);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Account ID not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: critical database error: ' || SQLERRM);
END;
/
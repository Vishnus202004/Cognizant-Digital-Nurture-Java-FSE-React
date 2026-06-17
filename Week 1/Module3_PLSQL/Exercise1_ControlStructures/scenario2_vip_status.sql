
BEGIN
  
    FOR r_vip IN (
        SELECT CustomerID, Balance 
        FROM Customers 
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = r_vip.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || r_vip.CustomerID || ' to VIP status. (Balance: $' || r_vip.Balance || ')');
    END LOOP;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing VIP promotions: ' || SQLERRM);
END;
/
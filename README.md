# Servlet-JSP_CURD

Bank2 sql tables -
bank_account

CUST_NAME                                          VARCHAR2(20)
 USR_NAME                                           VARCHAR2(20)
 ACC_NO                                    NOT NULL NUMBER(10)
 PASSWORD                                           VARCHAR2(20)
 PHONE_NO                                           NUMBER(11)
 ACC_BAL                                            FLOAT(126)

bank_recharge

ACC_NO                                             NUMBER(10)
 PHONENO                                            VARCHAR2(20)
 ISP                                                VARCHAR2(20)
 REC_AMT                                            FLOAT(126)
 REC_DATE                                           VARCHAR2(20)

Recharge0.3 sql table - 
 user_account
 
 ACCID                                     NOT NULL NUMBER(38)
 USERNAME                                           VARCHAR2(255)
 PHONENO                                            NUMBER(10)
 ACCBAL                                             NUMBER(38)
 PASSWORD                                           NUMBER(38)


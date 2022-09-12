/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, is_male, username, email, password, tel, ROLE, enabled)
VALUES ('Najib Rachid', TRUE, 'najib', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', '06000000','ROLE_ADMIN',TRUE),
       ('Khadija idlmhor', FALSE,'med','khadija@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', '06000040','ROLE_ADMIN',TRUE),
       ('Abderahim Oudor ', TRUE, 'ayoub','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', '06000040','ROLE_CLIENT',TRUE),
       ('Fatiha El habti', FALSE, 'fatiha','fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72', '06000090','ROLE_CLIENT',TRUE),
       ('Latifa Amouguay', FALSE, 'latifa','latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', '06000090','ROLE_CLIENT',TRUE),
       ('Anass ELmkhloufi', TRUE, 'anas', 'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', '06000090','ROLE_CLIENT',TRUE),
       ('Omar Dbaa', TRUE, 'omar', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', '06040090','ROLE_CLIENT', FALSE);

/*Seed TABLE Permissions:*/   
INSERT INTO public.permissions (id, name)
VALUES (1, 'ADMIN_FULL'),
       (2, 'USER_LIST'), (3, 'USER_VIEW'), (4, 'USER_ADD'), (5, 'USER_EDIT'), (6, 'USER_REMOVE'),
       (7, 'PRODUCT_LIST'), (8, 'PRODUCT_VIEW'), (9, 'PRODUCT_ADD'), (10, 'PRODUCT_EDIT'), (11, 'PRODUCT_REMOVE'),
       (12, 'CATEGORY_LIST'), (13, 'CATEGORY_VIEW'), (14, 'CATEGORY_ADD'), (15, 'CATEGORY_EDIT'), (16, 'CATEGORY_REMOVE'),
       (17, 'ORDER_LIST'), (18, 'ORDER_VIEW'), (19, 'ORDER_ADD'), (20, 'ORDER_EDIT'), (21, 'ORDER_REMOVE');

/*Seed TABLE User_Permissions:*/        
INSERT INTO public.user_permissions (user_id, permission_id)
VALUES (1, 1),
       (2, 1),
       (3, 7), (3, 8), (3, 12), (3, 13), (3, 14),
       (4, 7), (4, 8), (4, 12), (4, 13),
       (5, 7), (5, 8), (5, 12), (5, 13),
       (6, 7), (6, 8), (6, 12), (6, 13),
       (7, 7), (7, 8), (7, 12), (7, 13);


       

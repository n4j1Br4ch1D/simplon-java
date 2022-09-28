/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, is_male, username, email, password, tel, role, enabled) VALUES
       ('Najib Rachid', TRUE, 'najib', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', '06000000','ROLE_ADMIN',TRUE),
       ('Khadija Bigdade', FALSE,'med','khadija@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', '06000001','ROLE_ADMIN',TRUE),
       ('Abderahim El ouardi', TRUE, 'ayoub','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', '06000002','ROLE_CLIENT',TRUE),
       ('Fatiha El habti', FALSE, 'fatiha','fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72', '06000003','ROLE_CLIENT',TRUE),
       ('Latifa Amouguay', FALSE, 'latifa','latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', '06000004','ROLE_CLIENT',TRUE),
       ('Anass ELmkhloufi', TRUE, 'anas', 'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', '06000005','ROLE_CLIENT',TRUE),
       ('Omar Dbaa', TRUE, 'omar', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', '06000006','ROLE_CLIENT', FALSE);

/*Seed TABLE Permissions:*/   
INSERT INTO public.permissions (id, name) VALUES
       (1, 'ADMIN_FULL'),
       (2, 'USER_LIST'), (3, 'USER_VIEW'), (4, 'USER_ADD'), (5, 'USER_EDIT'), (6, 'USER_REMOVE'),
       (7, 'PRODUCT_LIST'), (8, 'PRODUCT_VIEW'), (9, 'PRODUCT_ADD'), (10, 'PRODUCT_EDIT'), (11, 'PRODUCT_REMOVE'),
       (12, 'CATEGORY_LIST'), (13, 'CATEGORY_VIEW'), (14, 'CATEGORY_ADD'), (15, 'CATEGORY_EDIT'), (16, 'CATEGORY_REMOVE'),
       (17, 'ORDER_LIST'), (18, 'ORDER_VIEW'), (19, 'ORDER_ADD'), (20, 'ORDER_EDIT'), (21, 'ORDER_REMOVE');

/*Seed TABLE User_Permissions:*/        
INSERT INTO public.user_permissions (user_id, permission_id) VALUES
       (1, 1),
       (2, 1),
       (3, 7), (3, 8), (3, 12), (3, 13), (3, 14),
       (4, 7), (4, 8), (4, 12), (4, 13),
       (5, 7), (5, 8), (5, 12), (5, 13),
       (6, 7), (6, 8), (6, 12), (6, 13),
       (7, 7), (7, 8), (7, 12), (7, 13);

/*Seed TABLE Categories:*/
INSERT INTO public.categories (name, description, img, enabled, parent_category_id) VALUES
('Skin', 'All types of common Skin infection.', 'imgs/categories/skin.png', TRUE, 1),
('Allergies', 'any types of common allerigies.', 'imgs/categories/allergies.png', TRUE, 1),
('Hearing', 'Problems with hearing products.', 'imgs/categories/hearing.png', TRUE, 3),
('Eyes', 'Skin, Eye, or any other type of infection.', 'imgs/categories/eyes.png', TRUE, 4),
('Glasses', 'Skin, Eye, or any other type of infection.', 'imgs/categories/glasses.png', TRUE, 3),
('Tiredness', 'Tiredness, less sleep, headaches.', 'imgs/categories/tiredness.png', TRUE, 6),
('Cold', ' common cold,Winter Cold, or any other type of flu.', 'imgs/categories/cold.png', false, 7);

/*Seed TABLE Products:*/
INSERT INTO public.products (name, description, regular_price, sale_price, img, enabled, category_id)
VALUES('Argan Oil', 'Skin Aragan Oil Anti Infections', 400, 250, 'imgs/categories/argain-oil.png', TRUE, 1),
('Zaytouna Oil', 'Skin Zaytouna Oil Anti Infections', 200, 150, 'imgs/categories/zaytouna-oil.png', TRUE, 2),
('Mega One', 'Mega one Hearing Device best quality', 700, 550, 'imgs/categories/mega-one.png', TRUE, 3),
('Kaskolkorakekafin', 'Sweet Eye drops ati eye innfections.', 100, 90, 'imgs/categories/kaskolkorakekafin.png', TRUE, 4),
('ZoomGlasses', 'For clear vision better view.', 150, 130, 'imgs/categories/zoom-glasses.png', TRUE, 5),
('Mega View', 'focus on whats in front of you.', 200, 150, 'imgs/categories/mega-view.png', TRUE, 5),
('Mega View Screen', 'nice offer computer screen + glasses', 800, 700, 'imgs/categories/mega-view-screen.png', TRUE, 5),
('GlassWear', 'glasswear dettach and attach multiple types.', 400, 300, 'imgs/categories/glasswear.png', False, 5),
('Lwizza', 'nice tasty medinice, my favorit.', 20, 10, 'imgs/categories/lwizza.png', TRUE, 6),
('L3ssida', 'common cold solution from morocco.', 30, 20, 'imgs/categories/l3ssida.png', TRUE, 7);

/*Seed TABLE Orders:*/
INSERT INTO public.orders (order_id, user_id, product_id, status, total_price) -- cart, order, paid.
VALUES(1, 1, 1, 'cart', 200),
(2, 2, 1, 'paid', 100),
(1, 1, 1, 'cart', 200),
(3, 2, 4, 'paid', 300),
(3, 2, 5, 'paid', 300),
(4, 3, 3, 'order', 500);




       

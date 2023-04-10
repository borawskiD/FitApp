INSERT INTO
    APPLICATION_USER (ID, MAIL, PASSWORD, NAME, BIRTH_DATE)
VALUES
    -- superadmin@example.com / hard
    (0, 'superadmin@example.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S', 'Dominik', '1991-11-12');
INSERT INTO
    HEALTH_DATA (ROW_ID, GENDER, ACTIVITY_LEVEL, HEIGHT, UPDATE_DATE, WEIGHT, USER_ID)
VALUES
    (0, 'M', '1', 190.0, '2023-04-10', 100.0, 0)
IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N'user_role')
BEGIN
  DROP TABLE user_role
END
IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N'app_role')
BEGIN
DROP TABLE app_role
END
IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N'app_user')
BEGIN
DROP TABLE app_user
END

CREATE TABLE app_role (
                        id BIGINT NOT NULL IDENTITY,
                        description varchar(255) DEFAULT NULL,
                        role_name varchar(255) DEFAULT NULL,
                        PRIMARY KEY (id)
);


CREATE TABLE app_user (
                        id BIGINT NOT NULL IDENTITY,
                        first_name varchar(255) NOT NULL,
                        last_name varchar(255) NOT NULL,
                        password varchar(255) NOT NULL,
                        username varchar(255) NOT NULL,
                        PRIMARY KEY (id)
);


CREATE TABLE user_role (
                         user_id BIGINT NOT NULL,
                         role_id BIGINT NOT NULL,
                         CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES app_user (id),
                         CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES app_role (id)
);

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N'trade_transaction')
begin
CREATE TABLE trade_transaction(
                          id BIGINT NOT NULL IDENTITY,
                          user_id varchar(255) NOT NULL,
                          currency_from varchar(255) NOT NULL,
                          currency_to varchar(255) NOT NULL,
                          amount_sell decimal(38,2) NOT NULL,
                          amount_buy decimal(38,2) NOT NULL,
                          rate decimal(38,2) NOT NULL,
                          time_placed datetime NOT NULL,
                          originating_country varchar(255) NOT NULL
)
END
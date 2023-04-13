CREATE TABLE app_user (
                          id BIGINT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE role (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE permission (
                            id BIGINT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description VARCHAR(255) NOT NULL
);

CREATE TABLE app_user_role (
                               user_id BIGINT NOT NULL,
                               role_id BIGINT NOT NULL,
                               PRIMARY KEY (user_id, role_id),
                               FOREIGN KEY (user_id) REFERENCES app_user (id) ON DELETE CASCADE,
                               FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);

CREATE TABLE role_permission (
                                 role_id BIGINT NOT NULL,
                                 permission_id BIGINT NOT NULL,
                                 PRIMARY KEY (role_id, permission_id),
                                 FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE,
                                 FOREIGN KEY (permission_id) REFERENCES permission (id) ON DELETE CASCADE
);

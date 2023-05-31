
CREATE SCHEMA irrigation;

CREATE SEQUENCE irrigation.id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE irrigation.plots (
                       id int8 PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       area DOUBLE PRECISION NOT NULL,
                       crop_type VARCHAR(255) NOT NULL
);

CREATE TABLE irrigation.time_slots (
                                       id int8 PRIMARY KEY,
                                       plot_id int8 NOT NULL,
                                       start_time TIME NOT NULL,
                                       end_time TIME NOT NULL,
                                       water_amount DOUBLE PRECISION NOT NULL,
                                       status VARCHAR(255) NOT NULL,
                                       FOREIGN KEY (plot_id) REFERENCES irrigation.plots (id)
);

CREATE TABLE irrigation.crop (
                                 id int8 PRIMARY KEY,
                                 crop_type VARCHAR(255) NOT NULL,
                                 recommended_slot_time VARCHAR(255) NOT NULL,
                                 recommended_water_amount INT NOT NULL
);



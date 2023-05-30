CREATE TABLE irrigation.crop (
                      id int8 PRIMARY KEY,
                      crop_type VARCHAR(255) NOT NULL,
                      recommended_slot_time VARCHAR(255) NOT NULL,
                      recommended_water_amount INT NOT NULL
);

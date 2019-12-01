CREATE TABLE checkin (
    id                  SERIAL,
    hospede_id          INTEGER NOT NULL,
    data_entrada        TIMESTAMP NOT NULL,
    data_saida          TIMESTAMP NOT NULL,
    adicional_veiculo   BOOLEAN NOT NULL
);

ALTER TABLE checkin
    ADD CONSTRAINT checkin_pk
        PRIMARY KEY (id);

ALTER TABLE checkin
    ADD CONSTRAINT checkin_hospede_id_fk
        FOREIGN KEY (hospede_id) REFERENCES hospede (id);

COMMENT ON TABLE checkin IS 'Check-in';
COMMENT ON COLUMN checkin.id IS 'ID do check-in';
COMMENT ON COLUMN checkin.hospede_id IS 'Hospede do check-in';
COMMENT ON COLUMN checkin.data_entrada IS 'Data de entrada do check-in';
COMMENT ON COLUMN checkin.data_saida IS 'Data de saída do check-in';
COMMENT ON COLUMN checkin.adicional_veiculo IS 'Verifica adicional de veículo do check-in';

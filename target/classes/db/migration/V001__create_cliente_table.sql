CREATE TABLE hospede (
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(50),
    telefone   INTEGER,
    cpf        VARCHAR(11)
);

COMMENT ON TABLE hospede IS 'Hospede';
COMMENT ON COLUMN hospede.id IS 'ID do hospede';
COMMENT ON COLUMN hospede.nome IS 'Nome do hospode';
COMMENT ON COLUMN hospede.telefone IS 'Telefone do hospode';
COMMENT ON COLUMN hospede.cpf IS 'CPF do hospede';
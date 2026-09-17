public class Funcionario {
    private String id;
    private String nomeCompleto;
    private String status;
    private String cargo;

    public Funcionario(String id, String nomeCompleto, String status, String cargo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.status = status;
        this.cargo = cargo;
    }

    public String getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getStatus() { return status; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("ID: %s | Nome Completo: %s | Status: %s | Cargo: %s",
                id, nomeCompleto, status, cargo);
    }
}

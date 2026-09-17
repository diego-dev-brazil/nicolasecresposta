import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaSalvaFuncionariosAtivos {

    public static void main(String[] args) {
        
        String sql = "SELECT Fun_ID, Fun_Nome_Completo, Fun_Status, Fun_Cargo FROM dbo.Funcionarios WHERE Fun_Status = ?";
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Ativo");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Funcionario func = new Funcionario(
                        rs.getString("Fun_ID"),
                        rs.getString("Fun_Nome_Completo"),
                        rs.getString("Fun_Status"),
                        rs.getString("Fun_Cargo")
                    );
                    listaFuncionarios.add(func);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou consultar o banco: " + e.getMessage());
            return;
        }

        String nomeArquivo = "saida_funcionarios_ativos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("--- RELATÓRIO DE FUNCIONÁRIOS ATIVOS ---\n");
            for (Funcionario f : listaFuncionarios) {
                writer.write(f.toString());
                writer.newLine();
            }
            System.out.println("Arquivo '" + nomeArquivo + "' gerado com sucesso! (" + listaFuncionarios.size() + " ativos)");
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}

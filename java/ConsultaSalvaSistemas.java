import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaSalvaSistemas {

    public static void main(String[] args) {
        String sql = "SELECT ID, Nome, Empresa, Responsavel FROM dbo.Sistemas";
        List<Sistema> listaSistemas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sistema sistema = new Sistema(
                    rs.getString("ID"),
                    rs.getString("Nome"),
                    rs.getString("Empresa"),
                    rs.getString("Responsavel")
                );
                listaSistemas.add(sistema);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou consultar o banco: " + e.getMessage());
            return;
        }

        String nomeArquivo = "saida_sistemas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("--- RELATÓRIO DE SISTEMAS ---\n");
            for (Sistema s : listaSistemas) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Arquivo '" + nomeArquivo + "' gerado com sucesso! (" + listaSistemas.size() + " registros)");
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}

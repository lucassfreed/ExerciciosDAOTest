package dao;

import bean.Filme;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lucas Rodrigo Frederico
 */
public class FilmeDAO {

    public int cadastrar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO (nome, "
                    + "diretor, "
                    + "categoria, "
                    + "ator_principal, "
                    + "ano, "
                    + "tempo_filme, "
                    + "faixa_etaria, "
                    + "idioma_original, "
                    + "orcamento, "
                    + "faturamento, "
                    + "legenda, "
                    + "dublado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int quantidade = 1;
                ps.setString(quantidade++, filme.getNome());
                ps.setString(quantidade++, filme.getDiretor());
                ps.setString(quantidade++, filme.getCategoria());
                ps.setString(quantidade++, filme.getAtorPrincipal());
                ps.setInt(quantidade++, filme.getAno());
                ps.setShort(quantidade++, filme.getTempoFilme());
                ps.setString(quantidade++, filme.getFaixaEtaria());
                ps.setString(quantidade++, filme.getIdiomaOriginal());
                ps.setDouble(quantidade++, filme.getOrcamento());
                ps.setDouble(quantidade++, filme.getFaturamento());
                ps.setBoolean(quantidade++, filme.isLegenda());
                ps.setBoolean(quantidade++, filme.isDublado());
                ps.execute();
                
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return -1;
    }

    public Filme obterPeloId(int identificador) {
        return null;
    }

}

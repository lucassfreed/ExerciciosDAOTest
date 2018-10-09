package dao;

import bean.Filme;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas Rodrigo Frederico
 */
public class FilmeDAO {

    public int cadastrar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes (nome, "
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
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return -1;
    }

    public Filme obterPeloId(int identificador) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "SELECT * FROM filmes WHERE id = ?;";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                ps.execute();
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Filme filme = new Filme();
                    filme.setId(rs.getInt("id"));
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("ator_principal"));
                    filme.setAno(rs.getInt("ano"));
                    filme.setTempoFilme(rs.getShort("tempo_filme"));
                    filme.setFaixaEtaria(rs.getString("faixa_etaria"));
                    filme.setIdiomaOriginal(rs.getString("idioma_original"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    return filme;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return null;
    }

    public boolean alterar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "UPDATE filmes SET nome = ?, "
                    + "diretor = ?, "
                    + "categoria = ?, "
                    + "ator_principal = ?, "
                    + "ano = ?, "
                    + "tempo_filme = ?, "
                    + "faixa_etaria = ?, "
                    + "idioma_original = ?, "
                    + "orcamento = ?, "
                    + "faturamento = ?, "
                    + "legenda = ?, "
                    + "dublado = ? WHERE id = ?;";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
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
                ps.setInt(quantidade++, filme.getId());
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return false;
    }

    public boolean apagar(int identificador) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM filmes WHERE id = ?;";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return false;
    }

}

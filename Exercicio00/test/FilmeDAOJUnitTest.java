
import bean.Filme;
import dao.FilmeDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lucas Rodrigo Frederico
 */
public class FilmeDAOJUnitTest {

    @Test
    public void testarCadastro() {
        FilmeDAO dao = new FilmeDAO();
        
        Filme filme1 = new Filme();
        filme1.setNome("A Origem");
        filme1.setDiretor("Christopher Nolan");
        filme1.setCategoria("Ficção científica, Suspense");
        filme1.setAno(2010);
        filme1.setAtorPrincipal("Leonardo DiCaprio");
        filme1.setTempoFilme((short)148);
        filme1.setOrcamento(160000000);
        filme1.setFaturamento(320000000);
        filme1.setFaixaEtaria("14 anos");
        filme1.setLegenda(true);
        filme1.setDublado(true);
        filme1.setIdiomaOriginal("Inglês");

        int identificador = dao.cadastrar(filme1);

        assertNotSame(identificador, -1);
        Filme filmeBuscado = dao.obterPeloId(identificador);
        assertNotNull(filmeBuscado);

        assertEquals(filme1.getNome(), filmeBuscado.getNome());
        assertEquals(filme1.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(filme1.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(filme1.getAno(), filmeBuscado.getAno());
        assertEquals(filme1.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(filme1.getTempoFilme(), filmeBuscado.getTempoFilme());
        assertEquals(filme1.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(filme1.getFaturamento(), filmeBuscado.getFaturamento(), 0);
        assertEquals(filme1.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(filme1.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(filme1.isDublado(), filmeBuscado.isDublado());
        assertEquals(filme1.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
    }
    
    @Test
    public void testarEdicao() {
        FilmeDAO dao = new FilmeDAO();
        
        Filme filme1 = new Filme();
        filme1.setNome("A Origem");
        filme1.setDiretor("Christopher Nolan");
        filme1.setCategoria("Ficção científica, Suspense");
        filme1.setAno(2010);
        filme1.setAtorPrincipal("Leonardo DiCaprio");
        filme1.setTempoFilme((short)148);
        filme1.setOrcamento(160000000);
        filme1.setFaturamento(320000000);
        filme1.setFaixaEtaria("14 anos");
        filme1.setLegenda(true);
        filme1.setDublado(true);
        filme1.setIdiomaOriginal("Inglês");

        int identificador = dao.cadastrar(filme1);
        filme1.setId(identificador);
        
        filme1.setNome("Avatar");
        filme1.setDiretor("James Cameron");
        filme1.setCategoria("Ação");
        filme1.setAno(2010);
        filme1.setAtorPrincipal("Leonardo DiCaprio");
        filme1.setTempoFilme((short)148);
        filme1.setOrcamento(1600000000);
        filme1.setFaturamento(320000000);
        filme1.setFaixaEtaria("14 anos");
        filme1.setLegenda(true);
        filme1.setDublado(true);
        filme1.setIdiomaOriginal("Inglês");
        boolean alterado = dao.alterar(filme1);
        assertTrue(alterado);
        
        Filme filmeBuscado = dao.obterPeloId(identificador);
        assertNotNull(filmeBuscado);
        
        assertEquals(filme1.getNome(), filmeBuscado.getNome());
        assertEquals(filme1.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(filme1.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(filme1.getAno(), filmeBuscado.getAno());
        assertEquals(filme1.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(filme1.getTempoFilme(), filmeBuscado.getTempoFilme());
        assertEquals(filme1.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(filme1.getFaturamento(), filmeBuscado.getFaturamento(), 0);
        assertEquals(filme1.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(filme1.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(filme1.isDublado(), filmeBuscado.isDublado());
        assertEquals(filme1.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
    }
    
    @Test
    public void testarApagar() {
        FilmeDAO dao = new FilmeDAO();
        
        Filme filme1 = new Filme();
        filme1.setNome("A Origem");
        filme1.setDiretor("Christopher Nolan");
        filme1.setCategoria("Ficção científica, Suspense");
        filme1.setAno(2010);
        filme1.setAtorPrincipal("Leonardo DiCaprio");
        filme1.setTempoFilme((short)148);
        filme1.setOrcamento(160000000);
        filme1.setFaturamento(320000000);
        filme1.setFaixaEtaria("14 anos");
        filme1.setLegenda(true);
        filme1.setDublado(true);
        filme1.setIdiomaOriginal("Inglês");
        
        int identificador = dao.cadastrar(filme1);
        boolean excluido = dao.apagar(identificador);
        assertTrue(excluido);
        
        Filme filmeBuscado = dao.obterPeloId(identificador);
        assertNull(filmeBuscado);
    }
}

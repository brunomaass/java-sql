package repositories;

import entities.Pessoa;
import factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;

public class PessoaRepository {

    // Método para inserir pessoa no banco de dados
    public void create(Pessoa pessoa) throws  Exception {

        Connection connection = ConnectionFactory
                                .openConnection();
        
        PreparedStatement preparedStatement 
                = connection.prepareStatement
                ("insert into pessoa(nome, email, cpf)"
                + "values(?, ?, ?)");

        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getEmail());
        preparedStatement.setString(3, pessoa.getCpf());
        preparedStatement.execute();

        connection.close();
                
    }

    // Método para atualizar pessoa no banco de dados
    public void update(Pessoa pessoa) throws Exception {

        Connection connection = ConnectionFactory.openConnection();

        PreparedStatement preparedStatement = connection.prepareStatement
                ("update pessoa set nome=?, email=?, cpf=? where idpessoa=?");

                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setString(2, pessoa.getEmail());
                preparedStatement.setString(3, pessoa.getCpf());
                preparedStatement.setInt(4, pessoa.getIdPessoa());
                preparedStatement.execute();

                connection.close();
    }

    // Método para excluir pessoa no banco de dados
    public void delete(Pessoa pessoa) throws Exception {
        
        Connection connection = ConnectionFactory.openConnection();

        PreparedStatement preparedStatement = connection.prepareStatement
                ("delete from pessoa where idpessoa=?");

        preparedStatement.setInt(1, pessoa.getIdPessoa());
        preparedStatement.execute();

        connection.close();
    }

    // Método para consultar todas as pessoas cadastradas
    public List<Pessoa> findAll() throws Exception {

        Connection connection = ConnectionFactory.openConnection();

        PreparedStatement preparedStatement = connection.prepareStatement
                ("select * from pessoa order by idpessoa");

        ResultSet resultSet = preparedStatement.executeQuery();

        //declarando uma lista de objetos da classe Pessoa
        List<Pessoa> lista = new ArrayList<Pessoa>();

        //precorrer os registros obtidos
        //da consulta feita no banco de dados
        while(resultSet.next()) {//enquanto houver registros: leia

            Pessoa pessoa = new Pessoa();

            pessoa.setIdPessoa(resultSet.getInt("idpessoa"));
            //coluna do banco de dados

            pessoa.setNome(resultSet.getString("nome"));
            // coluna do banco de dados

            pessoa.setEmail(resultSet.getString("email"));
            //coluna do banco de dados

            pessoa.setCpf(resultSet.getString("cpf"));
            // coluna do banco de daos

            lista.add(pessoa);// adiciona pessoas dentro da lista
        }
        connection.close();
        return lista;
    }

    // Método para consultar 1 pessoa através do id
    public Pessoa findById(Integer idPessoa) throws Exception{
        Connection connection = ConnectionFactory.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pessoa where idpessoa=?");

        preparedStatement.setInt(1, idPessoa);
        ResultSet resultset = preparedStatement.executeQuery();

        Pessoa pessoa = null; // vazio (sem espaço na memória)

        if(resultset.next()) { // enquanto houver registros: leia
            
            pessoa = new  Pessoa();

            pessoa.setIdPessoa(resultset.getInt("idpessoa"));
            //coluna do banco de dados

            pessoa.setNome(resultset.getString("nome"));
            //coluna do banco de dados

            pessoa.setEmail(resultset.getString("email"));
            //coluna do banco de dados

            pessoa.setCpf(resultset.getString("cpf"));
            //coluna do banco de dados
        }
        connection.close();
        return pessoa;
    }
}

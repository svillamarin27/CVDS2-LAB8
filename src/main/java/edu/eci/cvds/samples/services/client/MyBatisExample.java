package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        System.out.println("");
        System.out.println("Imprimiendo consulta de clientes");
        System.out.println("");
        System.out.println(cm.consultarClientes());
        System.out.println("");
        System.out.println("Imprimiendo consulta de cliente Id");
        System.out.println("");
        System.out.println(cm.consultarCliente(6));

        //cm.agregarItemRentadoACliente(6,15,parseDate("2020-03-03"),parseDate("2020-03-11"));
        ItemMapper im = sqlss.getMapper(ItemMapper.class);
        TipoItem tItem = new TipoItem(3,"Series");
        Item item = new Item(tItem,1234,"NuevoItem","Item creado por fonso",parseDate("2020-03-03"),1543,"format","genero");
        //im.insertarItem(item);

        System.out.println("");
        System.out.println("Imprimiendo consulta de items");
        System.out.println("");
        System.out.println(im.consultarItems());

        System.out.println("");
        System.out.println("Imprimiendo consulta de items id");
        System.out.println("");
        System.out.println(im.consultarItem(3));

        sqlss.commit();
        
        sqlss.close();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }


}

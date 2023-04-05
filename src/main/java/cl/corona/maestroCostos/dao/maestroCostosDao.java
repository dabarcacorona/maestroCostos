package cl.corona.maestroCostos.dao;

import cl.corona.maestroCostos.model.maestroCostos;
import cl.corona.maestroCostos.util.utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class maestroCostosDao {

    private static final Logger logger = LoggerFactory.getLogger(maestroCostosDao.class);

    @Autowired
    private EntityManager em;


    public List<maestroCostos> getReport() {

        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MAES_COSTOS");
        if (spq == null) {
            logger.debug("Problems in the DB with the Stored Procedure");
            return Collections.emptyList();
        }

        List<Object[]> rows = spq.getResultList();

        List<maestroCostos> result = new ArrayList<>(rows.size());

        for (Object[] row : rows) {
            result.add(
                    new maestroCostos(0, utility.convertToInt(row[0]), utility.convertToInt(row[1]), utility.convertToInt(row[2]),
                            utility.convertToInt(row[3]), (String) row[4], utility.convertToInt(row[5]), utility.convertToInt(row[6]),
                            (Date) row[7], (Date) row[8], (Date) row[9], utility.convertToInt(row[10]), (Date) row[11], (Date) row[12],
                            utility.convertToInt(row[13]), (String) row[14], (Date) row[15]));
        }
        return result;

    }
}
